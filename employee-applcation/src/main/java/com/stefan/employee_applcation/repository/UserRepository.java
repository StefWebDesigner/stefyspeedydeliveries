package com.stefan.employee_applcation.repository;

import java.util.Optional;

import com.stefan.employee_applcation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
