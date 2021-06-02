package com.globallogic.javaacademy.hibernate.basic.controller;


import com.globallogic.javaacademy.hibernate.basic.entity.Client;
import com.globallogic.javaacademy.hibernate.basic.entity.Gender;
import com.globallogic.javaacademy.hibernate.basic.repository.ClientRepository;
import com.globallogic.javaacademy.hibernate.basic.transaction.entitymanager.CustomerEntityManagerService;
import com.globallogic.javaacademy.hibernate.basic.transaction.propagation.ClientPropagationService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientRepository clientRepository;
    private final CustomerEntityManagerService customerEntityManagerService;
    private final ClientPropagationService clientPropagationService;

    public ClientController(ClientRepository clientRepository, CustomerEntityManagerService customerEntityManagerService, ClientPropagationService clientPropagationService) {
        this.clientRepository = clientRepository;
        this.customerEntityManagerService = customerEntityManagerService;
        this.clientPropagationService = clientPropagationService;
    }

    @GetMapping
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/future")
    public List<Client> getFutureClients() {
        return clientRepository.findFutureClients();
    }


    @PostMapping
    public Client createClient(@RequestParam String name, @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd") Date enrollmentDate, @RequestParam Gender gender) {
        Client client = new Client(name, enrollmentDate, gender);
        return clientRepository.save(client);
    }

    @PostMapping("/entity-manager")
    public Client createClientUsingEntityManager(@RequestParam String name, @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd") Date enrollmentDate, @RequestParam Gender gender) {
        Client client = new Client(name, enrollmentDate, gender);
        return customerEntityManagerService.save(client);
    }


    @PostMapping("/propagation")
    public Client createClientUsingPropagation(@RequestParam String name, @RequestParam  @DateTimeFormat(pattern="yyyy-MM-dd") Date enrollmentDate, @RequestParam Gender gender) {
        Client client = new Client(name, enrollmentDate, gender);
        return clientPropagationService.save(client);
    }

}
