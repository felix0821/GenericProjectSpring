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

import com.system.demo.dto.AcademicProgramListDto;
import com.system.demo.dto.Message;
import com.system.demo.model.Program;
import com.system.demo.service.ProgramService;

@RestController
@RequestMapping(value=URL_ACADEMIC_REQUEST)
@CrossOrigin(origins = "*")
public class AcademicController {
	
	@Autowired
	ProgramService programService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
	 public ResponseEntity<?> list(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		try {
			Iterable<Program> programs = programService.getAllPrograms();
			List<AcademicProgramListDto> academicProgramListDto = new ArrayList<>();
			for(Program program:programs) {
				academicProgramListDto.add(new AcademicProgramListDto(program.getProgramId(),program.getProgramIndex(),
						program.getProgramName(),program.getProgramState()));
			}
			
			return new ResponseEntity<List<AcademicProgramListDto>>(academicProgramListDto, HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
		}
		
	}

}
