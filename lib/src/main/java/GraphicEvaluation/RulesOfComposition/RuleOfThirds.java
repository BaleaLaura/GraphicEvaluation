package GraphicEvaluation.RulesOfComposition;

import com.google.common.base.CharMatcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RuleOfThirds extends RulesOfComposition {
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
        // The locations of the four points are established
        int xPct1 = width / 3;
        int yPct1 = height / 3;
        int xPct2 = xPct1 * 2;
        int yPct2 = yPct1 * 2;

        //the center of the image is set on the x-axis and the y-axis
        int xMid = width / 2;
        int yMid = height / 2;


        List<Integer> listaVal = new ArrayList<>();

        for (Map.Entry<String, String> elem : caracteristics.entrySet()) {
            position = elem.getKey();
            caracteristics.remove(position);
            break;
        }
        for (Map.Entry<String, String> elem : caracteristics.entrySet()) {

            position = elem.getValue();

            int y1Temp = Integer.parseInt(CharMatcher.digit().retainFrom(position.substring(20, 40)));

            /*
             Will check if the next word is on the same y (if it is part of the paragraph).
             If it is will move on to the next word and if it doesn't, will save x and y in the list and move on.
             */
            if (listaVal.contains(y1Temp) || listaVal.contains(y1Temp + 1) || listaVal.contains(y1Temp - 1) || listaVal.contains(y1Temp + 2) || listaVal.contains(y1Temp - 2) || listaVal.contains(y1Temp + 3) || listaVal.contains(y1Temp - 3) || listaVal.contains(y1Temp + 4) || listaVal.contains(y1Temp - 4)) {
                continue;
            } else {
                listaVal.clear();
                listaVal.add(y1Temp);
            }

            int x1 = Integer.parseInt(CharMatcher.digit().retainFrom(position.substring(13, 20)));
            int y1 = Integer.parseInt(CharMatcher.digit().retainFrom(position.substring(20, 30)));
            int x2 = Integer.parseInt(CharMatcher.digit().retainFrom(position.substring(60, 82)));
            int y2 = Integer.parseInt(CharMatcher.digit().retainFrom(position.substring(83, 90)));

            if (!((x1 < xPct1 && x2 < xMid + 30 && y1Temp < yPct1 && y2 < yMid + 30) || (x1 > xMid - 30 && x2 > xPct2 && y1Temp > yMid - 30 && y2 > yPct1) || (x1 > xMid - 30 && x2 > xPct2 && y1Temp < yPct1 && y2 < yMid + 30) || (x1 < xPct1 && x2 < xMid + 30 && y1Temp > yMid - 30 && y2 > yPct2))) {

                why = "One of the paragraphs crosses the seted limits.";
                return false;
            }
        }
        why = "Each paragraph is positioned next to one of the four dots";
        return true;
    }

    /**
     * will return the description of rule
     */
    @Override
    public String description() {
        return "Check that the text elements are around the four calculated points";
    }

    /**
     * will return the reason for the decision
     */
    @Override
    public String decisionExplanation() {
        return why;
    }

}

