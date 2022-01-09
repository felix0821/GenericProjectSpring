package com.system.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.system.demo.dto.ChangePasswordDto;
import com.system.demo.exception.CustomeFieldValidationException;
import com.system.demo.exception.UsernameOrIdNotFound;
import com.system.demo.model.Person;
import com.system.demo.repository.UserRepository;

@Service
@Transactional
public class UserServiceImplements implements UserService{
	
	//----------------------------------Iterable Methods----------------------------------//
		@Autowired
		UserRepository repository;
		
		@Autowired
		BCryptPasswordEncoder bCryptPasswordEncoder;
		//----------------------------------Iterable Methods----------------------------------//	
		@Override
		public Iterable<Person> getAllUsers() {
			return repository.findAll();
		}
		
		//----------------------------------Querys Methods----------------------------------//
		
		@Override
		public Person createUser(Person person) throws Exception {
			/*if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
				String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
				user.setPassword(encodedPassword);
				user = repository.save(user);
			}*/
			return repository.save(person);
		}
		@Override
		public Person updateUser(Person fromUser) throws Exception {
			Person toUser = getUserById(fromUser.getIdPerson());
			mapUser(fromUser, toUser);
			return repository.save(toUser);
		}
		@Override
		public void deleteUser(Long id) throws UsernameOrIdNotFound {
			Person person = getUserById(id);
			repository.delete(person);
		}
		
		//----------------------------------Send Methods----------------------------------//	
		
		@Override
		public Person getUserById(Long id) throws UsernameOrIdNotFound {
			return repository.findById(id).orElseThrow(() -> new UsernameOrIdNotFound("El Id del usuario no existe."));
		}
		@Override
		public Optional<Person> getUserByUsername(String username) {
			return repository.findByUsername(username);
		}
		@Override
		public Optional<Person> getUserByEmail(String email) {
			return repository.findByEmail(email);
		}
		@Override
		public Optional<Person> getUserByDni(String dni) {
			return repository.findByDni(dni);
		}
		@Override
		public boolean existsByUsername(String username) {
			return repository.existsByUsername(username);
		}
		@Override
		public boolean existsByEmail(String email) {
			return repository.existsByEmail(email);
		}
		@Override
		public boolean existsByDni(String dni) {
			return repository.existsByDni(dni);
		}

		
		
		
		//----------------------------------Util Methods----------------------------------//
		
		@Override
		public Person changePassword(ChangePasswordDto form) throws Exception {
			Person person = getUserById(form.getId());
			
			//if ( !isLoggedUserADMIN() && !user.getPassword().equals(form.getCurrentPassword())) {
				//hrow new Exception ("Current Password invalido.");
			//}
			
			if( person.getPassword().equals(form.getNewPassword())) {
				throw new Exception ("Nuevo debe ser diferente al password actual.");
			}
			
			if( !form.getNewPassword().equals(form.getConfirmPassword())) {
				throw new Exception ("Nuevo Password y Confirm Password no coinciden.");
			}
			
			String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
			person.setPassword(encodePassword);
			return repository.save(person);
		}
		
		
		//----------------------------------Methods Complements----------------------------------//
		
		protected void mapUser(Person from,Person to) {
			to.setUsername(from.getUsername());
			to.setName(from.getName());
			to.setLastnameFather(from.getLastnameFather());
			to.setLastnameMother(from.getLastnameMother());
			to.setEmail(from.getEmail());
			to.setDni(from.getDni());
			to.setDateBirth(from.getDateBirth());
			to.setRegistrationDate(from.getRegistrationDate());
			to.setState(from.getState());
			to.setUrlProfilepicture(from.getUrlProfilepicture());
			to.setPersonRolCollection(from.getPersonRolCollection());
		}
		
		private boolean isLoggedUserADMIN() {
			//Obtener el usuario logeado
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			UserDetails loggedUser = null;
			Object roles = null;

			//Verificar que ese objeto traido de sesion es el usuario
			if (principal instanceof UserDetails) {
				loggedUser = (UserDetails) principal;

				roles = loggedUser.getAuthorities().stream()
						.filter(x -> "ROLE_ADMIN".equals(x.getAuthority())).findFirst()
						.orElse(null); 
			}
			return roles != null ? true : false;
		}
		
		private Person getLoggedUser() throws Exception {
			//Obtener el usuario logeado
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			UserDetails loggedUser = null;

			//Verificar que ese objeto traido de sesion es el usuario
			if (principal instanceof UserDetails) {
				loggedUser = (UserDetails) principal;
			}
			
			Person myUser = repository
					.findByUsername(loggedUser.getUsername()).orElseThrow(() -> new Exception("Error obteniendo el usuario logeado desde la sesion."));
			
			return myUser;
		}
		
		private boolean checkUsernameAvailable(Person person) throws Exception {
			Optional<Person> userFound = repository.findByUsername(person.getUsername());
			if (userFound.isPresent()) {
				throw new CustomeFieldValidationException("Username no disponible","userName");
			}
			return true;
		}

		private boolean checkPasswordValid(Person person) throws Exception {
			if (person.getConfirmPassword() == null || person.getConfirmPassword().isEmpty()) {
				throw new CustomeFieldValidationException("Confirm Password es obligatorio","confirmPassword");
			}
			
			if ( !person.getPassword().equals(person.getConfirmPassword())) {
				throw new CustomeFieldValidationException("Password y Confirm Password no son iguales","password");
			}
			return true;
		}

}
