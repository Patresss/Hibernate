package com.globallogic.javaacademy.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name= "CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_generator")
    @SequenceGenerator(name="contact_generator", sequenceName = "contact_seq", allocationSize = 50)
    @Column(name = "CONTACT_ID")
    private Long id;


    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FARMER_ID")
    private Farmer farmer;

    public Long getId() {
        return id;
    }

    public Contact setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contact setPhoneNumber(String name) {
        this.phoneNumber = name;
        return this;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public Contact setFarmer(Farmer farmer) {
        this.farmer = farmer;
        return this;
    }
}
