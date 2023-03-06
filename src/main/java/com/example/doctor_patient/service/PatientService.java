package com.example.doctor_patient.service;

import com.example.doctor_patient.dao.IDoctor;
import com.example.doctor_patient.dao.IPatient;
import com.example.doctor_patient.model.Doctor;
import com.example.doctor_patient.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private IPatient iPatient;
    @Autowired
    private IDoctor iDoctor;

    public Patient addPatient(Patient patient) {
        return iPatient.save(patient);
    }

    public Patient getById(Integer patientId) {
        return iPatient.findById(patientId).get();
    }

    public List<Patient> findAll() {
        return iPatient.findAll();
    }

    public Patient updatePatient(Patient patient, Integer patientId) {
        Patient patient1=iPatient.findById(patientId).get();
        patient1.setPatientDisease(patient.getPatientDisease());
        patient1.setPatientNumber(patient.getPatientNumber());
        patient1.setPatientName(patient.getPatientName());
        patient1.setGender(patient.getGender());
        Doctor doctor=patient.getDoctor();
        patient1.setDoctor(doctor);
        return patient1;
    }

    public void deletePatient(Integer patientId) {
        iPatient.deleteById(patientId);
    }
}
