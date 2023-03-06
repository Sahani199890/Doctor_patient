package com.example.doctor_patient.util;

import com.example.doctor_patient.dao.IDoctor;
import com.example.doctor_patient.model.Doctor;
import com.example.doctor_patient.model.Patient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PatientUtil {
    @Autowired
    private IDoctor doctorRepo;
    public static List<String> validatePatient(String doctorData) {
        List<String> errorList=new ArrayList<>();
        JSONObject jsonObject=new JSONObject(doctorData);
        if(!jsonObject.has("patientName")){
            errorList.add("patientName");
        }
        else{
            String patientName = jsonObject.getString("patientName");
            if(patientName.length()<4 && patientName.length()>20){
                errorList.add("please enter valid name");
            }
        }
        if(!jsonObject.has("patientNumber")){
            errorList.add("patientNumber");
        }
        if(!jsonObject.has("patientDisease")){
            errorList.add("patientDisease");
        }
        if(!jsonObject.has("gender")){
            errorList.add("gender");
        }
        if(!jsonObject.has("doctorId")){
            errorList.add("doctorId");
        }
        return errorList;

    }
    public Patient setPatientData(String patientData) {
        JSONObject json=new JSONObject(patientData);
        Patient patient=new Patient();
        patient.setPatientName(json.getString("patientName"));
        patient.setPatientNumber(json.getString("patientNumber"));
        patient.setPatientDisease(json.getString("patientDisease"));
        patient.setGender(json.getString("gender"));
        int doctorId = json.getInt("doctorId");
        Doctor doctor = doctorRepo.findById(doctorId).get();
        patient.setDoctor(doctor);
        return patient;
    }
}
