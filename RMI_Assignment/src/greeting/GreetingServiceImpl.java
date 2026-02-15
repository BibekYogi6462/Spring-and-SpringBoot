package greeting;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GreetingServiceImpl extends UnicastRemoteObject implements GreetingService {
    
    public GreetingServiceImpl() throws RemoteException {
        super();
    }
    
    public String greet(String name) throws RemoteException {
        return "Hello, " + name + "! Welcome to RMI!";
    }
}