package com.avasafir.learning.domain;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "number")
    private int number;
    @Column(name = "area_code")
    private int areaCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }
    @ManyToOne
    @JoinColumn(name = "student_id",foreignKey = @ForeignKey(name = "STUDENT_ID_FK"))
    private Student student;

}
