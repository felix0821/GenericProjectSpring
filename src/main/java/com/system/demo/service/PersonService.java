package com.system.demo.service;

import java.util.Optional;

import com.system.demo.dto.specific.ChangePasswordDto;
import com.system.demo.exception.UsernameOrIdNotFound;
import com.system.demo.persistence.entity.Person;

public interface PersonService {

	//Iteradores
	Iterable<Person> getAllPersons();
	//Consultas CRUD
	public Person createPerson(Person person, String passConfirmation) throws Exception;
	public Person updatePerson(Person person) throws Exception;
	public void deletePerson(Long id) throws UsernameOrIdNotFound;
	//Consultas Operaciones
	public Person getPersonById(Long id) throws Exception;
	public Optional<Person> getPersonByUsername(String username);
	public Optional<Person> getPersonByEmail(String email);
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
	//Utilerias
	public Person changePassword(ChangePasswordDto form) throws Exception;

}
