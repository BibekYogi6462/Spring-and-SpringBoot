import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionTest {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/college";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);

            if(con != null) {
                System.out.println("Connected Successfully!");
            }

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
