package Calculator;

import java.awt.event.*;
import javax.swing.*;

public class Calculator
{
    Calculator()
    {
        JFrame jframe = new JFrame("Calculator");
        
        JLabel lblNum1 = new JLabel("Number 1:");
        lblNum1.setBounds(20, 30, 80, 20);
        jframe.add(lblNum1);
        
        JTextField txtNum1 = new JTextField();
        txtNum1.setBounds(100, 30, 150, 20);
        jframe.add(txtNum1);
        
        JLabel lblNum2 = new JLabel("Number 2:");
        lblNum2.setBounds(20, 60, 80, 20);
        jframe.add(lblNum2);
        
        JTextField txtNum2 = new JTextField();
        txtNum2.setBounds(100, 60, 150, 20);
        jframe.add(txtNum2);
        
        JButton btnAdd = new JButton("+");
        btnAdd.setBounds(20, 100, 50, 30);
        jframe.add(btnAdd);
        
        JButton btnSub = new JButton("-");
        btnSub.setBounds(80, 100, 50, 30);
        jframe.add(btnSub);
        
        JButton btnMul = new JButton("×");
        btnMul.setBounds(140, 100, 50, 30);
        jframe.add(btnMul);
        
        JButton btnDiv = new JButton("÷");
        btnDiv.setBounds(200, 100, 50, 30);
        jframe.add(btnDiv);
        
        JLabel lblResult = new JLabel("Result:");
        lblResult.setBounds(20, 150, 80, 20);
        jframe.add(lblResult);
        
        JTextField txtResult = new JTextField();
        txtResult.setBounds(100, 150, 150, 20);
        txtResult.setEditable(false);
        jframe.add(txtResult);
        
        jframe.setLayout(null);
        jframe.setSize(300, 250);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Addition
        btnAdd.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    double num1 = Double.parseDouble(txtNum1.getText());
                    double num2 = Double.parseDouble(txtNum2.getText());
                    double result = num1 + num2;
                    txtResult.setText(String.valueOf(result));
                } catch (NumberFormatException e) {
                    txtResult.setText("Invalid input");
                }
            }
        });
        
        // Subtraction
        btnSub.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    double num1 = Double.parseDouble(txtNum1.getText());
                    double num2 = Double.parseDouble(txtNum2.getText());
                    double result = num1 - num2;
                    txtResult.setText(String.valueOf(result));
                } catch (NumberFormatException e) {
                    txtResult.setText("Invalid input");
                }
            }
        });
        
        // Multiplication
        btnMul.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    double num1 = Double.parseDouble(txtNum1.getText());
                    double num2 = Double.parseDouble(txtNum2.getText());
                    double result = num1 * num2;
                    txtResult.setText(String.valueOf(result));
                } catch (NumberFormatException e) {
                    txtResult.setText("Invalid input");
                }
            }
        });
        
        // Division
        btnDiv.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                try {
                    double num1 = Double.parseDouble(txtNum1.getText());
                    double num2 = Double.parseDouble(txtNum2.getText());
                    
                    if (num2 == 0) {
                        txtResult.setText("Cannot divide by zero");
                    } else {
                        double result = num1 / num2;
                        txtResult.setText(String.valueOf(result));
                    }
                } catch (NumberFormatException e) {
                    txtResult.setText("Invalid input");
                }
            }
        });
    }
    
    public static void main(String args[])
    {
        new Calculator();
    }
}