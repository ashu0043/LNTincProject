package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.ClinicService;

@Service
public class ClinicServiceImplJpa implements ClinicService {

    @Override
    public List<Clinic> getAllClinics() throws SQLException {
        return new ArrayList<>();
    }

    @Override
    public Clinic getClinicById(int clinicId) {
        return null;
    }

    @Override
    public Integer addClinic(Clinic clinic) {
        return -1;
    }

    @Override
    public void updateClinic(Clinic clinic) {
        
    }

    @Override
    public void deleteClinic(int clinicId) {
        
    }

}