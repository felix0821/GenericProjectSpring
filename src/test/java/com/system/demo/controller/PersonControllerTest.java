package com.system.demo.controller;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.demo.dto.specific.PersonLoginDto;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.repository.PersonRepository;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.PersonService;
import com.system.demo.service.implementation.PersonServiceImplements;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
	
	private String token = "";
	
	@Autowired
	MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	/*
	@Test
	public void userTestGetAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(status().isOk());//.andExpect(status().isUnauthorized());
	}
	*/
	@Test
	public void userTestLogin() throws Exception{
		PersonLoginDto pld=new PersonLoginDto();
		pld.setPassword("1234");
		pld.setUsername("felix123");
		mockMvc.perform(post("/auth/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(pld))).andExpect(status().isOk());
	}
	
	//	CONSULTA REPOSITORIO
	@MockBean
	PersonRepository personRepository;
	@TestConfiguration
	static class UserServiceTestConfiguration {
		
		@Bean
		public PersonService personService() {
			return new PersonServiceImplements();
		}
	}
	@MockBean
    AuthenticationManager authenticationManager;
	
	@Autowired
    JwtProvider jwtProvider;
	
	//Genera una instancia de repositorio
	@BeforeEach
	public void setup() {
		List<Person> persons = new ArrayList<>();
		//Crear usuario
		Person person = generateUser();
		persons.add(person);
		Optional<Person> opt = Optional.of(person);
		//Mockito.when(personRepository.findAll()).thenReturn(persons);
		//Mockito.when(personRepository.findByPersonUsername(Mockito.anyString())).thenReturn(opt);
		//Mockito.when(personRepository.existsByPersonUsername("felix123")).thenReturn(true);
		//Mockito.when(personRepository.save(Mockito.any(Person.class))).then(returnsFirstArg());
		//Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(persons.get(0));
		
		String username="felix123";
		String psw="1234";
	    UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, psw);
	    Authentication authentication = authRequest;
	    Mockito.when(authenticationManager.authenticate(Mockito.any(Authentication.class))).thenReturn(authentication);
	    
	    String myToken = "$2a$10$eBDHYpbsQqeNpYeBaGjfKuT8Lz0HZTTmEN/9oasqKQO0zF12WY37m";
	    Mockito.when(jwtProvider.generateToken(Mockito.any(Authentication.class))).thenReturn(myToken);
	    
	}
	private Person generateUser() {
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
		String contraseña = "1234";
		//Crear usuario
		Person person = new Person(1L, "felix123", contraseña, "FELIX", "MONTALICO", "LAQUIHUANACO", 
	    		'M', dateRegister, "felixmontalico@gmail.com", 'A');
		person.setPersonDateBirth(dateBirth);
		return person;
	}

}
