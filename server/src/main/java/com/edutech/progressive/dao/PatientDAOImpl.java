package com.edutech.progressive.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Patient;

public class PatientDAOImpl implements PatientDAO {

    private Connection connection;
    
    public PatientDAOImpl() {
        try {
            connection=DatabaseConnectionManager.getConnection();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public int addPatient(Patient patient) throws SQLException{
        String sql="insert into patient (full_name, date_of_birth, contact_number, email, address) values (?,?,?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,patient.getFullName());
            ps.setDate(2,new Date(patient.getDateOfBirth().getTime()));
            ps.setString(3,patient.getContactNumber());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                patient.setPatientId(rs.getInt(1));
            }
            // return patient.getPatientId();
        }
        // catch(SQLException e){
        //     System.out.println(e);
        // }
        return patient.getPatientId();
    }

    @Override
    public Patient getPatientById(int patientId)throws SQLException{
        String sql="select * from patient where patient_id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1,patientId);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                return new Patient(patientId, rs.getString("full_name"), new Date(rs.getDate("date_of_birth").getTime()), rs.getString("contact_number"), rs.getString("email"), rs.getString("address"));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void updatePatient(Patient patient) throws SQLException{
        String sql="update patient set full_name=?, date_of_birth=?, contact_number=?, email=?, address=? where patient_id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setString(1,patient.getFullName());
            ps.setDate(2,new Date(patient.getDateOfBirth().getTime()));
            ps.setString(3,patient.getContactNumber());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setInt(6,patient.getPatientId());
            ps.executeUpdate();
            
            // return patient.getPatientId();
        }
        // catch(SQLException e){
        //     System.out.println(e);
        // }
    }

    @Override
    public void deletePatient(int patientId) throws SQLException{
        String sql="delete from patient where patient_id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ps.setInt(1,patientId);
            ps.executeUpdate();
        }
        // catch(SQLException e){
        //     System.out.println(e);
        // }
    }

    @Override
    public List<Patient> getAllPatients() throws SQLException{
        String sql="select * from patient";
        List<Patient> pat=new ArrayList<>();
        try(PreparedStatement ps=connection.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                pat.add(new Patient(rs.getInt("patient_id"), rs.getString("full_name"), new Date(rs.getDate("date_of_birth").getTime()), rs.getString("contact_number"), rs.getString("email"), rs.getString("address")));
            }
            // Collections.sort(pat,Comparator.comparing(Patient::getFullName));
            return pat;
        }
        // catch(SQLException e){
        //     System.out.println(e);
        // }
        // return pat;
    }

}
