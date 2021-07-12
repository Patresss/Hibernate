package com.globallogic.javaacademy.hibernate.basic.transaction.entitymanager;

import com.globallogic.javaacademy.hibernate.basic.entity.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

@Service
public class CustomerEntityManagerService {

    private final EntityManager entityManager;

    public CustomerEntityManagerService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Client save(Client client) {
        final Client updatedClient = entityManager.merge(client);
        return updatedClient;
    }


    @Transactional(propagation = REQUIRES_NEW)
    public void add1DefaultClient() {
        entityManager.persist(new Client());
    }

    public void add2DefaultClient() {
        entityManager.persist(new Client());
    }

    public void add3DefaultClient() {
        entityManager.persist(new Client());
        throw new RuntimeException("Error");
    }

}
