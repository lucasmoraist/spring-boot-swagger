package com.lucasmoraist.spring_boot_swagger.controller;

import com.lucasmoraist.spring_boot_swagger.exception.ExceptionDTO;
import com.lucasmoraist.spring_boot_swagger.exception.PersonNotfoundException;
import com.lucasmoraist.spring_boot_swagger.model.Person;
import com.lucasmoraist.spring_boot_swagger.repository.PersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "Person operations")
public class FindPersonByIdController {

    @Autowired
    private PersonRepository repository;

    @Operation(
            summary = "Find person by ID",
            description = "Find a person in the database by its ID"
    )
    @Parameter(
            name = "id",
            description = "The ID of the person to be found",
            required = true,
            example = "1"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Person found",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Person.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Person not found",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = ExceptionDTO.class)
                                    )
                            }
                    )
            }
    )
    @GetMapping("{id}")
    public ResponseEntity<Person> findById(Long id) {
        Person person = this.repository.findById(id)
                .orElseThrow(PersonNotfoundException::new);
        return ResponseEntity.ok().body(person);
    }

}
