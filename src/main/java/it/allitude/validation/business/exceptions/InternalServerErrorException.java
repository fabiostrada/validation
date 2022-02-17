package it.allitude.validation.business.exceptions;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends GenericException {

    public InternalServerErrorException() {
        super();
    }

    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalServerErrorException(Throwable cause) {
        super(cause);
    }

    protected InternalServerErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public static InternalServerErrorException of(Integer code, String message) {
        return new InternalServerErrorException(message).setCode(code);
    }

    public static InternalServerErrorException of(String message) {
        return new InternalServerErrorException(message);
    }

    public static final InternalServerErrorException VALIDATION_NOT_IMPLEMENT = of(1, "Unimplemented method exception");

}
