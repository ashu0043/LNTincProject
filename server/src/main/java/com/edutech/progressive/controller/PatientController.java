package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;
import com.edutech.progressive.service.impl.PatientServiceImplArraylist;
import com.edutech.progressive.service.impl.PatientServiceImplJpa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    // PatientService patientService;
    
    // public PatientController(PatientService patientService) {
    //     this.patientService = patientService;
    // }
    PatientServiceImplArraylist patientServiceImplArraylist;
    PatientServiceImplJpa patientServiceImplJpa;
    
    public PatientController(PatientServiceImplArraylist patientServiceImplArraylist,
            PatientServiceImplJpa patientServiceImplJpa) {
        this.patientServiceImplArraylist = patientServiceImplArraylist;
        this.patientServiceImplJpa = patientServiceImplJpa;
    }

    @GetMapping()
    public ResponseEntity<List<Patient>> getAllPatients() {
        return new ResponseEntity<List<Patient>>(patientServiceImplJpa.getAllPatients(), HttpStatus.OK);
    }

    @GetMapping("{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientId) {
        return new ResponseEntity<Patient>(patientServiceImplJpa.getPatientById(patientId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient) {
        return new ResponseEntity<Integer>(patientServiceImplJpa.addPatient(patient),HttpStatus.OK);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Void> updatePatient(@PathVariable int patientId,@RequestBody Patient patient) {
        patientServiceImplJpa.updatePatient(patient);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable int patientId) {
        patientServiceImplJpa.deletePatient(patientId);
        return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
    }
    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() {
        return new ResponseEntity<List<Patient>>(patientServiceImplArraylist.getAllPatients(), HttpStatus.OK);
    }
    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList() {
        patientServiceImplArraylist.addPatient(null);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() {
        return new ResponseEntity<List<Patient>>(patientServiceImplArraylist.getAllPatientSortedByName(), HttpStatus.OK);

    }
}
