package it.allitude.validation.config;

import it.allitude.validation.business.exceptions.ContainerException;
import it.allitude.validation.business.exceptions.Error;
import it.allitude.validation.business.exceptions.InternalServerErrorException;
import it.allitude.validation.business.helpers.ErrorHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ErrorHelper errorHelper;

    @Autowired
    public GlobalExceptionHandler setErrorHelper(ErrorHelper errorHelper) {
        this.errorHelper = errorHelper;
        return this;
    }

    @ExceptionHandler(value = {InternalServerErrorException.class})
    protected ResponseEntity<List<Error>> handle(InternalServerErrorException ex, WebRequest request) {
        final Error error = errorHelper.generateError(ex, ((ServletWebRequest) request).getRequest());
        return new ResponseEntity<>(Arrays.asList(error), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ContainerException.class})
    protected ResponseEntity<List<Error>> handle(ContainerException ex, WebRequest request) {
        final List<Error> exceptions = errorHelper.generateErrors(ex, (ServletWebRequest) request);
        return new ResponseEntity<>(exceptions, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
