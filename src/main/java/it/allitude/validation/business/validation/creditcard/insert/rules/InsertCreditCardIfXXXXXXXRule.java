package it.allitude.validation.business.validation.creditcard.insert.rules;

import it.allitude.validation.business.exceptions.GenericException;
import it.allitude.validation.business.model.CreditCard;
import it.allitude.validation.business.validation.common.ValidationRule;
import org.springframework.stereotype.Component;

@Component
public class InsertCreditCardIfXXXXXXXRule implements ValidationRule<CreditCard> {

    @Override
    public GenericException validate(CreditCard command) {
        return null;
    }

}
