package Darcy.springframework.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Darcy Xian  11/9/20  5:08 pm      spring5-recipe-app
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super();
    }

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(String message, Throwable cause){
        super(message,cause);
    }

}
