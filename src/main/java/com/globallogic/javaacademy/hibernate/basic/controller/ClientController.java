package com.globallogic.javaacademy.hibernate.basic.controller;

import com.globallogic.javaacademy.hibernate.basic.entity.Client;
import com.globallogic.javaacademy.hibernate.basic.repository.ClientRepository;
import com.globallogic.javaacademy.hibernate.basic.transaction.CustomerEntityManagerService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientRepository clientRepository;
    private final CustomerEntityManagerService customerEntityManagerService;

    public ClientController(ClientRepository clientRepository, CustomerEntityManagerService customerEntityManagerService) {
        this.clientRepository = clientRepository;
        this.customerEntityManagerService = customerEntityManagerService;
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
       return clientRepository.save(client);
    }

    @PostMapping("/em")
    public Client createClientEm(@RequestBody Client client) {
        return customerEntityManagerService.save(client);
    }

    @GetMapping
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public Client getClientByName(@PathVariable String name ) {
        return clientRepository.findByNameCustom(name).orElse(new Client());
    }

    @PostMapping("/default-list")
    @Transactional
    public void createClientEm() {
        customerEntityManagerService.add1DefaultClient();
        customerEntityManagerService.add2DefaultClient();
        customerEntityManagerService.add3DefaultClient();
    }


}
