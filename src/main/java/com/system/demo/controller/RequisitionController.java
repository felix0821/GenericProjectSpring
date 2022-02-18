package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemStatement.*;
import static com.system.demo.GenericProjectSystemDefinition.*;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.generic.DropdownDataDto;
import com.system.demo.dto.generic.HeaderDataDto;
import com.system.demo.dto.generic.Message;
import com.system.demo.dto.specific.DataDetailDto;
import com.system.demo.dto.specific.DataDto;
import com.system.demo.dto.specific.RequisitionEnrollDto;
import com.system.demo.dto.specific.RequisitionRegisterDto;
import com.system.demo.dto.specific.RequisitionTypeDto;
import com.system.demo.persistence.entity.Data;
import com.system.demo.persistence.entity.DataDetail;
import com.system.demo.persistence.entity.DataEntry;
import com.system.demo.persistence.entity.FinancialMovement;
import com.system.demo.persistence.entity.FinancialMovementDetail;
import com.system.demo.persistence.entity.Period;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.entity.Program;
import com.system.demo.persistence.entity.Requisition;
import com.system.demo.persistence.entity.RequisitionDataDetail;
import com.system.demo.persistence.entity.RequisitionDetail;
import com.system.demo.persistence.entity.RequisitionStatus;
import com.system.demo.persistence.entity.RequisitionStatusDetail;
import com.system.demo.persistence.repository.FinancialMovementRepository;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.DataDetailService;
import com.system.demo.service.DataService;
import com.system.demo.service.FinancialMovementDetailService;
import com.system.demo.service.FinancialMovementService;
import com.system.demo.service.PeriodService;
import com.system.demo.service.PersonService;
import com.system.demo.service.ProgramService;
import com.system.demo.service.RequisitionDataDetailService;
import com.system.demo.service.RequisitionDetailService;
import com.system.demo.service.RequisitionService;
import com.system.demo.service.RequisitionStatusDetailService;
import com.system.demo.service.RequisitionStatusService;
import com.system.demo.utility.PreferenceUtility;
import com.system.demo.utility.UniqIdUtility;

@RestController
@RequestMapping(value=URL_REQUISITION_REQUEST)
@CrossOrigin(origins = "*")
public class RequisitionController {
	
	@Autowired
    JwtProvider jwtProvider;
	@Autowired
	UniqIdUtility uniqueId;
	@Autowired
	PreferenceUtility preference;
	
	@Autowired
	PersonService personService;
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
	@Autowired
	DataService dataService;
	@Autowired
	DataDetailService dataDetailService;
	@Autowired
	ProgramService programService;
	@Autowired
	PeriodService periodService;
	@Autowired
	RequisitionStatusDetailService requisitionStatusDetailService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> formRequisition(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		try {
			Requisition requisition = requisitionService.getRequisitionById(1L).get();
			HeaderDataDto response = new HeaderDataDto(requisition.getRequisitionId().toString(), requisition.getRequisitionName());
			Iterable<Data> datas = dataService.getDatasByRequisitionId(1L);
			List<DataDto> datasDto = new ArrayList<>();
			for(Data data: datas) {
				DataEntry dataEntry = data.getDataEntryId();
				List<DataDetailDto> dataDetailsDto = new ArrayList<>();
				DataDto dataDto = new DataDto(data.getDataId(), data.getDataName(), data.getDataDescription(), data.getDataPlaceholder(),
						dataEntry.getDataEntryType(), dataEntry.getDataEntrySelection(), dataEntry.getDataEntryAccept());
				if(dataEntry.getDataEntrySelection()) {
					Iterable<DataDetail> dataDetails = dataDetailService.getDataDetailsByDataId(data.getDataId());
					for(DataDetail dataDetail: dataDetails) {
						dataDetailsDto.add(new DataDetailDto(dataDetail.getDataDetailName(), dataDetail.getDataDetailValue()));
					}
				}
				dataDto.setData_detail(dataDetailsDto);
				datasDto.add(dataDto);
			}
			response.setList(datasDto);
			return new ResponseEntity<HeaderDataDto>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping
	@ResponseBody
    public ResponseEntity<?> registerRequisition(@Valid @RequestBody HeaderDataDto<DropdownDataDto> requisitionRegisterDto,
    		@RequestHeader HttpHeaders headers, HttpServletRequest request, BindingResult bindingResult){
		if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
		String userFromToken = usernameFromToken(headers);
		try {
			Person person = personService.getPersonByUsername(userFromToken).get();
			Requisition requisition = requisitionService.getRequisitionById(1L).get();
			RequisitionStatus reqStatus = requisitionStatusService.getRequisitionStatusById(SYSTEM_REQUISITION_STATUS_SEND).get();
//			Insertar fecha de registro
			LocalDate fechaPeru=LocalDate.now(ZoneId.of("America/Lima"));
			Date dateRegister=Date.from(fechaPeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			boolean checking = false;
//			Objeto Solicitud
			Long idReqDetail = uniqueId.getUniqId();
			RequisitionDetail requisitionDetail = new RequisitionDetail(idReqDetail, checking, dateRegister);
			requisitionDetail.setPersonId(person);
			requisitionDetail.setRequisitionId(requisition);
			requisitionDetail = requisitionDetailService.createRequisitionDetail(requisitionDetail);
//			Objeto control documental
			Long idReqStatusDetail = uniqueId.getUniqId();
			int reqStatusDetailIndex = preference.getIndex(INDEX_REQUISITION_STATUS_DETAIL);
			RequisitionStatusDetail reqStatusDetail = new RequisitionStatusDetail(idReqStatusDetail, reqStatusDetailIndex, dateRegister);
			reqStatusDetail.setPersonId(person);
			reqStatusDetail.setRequisitionStatusId(reqStatus);
			reqStatusDetail.setRequisitionDetailId(requisitionDetail);
			requisitionStatusDetailService.createRequisitionStatusDetail(reqStatusDetail);
//			Registrar datos detalle
			List<DropdownDataDto> datas = requisitionRegisterDto.getList();
			for(DropdownDataDto data: datas) {
				RequisitionDataDetail reqDataDetail = new RequisitionDataDetail(requisition.getRequisitionId(), data.getId(), idReqDetail);
				reqDataDetail.setRequisitionDataDetailValue(data.getName());
				requisitionDataDetailService.createRequisitionDataDetail(reqDataDetail);
			}
			//	Consultas
			return new ResponseEntity(new Message("Solicitud enviado exitosamente"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value=URL_REQUISITION_STATUS_GET)
    public ResponseEntity<?> profile(@RequestHeader HttpHeaders headers){
		Iterable<RequisitionStatus> listRequisitionStatus = requisitionStatusService.getAllRequisitionStatus();
		
		return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value=URL_REQUISITION_ENROLL_GET)
    public ResponseEntity<?> enroll(@RequestParam(name ="programId")Long programId, @RequestParam(name ="periodId")Long periodId){
		try {
			Requisition requisition = requisitionService.getRequisitionById(1L).get();
			Program program = programService.getProgramById(programId);
			Period period = periodService.getPeriodById(periodId);
			RequisitionEnrollDto response = new RequisitionEnrollDto(requisition.getRequisitionId(), requisition.getRequisitionName(),
					program.getProgramId(), program.getProgramName(), period.getPeriodId(), period.getPeriodName());
			Iterable<Data> datas = dataService.getDatasByRequisitionId(1L);
			List<DataDto> datasDto = new ArrayList<>();
			for(Data data: datas) {
				DataEntry dataEntry = data.getDataEntryId();
				List<DataDetailDto> dataDetailsDto = new ArrayList<>();
				DataDto dataDto = new DataDto(data.getDataId(), data.getDataName(), data.getDataDescription(), data.getDataPlaceholder(),
						dataEntry.getDataEntryType(), dataEntry.getDataEntrySelection(), dataEntry.getDataEntryAccept());
				if(dataEntry.getDataEntrySelection()) {
					Iterable<DataDetail> dataDetails = dataDetailService.getDataDetailsByDataId(data.getDataId());
					for(DataDetail dataDetail: dataDetails) {
						dataDetailsDto.add(new DataDetailDto(dataDetail.getDataDetailName(), dataDetail.getDataDetailValue()));
					}
				}
				dataDto.setData_detail(dataDetailsDto);
				datasDto.add(dataDto);
			}
			response.setList(datasDto);
			return new ResponseEntity<RequisitionEnrollDto>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
		}
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
