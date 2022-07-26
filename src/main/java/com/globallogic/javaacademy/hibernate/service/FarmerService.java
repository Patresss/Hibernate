package com.globallogic.javaacademy.hibernate.service;

import com.globallogic.javaacademy.hibernate.entity.Contact;
import com.globallogic.javaacademy.hibernate.entity.Farmer;
import com.globallogic.javaacademy.hibernate.entity.Gender;
import com.globallogic.javaacademy.hibernate.repository.FarmerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public Farmer saveFarmer(final Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public Set<Farmer> findFemale() {
        return farmerRepository.findAllByGender(Gender.FEMALE);
    }

    public Set<Farmer> findActive() {
        return farmerRepository.findFarmerByActiveStatus(true);
    }

    @Transactional
    public Set<String> findPhones(final Long farmerId) {
        final Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer  " + farmerId + " does not exist"));
        return farmer.getContacts().stream()
                .map(Contact::getPhoneNumber)
                .collect(Collectors.toSet());
    }

    @Transactional
    public void deleteFirstContact(final Long farmerId) {
        final Farmer farmer = farmerRepository.findById(farmerId).orElseThrow();
        farmer.getContacts().stream()
                .findFirst()
                .ifPresent(farmer::removeContact);
    }


    @Transactional
    public void transaction(final Long farmerId) {
        final Farmer farmer = farmerRepository.findById(farmerId).orElseThrow();
        farmer.setName("UPDATED");
        if (isValid(farmer)) { // doesn't make sense because farmer is persisted
            farmerRepository.save(farmer);
        }
    }

    private boolean isValid(Farmer farmer) {
        return false;
    }


}
