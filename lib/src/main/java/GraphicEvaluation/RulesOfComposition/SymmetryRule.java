package GraphicEvaluation.RulesOfComposition;

import com.google.common.base.CharMatcher;
import org.springframework.stereotype.Component;

import java.util.Map;

public class SymmetryRule extends RulesOfComposition {
    static String why;

    /**
     * This method will evaluate the image
     *
     * @param caracteristics is a map with the information extracted by API
     * @param width represents the width of the image
     * @param height represents the height of the image
     * @return returns the decision and initialize the why variable which is the reason
     */
    @Override
    public boolean evaluate(Map<String, String> caracteristics, int width, int height) {

        String position = "";

        // Will store all the text in the image as a paragraph
        for (Map.Entry<String, String> elem : caracteristics.entrySet()) {

            position = elem.getValue();
            break;
        }
        // Represents the location of the paragraph on the x-axis and the y-axis
        int xMin = Integer.parseInt(CharMatcher.digit().retainFrom(position.substring(13, 20)));
        int xMax = Integer.parseInt(CharMatcher.digit().retainFrom(position.substring(60, 80)));
        double middle = width / 2f;

        double right = xMax - middle;
        double left = middle - xMin;

        if (Math.max(right, left) - Math.min(right, left) < 10) {
            why = "The position of the text is approximately in the center of the image";
            return true;

        }
        why = "The text is positioned further to the right / left of the center of the image";
        return false;
    }

    /**
     * will return the description of rule
     */
    @Override
    public String description() {
        return "Check that the text is placed symmetrically in the image ";
    }

    /**
     * will return the reason for the decision
     */
    @Override
    public String decisionExplanation() {
        return why;
    }


}
