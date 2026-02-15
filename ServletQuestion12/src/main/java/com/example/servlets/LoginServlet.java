package com.example.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Hardcoded credentials for validation
        // In real applications, this would come from a database
        if (isValidUser(username, password)) {
            // If valid, forward to success page
            RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
            dispatcher.forward(request, response);
        } else {
            // If invalid, redirect back to login with error
            response.sendRedirect("login.jsp?error=1");
        }
    }
    
    // Simple validation method with hardcoded credentials
    private boolean isValidUser(String username, String password) {
        // Hardcoded list of valid users
        // Format: username:password
//        String[][] validUsers = {
//            {"bibek", "bibek123"},
//            {"user", "user123"},
//            {"john", "john123"},
//            {"jane", "jane123"}
//        };
        String[][] validUsers = {
                {"Negha", "Negha123"},
                {"user", "user123"},
                {"john", "john123"},
                {"jane", "jane123"}
            };

        
        // Check if the provided credentials match any in the list
        for (String[] user : validUsers) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    // Handle GET requests - redirect to login page
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}