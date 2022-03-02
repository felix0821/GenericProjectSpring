package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemDefinition.*;
import static com.system.demo.GenericProjectSystemStatement.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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

import com.system.demo.dto.generic.HeaderDataDto;
import com.system.demo.dto.generic.Message;
import com.system.demo.dto.specific.EnrollmentAreaProgramDto;
import com.system.demo.dto.specific.EnrollmentProgramDto;
import com.system.demo.persistence.entity.Period;
import com.system.demo.persistence.entity.Program;
import com.system.demo.persistence.entity.ProgramPeriod;
import com.system.demo.service.PeriodService;
import com.system.demo.service.ProgramPeriodService;
import com.system.demo.service.ProgramService;

@RestController
@RequestMapping(value=URL_ENROLLMENT_REQUEST)
@CrossOrigin(origins = "*")
public class EnrollmentController {
	
	@Autowired
	ProgramService programService;
	@Autowired
	PeriodService periodService;
	@Autowired
	ProgramPeriodService programPeriodService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> getList(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		try {
			LocalDate fechaPeru=LocalDate.now(ZoneId.of(ZONE_DATE_LIMA));
			Date dateCurrent=Date.from(fechaPeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			Iterable<Period> periods = periodService.getAllPeriodByProgramPeriodEnrollmentAvailable(dateCurrent);
			List<HeaderDataDto> response = new ArrayList<>();
			for(Period period: periods) {
				String modality = period.getModalityId().getModalityName();
				String namePeriod = period.getPeriodName()+" "+modality+" "+period.getPeriodYear();
				HeaderDataDto headerData = new HeaderDataDto<EnrollmentAreaProgramDto>(period.getPeriodId().toString(), namePeriod);
				// Agregar programas disponibles
				Iterable<ProgramPeriod> programsPeriod = programPeriodService.getAllProgramPeriodByProgramIdAndEnrollmentAvailable(period.getPeriodId(), dateCurrent);
				EnrollmentAreaProgramDto administrativeArea = new EnrollmentAreaProgramDto("Área Administrativa");
				EnrollmentAreaProgramDto technicalArea = new EnrollmentAreaProgramDto("Área Técnica");
				for(ProgramPeriod programPeriod: programsPeriod) {
					Program program = programPeriod.getProgram();
					EnrollmentProgramDto enrollmentProgramDto = new EnrollmentProgramDto(program.getProgramId(), programPeriod.getProgramPeriodIndex(),
							false, 0, programPeriod.getProgramPeriodPayEnrollment(), programPeriod.getProgramPeriodPayPension(), program.getProgramName(), 
							program.getProgramImage(), programPeriod.getRequisitionId().getRequisitionId());
					if(program.getProgramArea() == 'A') administrativeArea.setProgram(enrollmentProgramDto);
					else technicalArea.setProgram(enrollmentProgramDto);
				}
				headerData.setItemList(administrativeArea);
				headerData.setItemList(technicalArea);
				response.add(headerData);
			}
			return new ResponseEntity<List<HeaderDataDto>>(response, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	//Eliminar y colocar tabla
	private String getModality(Character modality) {
		String result = null;
		if(modality=='V') {
			result = "Virtual";
		} else {
			result = "presencial";
		}
		return result;
	}

}
