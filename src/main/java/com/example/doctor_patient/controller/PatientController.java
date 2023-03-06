package com.example.doctor_patient.controller;

import com.example.doctor_patient.model.Patient;
import com.example.doctor_patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("/patient")
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }
    @GetMapping("/patient/{patientId}")
    public Patient getById(@PathVariable Integer patientId){
        return patientService.getById(patientId);
    }
    @GetMapping("/patient")
    public List<Patient> findAllPatients(){
        return patientService.findAll();
    }

}
