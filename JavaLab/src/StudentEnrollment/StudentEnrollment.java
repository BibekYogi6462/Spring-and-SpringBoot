package StudentEnrollment;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class StudentEnrollment
{
    // Table components
    JTable table;
    DefaultTableModel tableModel;
    int rowCount = 0;
    
    StudentEnrollment()
    {
        JFrame jframe = new JFrame("Student Enrollment");
        
        // Name field
        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 20, 80, 20);
        jframe.add(lblName);
        
        JTextField txtName = new JTextField();
        txtName.setBounds(100, 20, 150, 20);
        jframe.add(txtName);
        
        // Roll Number field
        JLabel lblRoll = new JLabel("Roll No:");
        lblRoll.setBounds(20, 50, 80, 20);
        jframe.add(lblRoll);
        
        JTextField txtRoll = new JTextField();
        txtRoll.setBounds(100, 50, 150, 20);
        jframe.add(txtRoll);
        
        // Gender Radio Buttons
        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(20, 80, 80, 20);
        jframe.add(lblGender);
        
        JRadioButton rbMale = new JRadioButton("Male");
        rbMale.setBounds(100, 80, 60, 20);
        jframe.add(rbMale);
        
        JRadioButton rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(170, 80, 70, 20);
        jframe.add(rbFemale);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        
        // Hobbies Checkboxes
        JLabel lblHobbies = new JLabel("Hobbies:");
        lblHobbies.setBounds(20, 110, 80, 20);
        jframe.add(lblHobbies);
        
        JCheckBox chkReading = new JCheckBox("Reading");
        chkReading.setBounds(100, 110, 80, 20);
        jframe.add(chkReading);
        
        JCheckBox chkSports = new JCheckBox("Sports");
        chkSports.setBounds(190, 110, 80, 20);
        jframe.add(chkSports);
        
        JCheckBox chkMusic = new JCheckBox("Music");
        chkMusic.setBounds(280, 110, 80, 20);
        jframe.add(chkMusic);
        
        // Course ComboBox
        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setBounds(20, 140, 80, 20);
        jframe.add(lblCourse);
        
        String[] courses = {"Computer Science", "Mathematics", "Physics", "Chemistry", "Biology"};
        JComboBox<String> cbCourse = new JComboBox<>(courses);
        cbCourse.setBounds(100, 140, 150, 20);
        jframe.add(cbCourse);
        
        // Submit Button
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(100, 170, 100, 30);
        jframe.add(btnSubmit);
        
        // Table to display student data
        String[] columns = {"Name", "Roll No", "Gender", "Hobbies", "Course"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 220, 460, 150);
        jframe.add(scrollPane);
        
        jframe.setLayout(null);
        jframe.setSize(520, 450);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Submit button action
        btnSubmit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                // Get name and roll number
                String name = txtName.getText();
                String roll = txtRoll.getText();
                
                // Get gender
                String gender = "";
                if (rbMale.isSelected())
                    gender = "Male";
                else if (rbFemale.isSelected())
                    gender = "Female";
                else
                    gender = "Not Selected";
                
                // Get hobbies
                String hobbies = "";
                if (chkReading.isSelected())
                    hobbies += "Reading ";
                if (chkSports.isSelected())
                    hobbies += "Sports ";
                if (chkMusic.isSelected())
                    hobbies += "Music ";
                if (hobbies.equals(""))
                    hobbies = "None";
                
                // Get course
                String course = (String) cbCourse.getSelectedItem();
                
                // Add to table
                Object[] row = {name, roll, gender, hobbies, course};
                tableModel.addRow(row);
                
                // Clear input fields
                txtName.setText("");
                txtRoll.setText("");
                genderGroup.clearSelection();
                chkReading.setSelected(false);
                chkSports.setSelected(false);
                chkMusic.setSelected(false);
                cbCourse.setSelectedIndex(0);
            }
        });
    }
    
    public static void main(String args[])
    {
        new StudentEnrollment();
    }
}