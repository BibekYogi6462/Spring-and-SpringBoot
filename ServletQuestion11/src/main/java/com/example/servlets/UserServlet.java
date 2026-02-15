package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle POST requests from the form
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get form data from request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        
        // Set response type
        response.setContentType("text/html");
        
        // Write response
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>User Details</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 50px; background-color: #f4f4f4; }");
        out.println(".container { max-width: 500px; margin: auto; background: white; padding: 30px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
        out.println("h2 { color: #4CAF50; text-align: center; }");
        out.println(".detail { margin: 20px 0; padding: 15px; background-color: #f9f9f9; border-left: 4px solid #4CAF50; }");
        out.println(".label { font-weight: bold; color: #555; }");
        out.println(".value { color: #333; margin-top: 5px; }");
        out.println("a { display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #4CAF50; color: white; text-decoration: none; border-radius: 4px; }");
        out.println("a:hover { background-color: #45a049; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h2>Form Submitted Successfully!</h2>");
        
        out.println("<div class='detail'>");
        out.println("<div class='label'>Name:</div>");
        out.println("<div class='value'>" + name + "</div>");
        out.println("</div>");
        
        out.println("<div class='detail'>");
        out.println("<div class='label'>Email:</div>");
        out.println("<div class='value'>" + email + "</div>");
        out.println("</div>");
        
        out.println("<a href='userForm.jsp'>Go Back to Form</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
    // Handle GET requests (optional - redirect to form)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("userForm.jsp");
    }
}