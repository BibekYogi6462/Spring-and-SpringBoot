package Database;

import java.sql.*;
import java.util.Scanner;

public class FundsTransfer
{
    public static void main(String args[])
    {
        Connection conn = null;
        Scanner scanner = new Scanner(System.in);
        
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
            
            // Display available accounts
            displayAllAccounts(conn);
            
            // Get transfer details from user
            System.out.println("\nFunds Transfer");
            System.out.print("Enter sender name: ");
            String sender = scanner.nextLine();
            
            System.out.print("Enter receiver name: ");
            String receiver = scanner.nextLine();
            
            System.out.print("Enter amount to transfer: ");
            double transferAmount = scanner.nextDouble();
            
            // Disable auto-commit (start transaction)
            conn.setAutoCommit(false);
            
            System.out.println("\nProcessing transfer...");
            System.out.println("----------------------------------------");
            
            // Perform transfer
            boolean success = transferFunds(conn, sender, receiver, transferAmount);
            
            if (success)
            {
                conn.commit();
                System.out.println("\nTRANSFER SUCCESSFUL!");
            }
            else
            {
                conn.rollback();
                System.out.println("\nTRANSFER FAILED - Transaction rolled back");
            }
            
            // Display updated balances
            displaySpecificBalances(conn, sender, receiver);
            
        }
        catch (Exception e)
        {
            System.out.println("\nERROR: " + e.getMessage());
            
            try
            {
                if (conn != null)
                {
                    conn.rollback();
                    System.out.println("Transaction rolled back due to error");
                }
            }
            catch (SQLException ex)
            {
                System.out.println("Rollback failed: " + ex.getMessage());
            }
        }
        finally
        {
            scanner.close();
            try
            {
                if (conn != null)
                {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            }
            catch (SQLException e)
            {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
    
    public static boolean transferFunds(Connection conn, String sender, String receiver, double amount)
    {
        PreparedStatement pstmtCheck = null;
        PreparedStatement pstmtDeduct = null;
        PreparedStatement pstmtAdd = null;
        ResultSet rs = null;
        
        try
        {
            // Check if both accounts exist and get sender's balance
            String checkSQL = "SELECT account_holder, balance FROM bank_accounts WHERE account_holder IN (?, ?)";
            pstmtCheck = conn.prepareStatement(checkSQL);
            pstmtCheck.setString(1, sender);
            pstmtCheck.setString(2, receiver);
            rs = pstmtCheck.executeQuery();
            
            boolean senderFound = false;
            boolean receiverFound = false;
            double senderBalance = 0;
            
            while (rs.next())
            {
                String holder = rs.getString("account_holder");
                double balance = rs.getDouble("balance");
                
                if (holder.equals(sender))
                {
                    senderFound = true;
                    senderBalance = balance;
                    System.out.println("Sender: " + holder + " - $" + balance);
                }
                else if (holder.equals(receiver))
                {
                    receiverFound = true;
                    System.out.println("Receiver: " + holder + " - $" + balance);
                }
            }
            
            // Validate accounts
            if (!senderFound)
            {
                System.out.println("Error: Sender account '" + sender + "' not found");
                return false;
            }
            
            if (!receiverFound)
            {
                System.out.println("Error: Receiver account '" + receiver + "' not found");
                return false;
            }
            
            // Check sufficient balance
            if (senderBalance < amount)
            {
                System.out.println("Error: Insufficient balance!");
                System.out.println("Available: $" + senderBalance + ", Required: $" + amount);
                return false;
            }
            
            if (amount <= 0)
            {
                System.out.println("Error: Transfer amount must be positive");
                return false;
            }
            
            // Perform transfer
            String deductSQL = "UPDATE bank_accounts SET balance = balance - ? WHERE account_holder = ?";
            pstmtDeduct = conn.prepareStatement(deductSQL);
            pstmtDeduct.setDouble(1, amount);
            pstmtDeduct.setString(2, sender);
            pstmtDeduct.executeUpdate();
            System.out.println("Deducted $" + amount + " from " + sender);
            
            String addSQL = "UPDATE bank_accounts SET balance = balance + ? WHERE account_holder = ?";
            pstmtAdd = conn.prepareStatement(addSQL);
            pstmtAdd.setDouble(1, amount);
            pstmtAdd.setString(2, receiver);
            pstmtAdd.executeUpdate();
            System.out.println("Added $" + amount + " to " + receiver);
            
            return true;
            
        }
        catch (SQLException e)
        {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                if (pstmtCheck != null) pstmtCheck.close();
                if (pstmtDeduct != null) pstmtDeduct.close();
                if (pstmtAdd != null) pstmtAdd.close();
            }
            catch (SQLException e)
            {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
    
    public static void displayAllAccounts(Connection conn)
    {
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bank_accounts");
            
            System.out.println("\nAvailable Accounts:");
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
            System.out.println("Error displaying accounts: " + e.getMessage());
        }
    }
    
    public static void displaySpecificBalances(Connection conn, String sender, String receiver)
    {
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(
                "SELECT account_holder, balance FROM bank_accounts WHERE account_holder IN (?, ?)"
            );
            pstmt.setString(1, sender);
            pstmt.setString(2, receiver);
            ResultSet rs = pstmt.executeQuery();
            
            System.out.println("\nFinal Balances:");
            System.out.println("----------------------------------------");
            
            while (rs.next())
            {
                String holder = rs.getString("account_holder");
                double balance = rs.getDouble("balance");
                System.out.println(holder + ": $" + balance);
            }
            
            rs.close();
            pstmt.close();
        }
        catch (SQLException e)
        {
            System.out.println("Error displaying balances: " + e.getMessage());
        }
    }
}