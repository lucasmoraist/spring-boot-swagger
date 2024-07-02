package com.lucasmoraist.spring_boot_swagger.controller;

import com.lucasmoraist.spring_boot_swagger.exception.ExceptionDTO;
import com.lucasmoraist.spring_boot_swagger.exception.PersonNotfoundException;
import com.lucasmoraist.spring_boot_swagger.model.Person;
import com.lucasmoraist.spring_boot_swagger.model.PersonDTO;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@Tag(name = "Person", description = "Person operations")
public class UpdatePersonController {

    @Autowired
    private PersonRepository repository;

    @Operation(
            summary = "Update a person",
            description = "Update a person by its id of the type Long"
    )
    @Parameter(
            name = "id",
            description = "The person's id",
            required = true,
            example = "1"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Person updated",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PersonDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Person not found",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionDTO.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid data",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ExceptionDTO.class)
                            )
                    )
            }
    )
    @PutMapping("{id}")
    public ResponseEntity<PersonDTO> update(@PathVariable Long id, @RequestBody PersonDTO dto) {
        Person person = this.repository.findById(id)
                .orElseThrow(PersonNotfoundException::new);

        if (dto.name() == null || dto.name().isEmpty() || dto.age() < 0 || dto.birthDate() == null) {
            throw new IllegalArgumentException();
        }

        person.setName(dto.name());
        person.setAge(dto.age());
        person.setBirthDate(dto.birthDate());
        person.setActive(dto.isActive());

        this.repository.save(person);

        return ResponseEntity.ok().body(dto);
    }

}
