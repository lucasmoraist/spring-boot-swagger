package com.lucasmoraist.spring_boot_swagger.exception;

public class PersonNotfoundException extends RuntimeException {

    public PersonNotfoundException() {
        super("Person not found");
    }

}
