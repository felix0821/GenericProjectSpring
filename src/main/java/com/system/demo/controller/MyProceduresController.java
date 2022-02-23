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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.generic.Message;
import com.system.demo.dto.specific.MyProceduresDto;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.entity.RequisitionDetail;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.PersonService;
import com.system.demo.service.RequisitionDetailService;
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
	
	
	
	//---------------------------JWT_UTIL--------------------------------------------------------
			public String usernameFromToken(HttpHeaders headers) {
				final String authorizationHeaderValue = headers.getFirst(HttpHeaders.AUTHORIZATION);
				String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
				String usernameFromToken = jwtProvider.getUsernameFromToken(token);
				return usernameFromToken;
			}

}
