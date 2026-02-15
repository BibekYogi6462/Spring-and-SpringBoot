package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Database connection details (change according to your database)
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // For MySQL 8+
    // private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // For older MySQL
    // private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver"; // For Derby
    
    private static final String DB_URL = "jdbc:mysql://localhost:3308/studentdb?useSSL=false&serverTimezone=UTC";
    // private static final String DB_URL = "jdbc:derby:studentdb;create=true"; // For Derby
    
    private static final String DB_USER = "root"; // Change to your MySQL username
    private static final String DB_PASSWORD = "bibek"; // Change to your MySQL password

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            // Load JDBC driver
            Class.forName(JDBC_DRIVER);
            
            // Establish connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            // SQL query to fetch all students
            String sql = "SELECT id, name, email, course, city, join_date FROM students ORDER BY id";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            // Start HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student List</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f4; }");
            out.println(".container { max-width: 1200px; margin: auto; background: white; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
            out.println("h2 { color: #333; text-align: center; margin-bottom: 30px; }");
            out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            out.println("th { background-color: #4CAF50; color: white; padding: 12px; text-align: left; }");
            out.println("td { padding: 10px; border-bottom: 1px solid #ddd; }");
            out.println("tr:hover { background-color: #f5f5f5; }");
            out.println(".record-count { margin-top: 20px; padding: 10px; background-color: #e7f3ff; border-left: 4px solid #2196F3; }");
            out.println(".no-data { text-align: center; color: #999; padding: 50px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h2>Student Records</h2>");
            
            // Check if there are records
            if (!rs.isBeforeFirst()) {
                out.println("<div class='no-data'>No students found in the database.</div>");
            } else {
                // Start table
                out.println("<table>");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th>ID</th>");
                out.println("<th>Name</th>");
                out.println("<th>Email</th>");
                out.println("<th>Course</th>");
                out.println("<th>City</th>");
                out.println("<th>Join Date</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody>");
                
                int count = 0;
                // Iterate through result set
                while (rs.next()) {
                    count++;
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String course = rs.getString("course");
                    String city = rs.getString("city");
                    java.sql.Date joinDate = rs.getDate("join_date");
                    
                    out.println("<tr>");
                    out.println("<td>" + id + "</td>");
                    out.println("<td>" + name + "</td>");
                    out.println("<td>" + email + "</td>");
                    out.println("<td>" + course + "</td>");
                    out.println("<td>" + city + "</td>");
                    out.println("<td>" + joinDate + "</td>");
                    out.println("</tr>");
                }
                
                out.println("</tbody>");
                out.println("</table>");
                
                // Show record count
                out.println("<div class='record-count'>");
                out.println("<strong>Total Records:</strong> " + count + " student(s) found");
                out.println("</div>");
            }
            
            out.println("<br><a href='index.html' style='display: inline-block; padding: 10px 20px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 4px;'>Back to Home</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (ClassNotFoundException e) {
            out.println("<div style='color: red; padding: 20px; background-color: #ffebee; border: 1px solid #ffcdd2; border-radius: 4px; margin: 20px;'>");
            out.println("<h3>Database Driver Error!</h3>");
            out.println("<p>JDBC Driver not found. Make sure you have added the database JAR file.</p>");
            out.println("<p>Error: " + e.getMessage() + "</p>");
            out.println("</div>");
            e.printStackTrace();
        } catch (SQLException e) {
            out.println("<div style='color: red; padding: 20px; background-color: #ffebee; border: 1px solid #ffcdd2; border-radius: 4px; margin: 20px;'>");
            out.println("<h3>Database Connection Error!</h3>");
            out.println("<p>Could not connect to database. Please check:</p>");
            out.println("<ul>");
            out.println("<li>Database server is running</li>");
            out.println("<li>Database name is correct</li>");
            out.println("<li>Username and password are correct</li>");
            out.println("</ul>");
            out.println("<p>Error: " + e.getMessage() + "</p>");
            out.println("</div>");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Handle POST requests the same as GET
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}