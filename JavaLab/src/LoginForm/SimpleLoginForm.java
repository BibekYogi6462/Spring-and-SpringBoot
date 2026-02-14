package LoginForm;

import java.awt.event.*;
import javax.swing.*;

public class SimpleLoginForm
{
    SimpleLoginForm()
    {
        JFrame jframe = new JFrame("Login Form");
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 30, 80, 20);
        jframe.add(lblUsername);
        
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(100, 30, 150, 20);
        jframe.add(txtUsername);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 60, 80, 20);
        jframe.add(lblPassword);
        
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(100, 60, 150, 20);
        jframe.add(txtPassword);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(100, 90, 100, 20);
        jframe.add(btnLogin);
        
        JLabel lblMessage = new JLabel("");
        lblMessage.setBounds(20, 120, 250, 20);
        jframe.add(lblMessage);
        
        jframe.setLayout(null);
        jframe.setSize(300, 200);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnLogin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                
                if(username.equals("admin") && password.equals("9999"))
                {
                    lblMessage.setText("Login Success");
                }
                else
                {
                    lblMessage.setText("Login failed");
                }
            }
        });
    }
    
    public static void main(String args[])
    {
        new SimpleLoginForm();
    }
}
