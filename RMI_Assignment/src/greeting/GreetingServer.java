package greeting;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GreetingServer {
    public static void main(String[] args) {
        try {
            GreetingServiceImpl obj = new GreetingServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("GreetingService", obj);
            
            System.out.println("Greeting Server is running...");
            System.out.println("Press Ctrl+C to stop");
            
        } catch (Exception e) {
            System.err.println("Server error: " + e);
            e.printStackTrace();
        }
    }
}