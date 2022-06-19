package GraphicEvaluation.RulesOfComposition;

import GraphicEvaluation.API.API;
import GraphicEvaluation.API.GoogleAPI.DetectTextGoogleAPI;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class RuleOfThirdsTest {

    @Test
    void evaluate() throws IOException {
        API api=new DetectTextGoogleAPI();
        RulesOfComposition rule=new RuleOfThirds();

        int width =916;
        int height =584;

        int width2 =1290;
        int height2 =700;

        Map<String, String> caracteristics=api.detectText("C:/Users/laula/Desktop/GraphicEvaluation/lib/src/Image/test2.png");
        Map<String, String> caracteristics2=api.detectText("C:/Users/laula/Desktop/GraphicEvaluation/lib/src/Image/ruleOfThird.png");

        assertFalse(rule.evaluate(caracteristics, width, height));
        assertTrue(rule.evaluate(caracteristics2, width2, height2));
    }
}