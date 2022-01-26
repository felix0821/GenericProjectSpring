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

import com.system.demo.dto.AcademicProgramDto;
import com.system.demo.dto.AcademicProgramRegisterDto;
import com.system.demo.dto.Message;
import com.system.demo.model.Program;
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
	
	/*
	 * GESTION DE PROGRAMAS
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
	 public ResponseEntity<?> list(@RequestHeader HttpHeaders headers, HttpServletRequest request){
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
	public ResponseEntity<?> viewProgram(@PathVariable(name ="id")Long id){
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
	public ResponseEntity<?> editData(@Valid @RequestBody AcademicProgramDto programEdit, BindingResult bindingResult) {
		//Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_EDIT_PROGRAM), HttpStatus.CREATED);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value=URL_ACADEMIC_PROGRAM_REGISTER_POST)
    public ResponseEntity<?> save(@Valid @RequestBody AcademicProgramRegisterDto programRegister, BindingResult bindingResult){
		try {
			//Realizamos las validaciones pertinentes
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	        Long idProgram = uI.uniqid();
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
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
