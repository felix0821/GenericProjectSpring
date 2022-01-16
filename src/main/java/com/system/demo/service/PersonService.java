package com.system.demo.service;

import java.util.Optional;

import com.system.demo.dto.ChangePasswordDto;
import com.system.demo.exception.UsernameOrIdNotFound;
import com.system.demo.model.Person;

public interface PersonService {

	//Iteradores
	Iterable<Person> getAllPersons();
	//Consultas
	public Person createPerson(Person person) throws Exception;
	public Person updatePerson(Person person) throws Exception;
	public void deletePerson(Long id) throws UsernameOrIdNotFound;
	//Envios
	public Person getPersonById(Long id) throws Exception;
	public Optional<Person> getPersonByUsername(String username);
	public Optional<Person> getPersonByEmail(String email);
	public Optional<Person> getPersonByDni(String dni);
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
	public boolean existsByDni(String dni);
	//Utilerias
	public Person changePassword(ChangePasswordDto form) throws Exception;

}
