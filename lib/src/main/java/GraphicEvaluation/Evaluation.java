package GraphicEvaluation;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import GraphicEvaluation.API.API;
import GraphicEvaluation.RulesOfComposition.RulesOfComposition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Evaluation {
    /**
     * These variables are static because we used them in the Controller class
     */

    public static String path;
    public static API api;
    public static RulesOfComposition rule;

    /**
     * Perform the evaluation
     *
     * @param path     the path to the image
     * @param apiName  the name of the api
     * @param ruleName the name of the rule
     */
    public static void EvaluationIMG(String path, API apiName, RulesOfComposition ruleName) {
        Evaluation.api = apiName;
        Evaluation.rule = ruleName;
        Evaluation.path = path;
        SpringApplication.run(Evaluation.class);

    }

}



