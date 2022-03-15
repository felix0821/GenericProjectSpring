package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemStatement.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.system.demo.GenericProjectSystemDefinition.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.generic.DropdownDataDto;
import com.system.demo.dto.generic.Message;
import com.system.demo.dto.specific.AlertDto;
import com.system.demo.dto.specific.AlertObserveDto;
import com.system.demo.dto.specific.AlertViewDataDto;
import com.system.demo.dto.specific.AlertViewDto;
import com.system.demo.dto.specific.AlertViewEventDto;
import com.system.demo.persistence.entity.Data;
import com.system.demo.persistence.entity.EnrollmentProgram;
import com.system.demo.persistence.entity.FinancialMovement;
import com.system.demo.persistence.entity.FinancialMovementDetail;
import com.system.demo.persistence.entity.FinancialRequisition;
import com.system.demo.persistence.entity.Period;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.entity.PersonRegistering;
import com.system.demo.persistence.entity.Program;
import com.system.demo.persistence.entity.Requisition;
import com.system.demo.persistence.entity.RequisitionDataDetail;
import com.system.demo.persistence.entity.RequisitionDetail;
import com.system.demo.persistence.entity.RequisitionRemark;
import com.system.demo.persistence.entity.RequisitionStatus;
import com.system.demo.persistence.entity.RequisitionStatusDetail;
import com.system.demo.persistence.entity.Uses;
import com.system.demo.persistence.repository.FinancialMovementRepository;
import com.system.demo.persistence.repository.FinancialRequisitionRepository;
import com.system.demo.persistence.repository.UsesRepository;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.DataService;
import com.system.demo.service.EnrollmentProgramService;
import com.system.demo.service.FinancialMovementDetailService;
import com.system.demo.service.PeriodService;
import com.system.demo.service.PersonRegisteringService;
import com.system.demo.service.PersonService;
import com.system.demo.service.ProgramService;
import com.system.demo.service.RequisitionDataDetailService;
import com.system.demo.service.RequisitionDetailService;
import com.system.demo.service.RequisitionRemarkService;
import com.system.demo.service.RequisitionStatusDetailService;
import com.system.demo.service.RequisitionStatusService;
import com.system.demo.utility.PreferenceUtility;
import com.system.demo.utility.UniqIdUtility;

@RestController
@RequestMapping(value=URL_ALERT_REQUEST)
@CrossOrigin(origins = "*")
public class AlertController {
	
	@Autowired
    JwtProvider jwtProvider;
	@Autowired
	UniqIdUtility uniqueId;
	@Autowired
	PreferenceUtility preference;
	
//	*Repository
	@Autowired
	UsesRepository usesRepository;
	
//	*Service
	@Autowired
	RequisitionDetailService requisitionDetailService;
	@Autowired
	RequisitionDataDetailService requisitionDataDetailService;
	@Autowired
	DataService dataService;
	@Autowired
	RequisitionStatusDetailService requisitionStatusDetailService;
	@Autowired
	PersonService personService;
	@Autowired
	RequisitionStatusService requisitionStatusService;
	@Autowired
	ProgramService programService;
	@Autowired
	PeriodService periodService;
	@Autowired
	EnrollmentProgramService enrollmentProgramService;
	@Autowired
	FinancialMovementDetailService financialMovementDetailService;
	@Autowired
	FinancialMovementRepository financialMovementService;
	@Autowired
	FinancialRequisitionRepository financialRequisitionRepository;
	@Autowired
	PersonRegisteringService personRegisteringService;
	@Autowired
	RequisitionRemarkService requisitionRemarkService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> getAlerts(@RequestHeader HttpHeaders headers){
		try {
			String userFromToken = usernameFromToken(headers);
//			°Mostrar lista de matriculados
			Person personId = personService.getPersonByUsername(userFromToken).get();
			Iterable<RequisitionDetail> requisitionDetails = requisitionDetailService.getAllRequisitionDetailByNotCheckingByPersonId(personId.getPersonId());
			List<AlertDto> alertsDto = new ArrayList<>();
			for(RequisitionDetail requisitionDetail: requisitionDetails) {
				Requisition requisition = requisitionDetail.getRequisitionId();
				Person person = requisitionDetail.getPersonId();
				alertsDto.add(new AlertDto(requisitionDetail.getRequisitionDetailId(), requisition.getRequisitionName(),
						person.getPersonUsername(), requisitionDetail.getRequisitionDetailDate()));
			}
			return new ResponseEntity<List<AlertDto>>(alertsDto, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_ALERT_VIEW_GET)
	public ResponseEntity<?> academicPeriodForm(@RequestParam(name ="id")Long id) {
		try {
//			°Consulta solicitud detalle
			RequisitionDetail reqDetail = requisitionDetailService.RequisitionDetailById(id).get();
			AlertViewDto alertDto = new AlertViewDto(reqDetail.getRequisitionDetailId(), reqDetail.getRequisitionId().getRequisitionName(),
					reqDetail.getRequisitionDetailDate(), reqDetail.getPersonId().getPersonUsername());
			List<AlertViewDataDto> dates = new ArrayList<>();
			Iterable<RequisitionDataDetail> reqDataDetails = requisitionDataDetailService.getRequisitionDetailsByRequisitionDetailId(id);
			for(RequisitionDataDetail reqDataDetail: reqDataDetails) {
				Data data = dataService.getDataById(reqDataDetail.getRequisitionDataDetailPK().getDataId()).get();
				String value = reqDataDetail.getRequisitionDataDetailValue();
				dates.add(new AlertViewDataDto(data.getDataId(), data.getDataName(), value, data.getDataType()));
			}
//			°Consulta eventos
			List<AlertViewEventDto> actions = new ArrayList<>();
			Iterable<Uses> usesIterable = usesRepository.findByRequisitionDetailId(id);
			for(Uses uses: usesIterable) {
				actions.add(new AlertViewEventDto(uses.getUsesId(), uses.getUsesName()));
			}
//			°Retornar solicitud
			alertDto.setData(dates);
			alertDto.setActions(actions);
			return new ResponseEntity<AlertViewDto>(alertDto, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(URL_ALERT_VALIDATE_POST)
	public ResponseEntity<?> postAlerts(@RequestHeader HttpHeaders headers, @Valid @RequestBody AlertViewDto alertDto) {
		String userFromToken = usernameFromToken(headers);
		try {
//			Insertar fecha de registro
			LocalDateTime dateTimePeru = LocalDateTime.now(ZoneId.of(ZONE_DATE_LIMA));
			Date dateRegister=Date.from(dateTimePeru.atZone(ZoneId.systemDefault()).toInstant());
			RequisitionDetail reqDetail = requisitionDetailService.RequisitionDetailById(alertDto.getId()).get();
//			Insertar ids
			Person person = personService.getPersonById(reqDetail.getPersonId().getPersonId());
			Period period = periodService.getPeriodById(1L);//alertDto.getPeriodId()
			Program program = programService.getProgramById(1L);//alertDto.getProgramId()
			FinancialMovement income = financialMovementService.getById(SYSTEM_FINANTIAL_MOVEMENT_INCOME_SOLES);
//			Crear persona que registra
			Long pRegisteringId = uniqueId.getUniqId();
			PersonRegistering pRegistering = new PersonRegistering(pRegisteringId, dateRegister, REGISTERING_FINANCIAL_MOVEMENT);
			pRegistering.setPersonId(personService.getPersonByUsername(userFromToken).get());
			personRegisteringService.createPersonRegistering(pRegistering);
//			Crear matricula
			EnrollmentProgram enroll = new EnrollmentProgram(person.getPersonId(), program.getProgramId(), period.getPeriodId());
			enroll.setEnrollmentProgramDate(dateRegister);
			enroll.setEnrollmentProgramChecking(false);
			enroll.setEnrollmentProgramState(SYSTEM_STATE_ACTIVE);
			enroll.setRequisitionDetailId(reqDetail);
			enrollmentProgramService.createEnrollmentProgramPeriod(enroll);
//			Crear movimiento financiero
			Long idMovFin = uniqueId.getUniqId();
			FinancialMovementDetail financial = new FinancialMovementDetail(idMovFin, 0, 
					dateRegister, SYSTEM_TYPE_AUTOGENERATED, SYSTEM_STATE_ACTIVE); //alertDto.getMonto()
			financial.setFinancialMovementId(income);
			financial.setPersonRegisteringId(pRegistering);
			financialMovementDetailService.createFinancialMovementDetail(financial);
//			Generar entidad estado
			RequisitionStatusDetail reqStatusDetail = new RequisitionStatusDetail(reqDetail.getRequisitionDetailId(), 
					SYSTEM_REQUISITION_STATUS_ACCEPT);
			reqStatusDetail.setPersonId(person);
			reqStatusDetail.setRequisitionStatusDetailDate(dateRegister);
			requisitionStatusDetailService.createRequisitionStatusDetail(reqStatusDetail);
			requisitionDetailService.checkingRequisitionDetailById(alertDto.getId());
			FinancialRequisition finMovReq = new FinancialRequisition(financial.getFinancialMovementDetailId(), 
					reqDetail.getRequisitionDetailId());
			finMovReq.setFinancialRequisitionState(SYSTEM_STATE_ACTIVE);
			financialRequisitionRepository.save(finMovReq);
			return new ResponseEntity(new Message(SYSTEM_SUCCESS), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_ALERT_VALIDATE), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(URL_ALERT_OBSERVE_POST)
	public ResponseEntity<?> getAlertObserve(@Valid @RequestBody AlertObserveDto observeDto, @RequestHeader HttpHeaders headers, 
			BindingResult bindingResult) {
		String userFromToken = usernameFromToken(headers);
		//Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
		try {
//			Insertar ids
			RequisitionDetail requisition = requisitionDetailService.RequisitionDetailById(observeDto.getId()).get();
			RequisitionStatus reqStatus = requisitionStatusService.getRequisitionStatusById(SYSTEM_REQUISITION_STATUS_OBSERVE).get();
			Person person = personService.getPersonByUsername(userFromToken).get();
//			Generar datos
			Long idReqRemark = uniqueId.getUniqId();
//			Insertar fecha de registro
			LocalDateTime dateTimePeru = LocalDateTime.now(ZoneId.of(ZONE_DATE_LIMA));
			Date dateRegister=Date.from(dateTimePeru.atZone(ZoneId.systemDefault()).toInstant());
//			Generar entidad observación
			RequisitionRemark reqRemark = new RequisitionRemark(idReqRemark, observeDto.getContent(), dateRegister);
			reqRemark.setRequisitionDetailId(requisition);
			reqRemark.setPersonId(person);
			requisitionRemarkService.createRequisitionRemark(reqRemark);
//			Generar entidad estado
			RequisitionStatusDetail reqStatusDetail = new RequisitionStatusDetail(requisition.getRequisitionDetailId(), 
					reqStatus.getRequisitionStatusId());
			reqStatusDetail.setRequisitionStatusDetailDate(dateRegister);
			reqStatusDetail.setPersonId(person);
			requisitionStatusDetailService.createRequisitionStatusDetail(reqStatusDetail);
			requisitionDetailService.checkingRequisitionDetailById(observeDto.getId());
			return new ResponseEntity(new Message(SYSTEM_SUCCESS), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	//---------------------------JWT_UTIL--------------------------------------------------------
		public String usernameFromToken(HttpHeaders headers) {
			final String authorizationHeaderValue = headers.getFirst(HttpHeaders.AUTHORIZATION);
			String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
			String usernameFromToken = jwtProvider.getUsernameFromToken(token);
			return usernameFromToken;
		}

}
