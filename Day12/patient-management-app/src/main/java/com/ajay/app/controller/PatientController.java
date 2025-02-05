package com.ajay.app.controller;

import org.springframework.web.bind.annotation.*;
import com.ajay.app.model.Patient;
import com.ajay.app.service.PatientService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/get")
    public Map<String, Patient> getAllPatients() {
        return patientService.readAllPatients();
    }

    @PostMapping("/create")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/update")
    public Patient updatePatient(@RequestParam("id") String id,@RequestParam("newHospitalName") String newHospitalName) {
        return patientService.updatePatient(id,newHospitalName);
    }

    @DeleteMapping("/delete")
    public void deletePatient(@RequestParam("id") String id) {
        patientService.deletePatient(id);
    }
}


