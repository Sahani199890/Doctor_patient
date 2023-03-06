package com.example.doctor_patient.dao;

import com.example.doctor_patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatient extends JpaRepository<Patient,Integer> {
}
