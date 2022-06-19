package GraphicEvaluation.RulesOfComposition;

import GraphicEvaluation.Exceptions.RuleNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * TODO the golden section rule can also be added
 */

public abstract class RulesOfComposition {
    /**
     * Evaluate the image and decide if it is graphically correct
     *
     * @param caracteristics is a map with the information extracted by api
     * @param width represents the width of the image
     * @param height represents the height of the image
     * @return Will return the decision, true is the image is correct or false if isn't
     */
    public abstract boolean evaluate(Map<String, String> caracteristics, int width, int height);

    /**
     * will return the description of rule
     */
    public abstract String description();

    /**
     * will return the reason for the decision
     */
    public abstract String decisionExplanation();

    /**
     * Will decide which Rule to use
     *
     * @param nameRule The name of rule
     * @return Will return the Rule object mentioned by nameRule
     * @throws RuleNotFoundException If the name does not correspond to any Rule.
     */
    public static RulesOfComposition getRuleOfComposition(String nameRule) throws RuleNotFoundException {

        switch (nameRule) {
            case "symmetry":
                return new SymmetryRule();
            case "thirds":
                return new RuleOfThirds();
            default:
                throw new RuleNotFoundException("Rule not found");
        }

    }


}
