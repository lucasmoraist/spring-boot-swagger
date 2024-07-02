package com.lucasmoraist.spring_boot_swagger.controller;

import com.lucasmoraist.spring_boot_swagger.model.Person;
import com.lucasmoraist.spring_boot_swagger.repository.PersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "Person operations")
public class FindAllPersonController {

    @Autowired
    private PersonRepository repository;

    @Operation(
            summary = "Find all persons",
            description = "Find all persons in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Persons found",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Person.class)
            )
    )
    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

}
