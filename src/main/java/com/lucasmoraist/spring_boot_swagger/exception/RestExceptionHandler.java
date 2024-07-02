package com.lucasmoraist.spring_boot_swagger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ExceptionDTO> IllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO("Preencha todos os campos obrigatórios", HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ExceptionDTO> exception(Exception e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(PersonNotfoundException.class)
    protected ResponseEntity<ExceptionDTO> personNotFoundException(PersonNotfoundException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage(), HttpStatus.NOT_FOUND));
    }

}
