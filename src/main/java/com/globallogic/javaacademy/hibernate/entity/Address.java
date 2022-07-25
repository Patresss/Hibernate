package com.globallogic.javaacademy.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name= "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_generator")
    @SequenceGenerator(name="address_generator", sequenceName = "address_seq", allocationSize = 50)
    @Column(name = "ADDRESS_ID")
    private Long id;

    private String city;

    @Embedded
    private Position position;


    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public Address setPosition(Position position) {
        this.position = position;
        return this;
    }
}
