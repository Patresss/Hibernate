package com.globallogic.javaacademy.hibernate.onetoone.entity;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(generator = "car_sequence")
    @Column(name = "car_id")
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "car_engine_id", referencedColumnName = "engine_id")
    private Engine engine;

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

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
