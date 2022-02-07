package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemDefinition.SYSTEM_ERROR;
import static com.system.demo.GenericProjectSystemStatement.URL_ACADEMIC_CYCLExEDIT_GET;
import static com.system.demo.GenericProjectSystemStatement.URL_PERSON_REQUEST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.ConfigurationProgramDto;
import com.system.demo.dto.Message;
import com.system.demo.persistence.entity.Program;
import com.system.demo.service.ProgramService;
import com.system.demo.utility.UniqId;

@RestController
@RequestMapping(value=URL_PERSON_REQUEST)
@CrossOrigin(origins = "*")
public class ConfigurationController {
	
	@Autowired
	UniqId uI;
	
	@Autowired
	ProgramService programService;
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value=URL_ACADEMIC_CYCLExEDIT_GET)
	public ResponseEntity<?> academicPeriodForm(@PathVariable(name ="id")Long id) {
		Iterable<Program> programs = programService.getAllPrograms();
		List<ConfigurationProgramDto> configurationProgramsDto = new ArrayList<>();
		for(Program program: programs) {
			configurationProgramsDto.add(new ConfigurationProgramDto(program.getProgramId(), program.getProgramIndex(), 
					program.getProgramName(), program.getProgramAcronym(), program.getProgramState()));
		}
		return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
	}

}
