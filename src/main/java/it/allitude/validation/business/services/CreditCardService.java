package it.allitude.validation.business.services;

import it.allitude.validation.business.model.CreditCard;
import it.allitude.validation.business.model.Registration;
import it.allitude.validation.business.validation.creditcard.insert.InsertCreditCardValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

    public InsertCreditCardValidator insertCreditCardValidator;

    @Autowired
    public CreditCardService setInsertCreditCardValidator(InsertCreditCardValidator insertCreditCardValidator) {
        this.insertCreditCardValidator = insertCreditCardValidator;
        return this;
    }

    public Registration insert(CreditCard creditCard) {
        insertCreditCardValidator.validate(creditCard);
        //TODO: Implementazione
        return null;
    }

}
