package com.system.demo.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.Message;
import com.system.demo.dto.RequisitionTypeDto;
import com.system.demo.model.Requisition;
import com.system.demo.model.RequisitionStatus;
import com.system.demo.service.RequisitionDetailService;
import com.system.demo.service.RequisitionService;
import com.system.demo.service.RequisitionStatusService;

@RestController
@RequestMapping(value=URL_REQUISITION_REQUEST)
@CrossOrigin(origins = "*")
public class RequisitionController {
	
	@Autowired
	RequisitionService requisitionService;
	
	@Autowired
	RequisitionDetailService requisitionDetailService;
	
	@Autowired
	RequisitionStatusService requisitionStatusService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> formRequisition(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		try {
			Iterable<Requisition> listRequisition = requisitionService.getAllRequisitions();
			List<RequisitionTypeDto> listRequisitionDto = new ArrayList<>();
			for(Requisition requisition:listRequisition) {
				listRequisitionDto.add(new RequisitionTypeDto(requisition.getIdRequisition(),requisition.getName()));
			}
			return new ResponseEntity<List<RequisitionTypeDto>>(listRequisitionDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping
	@ResponseBody
    public ResponseEntity<?> registerRequisition(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		
		return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value=URL_REQUISITION_STATUS_GET)
    public ResponseEntity<?> profile(@RequestHeader HttpHeaders headers){
		Iterable<RequisitionStatus> listRequisitionStatus = requisitionStatusService.getAllRequisitionStatus();
		
		return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
	}

}
