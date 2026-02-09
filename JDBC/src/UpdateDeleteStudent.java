import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateDeleteStudent {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/college";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);

            // UPDATE
            String updateQuery = "UPDATE student SET age=? WHERE id=?";
            PreparedStatement ps1 = con.prepareStatement(updateQuery);
            ps1.setInt(1, 25);
            ps1.setInt(2, 1);
            ps1.executeUpdate();

            System.out.println("Record Updated");

            // DELETE
            String deleteQuery = "DELETE FROM student WHERE id=?";
            PreparedStatement ps2 = con.prepareStatement(deleteQuery);
            ps2.setInt(1, 1);
            ps2.executeUpdate();

            System.out.println("Record Deleted");

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
