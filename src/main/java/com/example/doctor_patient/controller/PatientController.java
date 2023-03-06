package com.example.doctor_patient.controller;

import com.example.doctor_patient.model.Doctor;
import com.example.doctor_patient.model.Patient;
import com.example.doctor_patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/patient-update/{doctorId}")
    public ResponseEntity<Patient> updateDoctor(@RequestBody Patient patient, @PathVariable Integer PatientId){
        Patient patient1 = patientService.updatePatient(patient,PatientId);
        return new ResponseEntity<>(patient1, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/patient-delete/{patientId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Integer patientId){
        patientService.deletePatient(patientId);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }

}
