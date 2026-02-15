package student;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StudentService extends Remote {
    public String evaluateStudent(Student student) throws RemoteException;
}