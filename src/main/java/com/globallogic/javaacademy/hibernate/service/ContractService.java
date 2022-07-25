package com.globallogic.javaacademy.hibernate.service;

import com.globallogic.javaacademy.hibernate.entity.Address;
import com.globallogic.javaacademy.hibernate.entity.Contract;
import com.globallogic.javaacademy.hibernate.repository.ContractRepository;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    private final ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public Contract createContract(final Contract contract) {
        return contractRepository.save(contract);
    }
}
