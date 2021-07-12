package com.globallogic.javaacademy.hibernate.basic.repository;

import com.globallogic.javaacademy.hibernate.basic.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
