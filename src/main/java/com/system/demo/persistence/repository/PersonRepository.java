package com.system.demo.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Repository;

import com.system.demo.persistence.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{
	
	public List<Person> findAll();
	
	public Optional<Person> findByPersonId(Long personId);
	public Optional<Person> findByPersonUsername(String personUsername);
	public Optional<Person> findByPersonEmail(String personEmail);
	public boolean existsByPersonUsername(String personUsername);
	public boolean existsByPersonEmail(String personEmail);

}
