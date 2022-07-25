package com.globallogic.javaacademy.hibernate.repository;

import com.globallogic.javaacademy.hibernate.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
