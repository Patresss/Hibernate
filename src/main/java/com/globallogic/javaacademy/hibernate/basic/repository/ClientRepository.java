package com.globallogic.javaacademy.hibernate.basic.repository;

import com.globallogic.javaacademy.hibernate.basic.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByName(String name);

    @Query("select c from MyClient c where c.name = name ")
    Optional<Client> findByNameCustom(String name);

}
