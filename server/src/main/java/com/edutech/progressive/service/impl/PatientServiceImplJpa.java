package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.repository.PatientRepository;
import com.edutech.progressive.service.PatientService;

@Service
public class PatientServiceImplJpa implements PatientService {

    PatientRepository patientRepository;
    
    
    public PatientServiceImplJpa(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Integer addPatient(Patient patient) {
        Patient p1=patientRepository.save(patient);
        return p1.getPatientId();
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        List<Patient> pat=patientRepository.findAll();
        Collections.sort(pat);
        return pat;
    }
    public void updatePatient(Patient patient) {
        Patient pat=getPatientById(patient.getPatientId());
        pat.setFullName(patient.getFullName());
        pat.setDateOfBirth(patient.getDateOfBirth());
        pat.setAddress(patient.getAddress());
        pat.setEmail(patient.getEmail());
        pat.setContactNumber(patient.getContactNumber());
        patientRepository.save(pat);
    }

    public void deletePatient(int patientId) {
        patientRepository.deleteById(patientId);
    }

    public Patient getPatientById(int patientId) {
        return patientRepository.findByPatientId(patientId);
    }

}