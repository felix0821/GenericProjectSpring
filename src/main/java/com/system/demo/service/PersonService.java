package com.system.demo.service;

import java.util.Optional;

import com.system.demo.dto.ChangePasswordDto;
import com.system.demo.exception.UsernameOrIdNotFound;
import com.system.demo.model.Person;

public interface PersonService {

	//Iteradores
	Iterable<Person> getAllUsers();
	//Consultas
	public Person createUser(Person person) throws Exception;
	public Person updateUser(Person person) throws Exception;
	public void deleteUser(Long id) throws UsernameOrIdNotFound;
	//Envios
	public Person getUserById(Long id) throws Exception;
	public Optional<Person> getUserByUsername(String username);
	public Optional<Person> getUserByEmail(String email);
	public Optional<Person> getUserByDni(String dni);
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
	public boolean existsByDni(String dni);
	//Utilerias
	public Person changePassword(ChangePasswordDto form) throws Exception;

}
