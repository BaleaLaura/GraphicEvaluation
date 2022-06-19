import GraphicEvaluation.API.API;
import GraphicEvaluation.Exceptions.ApiNotFoundException;
import GraphicEvaluation.Exceptions.RuleNotFoundException;
import GraphicEvaluation.Evaluation;
import GraphicEvaluation.RulesOfComposition.RulesOfComposition;

public class Main {
    public static void main(String[] args) throws ApiNotFoundException, RuleNotFoundException {
        API api=API.getApi("google");
        RulesOfComposition rule= RulesOfComposition.getRuleOfComposition("symmetry");
        String path="C:/Users/laula/Desktop/GraphicEvaluation/lib/src/Image/simmetry.png";
        Evaluation.EvaluationIMG(path,api,rule);
    }
}
