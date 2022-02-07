package com.system.demo.controller;

import static com.system.demo.GenericProjectSystemStatement.*;
import static com.system.demo.GenericProjectSystemDefinition.*;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.AcademicPeriodDto;
import com.system.demo.dto.AcademicPeriodRegisterDto;
import com.system.demo.dto.ConfigurationProgramDto;
import com.system.demo.dto.ConfigurationProgramRegisterDto;
import com.system.demo.dto.CourseDetailListDto;
import com.system.demo.dto.HeaderDataDto;
import com.system.demo.dto.Message;
import com.system.demo.dto.ProgramDetailedDto;
import com.system.demo.dto.ProgramDetailedOccupationalDto;
import com.system.demo.dto.ProgramOccupationalRegisterDto;
import com.system.demo.dto.ProgramPeriodDto;
import com.system.demo.dto.ProgramPeriodEnrollmentDto;
import com.system.demo.dto.ProgramPeriodHeaderDto;
import com.system.demo.persistence.entity.Course;
import com.system.demo.persistence.entity.CourseDetail;
import com.system.demo.persistence.entity.EnrollmentProgramPeriod;
import com.system.demo.persistence.entity.OccupationalField;
import com.system.demo.persistence.entity.PedagogicalPeriod;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.entity.Program;
import com.system.demo.persistence.entity.ProgramPeriod;
import com.system.demo.persistence.entity.ProgramPeriodPK;
import com.system.demo.service.CourseDetailService;
import com.system.demo.service.EnrollmentProgramPeriodService;
import com.system.demo.service.OccupationalFieldService;
import com.system.demo.service.PedagogicalPeriodService;
import com.system.demo.service.ProgramPeriodService;
import com.system.demo.service.ProgramService;
import com.system.demo.utility.UniqId;

@RestController
@RequestMapping(value=URL_ACADEMIC_REQUEST)
@CrossOrigin(origins = "*")
public class AcademicController {
	
	@Autowired
	UniqId uI;
	
	@Autowired
	ProgramService programService;
	
	@Autowired
	ProgramPeriodService programPeriodService;
	
	@Autowired
	OccupationalFieldService occupationalFieldService;
	
	@Autowired
	PedagogicalPeriodService pedagogicalPeriodService;
	
	@Autowired
	EnrollmentProgramPeriodService enrollmentProgramPeriodService;
	
	@Autowired
	CourseDetailService courseDetailService;
	
	/*
	 * ENLACE PRINCIPAL - GESTION ACADEMICA
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> academicManagement(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		try {
			Iterable<PedagogicalPeriod> pedagogicalPeriods = pedagogicalPeriodService.getAllPedagogicalPeriods();
			List<AcademicPeriodDto> academicPedPeriodDto = new ArrayList<>();
			for(PedagogicalPeriod pedPeriod:pedagogicalPeriods) {
				academicPedPeriodDto.add(new AcademicPeriodDto(pedPeriod.getPedagogicalPeriodId(), pedPeriod.getPedagogicalPeriodIdentifier(), 
						pedPeriod.getPedagogicalPeriodYear(), pedPeriod.getPedagogicalPeriodName(), "",
						pedPeriod.getPedagogicalPeriodModality(), pedPeriod.getPedagogicalPeriodState()));
			}
			return new ResponseEntity<List<AcademicPeriodDto>>(academicPedPeriodDto, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value=URL_ACADEMIC_CYCLExEDIT_GET)
	public ResponseEntity<?> academicPeriodForm(@RequestParam(name ="id")Long id){
		//	Buscamos programa por id
		PedagogicalPeriod periodEdit = null;
		try {
			periodEdit = pedagogicalPeriodService.getPedagogicalPeriodById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		AcademicPeriodDto resultDto = new AcademicPeriodDto(periodEdit.getPedagogicalPeriodId(), periodEdit.getPedagogicalPeriodIdentifier(), 
				periodEdit.getPedagogicalPeriodYear(), periodEdit.getPedagogicalPeriodName(), periodEdit.getPedagogicalPeriodDescription(), 
				periodEdit.getPedagogicalPeriodModality(), periodEdit.getPedagogicalPeriodState());
		return new ResponseEntity<AcademicPeriodDto>(resultDto, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(URL_ACADEMIC_CYCLExEDIT_POST)
	public ResponseEntity<?> academicPeriodEdit(@Valid @RequestBody AcademicPeriodDto periodEditDto, BindingResult bindingResult) {
		//	Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        //	Buscamos programa por id
        PedagogicalPeriod periodEdit = null;
		try {
			periodEdit = pedagogicalPeriodService.getPedagogicalPeriodById(periodEditDto.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		periodEdit.setPedagogicalPeriodName(periodEditDto.getName());
		periodEdit.setPedagogicalPeriodYear(periodEditDto.getYear());
		periodEdit.setPedagogicalPeriodDescription(periodEditDto.getDescription());
		periodEdit.setPedagogicalPeriodModality(periodEditDto.getModality());
		periodEdit.setPedagogicalPeriodState(periodEditDto.getState());
		try {
			pedagogicalPeriodService.updatePedagogicalPeriod(periodEdit);
		} catch(Exception e) {
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_PERIOD), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_EDIT_PERIOD), HttpStatus.CREATED);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_ACADEMIC_CYCLExDELETE_GET)
	public ResponseEntity<?> periodDelete(@RequestParam(name="id")Long id) {
		try {
			pedagogicalPeriodService.deletePedagogicalPeriod(id);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_DELETE_PERIOD), HttpStatus.OK);
	}
	
	
	//-------------------------------------------------------
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value = URL_ACADEMIC_PROGRAM_EDIT_POST)
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
	@PostMapping(value = URL_ACADEMIC_PROGRAMxOCCUPATIONAL_REGISTER_POST)
    public ResponseEntity<?> programOccupationalRegister(@Valid @RequestBody ProgramOccupationalRegisterDto programOccupationalRegister, BindingResult bindingResult) {
		try {
			//Realizamos las validaciones pertinentes
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	        Long idOccupationalField = uI.getUniqId();
	        char state = 'A';
	        Integer index = null;
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
	@GetMapping(value = URL_ACADEMIC_PROGRAMxPERIODS_GET)
	public ResponseEntity<?> academicProgramPeriods(@PathVariable(name ="idProgram")Long id){
		//	Buscamos programa por id
		Program program = null;
		try {
			program = programService.getProgramById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		ProgramPeriodHeaderDto progPeriodHeaderDto = new ProgramPeriodHeaderDto(program.getProgramName());
		List<ProgramPeriodDto> progPeriodDtoList = new ArrayList<>();
		List<ProgramPeriod> progPeriods = programPeriodService.getProgramPeriodByProgramId(id);
		for(ProgramPeriod progPeriod:progPeriods) {
			progPeriodDtoList.add(new ProgramPeriodDto(progPeriod.getProgram().getProgramIdentifier(), progPeriod.getProgramPeriodIndex(), 
					progPeriod.getProgram().getProgramName(), progPeriod.getProgramPeriodOpening(), progPeriod.getProgramPeriodClosing(), 
					progPeriod.getProgramPeriodState()));
		}
		progPeriodHeaderDto.setProgramPeriods(progPeriodDtoList);
		return new ResponseEntity<ProgramPeriodHeaderDto>(progPeriodHeaderDto, HttpStatus.OK);
	}
	
	/*
	 * ENLACE - GESTION DE PERIODOS PEDAGÓGICOS
	 */
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value = URL_ACADEMIC_CYCLExREGISTER_POST)
    public ResponseEntity<?> pedagogicalPeriodRegister(@Valid @RequestBody AcademicPeriodRegisterDto periodRegister, BindingResult bindingResult){
		try {
			//Realizamos las validaciones pertinentes
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	        Long idPedPeriod = uI.getUniqId();
	        String identifier = uI.getIdentifier(Arrays.asList(periodRegister.getName(), 
	        		periodRegister.getModality().toString(), Integer.toString(periodRegister.getYear())));
	        //Construimos modelo de registro
	        PedagogicalPeriod pedagogicalPeriod = new PedagogicalPeriod(idPedPeriod, SYSTEM_INDEX, identifier, periodRegister.getName(),
	        		periodRegister.getYear(), periodRegister.getModality(), SYSTEM_STATE_ACTIVE);
	        PedagogicalPeriod pedPeriod = pedagogicalPeriodService.createPedagogicalPeriod(pedagogicalPeriod);
	        //Realizar registro en bloque
	       if(periodRegister.isBlockRegistration()) {
	    	   	List<Program> programs = programService.getProgramByState(SYSTEM_STATE_ACTIVE);
		        for(Program program:programs) {
		        	//Long idProgPeriod = uI.getUniqId();
		        	ProgramPeriodPK idProgPeriod = new ProgramPeriodPK(program.getProgramId(), pedPeriod.getPedagogicalPeriodId());
		        	ProgramPeriod progPeriod = new ProgramPeriod(idProgPeriod, SYSTEM_INDEX, periodRegister.getPayEnrollmet(), 
		        			periodRegister.getPayPension(), periodRegister.getDateOpening(), periodRegister.getDateClosingEnrollmet(), 
		        			periodRegister.getDateClosing(), SYSTEM_STATE_ACTIVE);
		        	programPeriodService.createProgramPeriod(progPeriod);
		        }
	       }
	        return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_PROGRAM), HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_ACADEMIC_CYCLE_PROGRAMS_GET)
	public ResponseEntity<?> academicProgramsPeriod(@PathVariable(name ="cycle")String identifier){
		//	Buscamos programa por id
		PedagogicalPeriod period = null;
		try {
			period = pedagogicalPeriodService.getPedagogicalPeriodByIdentifier(identifier).get();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		ProgramPeriodHeaderDto progPeriodHeaderDto = new ProgramPeriodHeaderDto(period.getPedagogicalPeriodName());
		List<ProgramPeriodDto> progPeriodDtoList = new ArrayList<>();
		List<ProgramPeriod> progPeriods = programPeriodService.getProgramPeriodByPedagogicalPeriodId(period.getPedagogicalPeriodId());
		for(ProgramPeriod progPeriod:progPeriods) {
			progPeriodDtoList.add(new ProgramPeriodDto(progPeriod.getProgram().getProgramIdentifier(), progPeriod.getProgramPeriodIndex(), 
					progPeriod.getProgram().getProgramName(), progPeriod.getProgramPeriodOpening(), progPeriod.getProgramPeriodClosing(), 
					progPeriod.getProgramPeriodState()));
		}
		progPeriodHeaderDto.setProgramPeriods(progPeriodDtoList);
		return new ResponseEntity<ProgramPeriodHeaderDto>(progPeriodHeaderDto, HttpStatus.OK);
	}
	/*
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_ACADEMIC_CYCLE_PROGRAM_ENROLLED_GET)
	public ResponseEntity<?> academicProgramPeriodView(@PathVariable(name ="program-id")Long id) {
		try {
			List<EnrollmentProgramPeriod> enrollProgList = enrollmentProgramPeriodService.getEnrollmentProgramPeriodByProgramPeriodId(id);
			List<ProgramPeriodEnrollmentDto> progEnrollDto = new ArrayList<>();
			for(EnrollmentProgramPeriod enrollProg:enrollProgList) {
				Person person = enrollProg.getPerson();
				progEnrollDto.add(new ProgramPeriodEnrollmentDto(person.getPersonName(), person.getPersonLastnameFather(),
						person.getPersonLastnameMother(), enrollProg.getPersonProgramPeriodDate()));
			}
			return new ResponseEntity<List<ProgramPeriodEnrollmentDto>>(progEnrollDto, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
	}
	*/
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_ACADEMIC_CYCLE_PROGRAM_COURSE_GET)
	public ResponseEntity<?> getAcademicCycleProgramCourse(@PathVariable(name ="cycle")String cycle, @PathVariable(name ="program")String prog) {
		ProgramPeriod progPeriod = null;
		Program program = null;
		PedagogicalPeriod period = null;
		try {
			program = programService.getProgramByIdentifier(prog).get();
			period = pedagogicalPeriodService.getPedagogicalPeriodByIdentifier(cycle).get();
			progPeriod = programPeriodService.getProgramPeriodById(program.getProgramId(), period.getPedagogicalPeriodId()).get();
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		HeaderDataDto cycleProgramHeaderDto = new HeaderDataDto<CourseDetailListDto>(progPeriod.getProgram().getProgramIdentifier(),
				progPeriod.getProgram().getProgramName());
		List<CourseDetailListDto> courseListDto = new ArrayList<>();
		Iterable<CourseDetail> courseDetailList = courseDetailService.getCourseDetailsByProgramPeriodId(program.getProgramId(), period.getPedagogicalPeriodId());
		for(CourseDetail courseDetail:courseDetailList) {
			Course course = courseDetail.getCourseId();
			courseListDto.add(new CourseDetailListDto(courseDetail.getCourseDetailId(), course.getCourseName(),
					courseDetail.getCourseDetailCapacity(), courseDetail.getCourseDetailState()));
		}
		cycleProgramHeaderDto.setList(courseListDto);
		return new ResponseEntity<HeaderDataDto>(cycleProgramHeaderDto, HttpStatus.OK);
	}

}
