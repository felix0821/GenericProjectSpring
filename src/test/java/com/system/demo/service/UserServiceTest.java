package com.system.demo.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.system.demo.model.User;
import com.system.demo.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
	
	@TestConfiguration
	static class UserServiceTestConfiguration {
		
		@Bean
		public UserService userService() {
			return new UserServiceImplements();
		}
	}
	
	@Autowired
	UserService userService;
	
	@MockBean
	UserRepository userRepository;
	
	//PRUEBAS DE ITERADOR
	@Test
	public void userTestServiceGetAllUsers() {
		List<User> expected = this.getListUsers();
		Iterable<User> result = userService.getAllUsers();
		
		int resultSize = 0;
		for(User user:result) {
			Assertions.assertEquals(user.toString(), expected.get(resultSize).toString());
			resultSize++;
		}
		Assertions.assertEquals(expected.size(), resultSize);
	}
	
	private User generateUser() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		Date dateBirth=null;
		try {
			dateBirth = formatter.parse("1995-08-21");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//Insertar fecha de registro
		LocalDate datePeru=LocalDate.now(ZoneId.of("America/Lima"));
		Date dateRegister=Date.from(datePeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		//Crear usuario
		User user = new User(1L, "felix123", "123", "FELIX", "MONTALICO", "LAQUIHUANACO", 
	    		"felixmontalico@gmail.com", "77283387", dateBirth, dateRegister, 'A');
		return user;
	}
	
	private List<User> getListUsers() {
		List<User> users = new ArrayList<>();
		//Crear usuario
		User user = generateUser();
		users.add(user);
		return users;
	}
	
	//Genera una instancia de repositorio
	@BeforeEach
	public void setup() {
		List<User> users = new ArrayList<>();
		//Crear usuario
		User user = generateUser();
		users.add(user);
		Mockito.when(userRepository.findAll()).thenReturn(users);
	}
	
	//PRUEBAS DE CONSULTA
	
	
	/*@Test
	public void userTestServiceChangePassword() {
		ChangePasswordDto form = new ChangePasswordDto();
		
		User userChangePassword = userService.changePassword(form);
		
		Assertions.assertEquals(userChangePassword.getPassword(), "123");
	}*/
	

}
