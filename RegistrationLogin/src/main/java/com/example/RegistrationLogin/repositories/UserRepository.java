package com.example.RegistrationLogin.repositories;

import com.example.RegistrationLogin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
