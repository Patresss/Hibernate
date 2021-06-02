package com.globallogic.javaacademy.hibernate.basic.repository;

import com.globallogic.javaacademy.hibernate.basic.entity.InfoMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoMessageRepository extends JpaRepository<InfoMessage, Long> {

}
