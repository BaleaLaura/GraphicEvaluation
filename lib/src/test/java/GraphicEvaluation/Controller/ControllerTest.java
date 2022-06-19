package GraphicEvaluation.Controller;

import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    static String path = "C:/Users/laula/Desktop/GraphicEvaluation/lib/src/Image/test2.png";

    @Test
    void dimension() throws IOException {

        assertEquals(916, Controller.dimension(path, "width"));
        assertEquals(584, Controller.dimension(path, "height"));
    }

    @Test
    void imageName() {
        assertEquals("test2.png", Controller.imageName(path));
    }
}