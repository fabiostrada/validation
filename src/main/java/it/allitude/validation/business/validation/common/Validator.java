package it.allitude.validation.business.validation.common;

import it.allitude.validation.business.exceptions.ContainerException;
import it.allitude.validation.business.exceptions.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static it.allitude.validation.business.helpers.ListHelper.isNotEmpty;

public abstract class Validator<T> {

    @Autowired
    protected ApplicationContext applicationContext;

    protected List<Class<? extends ValidationRule>> validatorRuleClasses;

    protected Validator<T> setValidatorRuleClasses(Class<? extends ValidationRule>...validatorRuleClasses) {
        this.validatorRuleClasses = Arrays.asList(validatorRuleClasses);
        return this;
    }

    public void validate(T command) {
        if (isNotEmpty(validatorRuleClasses)) {
            List<GenericException> exceptions = new ArrayList<>();
            validatorRuleClasses.forEach(validatorRuleClass -> {
                ValidationRule bean = applicationContext.getBean(validatorRuleClass);
                GenericException ex = bean.validate(command);
                if (ex != null) {
                    exceptions.add(ex);
                }
            });
            if (isNotEmpty(exceptions)) {
                throw new ContainerException(exceptions);
            }
        }
    }

    public static abstract class ValidatorWithContext<T, C> extends Validator<T> {

        private List<Class<? extends ValidationRule.WithContext>> validatorRuleWithContextClasses;

        protected ValidatorWithContext<T,C> setValidatorRuleWithContextClasses(Class<? extends ValidationRule.WithContext>...validatorRuleWithContextClasses) {
            this.validatorRuleWithContextClasses = Arrays.asList(validatorRuleWithContextClasses);
            return this;
        }

        public void validate(T command, C context) {
            List<GenericException> exceptions = new ArrayList<>();
            if (isNotEmpty(validatorRuleClasses)) {
                validatorRuleClasses.forEach(validatorRuleClass -> {
                    ValidationRule bean = applicationContext.getBean(validatorRuleClass);
                    GenericException ex = bean.validate(command);
                    if (ex != null) {
                        exceptions.add(ex);
                    }
                });
            }
            if (isNotEmpty(validatorRuleWithContextClasses)) {
                validatorRuleWithContextClasses.forEach(validatorRuleWithContextClass -> {
                    ValidationRule.WithContext bean = applicationContext.getBean(validatorRuleWithContextClass);
                    GenericException ex = bean.validate(command, context);
                    if (ex != null) {
                        exceptions.add(ex);
                    }
                });
            }
            if (isNotEmpty(exceptions)) {
                throw new ContainerException(exceptions);
            }
        }

    }


}
