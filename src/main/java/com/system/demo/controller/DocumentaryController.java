package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemStatement.*;

import java.util.ArrayList;
import java.util.List;

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

import com.system.demo.dto.DocumentaryListDetailDto;
import com.system.demo.dto.DocumentaryListDto;
import com.system.demo.dto.Message;
import com.system.demo.model.RequisitionDetail;
import com.system.demo.model.RequisitionStatus;
import com.system.demo.service.RequisitionStatusService;

@RestController
@RequestMapping(value=URL_DOCUMENTARY_REQUEST)
@CrossOrigin(origins = "*")
public class DocumentaryController {
	
	@Autowired
	RequisitionStatusService requisitionStatusService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> profile(@RequestHeader HttpHeaders headers){
		try {
			Iterable<RequisitionStatus> listRequisitionStatus = requisitionStatusService.getAllRequisitionStatus();
			List<DocumentaryListDto> documentaryListDto = new ArrayList<>();
			for (RequisitionStatus reqStatus : listRequisitionStatus) {
				DocumentaryListDto docDto = new DocumentaryListDto(reqStatus.getName(),reqStatus.getDescription());
				List<DocumentaryListDetailDto> docDetailDto = new ArrayList<>();
				for (RequisitionDetail reqDetail : reqStatus.getRequisitionDetailCollection()) {
					docDetailDto.add(new DocumentaryListDetailDto(reqDetail.getRequisition().getIdRequisition(),
							reqDetail.getPerson().getUsername(),reqDetail.getRequisition().getName(), reqDetail.getObservation()));
				}
				docDto.setDocumentaries(docDetailDto);
				documentaryListDto.add(docDto);
			}
			return new ResponseEntity<List<DocumentaryListDto>>(documentaryListDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
		}
	}

}
