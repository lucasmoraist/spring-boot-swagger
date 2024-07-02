package com.lucasmoraist.spring_boot_swagger.exception;

import org.springframework.http.HttpStatus;

public record ExceptionDTO(String msg, HttpStatus status) {
}
