package hitesh.sky.exception;

import org.springframework.stereotype.Component;

/**
 * Created by Hitesh on 25/06/2017.
 */

public class TechnicalFailureException extends Exception {

    public TechnicalFailureException(String message) {
        super(message);
    }
}
