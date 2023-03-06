package com.example.doctor_patient.service;

import com.example.doctor_patient.dao.IPatient;
import com.example.doctor_patient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private IPatient iPatient;

    public Patient addPatient(Patient patient) {
        return iPatient.save(patient);
    }

    public Patient getById(Integer patientId) {
        return iPatient.findById(patientId).get();
    }

    public List<Patient> findAll() {
        return iPatient.findAll();
    }
}
