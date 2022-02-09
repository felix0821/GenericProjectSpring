package com.system.demo.service;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.validation.BindingResult;
import org.thymeleaf.extras.springsecurity5.auth.Authorization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.demo.dto.specific.PersonLoginDto;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.repository.PersonRepository;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.PersonService;
import com.system.demo.service.implementation.PersonServiceImplements;
import com.system.demo.utility.EncripId;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonServiceTest {
 
 private String token = "$2a$10$eBDHYpbsQqeNpYeBaGjfKuT8Lz0HZTTmEN/9oasqKQO0zF12WY37m";
 
 
 @Autowired
 MockMvc mockMvc;
 
 @MockBean
    JwtProvider jwtProvider;
 @Autowired
 ObjectMapper objectMapper;
 
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
 
 @MockBean
    AuthenticationManager authenticationManager;
 
 
 @MockBean
 EncripId encripId;
 
 
 @Test
 public void userTestGetAll() throws Exception {
  mockMvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(status().isOk());//.andExpect(status().isUnauthorized());
 }
 
 @Test
 public void userTestLogin() throws Exception{
  BindingResult bindingResult=null;
  PersonLoginDto pld=new PersonLoginDto();
  pld.setPassword("1234");
  pld.setUsername("felix123");
  mockMvc.perform(post("/auth/login").
  contentType("aplication/json")
  .content(objectMapper.writeValueAsString(pld))).andExpect(status().isOk());
  System.out.println("llegoo aqui ");
  verify(authenticationManager).authenticate(Mockito.any(Authentication.class));
  System.out.println("Termino aqui");
 }
 
 
 @BeforeEach
 public void setup() throws Exception{
  
  
  Optional<Person> opt = Optional.of(generateUser());
  
  String username="felix123";
  String psw="1234";
     UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, psw);
     Authentication authentication = authRequest;
     Mockito.when(authenticationManager.authenticate(Mockito.any(Authentication.class))).thenReturn(authentication);
     Mockito.when(jwtProvider.generateToken(Mockito.any(Authentication.class))).thenReturn(token);
Mockito.when(encripId.encript(Mockito.any(String.class))).thenReturn("pasw");
     Mockito.when(personService.getPersonByUsername(Mockito.any(String.class))).thenReturn(opt);
     
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
  Person person = new Person(1L, "felix123", "123", "FELIX", "MONTALICO", "LAQUIHUANACO", 'M',
       dateRegister, "felixmontalico@gmail.com", 'A');
  return person;
 }

}
