package student;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StudentServer {
    public static void main(String[] args) {
        try {
            StudentServiceImpl obj = new StudentServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("StudentService", obj);
            
            System.out.println("Student Evaluation Server is running...");
            
        } catch (Exception e) {
            System.err.println("Server error: " + e);
            e.printStackTrace();
        }
    }
}