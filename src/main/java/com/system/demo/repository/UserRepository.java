package com.system.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.Person;

@Repository
public interface UserRepository extends JpaRepository<Person,Long>{
	public Optional<Person> findByIdPerson(Long id);
	public Optional<Person> findByUsername(String username);
	public Optional<Person> findByEmail(String email);
	public Optional<Person> findByDni(String dni);
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
	public boolean existsByDni(String dni);

}
