package GraphicEvaluation.API.GoogleAPI;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.Map;


public class DetectTextGoogleAPITest {

    @Test
    void detectText() throws IOException {
        String path = "C:/Users/laula/Desktop/GraphicEvaluation/lib/src/Image/test2.png";
        DetectTextGoogleAPI detectTextGoogleAPI = new DetectTextGoogleAPI();

        Map<String, String> listaTest = detectTextGoogleAPI.detectText(path);

        Assertions.assertEquals(19, listaTest.size());

    }
}