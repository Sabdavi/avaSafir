package com.avasafir.learning.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "student_address")
public class StudentAddress implements Serializable {
    @Id
    @ManyToOne
    private Student student;

    @Id
    @ManyToOne
    private Address address;
}
