package com.globallogic.javaacademy.hibernate.nplusoneproblem.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Person {

    @Id
    @GeneratedValue(generator = "person_sequence")
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
