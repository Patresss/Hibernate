package com.globallogic.javaacademy.hibernate.repository;

import com.globallogic.javaacademy.hibernate.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Query("Select c from Contact c join fetch c.farmer")
    Set<Contact> findAllWithFarmers();
}
