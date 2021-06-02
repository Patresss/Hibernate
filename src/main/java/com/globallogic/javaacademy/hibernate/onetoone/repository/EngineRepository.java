package com.globallogic.javaacademy.hibernate.onetoone.repository;

import com.globallogic.javaacademy.hibernate.onetoone.entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {
}
