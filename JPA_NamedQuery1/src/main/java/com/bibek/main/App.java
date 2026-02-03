package com.bibek.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.bibek.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("main-persistence-unit");
        EntityManager em = emf.createEntityManager();
        
      
        try {
        	TypedQuery<Student> query = em.createNamedQuery("getAllStudentDetails",Student.class);
        	List<Student> std_list = query.getResultList();
        	  for(Student std: std_list) {
              	System.out.println("Id: "+std.getId());
              	System.out.println("Name: " +std.getName());
              	System.out.println("Roll No : " +std.getRollno());
              }
              
        	
;        }catch(Exception e) {
        	e.printStackTrace();
        }finally {
        	em.close();
        	emf.close();
        }
            
    
    }
}
