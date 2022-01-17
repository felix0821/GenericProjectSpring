package com.system.demo.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.demo.dto.Message;
import com.system.demo.model.FinancialMovement;
import com.system.demo.model.Person;
import com.system.demo.model.PersonRol;
import com.system.demo.model.Requisition;
import com.system.demo.model.RequisitionStatus;
import com.system.demo.model.Role;
import com.system.demo.service.RoleService;
import com.system.demo.service.FinancialMovementService;
import com.system.demo.service.PersonRolService;
import com.system.demo.service.PersonService;
import com.system.demo.service.RequisitionService;
import com.system.demo.service.RequisitionStatusService;
import com.system.demo.util.UniqId;

@Controller
public class AppController {
	
	@Autowired
	UniqId uI;
	
	// Gestion de ACL
	@Autowired
	PersonService personService;
	@Autowired
	PersonRolService personRolService;
	@Autowired
	RoleService roleService;
	
	//Gestion de Solicitudes y Movimientos financieros
	@Autowired
	RequisitionService requisitionService;
	@Autowired
	FinancialMovementService financialMovementService;
	@Autowired
	RequisitionStatusService requisitionStatusService;
	
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
			generateFinancialMovement();
			generateRequisitionStatus();
			//generateRequisition();
			//generateRole();
			//generatePerson();
			model.addAttribute("page", "completed.html");
		} catch (Exception e) {
			model.addAttribute("page", "error.html");
			e.printStackTrace();
		}
		return "display-page";
	}
	
	private void generateFinancialMovement() throws Exception {
		FinancialMovement income, egress;
		// Crear objetos iniciales
		income = new FinancialMovement(1L,"Ingresos en soles", "S/", '+', 'A');
		egress = new FinancialMovement(2L,"Egresos en soles", "S/", '-', 'A');
		// Generar cosulta
		financialMovementService.createFinancialMovement(income);
		financialMovementService.createFinancialMovement(egress);
	}
	
	private void generateRequisitionStatus() throws Exception {
		RequisitionStatus sent, reviewed, observed;
		// Crear objetos iniciales
		sent = new RequisitionStatus(1L, "Enviado", 'A', null);
		reviewed = new RequisitionStatus(2L, "Revisado", 'A', null);
		observed = new RequisitionStatus(3L, "Observado", 'A', null);
		// Generar cosulta
		requisitionStatusService.createRequisitionStatus(sent);
		requisitionStatusService.createRequisitionStatus(reviewed);
		requisitionStatusService.createRequisitionStatus(observed);
	}
	
	private void generateRequisition() throws Exception {
		Requisition pay, collect;
		// Crear objetos iniciales
		pay = new Requisition(1L,"Pago de matricula",'A',null);
		collect = new Requisition(2L,"Cobro de sueldo",'A',null);
		// Generar cosulta
		requisitionService.createRequisition(pay);
		requisitionService.createRequisition(collect);
	}
	
	private void generateRole() throws Exception {
		Role admin,user,invited;
		// Crear objetos iniciales
		LocalDate datePeru=LocalDate.now(ZoneId.of("America/Lima"));
		Date dateRegister=Date.from(datePeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		admin = new Role(1L,"Administrador", dateRegister,'A',"Adminitrador de pagina");
		user = new Role(2L,"Usuario", dateRegister,'A',"Usuario de pagina");
		invited = new Role(3L,"Invitado", dateRegister,'A',"Invitado de pagina");
		// Generar cosulta
		roleService.createRole(admin);
		roleService.createRole(user);
		roleService.createRole(invited);
	}
	
	private void generatePerson() throws Exception {
		Person superadmin;
		// Crear objetos iniciales
		if(personService.existsByUsername("admin"))
			System.out.println("Ese nombre de usuario ya existe");
		else {
			Long idPerson = uI.uniqid();
			LocalDate datePeru=LocalDate.now(ZoneId.of("America/Lima"));
			String password = bCryptPasswordEncoder.encode("admin");
			Date dateRegister=Date.from(datePeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			// SuperAdmin
			superadmin = new Person(idPerson, "admin", password, "ADMIN", "NaN", 
					"NaN", "NaN", "11111111",dateRegister, 
					dateRegister, 'A');
			personService.createPerson(superadmin);
	        //Agregar rol a nuevo usuario
	        Long idRoleAdmin = 1L;
	        PersonRol personRol = new PersonRol(idPerson,idRoleAdmin);
			personRol.setState('A');
			personRolService.createPersonRol(personRol);
			System.out.println("Usuario creado exitosamente");
		}
	}

}
