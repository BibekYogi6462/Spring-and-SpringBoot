//One to ONe

//package com.example.mappings;
//
//import com.example.mappings.entities.Laptop;
//import com.example.mappings.entities.Student;
//import com.example.mappings.repositories.StudentRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class MappingsApplication {
//
//	private static final Logger logger = LoggerFactory.getLogger(MappingsApplication.class);
//
//
////	One to One Mapping
////	private static StudentRepository studentRepository;
////
////	@Autowired
////	public void setStudentRepository(StudentRepository repo) {
////		studentRepository = repo;
////	}
////
////	public static void main(String[] args) {
////		SpringApplication.run(MappingsApplication.class, args);
////
////		Student student = new Student();
////		student.setStudentName("Bibek");
////		student.setAbout("Hello About");
////		student.setStudentId(1);
////
////		Laptop laptop = new Laptop();
////         laptop.setModelNumber("asdasd");
////		 laptop.setBrand("ROG");
////		 laptop.setLaptopId(1);
////		 laptop.setStudent(student);
////
////		 student.setLaptop(laptop);
////
////		Student saved = studentRepository.save(student);
////		logger.info("Saved Student: {}", saved.getStudentName());
//	}
//}



//One to Many
// One to Many
package com.example.mappings;

import com.example.mappings.entities.Address;
import com.example.mappings.entities.Student;
import com.example.mappings.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MappingsApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	// No AddressRepository needed!

	public static void main(String[] args) {
		SpringApplication.run(MappingsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// One to Many Mapping Example
		System.out.println("=== One to Many Mapping Example ===");

		// Create Student
		Student student = new Student();
		student.setStudentId(15);
		student.setStudentName("RAJU");
		student.setAbout("Hello About");

		// Create Addresses
		Address a1 = new Address();
		a1.setAddressId(12);
		a1.setStreet("151");
		a1.setCity("Maya");
		a1.setCountry("Nepal");
		a1.setStudent(student);  // Set the student reference

		Address a2 = new Address();
		a2.setAddressId(13);
		a2.setStreet("152");
		a2.setCity("Kathmandu");
		a2.setCountry("Nepal");
		a2.setStudent(student);  // Set the student reference

		Address a3 = new Address();
		a3.setAddressId(14);
		a3.setStreet("153");
		a3.setCity("Pokhara");
		a3.setCountry("Nepal");
		a3.setStudent(student);  // Set the student reference

		// Create list and add addresses
		List<Address> addressList = new ArrayList<>();
		addressList.add(a1);
		addressList.add(a2);
		addressList.add(a3);

		// Set addresses to student
		student.setAddressList(addressList);

		// Save ONLY the student - addresses will be saved automatically due to CASCADE
		studentRepository.save(student);

		System.out.println("Student saved with " + student.getAddressList().size() + " addresses");
		System.out.println("No AddressRepository needed because of CascadeType.ALL!");
	}
}