package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemStatement.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.system.demo.GenericProjectSystemDefinition.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.generic.Message;
import com.system.demo.dto.specific.AlertDto;
import com.system.demo.dto.specific.AlertViewDataDto;
import com.system.demo.dto.specific.AlertViewDto;
import com.system.demo.persistence.entity.Data;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.entity.Requisition;
import com.system.demo.persistence.entity.RequisitionDataDetail;
import com.system.demo.persistence.entity.RequisitionDetail;
import com.system.demo.persistence.entity.RequisitionStatus;
import com.system.demo.persistence.entity.RequisitionStatusDetail;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.DataService;
import com.system.demo.service.PersonService;
import com.system.demo.service.RequisitionDataDetailService;
import com.system.demo.service.RequisitionDetailService;
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> getAlerts(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		try {
			Iterable<RequisitionDetail> requisitionDetails = requisitionDetailService.getRequisitionDetailsByRequisitionIdNotChecking(1L);
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
	public ResponseEntity<?> academicPeriodForm(@RequestParam(name ="id")Long id){
		try {
			RequisitionDetail requisition = requisitionDetailService.RequisitionDetailById(id).get();
			AlertViewDto alertDto = new AlertViewDto(requisition.getRequisitionDetailId(), requisition.getRequisitionId().getRequisitionName(),
					requisition.getRequisitionDetailDate(), requisition.getPersonId().getPersonUsername());
			List<AlertViewDataDto> dates = new ArrayList<>();
			Iterable<RequisitionDataDetail> reqDataDetails = requisitionDataDetailService.getRequisitionDetailsByRequisitionDetailId(id);
			for(RequisitionDataDetail reqDataDetail: reqDataDetails) {
				Data data = dataService.getDataById(reqDataDetail.getRequisitionDataDetailPK().getDataId()).get();
				dates.add(new AlertViewDataDto(data.getDataId(), data.getDataName(),reqDataDetail.getRequisitionDataDetailValue(), 
						data.getDataType()));
			}
			alertDto.setData(dates);
			return new ResponseEntity<AlertViewDto>(alertDto, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(URL_ALERT_VALIDATE_POST)
	public ResponseEntity<?> postAlerts(@RequestHeader HttpHeaders headers) {
		
		return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(URL_ALERT_OBSERVE_GET)
	public ResponseEntity<?> getAlertObserve(@RequestParam(name ="id")Long id, @RequestHeader HttpHeaders headers) {
		String userFromToken = usernameFromToken(headers);
		try {
			/*RequisitionDetail requisition = requisitionDetailService.RequisitionDetailById(id).get();
			Person person = personService.getPersonByUsername(userFromToken).get();
			RequisitionStatus reqStatus = requisitionStatusService.getRequisitionStatusById(SYSTEM_REQUISITION_STATUS_OBSERVE).get();
			Long idReqStatusDetail = uniqueId.getUniqId();
			int reqStatusDetailIndex = preference.getIndex(INDEX_REQUISITION_STATUS_DETAIL);
			LocalDate fechaPeru=LocalDate.now(ZoneId.of("America/Lima"));
			Date dateRegister=Date.from(fechaPeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			RequisitionStatusDetail reqStatusDetail = new RequisitionStatusDetail(idReqStatusDetail, reqStatusDetailIndex, dateRegister);
			reqStatusDetail.setPersonId(person);
			reqStatusDetail.setRequisitionStatusId(reqStatus);
			reqStatusDetail.setRequisitionDetailId(requisition);
			requisitionStatusDetailService.createRequisitionStatusDetail(reqStatusDetail);*/
			requisitionDetailService.checkingRequisitionDetailById(id);
			return new ResponseEntity(new Message(SYSTEM_SUCCESS), HttpStatus.OK);
		} catch(Exception e) {
			System.out.println(e);
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
