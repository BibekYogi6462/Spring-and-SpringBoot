package JavaBean;

public class TestStudentBean
{
    public static void main(String args[])
    {
        System.out.println("Testing StudentBean");
        System.out.println("========================================");
        
        // Test 1: Create object and set valid values
        System.out.println("\nTest 1: Setting valid values");
        StudentBean student1 = new StudentBean();
        student1.setName("Negha Shrestha");
        student1.setRollNumber(100);
        student1.setMarks(99.99);
        student1.display();
        
        // Test 2: Test validation - negative roll number
        System.out.println("\nTest 2: Setting negative roll number");
        StudentBean student2 = new StudentBean();
        student2.setName("Kreeti");
        student2.setRollNumber(-5);
        student2.setMarks(95.0);
        student2.display();
        
        // Test 3: Test validation - marks out of range (above 100)
        System.out.println("\nTest 3: Setting marks above 100");
        StudentBean student3 = new StudentBean();
        student3.setName("Preeti");
        student3.setRollNumber(102);
        student3.setMarks(150.0);  // Changed from 15.0 to 150.0
        student3.display();
        
        // Test 4: Test validation - marks out of range (negative)
        System.out.println("\nTest 4: Setting negative marks");
        StudentBean student4 = new StudentBean();
        student4.setName("Raju");
        student4.setRollNumber(103);
        student4.setMarks(-20.0);
        student4.display();
        
        // Test 5: Test validation - zero roll number (not positive)
        System.out.println("\nTest 5: Setting zero roll number");
        StudentBean student5 = new StudentBean();
        student5.setName("Mapil");
        student5.setRollNumber(0);
        student5.setMarks(75.0);
        student5.display();
        
        // Test 6: Test validation - boundary values
        System.out.println("\nTest 6: Testing boundary values (marks = 0 and 100)");
        StudentBean student6 = new StudentBean();
        student6.setName("Kapil");
        student6.setRollNumber(104);
        student6.setMarks(0.0);
        student6.display();
        
        StudentBean student7 = new StudentBean();
        student7.setName("Radhey");
        student7.setRollNumber(105);
        student7.setMarks(100.0);
        student7.display();
        
        // Test 7: Testing getter methods
        System.out.println("\nTest 7: Testing getter methods");
        StudentBean student8 = new StudentBean();
        student8.setName("Priya");
        student8.setRollNumber(106);
        student8.setMarks(88.5);
        
        System.out.println("Name (via getter): " + student8.getName());
        System.out.println("Roll Number (via getter): " + student8.getRollNumber());
        System.out.println("Marks (via getter): " + student8.getMarks());
    }
}