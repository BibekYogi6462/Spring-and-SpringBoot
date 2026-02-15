package greeting;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GreetingService extends Remote {
    public String greet(String name) throws RemoteException;
}
