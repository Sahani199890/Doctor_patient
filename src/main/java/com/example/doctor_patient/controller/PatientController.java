package com.example.doctor_patient.controller;

import com.example.doctor_patient.model.Doctor;
import com.example.doctor_patient.model.Patient;
import com.example.doctor_patient.service.PatientService;
import com.example.doctor_patient.util.DocUtil;
import com.example.doctor_patient.util.PatientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientUtil patientUtil;
    @PostMapping("/patient")
    public ResponseEntity<String> addPatient(@RequestBody String patientData){
        List<String> errorCheck= PatientUtil.validatePatient(patientData);
        if(errorCheck.isEmpty()){
            Patient patient=patientUtil.setPatientData(patientData);
            Patient patient1 = patientService.addPatient(patient);
            return new ResponseEntity<>("Patient data added successfully"+patient1.toString(),HttpStatus.CREATED);
        }else {
            String[] answer = Arrays.copyOf(
                    errorCheck.toArray(), errorCheck.size(), String[].class);
            return new ResponseEntity<String>("please provide " +Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/patient/{patientId}")
    public Patient getById(@PathVariable Integer patientId){
        return patientService.getById(patientId);
    }

    @GetMapping("/patient")
    public List<Patient> findAllPatients(){
        return patientService.findAll();
    }


    @PutMapping("/patient-update/{patientIdc}")
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
