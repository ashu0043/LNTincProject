package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.impl.DoctorServiceImplJpa;

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
@RequestMapping("/doctor")
public class DoctorController {

    DoctorServiceImplJpa doctorService;
    
    public DoctorController(DoctorServiceImplJpa doctorService) {
        this.doctorService = doctorService;
    }
    
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return new ResponseEntity<List<Doctor>>(doctorService.getAllDoctors(), HttpStatus.OK);
    }
    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable int doctorId) {
        return new ResponseEntity<Doctor>(doctorService.getDoctorById(doctorId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Integer> addDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<Integer>(doctorService.addDoctor(doctor), HttpStatus.CREATED);
    }
    @PutMapping("/{doctorId}")
    public ResponseEntity<Void> updateDoctor(@PathVariable int doctorId,@RequestBody Doctor doctor) {
        doctorService.updateDoctor(doctor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @DeleteMapping("/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable int doctorId) {
        doctorService.deleteDoctor(doctorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/experience")
    public ResponseEntity<List<Doctor>> getDoctorSortedByExperience() {
        return new ResponseEntity<List<Doctor>>(doctorService.getDoctorSortedByExperience(), HttpStatus.OK);
    }
}
