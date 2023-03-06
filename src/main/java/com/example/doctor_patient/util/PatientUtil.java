package com.example.doctor_patient.util;

import com.example.doctor_patient.model.Doctor;
import com.example.doctor_patient.model.Patient;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PatientUtil {
    public static List<String> validatePatient(String doctorData) {
        List<String> errorList=new ArrayList<>();
        JSONObject jsonObject=new JSONObject(doctorData);
        if(!jsonObject.has("patientName")){
            errorList.add("please enter (patientName)");
        }
        if(!jsonObject.has("patientNumber")){
            errorList.add("please enter (patientNumber");
        }
        if(!jsonObject.has("patientDisease")){
            errorList.add("please enter (patientDisease");
        }
        if(!jsonObject.has("gender")){
            errorList.add("please enter (gender)");
        }
        return errorList;

    }
    public static Patient setPatientData(String patientData) {
        JSONObject json=new JSONObject(patientData);
        Patient patient=new Patient();
        patient.setPatientName(json.getString("patientName"));
        patient.setPatientNumber(json.getString("patientNumber"));
        patient.setPatientDisease(json.getString("patientDisease"));
        patient.setGender(json.getString("gender"));
        return patient;
    }
}
