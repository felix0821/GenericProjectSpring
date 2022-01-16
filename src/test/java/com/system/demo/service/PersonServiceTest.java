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

import com.system.demo.model.Person;
import com.system.demo.repository.PersonRepository;

@SpringBootTest
public class PersonServiceTest {
	
	@TestConfiguration
	static class UserServiceTestConfiguration {
		
		@Bean
		public PersonService personService() {
			return new PersonServiceImplements();
		}
	}
	
	@Autowired 
	PersonService personService;
	
	@MockBean
	PersonRepository personRepository;
	
	//PRUEBAS DE ITERADOR
	@Test
	public void userTestServiceGetAllUsers() {
		List<Person> expected = this.getListUsers();
		Iterable<Person> result = personService.getAllPersons();
		
		int resultSize = 0;
		for(Person person:result) {
			Assertions.assertEquals(person.toString(), expected.get(resultSize).toString());
			resultSize++;
		}
		Assertions.assertEquals(expected.size(), resultSize);
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
		//Crear usuario
		Person person = new Person(1L, "felix123", "123", "FELIX", "MONTALICO", "LAQUIHUANACO", 
	    		"felixmontalico@gmail.com", "77283387", dateBirth, dateRegister, 'A');
		return person;
	}
	
	private List<Person> getListUsers() {
		List<Person> persons = new ArrayList<>();
		//Crear usuario
		Person person = generateUser();
		persons.add(person);
		return persons;
	}
	
	//Genera una instancia de repositorio
	@BeforeEach
	public void setup() {
		List<Person> persons = new ArrayList<>();
		//Crear usuario
		Person person = generateUser();
		persons.add(person);
		Mockito.when(personRepository.findAll()).thenReturn(persons);
	}
	
	//PRUEBAS DE CONSULTA
	
	
	/*@Test
	public void userTestServiceChangePassword() {
		ChangePasswordDto form = new ChangePasswordDto();
		
		User userChangePassword = userService.changePassword(form);
		
		Assertions.assertEquals(userChangePassword.getPassword(), "123");
	}*/
	

}
