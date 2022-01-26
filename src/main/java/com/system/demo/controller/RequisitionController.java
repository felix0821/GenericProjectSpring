package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemStatement.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.Message;
import com.system.demo.dto.RequisitionRegisterDto;
import com.system.demo.dto.RequisitionTypeDto;
import com.system.demo.model.FinancialMovement;
import com.system.demo.model.FinancialMovementDetail;
import com.system.demo.model.Person;
import com.system.demo.model.Requisition;
import com.system.demo.model.RequisitionDataDetail;
import com.system.demo.model.RequisitionDetail;
import com.system.demo.model.RequisitionStatus;
import com.system.demo.repository.FinancialMovementRepository;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.FinancialMovementDetailService;
import com.system.demo.service.FinancialMovementService;
import com.system.demo.service.PersonService;
import com.system.demo.service.RequisitionDataDetailService;
import com.system.demo.service.RequisitionDetailService;
import com.system.demo.service.RequisitionService;
import com.system.demo.service.RequisitionStatusService;
import com.system.demo.utility.UniqId;

@RestController
@RequestMapping(value=URL_REQUISITION_REQUEST)
@CrossOrigin(origins = "*")
public class RequisitionController {
	
	@Autowired
    JwtProvider jwtProvider;
	
	@Autowired
	PersonService personService;
	
	@Autowired
	UniqId uI;
	
	@Autowired
	RequisitionService requisitionService;
	
	@Autowired
	RequisitionDetailService requisitionDetailService;
	
	@Autowired
	RequisitionStatusService requisitionStatusService;
	
	@Autowired
	FinancialMovementDetailService financialMovementDetailService;
	
	@Autowired
	FinancialMovementRepository financialMovementService;
	
	@Autowired
	RequisitionDataDetailService requisitionDataDetailService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> formRequisition(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		try {
			/*Iterable<Requisition> listRequisition = requisitionService.getAllRequisitions();
			List<RequisitionTypeDto> listRequisitionDto = new ArrayList<>();
			for(Requisition requisition:listRequisition) {
				listRequisitionDto.add(new RequisitionTypeDto(requisition.getRequisitionId(), requisition.getRequisitionName()));
			}
			return new ResponseEntity<List<RequisitionTypeDto>>(listRequisitionDto, HttpStatus.OK);*/
			return new ResponseEntity(new Message("Solicitud de matricula"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
		}
	}
	/*
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping
	@ResponseBody
    public ResponseEntity<?> registerRequisition(@Valid @RequestBody RequisitionRegisterDto requisitionRegisterDto,
    		@RequestHeader HttpHeaders headers, HttpServletRequest request, BindingResult bindingResult){
		if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
		String userFromToken = usernameFromToken(headers);
		try {
			Person user = personService.getPersonByUsername(userFromToken).get();
			Requisition requisition = requisitionService.getRequisitionById(1L).get();
			RequisitionStatus requisitionStatus = requisitionStatusService.RequisitionStatusById(1L);
			//	Insertar fecha de registro
			LocalDate fechaPeru=LocalDate.now(ZoneId.of("America/Lima"));
			Date dateRegister=Date.from(fechaPeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			boolean checking = false;
			//	Objeto Solicitud
			Long idReqDetail = uI.uniqid();
			RequisitionDetail requisitionDetail = new RequisitionDetail(idReqDetail, checking, dateRegister);
			//	Objeto movimiento financiero
			Long idMovFin = 1L;
			/*FinancialMovement f = financialMovementService.getById(idMovFin);
			Long idFinDetail = uI.uniqid();
			FinancialMovementDetail financialMovementDetail = new FinancialMovementDetail(idFinDetail, requisitionRegisterDto.getAmount(),
					dateRegister, 'A','A');
			financialMovementDetail.setFinancialMovementId(f);*/
			//financialMovementDetailService.createFinancialMovementDetail(financialMovementDetail);
			/*RequisitionDataDetail program = new RequisitionDataDetail(1L,1L,idReqDetail);
			program.setRequisitionDataDetailValue(requisitionRegisterDto.getIdProgram().toString());
			requisitionDataDetailService.createRequisitionDataDetail(program);
			RequisitionDataDetail amount = new RequisitionDataDetail(1L,2L,idReqDetail);
			amount.setRequisitionDataDetailValue(requisitionRegisterDto.getAmount().toString());
			requisitionDataDetailService.createRequisitionDataDetail(amount);
			RequisitionDataDetail bank = new RequisitionDataDetail(1L,3L,idReqDetail);
			bank.setRequisitionDataDetailValue(requisitionRegisterDto.getBank());
			requisitionDataDetailService.createRequisitionDataDetail(bank);
			RequisitionDataDetail operation = new RequisitionDataDetail(1L,4L,idReqDetail);
			operation.setRequisitionDataDetailValue(requisitionRegisterDto.getOperation()+"");
			requisitionDataDetailService.createRequisitionDataDetail(operation);
			RequisitionDataDetail image = new RequisitionDataDetail(1L,5L,idReqDetail);
			image.setRequisitionDataDetailValue(requisitionRegisterDto.getImage());
			requisitionDataDetailService.createRequisitionDataDetail(image);
			RequisitionDataDetail observation = new RequisitionDataDetail(1L,6L,idReqDetail);
			observation.setRequisitionDataDetailValue(requisitionRegisterDto.getComment());
			//	Consultas
			requisitionDetailService.createRequisitionDetail(requisitionDetail);
			//financialMovementDetailService.createFinancialMovementDetail(financialMovementDetail);
			
			return new ResponseEntity(new Message("Solicitud enviado exitosamente"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
		}
	}*/
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value=URL_REQUISITION_STATUS_GET)
    public ResponseEntity<?> profile(@RequestHeader HttpHeaders headers){
		Iterable<RequisitionStatus> listRequisitionStatus = requisitionStatusService.getAllRequisitionStatus();
		
		return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
	}
	
	//---------------------------JWT_UTIL--------------------------------------------------------
	public String usernameFromToken(HttpHeaders headers) {
		final String authorizationHeaderValue = headers.getFirst(HttpHeaders.AUTHORIZATION);
		String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
		String usernameFromToken = jwtProvider.getUsernameFromToken(token);
		return usernameFromToken;
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_REQUISITION_REGISTER_GET)
	public ResponseEntity<?> registerForm(@PathVariable(name ="requisition")String requisition) {
		
		return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
	}
}
