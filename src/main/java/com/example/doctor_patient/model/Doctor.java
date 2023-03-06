package com.example.doctor_patient.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor_tbl")
public class Doctor {
    @Id
    @Column(name="doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;
    @Column(name="doctor_name")
    private String doctorName;
    @Column(name="doctor_exp")
    private String doctorExp;
    @Column(name="specialization")
    private String specializedIn;
}