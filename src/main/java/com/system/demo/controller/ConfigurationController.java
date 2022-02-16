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

import com.system.demo.dto.generic.Message;
import com.system.demo.dto.specific.ConfigurationProgramDto;
import com.system.demo.dto.specific.ConfigurationProgramRegisterDto;
import com.system.demo.dto.specific.ProgramDetailedDto;
import com.system.demo.dto.specific.ProgramDetailedOccupationalDto;
import com.system.demo.dto.specific.ProgramOccupationalRegisterDto;
import com.system.demo.persistence.entity.OccupationalField;
import com.system.demo.persistence.entity.Program;
import com.system.demo.service.ModulusService;
import com.system.demo.service.OccupationalFieldService;
import com.system.demo.service.ProgramService;
import com.system.demo.utility.PreferenceUtility;
import com.system.demo.utility.UniqIdUtility;

@RestController
@RequestMapping(value=URL_CONFIGURATION_REQUEST)
@CrossOrigin(origins = "*")
public class ConfigurationController {
	
	@Autowired
	UniqIdUtility uniqueId;
	@Autowired
	PreferenceUtility preference;
	
	@Autowired
	ProgramService programService;
	@Autowired
	OccupationalFieldService occupationalFieldService;
	@Autowired
	ModulusService modulusService;
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value=URL_CONFIGURATION_PROGRAM_GET)
	public ResponseEntity<?> academicPeriodForm() {
		try {
			Iterable<Program> programs = programService.getAllPrograms();
			List<ConfigurationProgramDto> configurationProgramsDto = new ArrayList<>();
			for(Program program: programs) {
				configurationProgramsDto.add(new ConfigurationProgramDto(program.getProgramId(), program.getProgramIdentifier(), 
						program.getProgramIndex(), program.getProgramName(), program.getProgramAcronym(), "", program.getProgramState()));
			}
			return new ResponseEntity<List<ConfigurationProgramDto>>(configurationProgramsDto, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked"})
	@PostMapping(value=URL_CONFIGURATION_PROGRAMxREGISTER_POST)
    public ResponseEntity<?> programRegister(@Valid @RequestBody ConfigurationProgramRegisterDto programRegister, BindingResult bindingResult){
		try {
//			°Realizar validaciones
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
//			°Generar valores
	        Long idProgram = uniqueId.getUniqId();
	        String identifierProgram = uniqueId.getIdentifier(Arrays.asList(programRegister.getName()));
	        Integer indexProgram = preference.getIndex(INDEX_PROGRAM);
//			°Generar entidad
	        Program program = new Program(idProgram, indexProgram, identifierProgram, programRegister.getName(), programRegister.getAcronym(),
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
		String identifier = uniqueId.getIdentifier(Arrays.asList(programEditDto.getName()));
		programEdit.setProgramIdentifier(identifier);
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
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_EDIT_PROGRAM), HttpStatus.OK);
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
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value = URL_CONFIGURATION_PROGRAM_EDIT_POST)
	public ResponseEntity<?> programEdit(@Valid @RequestBody ProgramDetailedDto programEditDto, BindingResult bindingResult) {
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
		programEdit.setProgramRequirement(programEditDto.getRequirement());
		programEdit.setProgramCurriculum(programEditDto.getCurriculum());
		programEdit.setProgramImage(programEditDto.getImage());
		programEdit.setProgramArea(programEditDto.getArea());
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
	@PostMapping(value = URL_CONFIGURATION_PROGRAM_OCCUPATIONALxREGISTER_POST)
    public ResponseEntity<?> programOccupationalRegister(@Valid @RequestBody ProgramOccupationalRegisterDto programOccupationalRegister, BindingResult bindingResult) {
		try {
//			°Realizar validaciones
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
//	    	°Generar valores
	        Long idOccupationalField = uniqueId.getUniqId();
	        Integer indexOccupationalField = preference.getIndex(INDEX_OCCUPATIONAL_FIELD);
	        Character stateOccupationalField = SYSTEM_STATE_ACTIVE;
//	    	°Generar entidad
	        Program programId = programService.getProgramById(programOccupationalRegister.getIdProgram());
	        OccupationalField occupationalField = new OccupationalField(idOccupationalField, indexOccupationalField, 
	        		programOccupationalRegister.getName(), stateOccupationalField);
	        occupationalField.setProgramId(programId);
	        try {
	        	occupationalFieldService.createOccupationalField(occupationalField);
				return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_PROGRAM), HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(new Message(SYSTEM_ERROR_REGISTER), HttpStatus.BAD_REQUEST);
			}
		} catch(Exception e) {
			System.out.println(e);
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}

}
