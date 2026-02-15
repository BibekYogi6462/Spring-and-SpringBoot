package student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StudentServiceImpl extends UnicastRemoteObject implements StudentService {
    
    public StudentServiceImpl() throws RemoteException {
        super();
    }
    
    public String evaluateStudent(Student student) throws RemoteException {
        if (student.getMarks() >= 40) {
            return "PASS - " + student.getName() + " scored " + student.getMarks() + " marks";
        } else {
            return "FAIL - " + student.getName() + " scored " + student.getMarks() + " marks (Need 40+)";
        }
    }
}