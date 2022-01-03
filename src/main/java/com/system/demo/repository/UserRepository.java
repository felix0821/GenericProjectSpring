package com.system.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	public Optional<User> findByUsername(String username);
	public Optional<User> findByEmail(String email);
	public Optional<User> findByDni(String dni);
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
	public boolean existsByDni(String dni);

}
