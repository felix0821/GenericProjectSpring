package com.system.demo.controller;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {
	
	private String token = "";
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void userTestGetAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(status().isOk());//.andExpect(status().isUnauthorized());
	}
	
	@Test
	public void userTestLogin() throws Exception{
		mockMvc.perform(post("/login")).andExpect(status().isOk());
	}

}
