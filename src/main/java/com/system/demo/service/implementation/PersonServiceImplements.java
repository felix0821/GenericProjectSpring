package com.system.demo.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.system.demo.dto.ChangePasswordDto;
import com.system.demo.exception.CustomeFieldValidationException;
import com.system.demo.exception.UsernameOrIdNotFound;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.repository.PersonRepository;
import com.system.demo.service.PersonService;

@Service
@Transactional
public class PersonServiceImplements implements PersonService{
	
	//----------------------------------Iterable Methods----------------------------------//
		@Autowired
		PersonRepository repository;
		
		@Autowired
		BCryptPasswordEncoder bCryptPasswordEncoder;
		//----------------------------------Iterable Methods----------------------------------//	
		@Override
		public Iterable<Person> getAllPersons() {
			return repository.findAll();
		}
		
		//----------------------------------Querys Methods----------------------------------//
		
		@Override
		public Person createPerson(Person person) throws Exception {
			/*if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
				String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
				user.setPassword(encodedPassword);
				user = repository.save(user);
			}*/
			return repository.save(person);
		}
		@Override
		public Person updatePerson(Person fromUser) throws Exception {
			Person toUser = getPersonById(fromUser.getPersonId());
			mapUser(fromUser, toUser);
			return repository.save(toUser);
		}
		@Override
		public void deletePerson(Long id) throws UsernameOrIdNotFound {
			Person person = getPersonById(id);
			repository.delete(person);
		}
		
		//----------------------------------Send Methods----------------------------------//	
		
		@Override
		public Person getPersonById(Long id) throws UsernameOrIdNotFound {
			return repository.findById(id).orElseThrow(() -> new UsernameOrIdNotFound("El Id del usuario no existe."));
		}
		@Override
		public Optional<Person> getPersonByUsername(String username) {
			return repository.findByPersonUsername(username);
		}
		@Override
		public Optional<Person> getPersonByEmail(String email) {
			return repository.findByPersonEmail(email);
		}
		@Override
		public boolean existsByUsername(String username) {
			return repository.existsByPersonUsername(username);
		}
		@Override
		public boolean existsByEmail(String email) {
			return repository.existsByPersonEmail(email);
		}

		
		//----------------------------------Util Methods----------------------------------//
		
		@Override
		public Person changePassword(ChangePasswordDto form) throws Exception {
			Person person = getPersonById(form.getId());
			
			//if ( !isLoggedUserADMIN() && !user.getPassword().equals(form.getCurrentPassword())) {
				//hrow new Exception ("Current Password invalido.");
			//}
			
			if( person.getPersonPassword().equals(form.getNewPassword())) {
				throw new Exception ("Nuevo debe ser diferente al password actual.");
			}
			
			if( !form.getNewPassword().equals(form.getConfirmPassword())) {
				throw new Exception ("Nuevo Password y Confirm Password no coinciden.");
			}
			
			String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
			person.setPersonPassword(encodePassword);
			return repository.save(person);
		}
		
		
		//----------------------------------Methods Complements----------------------------------//
		
		protected void mapUser(Person from,Person to) {
			to.setPersonUsername(from.getPersonUsername());
			to.setPersonName(from.getPersonName());
			to.setPersonLastnameFather(from.getPersonLastnameFather());
			to.setPersonLastnameMother(from.getPersonLastnameMother());
			to.setPersonEmail(from.getPersonEmail());
			to.setPersonDateBirth(from.getPersonDateBirth());
			to.setPersonDateRegistration(from.getPersonDateRegistration());
			to.setPersonState(from.getPersonState());
			to.setPersonUrlProfilepicture(from.getPersonUrlProfilepicture());
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
					.findByPersonUsername(loggedUser.getUsername()).orElseThrow(() -> new Exception("Error obteniendo el usuario logeado desde la sesion."));
			
			return myUser;
		}
		
		private boolean checkUsernameAvailable(Person person) throws Exception {
			Optional<Person> userFound = repository.findByPersonUsername(person.getPersonUsername());
			if (userFound.isPresent()) {
				throw new CustomeFieldValidationException("Username no disponible","userName");
			}
			return true;
		}

		private boolean checkPasswordValid(Person person) throws Exception {
			if (person.getConfirmPassword() == null || person.getConfirmPassword().isEmpty()) {
				throw new CustomeFieldValidationException("Confirm Password es obligatorio","confirmPassword");
			}
			
			if ( !person.getPersonPassword().equals(person.getConfirmPassword())) {
				throw new CustomeFieldValidationException("Password y Confirm Password no son iguales","password");
			}
			return true;
		}

}
