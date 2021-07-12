package com.globallogic.javaacademy.hibernate.basic.entity;


import com.globallogic.javaacademy.hibernate.basic.converter.YesNoConverter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "MyClient")
@Table(name = "GL_CLIENT")
public class Client {

    @Id
    @GeneratedValue(generator = "client_sequence")
    private Long id;

    @Column(name = "first_name", length = 10)
    private String name;

    private String surname;

    @Transient
    private String transient2;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "enrollment_date")
    @Temporal(TemporalType.DATE) // TIMESTAMP
    private Date enrollmentDate = new Date();

    @Convert(converter = YesNoConverter.class)
    private boolean active;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}