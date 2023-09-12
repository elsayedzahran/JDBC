package Repositories;

import java.sql.*;

public class PatientRepository {
    Connection connection;
    public PatientRepository(Connection connection){
        this.connection = connection;
    }
    public void getPatientNamesForEachDoctor(int doctorID) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT p.Name " +
                "FROM Patient p " +
                "WHERE p.DoctorID = ?");
        preparedStatement.setInt(1, doctorID);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String patientName = resultSet.getString("Name");
            System.out.println("Patient Name: " + patientName);
        }

    }
}
