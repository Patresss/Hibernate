package com.globallogic.javaacademy.hibernate.basic.transaction.entitymanager;

import com.globallogic.javaacademy.hibernate.basic.entity.Client;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class CustomerEntityManagerService {

    private final EntityManager entityManager;

    public CustomerEntityManagerService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Client save(Client client) {
        entityManager.persist(client);
//        entityManager.merge(client);
//        entityManager.detach(client);
        return client;
    }

    @Transactional
    public Client getById(Long clientId) {
        return entityManager.find(Client.class, clientId);
    }
}
