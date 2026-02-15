package greeting;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class GreetingClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            GreetingService greeter = (GreetingService) registry.lookup("GreetingService");
            
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            
            String result = greeter.greet(name);
            System.out.println("\n" + result);
            
            scanner.close();
            
        } catch (Exception e) {
            System.err.println("Client error: " + e);
            e.printStackTrace();
        }
    }
}
