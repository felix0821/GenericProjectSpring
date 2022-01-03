package com.system.demo.service;

import java.util.Optional;

import com.system.demo.dto.ChangePasswordDto;
import com.system.demo.exception.UsernameOrIdNotFound;
import com.system.demo.model.User;

public interface UserService {

	//Iteradores
	Iterable<User> getAllUsers();
	//Consultas
	public User createUser(User user) throws Exception;
	public User updateUser(User user) throws Exception;
	public void deleteUser(Long id) throws UsernameOrIdNotFound;
	//Envios
	public User getUserById(Long id) throws Exception;
	public Optional<User> getUserByUsername(String username);
	public Optional<User> getUserByEmail(String email);
	public Optional<User> getUserByDni(String dni);
	public boolean existsByUsername(String username);
	public boolean existsByEmail(String email);
	public boolean existsByDni(String dni);
	//Utilerias
	public User changePassword(ChangePasswordDto form) throws Exception;

}
