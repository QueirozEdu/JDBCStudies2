package application;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertData {

    public static void main(String[] args) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + "VALUES "
                    + "(?, ?, ?, ?, ?)");

            st.setString(1, "Carl Purple");
            st.setString(2, "carl@gmail.com");
            st.setDate(3, new java.sql.Date(simpleDateFormat.parse("22/05/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Affected rows: " + rowsAffected);
        }
        catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
