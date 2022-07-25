package com.globallogic.javaacademy.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name= "CONTRACT")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contract_generator")
    @SequenceGenerator(name="contract_generator", sequenceName = "contract_seq", allocationSize = 50)
    @Column(name = "CONTRACT_ID")
    private Long id;

    private String name;
}
