package application;

import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DB.getConnection();

            preparedStatement = conn.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE "
                            + "Id = ?"
            );
            preparedStatement.setInt(1, 5);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);

        }
        catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }
    }
}