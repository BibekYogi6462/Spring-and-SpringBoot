package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Set the response type to HTML
        response.setContentType("text/html");
        
        // Get the writer object to write HTML response
        PrintWriter out = response.getWriter();
        
        // Write the welcome message
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Welcome Servlet</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; }");
        out.println("h1 { color: #0066cc; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome to Java Servlets!</h1>");
        out.println("<p>This message is coming from your first servlet using doGet() method.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}