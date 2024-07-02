package com.lucasmoraist.spring_boot_swagger.controller;

import com.lucasmoraist.spring_boot_swagger.exception.ExceptionDTO;
import com.lucasmoraist.spring_boot_swagger.model.Person;
import com.lucasmoraist.spring_boot_swagger.model.PersonDTO;
import com.lucasmoraist.spring_boot_swagger.repository.PersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "Person operations")
public class CreatePersonController {

    @Autowired
    private PersonRepository repository;

    @Operation(
            summary = "Save a person",
            description = "Save a person in the database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Person saved",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PersonDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid data",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionDTO.class)
                            )
                    ),
            }
    )
    @PostMapping
    public ResponseEntity<Person> save(@RequestBody PersonDTO dto) {
        if (dto.name() == null || dto.name().isEmpty() || dto.age() < 0 || dto.birthDate() == null) {
            throw new IllegalArgumentException();
        }

        Person person = Person.builder()
                .name(dto.name())
                .age(dto.age())
                .birthDate(dto.birthDate())
                .isActive(dto.isActive())
                .build();
        return ResponseEntity.ok(repository.save(person));
    }

}
