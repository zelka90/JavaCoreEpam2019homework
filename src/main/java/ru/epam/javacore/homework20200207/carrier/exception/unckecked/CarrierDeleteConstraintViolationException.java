package ru.epam.javacore.homework20200207.carrier.exception.unckecked;

import ru.epam.javacore.homework20200207.common.business.exception.unchecked.OurCompanyUncheckedException;

public class CarrierDeleteConstraintViolationException extends OurCompanyUncheckedException {

    private static final String MESSAGE = "Cant delete carrier with id '%s'. There are transportations which relates to it!";

    public CarrierDeleteConstraintViolationException(String message) {
        super(message);
    }

    public CarrierDeleteConstraintViolationException(long carrierId) {
        this(String.format(MESSAGE, carrierId));
    }
}
