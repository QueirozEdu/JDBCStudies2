package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSalary {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DB.getConnection();

            preparedStatement = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE "
                            + "(DepartmentId = ?)");

            preparedStatement.setDouble(1, 200.0);
            preparedStatement.setInt(2, 2);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}
