package com.bibek.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bibek.beans.Student;

@Configuration
public class StdConfigFile {
	
	
 @Bean	
  public Student stdObj()
  {
	  Student std = new Student();
	  std.setName("Bibek");
	  std.setRollno("5");
	  return std;
	  
	  
  }
	
	
}
