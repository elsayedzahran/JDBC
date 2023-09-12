package Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DrugRepository {
    Connection connection;
    public DrugRepository(Connection connection){
        this.connection = connection;
    }
    public void getDrugNamesForSpecificDoctor(int doctorID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT Drug.DrugName" +
                " FROM Drug" +
                " INNER JOIN DrugPatient  ON Drug.DrugID = DrugPatient.DrugID\n" +
                " INNER JOIN Patient ON DrugPatient.PatientID = Patient.PatientID\n" +
                " where Patient.DoctorID = ?");

        preparedStatement.setInt(1, doctorID);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String patientName = resultSet.getString("DrugName");
            System.out.println("Drug Name: " + patientName);
        }

    }
}
