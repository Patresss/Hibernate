package com.globallogic.javaacademy.hibernate.basic.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "MyClient")
@Table(name = "BUSSINESS_CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_name", nullable = false, length = 32)
    private String name;

    @Temporal(TemporalType.DATE)
    private Date enrollmentDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Transient
    private String uuid;


    public Client() {

    }

    public Client(String name, Date enrollmentDate, Gender gender) {
        this.name = name;
        this.enrollmentDate = enrollmentDate;
        this.gender = gender;
        this.uuid = UUID.randomUUID().toString();
    }

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

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
