package GraphicEvaluation.Exceptions;

import org.springframework.stereotype.Component;


public class RuleNotFoundException extends Exception{
    public RuleNotFoundException(
            String string) {
        super(string);
    }
}
