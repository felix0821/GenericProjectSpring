package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemDefinition.*;
import static com.system.demo.GenericProjectSystemStatement.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.AcademicProgramRegisterDto;
import com.system.demo.dto.ConfigurationProgramDto;
import com.system.demo.dto.Message;
import com.system.demo.dto.ProgramDetailedDto;
import com.system.demo.dto.ProgramDetailedOccupationalDto;
import com.system.demo.persistence.entity.OccupationalField;
import com.system.demo.persistence.entity.Program;
import com.system.demo.service.OccupationalFieldService;
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
	
	@Autowired
	OccupationalFieldService occupationalFieldService;
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value=URL_CONFIGURATION_PROGRAM_GET)
	public ResponseEntity<?> academicPeriodForm(@PathVariable(name ="id")Long id) {
		Iterable<Program> programs = programService.getAllPrograms();
		List<ConfigurationProgramDto> configurationProgramsDto = new ArrayList<>();
		for(Program program: programs) {
			configurationProgramsDto.add(new ConfigurationProgramDto(program.getProgramId(), program.getProgramIdentifier(), 
					program.getProgramIndex(), program.getProgramName(), program.getProgramAcronym(), "", program.getProgramState()));
		}
		return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked"})
	@PostMapping(value=URL_CONFIGURATION_PROGRAMxREGISTER_POST)
    public ResponseEntity<?> programRegister(@Valid @RequestBody AcademicProgramRegisterDto programRegister, BindingResult bindingResult){
		try {
			//Realizamos las validaciones pertinentes
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	        Long idProgram = uI.getUniqId();
	        String identifier = uI.getIdentifier(Arrays.asList(programRegister.getName()));
	        Program program = new Program(idProgram, SYSTEM_INDEX, identifier, programRegister.getName(), programRegister.getAcronym(),
	        		programRegister.getArea(), SYSTEM_STATE_ACTIVE);
	        program.setProgramDescription(programRegister.getDescription());
	        if(programRegister.getImage()!=null) program.setProgramImage(programRegister.getImage());
	        try {
				programService.createProgram(program);
				return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_PROGRAM), HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(new Message(SYSTEM_ERROR_REGISTER_PROGRAM), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value=URL_CONFIGURATION_PROGRAMxEDIT_GET)
	public ResponseEntity<?> academicProgramForm(@RequestParam(name ="id")Long id){
		//	Buscamos programa por id
		Program programEdit = null;
		try {
			programEdit = programService.getProgramById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		ConfigurationProgramDto result = new ConfigurationProgramDto(programEdit.getProgramId(), programEdit.getProgramIdentifier(), 
				programEdit.getProgramIndex(), programEdit.getProgramName(), programEdit.getProgramAcronym(), programEdit.getProgramDescription(), 
				programEdit.getProgramState());
		return new ResponseEntity<ConfigurationProgramDto>(result, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(URL_CONFIGURATION_PROGRAMxEDIT_POST)
	public ResponseEntity<?> academicProgramEdit(@Valid @RequestBody ConfigurationProgramDto programEditDto, BindingResult bindingResult) {
		//	Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        //	Buscamos programa por id
        Program programEdit = null;
		try {
			programEdit = programService.getProgramById(programEditDto.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		programEdit.setProgramName(programEditDto.getName());
		programEdit.setProgramAcronym(programEditDto.getAcronym());
		programEdit.setProgramDescription(programEditDto.getDescription());
		programEdit.setProgramState(programEditDto.getState());
		try {
			programService.updateProgram(programEdit);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_PROGRAM), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_EDIT_PROGRAM), HttpStatus.CREATED);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_CONFIGURATION_PROGRAMxDELETE_GET)
	public ResponseEntity<?> programDelete(@RequestParam(name="id")Long id) {
		try {
			programService.deleteProgram(id);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_DELETE_PROGRAM), HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_CONFIGURATION_PROGRAM_VIEW_GET)
	public ResponseEntity<?> programView(@PathVariable(name ="program")String identifier) {
		//		Buscamos programa por id
		Program programEdit = null;
		try {
			programEdit = programService.getProgramByIdentifier(identifier).get();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		ProgramDetailedDto result = new ProgramDetailedDto(programEdit.getProgramId(), programEdit.getProgramName(), 
				programEdit.getProgramAcronym(), programEdit.getProgramDescription(), programEdit.getProgramRequirement(), 
				programEdit.getProgramCurriculum(), programEdit.getProgramImage(), programEdit.getProgramArea(), programEdit.getProgramState());
		List<ProgramDetailedOccupationalDto> occupationalsDto = new ArrayList<>();
		List<OccupationalField> occupationals = occupationalFieldService.getOccupationalFieldByProgramId(programEdit.getProgramId());
		for(OccupationalField occupational: occupationals) {
			occupationalsDto.add(new ProgramDetailedOccupationalDto(occupational.getOccupationalFieldId(),
					occupational.getOccupationalFieldIndex(), occupational.getOccupationalFieldName(), occupational.getOccupationalFieldState()));
		}
		result.setOccupationals(occupationalsDto);
		return new ResponseEntity<ProgramDetailedDto>(result, HttpStatus.OK);
	}

}
