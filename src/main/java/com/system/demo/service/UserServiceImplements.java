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
import com.system.demo.model.User;
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
		public Iterable<User> getAllUsers() {
			return repository.findAll();
		}
		
		//----------------------------------Querys Methods----------------------------------//
		
		@Override
		public User createUser(User user) throws Exception {
			/*if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
				String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
				user.setPassword(encodedPassword);
				user = repository.save(user);
			}*/
			return repository.save(user);
		}
		@Override
		public User updateUser(User fromUser) throws Exception {
			User toUser = getUserById(fromUser.getIdUser());
			mapUser(fromUser, toUser);
			return repository.save(toUser);
		}
		@Override
		public void deleteUser(Long id) throws UsernameOrIdNotFound {
			User user = getUserById(id);
			repository.delete(user);
		}
		
		//----------------------------------Send Methods----------------------------------//	
		
		@Override
		public User getUserById(Long id) throws UsernameOrIdNotFound {
			return repository.findByIdUser(id).orElseThrow(() -> new UsernameOrIdNotFound("El Id del usuario no existe."));
		}
		@Override
		public Optional<User> getUserByUsername(String username) {
			return repository.findByUsername(username);
		}
		@Override
		public Optional<User> getUserByEmail(String email) {
			return repository.findByEmail(email);
		}
		@Override
		public Optional<User> getUserByDni(String dni) {
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
		public User changePassword(ChangePasswordDto form) throws Exception {
			User user = getUserById(form.getId());
			
			//if ( !isLoggedUserADMIN() && !user.getPassword().equals(form.getCurrentPassword())) {
				//hrow new Exception ("Current Password invalido.");
			//}
			
			if( user.getPassword().equals(form.getNewPassword())) {
				throw new Exception ("Nuevo debe ser diferente al password actual.");
			}
			
			if( !form.getNewPassword().equals(form.getConfirmPassword())) {
				throw new Exception ("Nuevo Password y Confirm Password no coinciden.");
			}
			
			String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
			user.setPassword(encodePassword);
			return repository.save(user);
		}
		
		
		//----------------------------------Methods Complements----------------------------------//
		
		protected void mapUser(User from,User to) {
			to.setUsername(from.getUsername());
			to.setName(from.getName());
			to.setLastname(from.getLastname());
			to.setLastnameMother(from.getLastnameMother());
			to.setEmail(from.getEmail());
			to.setDni(from.getDni());
			to.setDateBirth(from.getDateBirth());
			to.setRegistrationDate(from.getRegistrationDate());
			to.setState(from.getState());
			to.setUrlProfilepicture(from.getUrlProfilepicture());
			to.setUserRolCollection(from.getUserRolCollection());
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
		
		private User getLoggedUser() throws Exception {
			//Obtener el usuario logeado
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			UserDetails loggedUser = null;

			//Verificar que ese objeto traido de sesion es el usuario
			if (principal instanceof UserDetails) {
				loggedUser = (UserDetails) principal;
			}
			
			User myUser = repository
					.findByUsername(loggedUser.getUsername()).orElseThrow(() -> new Exception("Error obteniendo el usuario logeado desde la sesion."));
			
			return myUser;
		}
		
		private boolean checkUsernameAvailable(User user) throws Exception {
			Optional<User> userFound = repository.findByUsername(user.getUsername());
			if (userFound.isPresent()) {
				throw new CustomeFieldValidationException("Username no disponible","userName");
			}
			return true;
		}

		private boolean checkPasswordValid(User user) throws Exception {
			if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
				throw new CustomeFieldValidationException("Confirm Password es obligatorio","confirmPassword");
			}
			
			if ( !user.getPassword().equals(user.getConfirmPassword())) {
				throw new CustomeFieldValidationException("Password y Confirm Password no son iguales","password");
			}
			return true;
		}

}
