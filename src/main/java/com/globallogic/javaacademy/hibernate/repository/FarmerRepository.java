package com.globallogic.javaacademy.hibernate.repository;

import com.globallogic.javaacademy.hibernate.entity.Farmer;
import com.globallogic.javaacademy.hibernate.entity.Gender;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {


    //@Query("select f From Farmer f join fetch f.contacts")
//    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, attributePaths = "contacts")
    Set<Farmer> findAllByGender(Gender gender);


    @Query("Select f from Farmer f where f.activeStatus = :activeStatus")
    Set<Farmer> findFarmerByActiveStatus(boolean activeStatus);
}
