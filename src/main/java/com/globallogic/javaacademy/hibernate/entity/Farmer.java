package com.globallogic.javaacademy.hibernate.entity;


import com.globallogic.javaacademy.hibernate.converter.YesNoConverter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "FARMER")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "farmer_generator")
    @SequenceGenerator(name = "farmer_generator", sequenceName = "farmer_seq", allocationSize = 50)
    @Column(name = "FARMER_ID")
    private Long id;

    private String name;

    @Column(name = "SURNAME")
    private String lastName;

    @Enumerated(value = STRING)
    private Gender gender;

    @Column(name = "ACTIVE_STATUS")
    @Convert(converter = YesNoConverter.class)
    private boolean activeStatus;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRACT_ID", referencedColumnName = "CONTRACT_ID")
    private Contract contract;

    @OneToMany(
            mappedBy = "farmer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Contact> contacts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "FARMER_ADDRESS",
            joinColumns = @JoinColumn(name = "FARMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
    )
    private Set<Address> addresses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public Farmer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Farmer setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Farmer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public Farmer setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public Farmer setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
        return this;
    }

    public Contract getContract() {
        return contract;
    }

    public Farmer setContract(Contract contract) {
        this.contract = contract;
        return this;
    }

    public void addContact(final Contact contact) {
        contact.setFarmer(this);
        contacts.add(contact);
    }

    public void removeContact(final Contact contact) {
        contact.setFarmer(null);
        contacts.remove(contact);
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void addAddress(final Address address) {
        addresses.add(address);
    }

    public Set<Address> getAddresses() {
        return addresses;
    }
}
