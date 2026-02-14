package JavaBean;


import java.io.Serializable;

public class StudentBean implements Serializable
{
    // Private properties
    private String name;
    private int rollNumber;
    private double marks;
    
    // Default constructor
    public StudentBean()
    {
        this.name = "";
        this.rollNumber = 0;
        this.marks = 0.0;
    }
    
    // Getter and Setter for name
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    // Getter and Setter for rollNumber with validation
    public int getRollNumber()
    {
        return rollNumber;
    }
    
    public void setRollNumber(int rollNumber)
    {
        if (rollNumber > 0)
        {
            this.rollNumber = rollNumber;
        }
        else
        {
            System.out.println("Error: Roll number must be positive. Setting to 0.");
            this.rollNumber = 0;
        }
    }
    
    // Getter and Setter for marks with validation
    public double getMarks()
    {
        return marks;
    }
    
    public void setMarks(double marks)
    {
        if (marks >= 0 && marks <= 100)
        {
            this.marks = marks;
        }
        else
        {
            System.out.println("Error: Marks must be between 0 and 100. Setting to 0.");
            this.marks = 0;
        }
    }
    
    // Display method to print values
    public void display()
    {
        System.out.println("\nStudent Details:");
        System.out.println("----------------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("----------------------------------------");
    }
}