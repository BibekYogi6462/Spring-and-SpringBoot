import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchStudent {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/college";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            while(rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age")
                );
            }

            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
