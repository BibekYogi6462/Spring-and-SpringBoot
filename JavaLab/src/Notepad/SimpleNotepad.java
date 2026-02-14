package Notepad;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SimpleNotepad
{
    SimpleNotepad()
    {
        JFrame jframe = new JFrame("My Notepad");
        
        // Create text area
        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 50, 460, 300);
        jframe.add(textArea);
        
        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        
        // Create File menu
        JMenu fileMenu = new JMenu("File");
        
        // Create menu items
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        
        // Add menu items to File menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Adds a separator line
        fileMenu.add(exitItem);
        
        // Add File menu to menu bar
        menuBar.add(fileMenu);
        
        // Set menu bar to frame
        jframe.setJMenuBar(menuBar);
        
        jframe.setLayout(null);
        jframe.setSize(500, 400);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // New menu item action
        newItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                textArea.setText("");
            }
        });
        
        // Open menu item action
        openItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(jframe);
                
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        File file = fileChooser.getSelectedFile();
                        FileReader reader = new FileReader(file);
                        BufferedReader br = new BufferedReader(reader);
                        
                        textArea.setText("");
                        String line;
                        
                        while ((line = br.readLine()) != null)
                        {
                            textArea.append(line + "\n");
                        }
                        
                        br.close();
                        reader.close();
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(jframe, "Error opening file: " + e.getMessage());
                    }
                }
            }
        });
        
        // Save menu item action
        saveItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(jframe);
                
                if (result == JFileChooser.APPROVE_OPTION)
                {
                    try
                    {
                        File file = fileChooser.getSelectedFile();
                        FileWriter writer = new FileWriter(file);
                        BufferedWriter bw = new BufferedWriter(writer);
                        
                        bw.write(textArea.getText());
                        
                        bw.close();
                        writer.close();
                        
                        JOptionPane.showMessageDialog(jframe, "File saved successfully!");
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(jframe, "Error saving file: " + e.getMessage());
                    }
                }
            }
        });
        
        // Exit menu item action
        exitItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                int choice = JOptionPane.showConfirmDialog(jframe, 
                    "Are you sure you want to exit?", "Exit", 
                    JOptionPane.YES_NO_OPTION);
                
                if (choice == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
        });
    }
    
    public static void main(String args[])
    {
        new SimpleNotepad();
    }
}