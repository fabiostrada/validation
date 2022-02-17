package it.allitude.validation.business.exceptions;

import java.util.List;

public class ContainerException extends RuntimeException {

    private List<GenericException> exceptions;

    public ContainerException(List<GenericException> exceptions) {
        this.exceptions = exceptions;
    }

    public List<GenericException> getExceptions() {
        return exceptions;
    }

}
