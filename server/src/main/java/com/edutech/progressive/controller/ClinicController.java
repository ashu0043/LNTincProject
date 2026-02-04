package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.impl.ClinicServiceImplJpa;

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
@RequestMapping("/clinic")
public class ClinicController {

    ClinicServiceImplJpa clinicServiceImplJpa;
    
        public ClinicController(ClinicServiceImplJpa clinicServiceImplJpa) {
            this.clinicServiceImplJpa = clinicServiceImplJpa;
        }

    @GetMapping
    public ResponseEntity<?> getAllClinics() {
        return new ResponseEntity<List<Clinic>>(clinicServiceImplJpa.getAllClinics(),HttpStatus.OK);    
    }

    @GetMapping("/{clinicID}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable int clinicID) {
        return new ResponseEntity<Clinic>(clinicServiceImplJpa.getClinicById(clinicID), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> addClinic(@RequestBody Clinic clinic) {
        return new ResponseEntity<Integer>(clinicServiceImplJpa.addClinic(clinic), HttpStatus.CREATED);
    }
    @PutMapping("/{clinicID}")
    public ResponseEntity<Void> updateClinic(@PathVariable int clinicID, @RequestBody Clinic clinic) {
        clinicServiceImplJpa.updateClinic(clinic);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/{clinicID}")
    public ResponseEntity<Void> deleteClinic(@PathVariable int clinicID) {
        clinicServiceImplJpa.deleteClinic(clinicID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Clinic>> getAllClinicByLocation(@PathVariable String location) {
        return new ResponseEntity<List<Clinic>>(clinicServiceImplJpa.getAllClinicByLocation(location), HttpStatus.OK);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Clinic>> getAllClinicByDoctorId(@PathVariable int doctorId) {
        return new ResponseEntity<List<Clinic>>(clinicServiceImplJpa.getAllClinicByDoctorId(doctorId), HttpStatus.OK);
    }
}
