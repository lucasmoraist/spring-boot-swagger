package com.lucasmoraist.spring_boot_swagger.model;

import java.time.LocalDate;

public record PersonDTO(
        String name,
        int age,
        LocalDate birthDate,
        boolean isActive
) {}
