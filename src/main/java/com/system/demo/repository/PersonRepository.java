package com.system.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.demo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{
	public Optional<Person> findByPersonId(Long personId);
	public Optional<Person> findByPersonUsername(String personUsername);
	public Optional<Person> findByPersonEmail(String personEmail);
	public boolean existsByPersonUsername(String personUsername);
	public boolean existsByPersonEmail(String personEmail);

}
