package com.globallogic.javaacademy.hibernate.service;

import com.globallogic.javaacademy.hibernate.entity.Contact;
import com.globallogic.javaacademy.hibernate.entity.Farmer;
import com.globallogic.javaacademy.hibernate.repository.ContactRepository;
import com.globallogic.javaacademy.hibernate.repository.FarmerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Transactional
    public Set<String> findPhonesWithFarmer() {
        return contactRepository.findAllWithFarmers().stream()
                .map(contact -> contact.getFarmer().getName() + ": " + contact.getPhoneNumber())
                .collect(Collectors.toSet());
    }


}
