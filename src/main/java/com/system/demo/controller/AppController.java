package com.system.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.system.demo.dto.AlertRequisitionDto;
import com.system.demo.dto.Message;
import com.system.demo.dto.RequisitionRegisterDto;
import com.system.demo.model.FinancialMovement;
import com.system.demo.model.IdentificationDocument;
import com.system.demo.model.Person;
import com.system.demo.model.PersonIdentificationDocument;
import com.system.demo.model.PersonRole;
import com.system.demo.model.Requisition;
import com.system.demo.model.RequisitionDetail;
import com.system.demo.model.RequisitionStatus;
import com.system.demo.model.Role;
import com.system.demo.service.RoleService;
import com.system.demo.utility.UniqId;
import com.system.demo.service.FinancialMovementService;
import com.system.demo.service.IdentificationDocumentService;
import com.system.demo.service.PersonIdentificationDocumentService;
import com.system.demo.service.PersonRoleService;
import com.system.demo.service.PersonService;
import com.system.demo.service.RequisitionDetailService;
import com.system.demo.service.RequisitionService;
import com.system.demo.service.RequisitionStatusService;

@Controller
public class AppController {
	
	@Autowired
	UniqId uI;
	
	// Gestion de ACL
	@Autowired
	PersonService personService;
	@Autowired
	PersonRoleService personRoleService;
	@Autowired
	RoleService roleService;
	@Autowired
	PersonIdentificationDocumentService personIdentDocService;
	@Autowired
	IdentificationDocumentService identificationDocumentService;
	
	//Gestion de Solicitudes y Movimientos financieros
	@Autowired
	RequisitionService requisitionService;
	@Autowired
	FinancialMovementService financialMovementService;
	@Autowired
	RequisitionStatusService requisitionStatusService;
	@Autowired
	RequisitionDetailService requisitionDetailService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@MessageMapping
	@SendTo("/alert-response")
	public List<AlertRequisitionDto> sendAlert() {
		List<AlertRequisitionDto> response = new ArrayList<>();
		/*RequisitionStatus req = requisitionStatusService.RequisitionStatusById(1L);
		Iterable<RequisitionDetail> reqDetails = req.getRequisitionDetailCollection();
		for (RequisitionDetail reqDet : reqDetails) {
			response.add(new AlertRequisitionDto(reqDet.getIdRequisitionDetail(),
					reqDet.getBank(), reqDet.getDocument(), reqDet.getObservation()));
		}*/
		return response;
	}
	
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
			generateRequisition();
			generateRole();
			generateDocument();
			generatePerson();
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
		sent = new RequisitionStatus(1L, "Enviado", "Esta solicitud...", 'A');
		reviewed = new RequisitionStatus(2L, "Aceptado","Esta solicitud...", 'A');
		observed = new RequisitionStatus(3L, "Observado","Esta solicitud...", 'A');
		// Generar cosulta
		requisitionStatusService.createRequisitionStatus(sent);
		requisitionStatusService.createRequisitionStatus(reviewed);
		requisitionStatusService.createRequisitionStatus(observed);
	}
	
	private void generateRequisition() throws Exception {
		Requisition pay, collect;
		// Crear objetos iniciales
		pay = new Requisition(1L,"Pago de matricula",'A');
		collect = new Requisition(2L,"Cobro de sueldo",'A');
		// Generar cosulta
		requisitionService.createRequisition(pay);
		requisitionService.createRequisition(collect);
	}
	
	private void generateRole() throws Exception {
		Role admin,user,invited,coordinador_academico,finanzas,apoyo_academico;
		// Crear objetos iniciales
		LocalDate datePeru=LocalDate.now(ZoneId.of("America/Lima"));
		Date dateRegister=Date.from(datePeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		admin = new Role(1L,"Administrador",'A', 'A');
		user = new Role(2L,"Usuario",'A', 'A');
		invited = new Role(3L,"Invitado",'A', 'A');
		//Roles ingresados por el usuario
		coordinador_academico = new Role(1641872943917859L,"Coordinador Academico",'A', 'D');
		finanzas = new Role(1641872943917970L,"Finanzas",'A', 'D');
		apoyo_academico = new Role(1641872943917998L,"Apoyo Academico",'A', 'D');
		// Generar cosulta
		roleService.createRole(admin);
		roleService.createRole(user);
		roleService.createRole(invited);
		
		roleService.createRole(coordinador_academico);
		roleService.createRole(finanzas);
		roleService.createRole(apoyo_academico);
	}
	
	private void generateDocument() throws Exception {
		IdentificationDocument doc = new IdentificationDocument(1L,"DNI",'A','E');
		identificationDocumentService.createIdentificationDocument(doc);
	}
	
	private void generatePerson() throws Exception {
		Person superadmin,laura;
		// Crear objetos iniciales
		
		if(personService.existsByUsername("admin"))
			System.out.println("Ese nombre de usuario ya existe");
		else {
			Long idPerson = uI.uniqid();
			LocalDate datePeru=LocalDate.now(ZoneId.of("America/Lima"));
			String password = bCryptPasswordEncoder.encode("admin");
			Date dateRegister=Date.from(datePeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			// SuperAdmin
			superadmin = new Person(idPerson, "admin", password, "ADMIN", "Sin apellido paterno", "Sin apellido materno",
					  'X', dateRegister, "admin@ucps", 'A');
			personService.createPerson(superadmin);
	        //Agregar rol a nuevo usuario
	        Long idRoleAdmin = 1L;
	        PersonRole personRole = new PersonRole(idPerson,idRoleAdmin);
			personRole.setPersonRoleState('A');
			personRoleService.createPersonRol(personRole);
			System.out.println("Usuario creado exitosamente");
			//MIGRACION
			Long idPerson1 = 1642442280123234L;
			String sDate1="1997-02-24";  
		    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
		    String password1 = "$2a$10$SRg8z0g.h3HcdMItix2XUuszgDUZPAtL/0M/.JyJnuSvyRDFXgAza";
			laura = new Person(idPerson1, "Laura", password1, "LAURA CECILIA", "LAROTA", "COAGUILA",
					  'F', dateRegister, "LAURA_CECILIA@LAROTACOAGUILA", 'A');
			laura.setPersonDateBirth(date1);
			personService.createPerson(laura);
			//DNI
			PersonIdentificationDocument personIdentificationDocument = new PersonIdentificationDocument(1L,idPerson1);
	        personIdentificationDocument.setPersonIdentificationDocumentValue("73044884");
	        personIdentDocService.createPersonIdentificationDocument(personIdentificationDocument);
			//ROL
	        PersonRole personRol1 = new PersonRole(idPerson1,2L);
			personRol1.setPersonRoleState('A');
			PersonRole personRol2 = new PersonRole(idPerson1,1641872943917998L);
			personRol2.setPersonRoleState('A');
			personRoleService.createPersonRol(personRol1);
			personRoleService.createPersonRol(personRol2);
			System.out.println("Usuario Laura creado exitosamente");
		}
	}

}
