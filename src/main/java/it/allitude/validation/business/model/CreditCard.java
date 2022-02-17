package it.allitude.validation.business.model;

import java.util.Objects;

public class CreditCard implements IPerson {

    private Long idPerson;
    private CreditCardType type;

    public CreditCardType getType() {
        return type;
    }

    public CreditCard setType(CreditCardType type) {
        this.type = type;
        return this;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public CreditCard setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return Objects.equals(idPerson, that.idPerson) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson, type);
    }

}
