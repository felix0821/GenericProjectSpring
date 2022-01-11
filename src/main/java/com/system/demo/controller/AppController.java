package com.system.demo.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.demo.model.Person;
import com.system.demo.model.PersonRol;
import com.system.demo.model.Role;
import com.system.demo.service.RoleService;
import com.system.demo.service.UserRolService;
import com.system.demo.service.UserService;
import com.system.demo.util.UniqId;

@Controller
public class AppController {
	
	@Autowired
	UniqId uI;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRolService userRolService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping({"/","/index"})
	public String index(ModelMap model) {
		//ModelAndView mv = new ModelAndView();
		model.addAttribute("page", "index.html");
		//mv.setViewName("page");
		return "display-page";
	}
	
	@PostMapping("/generate-data")
	public String createUser(ModelMap model) {
		try {
			generateRole();
			generatePerson();
			model.addAttribute("page", "completed.html");
		} catch (Exception e) {
			model.addAttribute("page", "error.html");
			e.printStackTrace();
		}
		return "display-page";
	}
	
	private void generateRole() throws Exception {
		Role admin,user,invited;
		// Crear objetos iniciales
		LocalDate datePeru=LocalDate.now(ZoneId.of("America/Lima"));
		Date dateRegister=Date.from(datePeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		admin = new Role(1L,"Administrador", dateRegister,'A',"Adminitrador de pagina");
		user = new Role(2L,"Usuario", dateRegister,'A',"Usuario de pagina");
		invited = new Role(3L,"Invitado", dateRegister,'A',"Invitado de pagina");
		roleService.createRole(admin);
		roleService.createRole(user);
		roleService.createRole(invited);
	}
	
	private void generatePerson() throws Exception {
		Person superadmin, us;
		// Crear objetos iniciales
		Long idPerson = uI.uniqid();
		LocalDate datePeru=LocalDate.now(ZoneId.of("America/Lima"));
		String password = bCryptPasswordEncoder.encode("admin");
		Date dateRegister=Date.from(datePeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		// SuperAdmin
		superadmin = new Person(idPerson, "admin", password, "ADMIN", "NaN", 
				"NaN", "NaN", "11111111",dateRegister, 
				dateRegister, 'A');
		
		Long idPerson1 = uI.uniqid();
		us = new Person(idPerson1, "add", password, "1234", "NaN", 
				"NaN", "asdasd", "11111111",dateRegister, 
				dateRegister, 'A');
		
		userService.createUser(us);
		userService.createUser(superadmin);
        //Agregar rol a nuevo usuario
        Long idRoleAdmin = 1L;
        Long idRoleUser = 2L;
        PersonRol personRol = new PersonRol(idPerson,idRoleAdmin);
		personRol.setState('A');
		userRolService.createPersonRol(personRol);
		
		PersonRol personRol1 = new PersonRol(idPerson1,idRoleAdmin);
		PersonRol personRol2 = new PersonRol(idPerson1,idRoleUser);
		userRolService.createPersonRol(personRol1);
		userRolService.createPersonRol(personRol2);
	}

}
