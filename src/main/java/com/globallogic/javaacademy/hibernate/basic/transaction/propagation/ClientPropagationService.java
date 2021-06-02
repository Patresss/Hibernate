package com.globallogic.javaacademy.hibernate.basic.transaction.propagation;

import com.globallogic.javaacademy.hibernate.basic.entity.Client;
import com.globallogic.javaacademy.hibernate.basic.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientPropagationService {

    private final InfoMessageService infoMessageService;
    private final ClientRepository clientRepository;


    public ClientPropagationService(InfoMessageService infoMessageService, ClientRepository clientRepository) {
        this.infoMessageService = infoMessageService;
        this.clientRepository = clientRepository;
    }


    @Transactional
    public Client save(Client client) {
        infoMessageService.save("Create client: " + client.getName());
        clientRepository.save(client);
        throw new RuntimeException("Something is wrong");
    }
}
