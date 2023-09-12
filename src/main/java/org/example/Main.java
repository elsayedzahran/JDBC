package org.example;


import Repositories.DoctorRepository;
import Repositories.DrugRepository;
import Repositories.PatientRepository;

import java.sql.Connection;
import java.sql.DriverManager;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String jdbcUrl = "jdbc:mysql://localhost:3306/Hospital?useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection(jdbcUrl,"root","Pa$$w0rd")){

            if (connection != null) {
//                DoctorRepository doctorRepository = new DoctorRepository(connection);
//                doctorRepository.getDoctorsForSpecificHospital(1);
//
//                PatientRepository patientRepository = new PatientRepository(connection);
//                patientRepository.getPatientNamesForEachDoctor(1);

                DrugRepository drugRepository = new DrugRepository(connection);
                drugRepository.getDrugNamesForSpecificDoctor(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}