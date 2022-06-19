package GraphicEvaluation.Exceptions;

import org.springframework.stereotype.Component;


public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String string){
        super(string);
    }

}
