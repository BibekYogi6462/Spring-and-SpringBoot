package student;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StudentClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            StudentService service = (StudentService) registry.lookup("StudentService");
            
            // Create some student objects
            Student s1 = new Student(101, "Bibek Yogi", 04);
            Student s2 = new Student(102, "Salman Khan", 35);
            Student s3 = new Student(103, "RAY Kuan", 42);
            
            // Send to server and get results
            System.out.println("Student Evaluation Results");
            System.out.println("==========================");
            
            System.out.println("Student 1: " + s1);
            System.out.println("Result: " + service.evaluateStudent(s1) + "\n");
            
            System.out.println("Student 2: " + s2);
            System.out.println("Result: " + service.evaluateStudent(s2) + "\n");
            
            System.out.println("Student 3: " + s3);
            System.out.println("Result: " + service.evaluateStudent(s3) + "\n");
            
        } catch (Exception e) {
            System.err.println("Client error: " + e);
            e.printStackTrace();
        }
    }
}