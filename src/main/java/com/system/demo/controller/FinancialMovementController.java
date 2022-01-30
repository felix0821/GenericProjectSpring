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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.FinancialMovementListDto;
import com.system.demo.dto.Message;
import com.system.demo.persistence.entity.FinancialMovementDetail;
import com.system.demo.persistence.entity.FinancialMovementRequisition;
import com.system.demo.service.FinancialMovementDetailService;
import com.system.demo.service.FinancialMovementService;

@RestController
@RequestMapping(value=URL_FINANCIAL_MOVEMENT_REQUEST)
@CrossOrigin(origins = "*")
public class FinancialMovementController {
	
	@Autowired
	FinancialMovementService financialMovementService;
	
	@Autowired
	FinancialMovementDetailService financialMovementDetailService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> list(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		try {
			Iterable<FinancialMovementDetail> financialMovDetailList = financialMovementDetailService.getAllFinancialMovementDetail();
			List<FinancialMovementListDto> financialMovDetailListDto = new ArrayList<>();
			for (FinancialMovementDetail fMovDetail : financialMovDetailList) {
				financialMovDetailListDto.add(new FinancialMovementListDto(fMovDetail.getFinancialMovementDetailId(),
						fMovDetail.getFinancialMovementId().getFinancialMovementName(), fMovDetail.getFinancialMovementId().getFinancialMovementSymbol(),
						fMovDetail.getFinancialMovementDetailAmount(),"Registro por solicitud", fMovDetail.getFinancialMovementDetailOperationNumber()));
			}
			return new ResponseEntity<List<FinancialMovementListDto>>(financialMovDetailListDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
		}
		
	}
}
