import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertStudent {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/college";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO student(id, name, age) VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setString(2, "Bibek");
            ps.setInt(3, 21);

            int rows = ps.executeUpdate();
            System.out.println(rows + " Record Inserted");

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

