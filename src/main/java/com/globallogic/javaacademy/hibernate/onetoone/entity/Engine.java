package com.globallogic.javaacademy.hibernate.onetoone.entity;

import javax.persistence.*;


@Entity
public class Engine {

    @Id
    @GeneratedValue(generator = "engine_sequence")
    @Column(name = "engine_id")
    private Long id;

    private String name;

    @OneToOne(mappedBy = "engine")
    private Car car;

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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

