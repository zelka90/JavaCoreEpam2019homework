package ru.epam.javacore.homework20200207.common.business.exception.checked;

import ru.epam.javacore.homework20200207.common.business.exception.checked.OurCompanyCheckedException;

public class PrintStorageException extends OurCompanyCheckedException {

    public PrintStorageException(String message) {
        super(message);
    }

}