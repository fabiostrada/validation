package it.allitude.validation.business.validation.common;

import it.allitude.validation.business.exceptions.GenericException;
import it.allitude.validation.business.exceptions.InternalServerErrorException;

public interface ValidationRule<T> {

    default GenericException validate(T command) {
        return InternalServerErrorException.VALIDATION_NOT_IMPLEMENT;
    }

    interface WithContext<T, C> extends ValidationRule<T> {
        default GenericException validate(T data, C context) {
            return this.validate(data);
        }
    }

}
