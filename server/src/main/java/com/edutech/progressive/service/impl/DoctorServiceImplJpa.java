package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.service.DoctorService;

@Service
public class DoctorServiceImplJpa implements DoctorService{

    @Override
    public List<Doctor> getAllDoctors() {
        return new ArrayList<>();
    }

    @Override
    public Integer addDoctor(Doctor doctor) {
        return -1;
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() {
        return new ArrayList<>();
    }
    public void updateDoctor(Doctor doctor) { }

    public void deleteDoctor(int doctorId) { }

    public Doctor getDoctorById(int doctorId) { return null; }

}