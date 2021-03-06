package ru.epam.javacore.homework20191223.cargo.exception.unckecked;

import ru.epam.javacore.homework20191223.common.business.exception.unchecked.OurCompanyException;

public class CargoDeleteConstraintViolationException extends OurCompanyException {

    private static final String MESSAGE = "Can't delete cargo with id '%s'. There are transportations which relates to it!";

    public CargoDeleteConstraintViolationException(String message){
        super(message);
    }

    public CargoDeleteConstraintViolationException(long cargoId){
        this(String.format(MESSAGE, cargoId));
    }
}
