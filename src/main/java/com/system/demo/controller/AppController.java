package com.system.demo.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.demo.model.Role;
import com.system.demo.service.RoleService;

@Controller
public class AppController {
	
	@Autowired
	RoleService roleService;
	
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
			model.addAttribute("page", "completed.html");
		} catch (Exception e) {
			model.addAttribute("page", "error.html");
			e.printStackTrace();
		}
		return "display-page";
	}
	
	private void generateRole() throws Exception {
		Role admin,user;
		LocalDate datePeru=LocalDate.now(ZoneId.of("America/Lima"));
		Date dateRegister=Date.from(datePeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		admin = new Role(1L,"ADMIN", dateRegister,'A',"Adminitrador de pagina");
		user = new Role(2L,"USER", dateRegister,'A',"Usuario de pagina");
		roleService.createRole(admin);
		roleService.createRole(user);
	}

}
