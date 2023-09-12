package Repositories;

import java.sql.*;

public class DoctorRepository {
    Connection connection;
    public DoctorRepository(Connection connection){
        this.connection = connection;
    }
    public void getDoctorsForSpecificHospital(int hospitalID) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT d.Name " +
                "FROM Doctor d " +
                "WHERE d.HospitalID = ?");
        preparedStatement.setInt(1, hospitalID);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String doctorName = resultSet.getString("Name");
            System.out.println("Doctor Name: " + doctorName);
        }
    }

}
