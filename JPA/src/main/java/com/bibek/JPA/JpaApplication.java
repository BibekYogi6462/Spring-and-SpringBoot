package com.bibek.JPA;

import com.bibek.JPA.models.Author;
import com.bibek.JPA.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository
	){
		return args -> {
			var author = Author.builder()
					.firstName("Bibek")
					.lastName("Yogi")
					.email("bibek@gmail.com")
					.build();

			repository.save(author);

			System.out.println("Author saved successfully!");
		};
	}
}