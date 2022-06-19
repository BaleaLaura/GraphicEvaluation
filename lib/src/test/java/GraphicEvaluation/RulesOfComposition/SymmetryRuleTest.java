package GraphicEvaluation.RulesOfComposition;

import GraphicEvaluation.API.API;
import GraphicEvaluation.API.GoogleAPI.DetectTextGoogleAPI;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SymmetryRuleTest {

    @Test
    void evaluate() throws IOException {
        API api = new DetectTextGoogleAPI();
        RulesOfComposition rule=new SymmetryRule();

        int width =558;
        int height = 703;

        int width2 =758;
        int height2 =1164;

        Map<String, String> caracteristics=api.detectText("C:/Users/laula/Desktop/GraphicEvaluation/lib/src/Image/simmetry.png");
        Map<String, String> caracteristics2=api.detectText("C:/Users/laula/Desktop/GraphicEvaluation/lib/src/Image/test.png");

        assertTrue(rule.evaluate(caracteristics, width, height));
        assertFalse(rule.evaluate(caracteristics2, width2, height2));
    }

}