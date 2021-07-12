package com.globallogic.javaacademy.hibernate.nplusoneproblem.repository;

import com.globallogic.javaacademy.hibernate.nplusoneproblem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p join fetch p.addresses")
    List<Person> findPersonsWithAddresses();

}
