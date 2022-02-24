package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemStatement.*;
import static com.system.demo.GenericProjectSystemDefinition.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.generic.Message;
import com.system.demo.dto.specific.FinancialMovementHeaderDto;
import com.system.demo.dto.specific.FinancialMovementListDto;
import com.system.demo.dto.specific.FinancialMovementRangeDto;
import com.system.demo.persistence.entity.FinancialMovementDetail;
import com.system.demo.persistence.entity.FinancialMovementRequisition;
import com.system.demo.persistence.entity.RequisitionDataDetail;
import com.system.demo.persistence.entity.RequisitionDataDetailPK;
import com.system.demo.persistence.repository.FinancialMovementRequisitionRepository;
import com.system.demo.persistence.repository.RequisitionDataDetailRepository;
import com.system.demo.service.FinancialMovementDetailService;
import com.system.demo.service.FinancialMovementRequisitionService;
import com.system.demo.service.FinancialMovementService;

@RestController
@RequestMapping(value=URL_FINANCIAL_MOVEMENT_REQUEST)
@CrossOrigin(origins = "*")
public class FinancialMovementController {
	
	@Autowired
	FinancialMovementService financialMovementService;
	
	@Autowired
	FinancialMovementDetailService financialMovementDetailService;
	@Autowired
	FinancialMovementRequisitionRepository financialMovementRequisitionService;
	@Autowired
	RequisitionDataDetailRepository requisitionDataDetailRepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> getList(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		try {
			Iterable<FinancialMovementDetail> financialMovDetailList = financialMovementDetailService.getAllFinancialMovementDetail();
			List<FinancialMovementListDto> financialMovDetailListDto = new ArrayList<>();
			for (FinancialMovementDetail fMovDetail : financialMovDetailList) {
				long idFmovDetail = fMovDetail.getFinancialMovementDetailId();
				Iterable<FinancialMovementRequisition> fMovReq = financialMovementRequisitionService.findByFinancialMovementDetailId(idFmovDetail);
				FinancialMovementRequisition fmov= null;
				for(FinancialMovementRequisition f:fMovReq) {
					fmov=f;
				}
				RequisitionDataDetailPK id = new RequisitionDataDetailPK(1L,10006L,fmov.getRequisitionDetail().getRequisitionDetailId());
				Optional<RequisitionDataDetail> reqDataDet = requisitionDataDetailRepository.findById(id);
				FinancialMovementListDto rec = new FinancialMovementListDto(fMovDetail.getFinancialMovementDetailId(), fMovDetail.getFinancialMovementDetailDate(),
						fMovDetail.getFinancialMovementId().getFinancialMovementName(), fMovDetail.getFinancialMovementId().getFinancialMovementSymbol(),
						fMovDetail.getFinancialMovementDetailAmount(),"Registro por solicitud", 0, 
						reqDataDet.get().getRequisitionDataDetailValue()); //Eliminar numero de operaciones
				financialMovDetailListDto.add(rec);
			}
			return new ResponseEntity<List<FinancialMovementListDto>>(financialMovDetailListDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//Restringir rango de fechas*
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping
	@ResponseBody
    public ResponseEntity<?> postList(@Valid @RequestBody FinancialMovementRangeDto finMovRangeDto, HttpServletRequest request){
		try {
			Iterable<FinancialMovementDetail> financialMovDetailList = financialMovementDetailService.getAllFinancialMovementDetailByDateRange(finMovRangeDto.getStartDate(), finMovRangeDto.getEndDate());
			double income = financialMovementDetailService.getSumAmountTypeByDateRange(finMovRangeDto.getStartDate(), finMovRangeDto.getEndDate(), SYSTEM_FINANTIAL_MOVEMENT_TYPE_INCOME);
			double egress = financialMovementDetailService.getSumAmountTypeByDateRange(finMovRangeDto.getStartDate(), finMovRangeDto.getEndDate(), SYSTEM_FINANTIAL_MOVEMENT_TYPE_EGRESS);
			FinancialMovementHeaderDto result = new FinancialMovementHeaderDto(income, egress, (income-egress));
			List<FinancialMovementListDto> financialMovDetailListDto = new ArrayList<>();
			for (FinancialMovementDetail fMovDetail : financialMovDetailList) {
				long idFmovDetail = fMovDetail.getFinancialMovementDetailId();
				Iterable<FinancialMovementRequisition> fMovReq = financialMovementRequisitionService.findByFinancialMovementDetailId(idFmovDetail);
				FinancialMovementRequisition fmov= null;
				for(FinancialMovementRequisition f:fMovReq) {
					fmov=f;
				}
				RequisitionDataDetailPK id = new RequisitionDataDetailPK(1L,10006L,fmov.getRequisitionDetail().getRequisitionDetailId());
				Optional<RequisitionDataDetail> reqDataDet = requisitionDataDetailRepository.findById(id);
				FinancialMovementListDto rec = new FinancialMovementListDto(fMovDetail.getFinancialMovementDetailId(), fMovDetail.getFinancialMovementDetailDate(),
						fMovDetail.getFinancialMovementId().getFinancialMovementName(), fMovDetail.getFinancialMovementId().getFinancialMovementSymbol(),
						fMovDetail.getFinancialMovementDetailAmount(),"Registro por solicitud", 0, 
						reqDataDet.get().getRequisitionDataDetailValue()); //Eliminar numero de operaciones
				financialMovDetailListDto.add(rec);
			}
			result.setList(financialMovDetailListDto);
			return new ResponseEntity<FinancialMovementHeaderDto>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
}
