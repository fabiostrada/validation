package it.allitude.validation.business.validation.common.rules;

import it.allitude.validation.business.exceptions.GenericException;
import it.allitude.validation.business.model.IPerson;
import it.allitude.validation.business.validation.common.ValidationRule;
import org.springframework.stereotype.Component;

@Component
public class UpdateIfExistPersonRule implements ValidationRule<IPerson> {

    @Override
    public GenericException validate(IPerson command) {
        return null;
    }

}
