package GraphicEvaluation.Exceptions;

import org.springframework.stereotype.Component;


public class ApiNotFoundException extends Exception{
    public ApiNotFoundException(String string){
        super(string);
    }
}
