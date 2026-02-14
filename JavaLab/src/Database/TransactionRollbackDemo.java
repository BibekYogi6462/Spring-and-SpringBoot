package Database;

import java.sql.*;

public class TransactionRollbackDemo
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
            
            // First operation: Insert a record
            String insertSQL = "INSERT INTO bank_accounts (account_holder, balance) " +
                              "VALUES ('Liza', 10000.00)";
            stmt.executeUpdate(insertSQL);
            System.out.println("Record inserted: Liza with balance 10000.0");
            
            // Intentionally cause an error (divide by zero)
            System.out.println("\nIntentionally causing an error...");
            int result = 10 / 0; // This will throw ArithmeticException
            
            // Second operation: Update record (this will not execute)
            String updateSQL = "UPDATE bank_accounts SET balance = 15000.00 " +
                              "WHERE account_holder = 'Liza'";
            stmt.executeUpdate(updateSQL);
            System.out.println("Record updated successfully");
            
            // Commit if all operations succeed
            conn.commit();
            System.out.println("\nSUCCESS: Transaction committed!");
            
        }
        catch (ArithmeticException e)
        {
            System.out.println("\nERROR: Arithmetic exception occurred - " + e.getMessage());
            rollbackTransaction(conn);
        }
        catch (SQLException e)
        {
            System.out.println("\nERROR: Database error - " + e.getMessage());
            rollbackTransaction(conn);
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
            rollbackTransaction(conn);
        }
        finally
        {
            // Display final state of table
            displayRecords(conn);
            
            // Clean up resources
            try
            {
                if (stmt != null) stmt.close();
                if (conn != null)
                {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    
    // Method to rollback transaction
    public static void rollbackTransaction(Connection conn)
    {
        try
        {
            if (conn != null)
            {
                conn.rollback();
                System.out.println("Transaction rolled back - no changes saved to database");
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Rollback failed: " + ex.getMessage());
        }
    }
    
    // Method to display records (matching your old code's column names)
    public static void displayRecords(Connection conn)
    {
        try
        {
            if (conn == null || conn.isClosed())
            {
                System.out.println("\nCannot display records - no database connection");
                return;
            }
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bank_accounts");
            
            System.out.println("\nCurrent records in bank_accounts table:");
            System.out.println("----------------------------------------");
            System.out.println("ID\tAccount Holder\t\tBalance");
            System.out.println("----------------------------------------");
            
            boolean hasRecords = false;
            while (rs.next())
            {
                hasRecords = true;
                int id = rs.getInt("account_id");        // Using account_id
                String holder = rs.getString("account_holder"); // Using account_holder
                double balance = rs.getDouble("balance");      // Using balance
                
                System.out.println(id + "\t" + holder + "\t\t$" + balance);
            }
            
            if (!hasRecords)
            {
                System.out.println("No records found in table (transaction was rolled back)");
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