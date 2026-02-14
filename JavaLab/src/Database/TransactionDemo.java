package Database;

import java.sql.*;

public class TransactionDemo
{
    public static void main(String args[])
    {
        Connection conn = null;
        Statement stmt = null;
        
        try
        {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3308/bankdb", 
                "root", 
                "bibek"
            );
            
            // Disable auto-commit (start transaction)
            conn.setAutoCommit(false);
            
            // Create statement
            stmt = conn.createStatement();
            
            // Create table if not exists
            String createTable = "CREATE TABLE IF NOT EXISTS bank_accounts (" +
                                "account_id INT PRIMARY KEY AUTO_INCREMENT, " +
                                "account_holder VARCHAR(50), " +
                                "balance DOUBLE)";
            stmt.executeUpdate(createTable);
            
            // Insert first record
            String insert1 = "INSERT INTO bank_accounts (account_holder, balance) " +
                           "VALUES ('Negha Shrestha', 4000.00)";
            stmt.executeUpdate(insert1);
            System.out.println("First record inserted successfully");
            
            // Insert second record
            String insert2 = "INSERT INTO bank_accounts (account_holder, balance) " +
                           "VALUES ('Kreeti Shrestha', 5000.00)";
            stmt.executeUpdate(insert2);
            System.out.println("Second record inserted successfully");
            
            // Commit both inserts as a single unit
            conn.commit();
            System.out.println("\nSUCCESS: Both records inserted and committed successfully!");
            
            // Display all records
            displayRecords(conn);
            
        }
        catch (SQLException e)
        {
            System.out.println("\n❌ ERROR: Transaction failed!");
            System.out.println("Reason: " + e.getMessage());
            
            // Rollback if connection is still valid
            if (conn != null)
            {
                try
                {
                    conn.rollback();
                    System.out.println("Transaction rolled back");
                }
                catch (SQLException ex)
                {
                    System.out.println("Rollback failed: " + ex.getMessage());
                }
            }
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
        }
        finally
        {
            // Clean up resources
            try
            {
                if (stmt != null) stmt.close();
                if (conn != null)
                {
                    conn.setAutoCommit(true); // Reset auto-commit
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    
    // Method to display records from bank_accounts table
    public static void displayRecords(Connection conn)
    {
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bank_accounts");
            
            System.out.println("\n Current records in bank_accounts table:");
            System.out.println("----------------------------------------");
            System.out.println("ID\tAccount Holder\t\tBalance");
            System.out.println("----------------------------------------");
            
            while (rs.next())
            {
                int id = rs.getInt("account_id");
                String holder = rs.getString("account_holder");
                double balance = rs.getDouble("balance");
                
                System.out.println(id + "\t" + holder + "\t\t$" + balance);
            }
            
            rs.close();
            stmt.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error displaying records: " + e.getMessage());
        }
    }
}