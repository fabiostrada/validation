package it.allitude.validation.business.validation.creditcard.insert;

import it.allitude.validation.business.model.CreditCard;
import it.allitude.validation.business.validation.common.Validator;
import it.allitude.validation.business.validation.common.rules.UpdateIfExistPersonRule;
import it.allitude.validation.business.validation.creditcard.insert.rules.InsertCreditCardIfXXXXXXXRule;
import org.springframework.stereotype.Component;

@Component
public class InsertCreditCardValidator extends Validator<CreditCard> {

    public InsertCreditCardValidator() {
        setValidatorRuleClasses(InsertCreditCardIfXXXXXXXRule.class,
                                UpdateIfExistPersonRule.class);
    }

}
