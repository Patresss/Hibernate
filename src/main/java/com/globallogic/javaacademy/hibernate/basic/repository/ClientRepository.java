package com.globallogic.javaacademy.hibernate.basic.repository;

import com.globallogic.javaacademy.hibernate.basic.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from MyClient c where c.enrollmentDate > CURRENT_DATE ")
    List<Client> findFutureClients();

}
