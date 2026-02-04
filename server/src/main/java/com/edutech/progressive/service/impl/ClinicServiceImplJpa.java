package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.service.ClinicService;

@Service
public class ClinicServiceImplJpa implements ClinicService {

    ClinicRepository clinicRepository;
    
    public ClinicServiceImplJpa(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> getAllClinics(){
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getClinicById(int clinicId) {
        return clinicRepository.findByClinicId(clinicId);
    }

    @Override
    public Integer addClinic(Clinic clinic) {
        Clinic c1=clinicRepository.save(clinic);
        return c1.getClinicId();
    }

    @Override
    public void updateClinic(Clinic clinic) {
        Clinic c1=getClinicById(clinic.getClinicId());
        c1.setClinicName(clinic.getClinicName());
        c1.setContactNumber(clinic.getContactNumber());
        c1.setDoctorId(clinic.getDoctorId());
        c1.setDoctor(clinic.getDoctor());
        c1.setEstablishedYear(clinic.getEstablishedYear());
        c1.setLocation(clinic.getLocation());
        clinicRepository.save(c1);
    }

    @Override
    public void deleteClinic(int clinicId) {
        clinicRepository.deleteById(clinicId);
    }

    public List<Clinic> getAllClinicByLocation(String location) {
        return clinicRepository.findAllByLocation(location);
     }

    public List<Clinic> getAllClinicByDoctorId(int doctorId) { 
        return clinicRepository.findAllByDoctorId(doctorId);
    }

}