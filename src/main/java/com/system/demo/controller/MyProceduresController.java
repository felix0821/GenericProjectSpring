package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemDefinition.*;
import static com.system.demo.GenericProjectSystemStatement.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.generic.Message;
import com.system.demo.dto.specific.AlertViewDataDto;
import com.system.demo.dto.specific.AlertViewDto;
import com.system.demo.dto.specific.MyProceduresDto;
import com.system.demo.dto.specific.MyProceduresObserveDto;
import com.system.demo.dto.specific.MyProceduresStatusDto;
import com.system.demo.dto.specific.MyProceduresViewDto;
import com.system.demo.persistence.entity.Data;
import com.system.demo.persistence.entity.Period;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.entity.Program;
import com.system.demo.persistence.entity.RequisitionDataDetail;
import com.system.demo.persistence.entity.RequisitionDetail;
import com.system.demo.persistence.entity.RequisitionRemark;
import com.system.demo.persistence.entity.RequisitionStatusDetail;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.DataService;
import com.system.demo.service.PeriodService;
import com.system.demo.service.PersonService;
import com.system.demo.service.ProgramService;
import com.system.demo.service.RequisitionDataDetailService;
import com.system.demo.service.RequisitionDetailService;
import com.system.demo.service.RequisitionRemarkService;
import com.system.demo.service.RequisitionStatusDetailService;

@RestController
@RequestMapping(value=URL_MYxPROCEDURES_REQUEST)
@CrossOrigin(origins = "*")
public class MyProceduresController {
	
	@Autowired
    JwtProvider jwtProvider;
	
	@Autowired
	PersonService personService;
	@Autowired
	RequisitionDetailService requisitionDetailService;
	@Autowired
	RequisitionStatusDetailService requisitionStatusDetailService;
	@Autowired
	RequisitionDataDetailService requisitionDataDetailService;
	@Autowired
	RequisitionRemarkService requisitionRemarkService;
	@Autowired
	DataService dataService;
	@Autowired
	ProgramService programService;
	@Autowired
	PeriodService periodService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> getAlerts(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		String userFromToken = usernameFromToken(headers);
		try {
			List<MyProceduresDto> result = new ArrayList<>();
			Person person = personService.getPersonByUsername(userFromToken).get();
			Iterable<RequisitionDetail> reqDetails = requisitionDetailService.getRequisitionDetailsByPersonId(person.getPersonId());
			for(RequisitionDetail reqDetail: reqDetails) {
				result.add(new MyProceduresDto(reqDetail.getRequisitionDetailId(), reqDetail.getRequisitionId().getRequisitionName(), 
						reqDetail.getRequisitionDetailChecking(), reqDetail.getRequisitionDetailDate()));
			}
			return new ResponseEntity<List<MyProceduresDto>>(result, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_MYxPROCEDURES_VIEW_GET)
	public ResponseEntity<?> academicPeriodForm(@RequestParam(name ="id")Long id) {
		try {
			Period period = null;
			Program program = null;
			RequisitionDetail requisition = requisitionDetailService.RequisitionDetailById(id).get();
			MyProceduresViewDto procedureDto = new MyProceduresViewDto(requisition.getRequisitionId().getRequisitionName(),
					requisition.getRequisitionDetailDate());
			List<AlertViewDataDto> dates = new ArrayList<>();
			List<MyProceduresObserveDto> observes = new ArrayList<>();
			List<MyProceduresStatusDto> states = new ArrayList<>();
			//	Entidades
			Iterable<RequisitionDataDetail> reqDataDetails = requisitionDataDetailService.getRequisitionDetailsByRequisitionDetailId(id);
			Iterable<RequisitionStatusDetail> reqStatusDetails = requisitionStatusDetailService.getRequisitionStatusDetailsByRequisitionDetailId(id);
			Iterable<RequisitionRemark> reqRemarks = requisitionRemarkService.getRequisitionRemarksByRequisitionDetailId(id);
//			Insertar datos
			for(RequisitionDataDetail reqDataDetail: reqDataDetails) {
				Data data = dataService.getDataById(reqDataDetail.getRequisitionDataDetailPK().getDataId()).get();
				String value = "";
				if(data.getDataId()==10001L) {
					period = periodService.getPeriodById(Long.parseLong(reqDataDetail.getRequisitionDataDetailValue()));
					value = period.getPeriodIdentifier();
				} else if(data.getDataId()==10002L) {
					program = programService.getProgramById(Long.parseLong(reqDataDetail.getRequisitionDataDetailValue()));
					value = program.getProgramName();
				} else {
					value = reqDataDetail.getRequisitionDataDetailValue();
				}
				dates.add(new AlertViewDataDto(data.getDataId(), data.getDataName(), value, data.getDataType()));
			}
			procedureDto.setData(dates);
//			Insertar observaciones
			for(RequisitionStatusDetail reqStatusDetail: reqStatusDetails) {
				states.add(new MyProceduresStatusDto(reqStatusDetail.getRequisitionStatus().getRequisitionStatusName(), 
						reqStatusDetail.getRequisitionStatus().getRequisitionStatusColor()));
			}
			procedureDto.setStates(states);
//			Insertar observaciones
			for(RequisitionRemark reqRemark: reqRemarks) {
				observes.add(new MyProceduresObserveDto(reqRemark.getRequisitionRemarkContent(), reqRemark.getRequisitionRemarkDate(), 
						reqRemark.getPersonId().getPersonUsername()));
			}
			procedureDto.setObserves(observes);
			//	Retornar
			return new ResponseEntity<MyProceduresViewDto>(procedureDto, HttpStatus.OK);
		} catch(Exception e) {
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
