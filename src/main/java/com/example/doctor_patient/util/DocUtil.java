package com.example.doctor_patient.util;

import com.example.doctor_patient.model.Doctor;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DocUtil {
     public static List<String> Validate(String doctorData) {
        List<String> errorList=new ArrayList<>();
        JSONObject jsonObject=new JSONObject(doctorData);
        if(!jsonObject.has("doctorName")){
            errorList.add("please enter doctor name as (doctorName)");
        }
        if(!jsonObject.has("doctorExp")){
            errorList.add("please enter doctor's experience as (doctorExp)");
        }
        if(!jsonObject.has("specializedIn")){
            errorList.add("please enter doctor's specializedIn as (specializedIn");
        }
        return errorList;

    }
     public static Doctor setDoctorData(String doctorData) {
        JSONObject json=new JSONObject(doctorData);
        Doctor doctor=new Doctor();
        doctor.setDoctorExp(json.getString("doctorExp"));
        doctor.setDoctorName(json.getString("doctorName"));
        doctor.setSpecializedIn(json.getString("specializedIn"));
        return doctor;
    }
}
