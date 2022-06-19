package GraphicEvaluation.Controller;

import GraphicEvaluation.API.API;

import GraphicEvaluation.DataBase.Model.*;
import GraphicEvaluation.DataBase.Service.*;
import GraphicEvaluation.Evaluation;
import GraphicEvaluation.RulesOfComposition.RulesOfComposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * Will take the information extracted from the API and the composition rules.
 * This information will be added to the database.
 * A new record will be added to each call.
 */

// TODO 1 - For composition rules could extract information from the database with the name of the desired image.
// TODO 2 - When re-evaluating an already evaluated image new information will be updated

@Component
public class Controller implements CommandLineRunner {

    //Inject objects
    @Autowired
    private final Images_Service imagesService;
    private final APIs_Service apIsService;
    private final APICalls_Service apiCallsService;
    private final EvaluationImg_Service evaluationImgService;
    private final Rules_Service rulesService;
    private final RulesHasImages_Service rulesHasImagesService;

    public Controller(Images_Service imagesService, APIs_Service apIsService, APICalls_Service apiCallsService, EvaluationImg_Service evaluationImgService, Rules_Service rulesService, RulesHasImages_Service rulesHasImagesService) throws IOException {

        this.imagesService = imagesService;
        this.apIsService = apIsService;
        this.apiCallsService = apiCallsService;
        this.evaluationImgService = evaluationImgService;
        this.rulesService = rulesService;
        this.rulesHasImagesService = rulesHasImagesService;
    }

    public void run(String... args) throws Exception {
        // The necessary information, the path, the API and the rule are established
        String path = Evaluation.path;
        API api = Evaluation.api;
        RulesOfComposition rulesOfComposition = Evaluation.rule;

        String ImageName = imageName(path);
        Map<String, String> caracteristcs = api.detectText(path);
        System.out.println("API");
        System.out.println(caracteristcs);

        int width = dimension(path, "width");
        int height = dimension(path, "height");

        //save the decision in a boolean variable
        boolean state = rulesOfComposition.evaluate(caracteristcs, width, height);

        //Current date
        LocalDate localDate = LocalDate.now();
        Value value = Value.TEXT;

        /*
        Add the value in tables
        */
        Images images = new Images();
        images.setDateImg(localDate);
        images.setNameImg(ImageName);
        imagesService.saveImage(images);


        APIs apIs = new APIs();
        apIs.setDateAPI(localDate);
        apIs.setNameApi(api.getClass().getSimpleName());
        apIsService.saveAPi(apIs);

        //add the information as a json file
        JsonGoogle jsonGoogle = new JsonGoogle();
        List<String> lista = new ArrayList<>();

        //add the information from map to a list
        for (Map.Entry<String, String> elem : caracteristcs.entrySet()) {
            lista.add(elem.getKey());
            lista.add(elem.getValue());
        }
        //add the list to a json file
        jsonGoogle.setElem(lista);
        APIsCallsId apIs_calls_id = new APIsCallsId();
        apIs_calls_id.setIdImg(images.getIdImg());
        apIs_calls_id.setIdAPI(apIs.getIdAPI());

        APIsCalls apIs_calls = new APIsCalls();
        apIs_calls.setId(apIs_calls_id);
        apIs_calls.setIdImg(images);
        apIs_calls.setApiId(apIs);
        apIs_calls.setResponseAPI(jsonGoogle);
        apIs_calls.setDateAPI(localDate);
        apiCallsService.saveApi_calls(apIs_calls);


        EvaluationImg evaluationImg = new EvaluationImg();
        evaluationImg.setImages(images);
        evaluationImg.setTypeCharacteristics(value);
        evaluationImg.setCharacteristics(width + "X" + height);
        evaluationImgService.saveEvaluationImg(evaluationImg);


        Rules rule = new Rules();
        rule.setNameRule(rulesOfComposition.getClass().getSimpleName());
        rule.setDescription(rulesOfComposition.description());
        rulesService.saveRules(rule);

        RulesHasImagesId rules_has_images_id = new RulesHasImagesId();
        rules_has_images_id.setIdRule(rule.getIdRule());
        rules_has_images_id.setIdImg(images.getIdImg());

        RulesHasImages rules_has_images = new RulesHasImages();
        rules_has_images.setIdRule(rule);
        rules_has_images.setId(rules_has_images_id);
        rules_has_images.setDateEvaluation(localDate);
        rules_has_images.setState(state);
        rules_has_images.setWhy(rulesOfComposition.decisionExplanation());
        rules_has_images.setIdImg(images);
        rulesHasImagesService.saveRulesImage(rules_has_images);

        //displaying the decision and the reason
        System.out.println("Decision: " + state);
        System.out.println("Reason: " + rulesOfComposition.decisionExplanation());
    }

    /**
     * Extract the image size
     *
     * @param path    the path to image
     * @param request what information i want to receive, width or height of the image
     * @return returns what receive as a request
     */
    public static int dimension(String path, String request) throws IOException {
        File file = new File(path);
        ImageInputStream iis = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
        int width = 0;
        int height = 0;

        if (readers.hasNext()) {
            ImageReader reader = readers.next();
            reader.setInput(iis, true);

            width = reader.getWidth(0);
            height = reader.getHeight(0);

        }
        return Objects.equals(request, "width") ? width : height;
    }

    /**
     * Extract the image name from the received path
     *
     * @param path The path to image
     * @return return the name of image as a string
     */
    public static String imageName(String path) {
        StringBuilder name = new StringBuilder("");
        for (int i = path.length() - 1; i >= 0; i--) {
            if (path.charAt(i) == '/') {
                break;
            }
            name.append(path.charAt(i));
        }
        return name.reverse().toString();
    }


}

