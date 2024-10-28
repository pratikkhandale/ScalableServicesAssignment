package com.movies.springboot.User_Service.repository;

import java.util.Optional;

import com.movies.springboot.User_Service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
