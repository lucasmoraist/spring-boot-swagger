package com.lucasmoraist.spring_boot_swagger.repository;

import com.lucasmoraist.spring_boot_swagger.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
