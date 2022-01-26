package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemStatement.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.AcademicPedagogicalPeriodRegisterDto;
import com.system.demo.dto.AcademicProgramDto;
import com.system.demo.dto.AcademicProgramRegisterDto;
import com.system.demo.dto.Message;
import com.system.demo.dto.ProgramDetailedDto;
import com.system.demo.dto.ProgramDetailedOccupationalDto;
import com.system.demo.dto.ProgramOccupationalRegisterDto;
import com.system.demo.model.OccupationalField;
import com.system.demo.model.Program;
import com.system.demo.service.OccupationalFieldService;
import com.system.demo.service.PedagogicalPeriodService;
import com.system.demo.service.ProgramService;
import com.system.demo.utility.UniqId;

@RestController
@RequestMapping(value=URL_ACADEMIC_REQUEST)
@CrossOrigin(origins = "*")
public class AcademicController {
	private int index = 1;
	
	@Autowired
	UniqId uI;
	
	@Autowired
	ProgramService programService;
	
	@Autowired
	OccupationalFieldService occupationalFieldService;
	
	@Autowired
	PedagogicalPeriodService pedagogicalPeriodService;
	
	/*
	 * GESTION DE PROGRAMAS
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> academicManagement(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		try {
			Iterable<Program> programs = programService.getAllPrograms();
			List<AcademicProgramDto> academicProgramDto = new ArrayList<>();
			for(Program program:programs) {
				academicProgramDto.add(new AcademicProgramDto(program.getProgramId(),program.getProgramIndex(),
						program.getProgramName(),program.getProgramAcronym(),program.getProgramState()));
			}
			return new ResponseEntity<List<AcademicProgramDto>>(academicProgramDto, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value=URL_ACADEMIC_EDITxPROGRAM_GET)
	public ResponseEntity<?> academicProgramForm(@PathVariable(name ="id")Long id){
		//	Buscamos programa por id
		Program programEdit = null;
		try {
			programEdit = programService.getProgramById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		AcademicProgramDto result = new AcademicProgramDto(programEdit.getProgramId(), programEdit.getProgramIndex(),
				programEdit.getProgramName(), programEdit.getProgramAcronym(), programEdit.getProgramDescription(), programEdit.getProgramState());
		return new ResponseEntity<AcademicProgramDto>(result, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(URL_ACADEMIC_EDITxPROGRAM_POST)
	public ResponseEntity<?> academicProgramEdit(@Valid @RequestBody AcademicProgramDto programEditDto, BindingResult bindingResult) {
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
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_PROGRAM), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_EDIT_PROGRAM), HttpStatus.CREATED);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value=URL_ACADEMIC_PROGRAM_REGISTER_POST)
    public ResponseEntity<?> programRegister(@Valid @RequestBody AcademicProgramRegisterDto programRegister, BindingResult bindingResult){
		try {
			//Realizamos las validaciones pertinentes
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	        Long idProgram = uI.uniqid();
	        int index = this.index;
	        this.index++;
	        char state = 'A';
	        Program program = new Program(idProgram,index,programRegister.getName(),programRegister.getAcronym(),
	        		programRegister.getDescription(), programRegister.getArea(), state);
	        if(programRegister.getImage()!=null) program.setProgramImage(programRegister.getImage());
	        try {
				programService.createProgram(program);
				return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_PROGRAM), HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(new Message(SYSTEM_ERROR_REGISTER), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value=URL_ACADEMIC_PROGRAM_VIEW_GET)
	public ResponseEntity<?> programView(@PathVariable(name ="id")Long id) {
		//		Buscamos programa por id
		Program programEdit = null;
		try {
			programEdit = programService.getProgramById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		ProgramDetailedDto result = new ProgramDetailedDto(programEdit.getProgramId(), programEdit.getProgramName(), 
				programEdit.getProgramAcronym(), programEdit.getProgramDescription(), programEdit.getProgramRequirement(), 
				programEdit.getProgramCurriculum(), programEdit.getProgramImage(), programEdit.getProgramArea(), programEdit.getProgramState());
		List<ProgramDetailedOccupationalDto> occupationalsDto = new ArrayList<>();
		for(OccupationalField occupational:occupationalFieldService.getOccupationalFieldByProgramId(id)) {
			occupationalsDto.add(new ProgramDetailedOccupationalDto(occupational.getOccupationalFieldId(),
					occupational.getOccupationalFieldIndex(), occupational.getOccupationalFieldName(), occupational.getOccupationalFieldState()));
		}
		result.setOccupationals(occupationalsDto);
		return new ResponseEntity<ProgramDetailedDto>(result, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(URL_ACADEMIC_PROGRAM_EDIT_POST)
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
	@GetMapping(URL_ACADEMIC_PROGRAM_DELETE_GET)
	public ResponseEntity<?> programDelete(@PathVariable(name="id")Long id) {
		try {
			programService.deleteProgram(id);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_DELETE_PROGRAM), HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value=URL_ACADEMIC_PROGRAMxOCCUPATIONAL_REGISTER_POST)
    public ResponseEntity<?> programOccupationalRegister(@Valid @RequestBody ProgramOccupationalRegisterDto programOccupationalRegister, BindingResult bindingResult) {
		try {
			//Realizamos las validaciones pertinentes
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	        Long idOccupationalField = uI.uniqid();
	        int index = this.index;
	        this.index++;
	        char state = 'A';
	        Program programId = programService.getProgramById(programOccupationalRegister.getIdProgram());
	        OccupationalField occupationalField = new OccupationalField(idOccupationalField, index, programOccupationalRegister.getName(), 
	        		state);
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
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value=URL_ACADEMIC_PEDAGOGICALxPERIOD_REGISTER_POST)
    public ResponseEntity<?> pedagogicalPeriodRegister(@Valid @RequestBody AcademicPedagogicalPeriodRegisterDto periodRegister, BindingResult bindingResult){
		try {
			//Realizamos las validaciones pertinentes
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	        System.out.println("---------> "+periodRegister.isBlockRegistration());
	        System.out.println("---------> "+periodRegister.getPayEnrollmet());
	        /*Long idProgram = uI.uniqid();
	        int index = this.index;
	        this.index++;
	        char state = 'A';
	        Program program = new Program(idProgram,index,programRegister.getName(),programRegister.getAcronym(),
	        		programRegister.getDescription(), state, programRegister.getArea());
	        if(programRegister.getImage()!=null) program.setProgramImage(programRegister.getImage());
	        try {
				programService.createProgram(program);
				return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_PROGRAM), HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(new Message(SYSTEM_ERROR_REGISTER), HttpStatus.BAD_REQUEST);
			}*/
	        return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_PROGRAM), HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}

}
