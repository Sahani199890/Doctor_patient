package com.example.doctor_patient.dao;

import com.example.doctor_patient.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoctor extends JpaRepository<Doctor,Integer> {
}
