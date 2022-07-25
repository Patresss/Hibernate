package com.globallogic.javaacademy.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Position {

    @Column(name = "POSITION_X")
    private Long positionX;

    @Column(name = "POSITION_Y")
    private Long positionY;


    public Long getPositionX() {
        return positionX;
    }

    public Position setPositionX(Long positionX) {
        this.positionX = positionX;
        return this;
    }

    public Long getPositionY() {
        return positionY;
    }

    public Position setPositionY(Long positionY) {
        this.positionY = positionY;
        return this;
    }
}
