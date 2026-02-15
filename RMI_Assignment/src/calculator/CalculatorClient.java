package calculator;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Get the registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Look up the remote object
            Calculator calc = (Calculator) registry.lookup("CalculatorService");
            
            // Test the methods
            int a = 20, b = 5;
            
            System.out.println("Testing Calculator RMI");
            System.out.println("======================");
            System.out.println(a + " + " + b + " = " + calc.add(a, b));
            System.out.println(a + " - " + b + " = " + calc.subtract(a, b));
            System.out.println(a + " * " + b + " = " + calc.multiply(a, b));
            System.out.println(a + " / " + b + " = " + calc.divide(a, b));
            
        } catch (Exception e) {
            System.err.println("Client error: " + e);
            e.printStackTrace();
        }
    }
}