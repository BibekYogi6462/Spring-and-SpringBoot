package calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create the remote object
            CalculatorImpl obj = new CalculatorImpl();
            // Create RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Bind the object to a name
            registry.rebind("CalculatorService", obj);
            
            System.out.println("Calculator Server is running...");
       
            
        } catch (Exception e) {
            System.err.println("Server error: " + e);
            e.printStackTrace();
        }
    }
}
