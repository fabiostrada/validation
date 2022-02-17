package it.allitude.validation.business.exceptions;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {

    protected HttpStatus httpStatus;

    protected Integer code;

    public GenericException() {
        super();
    }

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericException(Throwable cause) {
        super(cause);
    }

    protected GenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public <T extends GenericException> T setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return (T)this;
    }

    public Integer getCode() {
        return code;
    }

    public<T extends GenericException> T setCode(Integer code) {
        this.code = code;
        return (T)this;
    }
}
