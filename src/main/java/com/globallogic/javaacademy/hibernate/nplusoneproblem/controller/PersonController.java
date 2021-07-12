package com.globallogic.javaacademy.hibernate.nplusoneproblem.controller;

import com.globallogic.javaacademy.hibernate.nplusoneproblem.entity.Address;
import com.globallogic.javaacademy.hibernate.nplusoneproblem.entity.Person;
import com.globallogic.javaacademy.hibernate.nplusoneproblem.repository.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonController {


    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;

    }

    @PostMapping
    public void printAddresses() {
        final List<Person> persons = personRepository.findPersonsWithAddresses();
        persons.stream()
                .map(Person::getAddresses)
                .flatMap(Collection::stream)
                .map(Address::getValue)
                .forEach(System.out::println);
    }
}
