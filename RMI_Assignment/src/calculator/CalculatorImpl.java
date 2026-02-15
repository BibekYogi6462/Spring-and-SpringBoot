package calculator;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    
    // Constructor
    public CalculatorImpl() throws RemoteException {
        super();
    }
    
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
    
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }
    
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }
    
    public int divide(int a, int b) throws RemoteException {
        if(b == 0) throw new RemoteException("Divide by zero!");
        return a / b;
    }
}