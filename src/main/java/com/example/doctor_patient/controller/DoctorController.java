package com.example.doctor_patient.controller;

import com.example.doctor_patient.model.Doctor;
import com.example.doctor_patient.service.DoctorService;
import com.example.doctor_patient.util.DocUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController{
    @Autowired
    private DoctorService doctorservice;

    @PostMapping("/add-doctor")
    public ResponseEntity<String> addDoctor(@RequestBody String doctorData){
        List<String> errorCheck=DocUtil.Validate(doctorData);
        if(errorCheck.isEmpty()){
            Doctor doctor=DocUtil.setDoctorData(doctorData);
            doctorservice.addDoctor(doctor);
            return new ResponseEntity<>("Doctor data added successfully",HttpStatus.CREATED);
        }else {
//            String[] ans= Arrays.copyOf(errorCheck.toArray(),errorCheck.size(),String[].class);
            return new ResponseEntity<String>("please provide " +errorCheck.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/doctor/{doctorId}")
    public Doctor getById(@PathVariable int doctorId){
        return doctorservice.getById(doctorId);
    }
    @GetMapping("/all-doctor")
    public List<Doctor> getAllDoctor(){
        return doctorservice.getAllDoctor();
    }
    @PutMapping("/doctor-update/{doctorId}")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable Integer doctorId){
        Doctor doctor1 = doctorservice.updateDoctor(doctorId, doctor);
        return new ResponseEntity<>(doctor1, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/doctor-delete/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Integer doctorId){
        doctorservice.deleteDoctor(doctorId);
        return new ResponseEntity<>("successfully deleted", HttpStatus.OK);
    }
}
