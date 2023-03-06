package com.example.doctor_patient.service;

import com.example.doctor_patient.dao.IDoctor;
import com.example.doctor_patient.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private IDoctor iDoctor;

    public Doctor addDoctor(Doctor doctor) {
        return iDoctor.save(doctor);
    }

    public Doctor getById(int id) {
        return iDoctor.findById(id).get();
    }

    public List<Doctor> getAllDoctor() {
        return iDoctor.findAll();
    }
    public void deleteDoctor(Integer doctorId){
        iDoctor.deleteById(doctorId);
    }
    public Doctor updateDoctor(Integer doctorId,Doctor doctor){
        Doctor doctor1=iDoctor.findById(doctorId).get();
        doctor1.setDoctorName(doctor.getDoctorName());
        doctor1.setDoctorExp(doctor.getDoctorExp());
//        doctor.setPatient(doctor1.getPatient());
        doctor1.setSpecializedIn(doctor.getSpecializedIn());
        return iDoctor.save(doctor);
    }

}
