package main.homework20200113.cargo.exception.unckecked;

import main.homework20200113.common.business.exception.unchecked.OurCompanyUncheckedException;

public class CargoDeleteConstraintViolationException extends OurCompanyUncheckedException {

    private static final String MESSAGE = "Can't delete cargo with id '%s'. There are transportations which relates to it!";

    public CargoDeleteConstraintViolationException(String message){
        super(message);
    }

    public CargoDeleteConstraintViolationException(long cargoId){
        this(String.format(MESSAGE, cargoId));
    }
}