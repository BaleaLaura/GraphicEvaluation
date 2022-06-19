package GraphicEvaluation.API.GoogleAPI;

import GraphicEvaluation.API.API;
import com.google.cloud.vision.v1.*;
import com.google.protobuf.ByteString;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * The API returns the information in a json file, but for an easy management i added the information in a map.
 */
public class DetectTextGoogleAPI extends API {

    /**
     * Detects text in the specified image.
     *
     * //@param filePath-the path to the image
     * @return return a map with information
     */
    @Override
    public Map<String, String> detectText(String filePath) throws IOException {
        List<AnnotateImageRequest> requests = new ArrayList<>();

        ByteString imgBytes = ByteString.readFrom(new FileInputStream(filePath));

        Image img = Image.newBuilder().setContent(imgBytes).build();
        Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
        AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
        requests.add(request);

        Map<String, String> map = new LinkedHashMap<>();
        List<AnnotateImageResponse> responses;

        /*Initialize client that will be used to send requests. This client only needs to be created
           once, and can be reused for multiple requests. After completing all of your requests, call
          the "close" method on the client to safely clean up any remaining background resources.*/

        try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
            BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
            responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
                if (res.hasError()) {
                    System.out.format("Error: %s%n", res.getError().getMessage());
                }
                /*For full list of available annotations, see http://g.co/cloud/vision/docs*/

                for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
                    map.put("TEXT: " + annotation.getDescription() + "\n", annotation.getBoundingPoly().toString());
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return map;
    }


}
