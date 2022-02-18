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

import com.system.demo.dto.generic.DropdownDataDto;
import com.system.demo.dto.generic.HeaderDataDto;
import com.system.demo.dto.generic.Message;
import com.system.demo.dto.specific.AcademicPeriodDto;
import com.system.demo.dto.specific.AcademicPeriodRegisterDto;
import com.system.demo.dto.specific.ConfigurationProgramDto;
import com.system.demo.dto.specific.ConfigurationProgramRegisterDto;
import com.system.demo.dto.specific.CourseDetailListDto;
import com.system.demo.dto.specific.ProgramDetailedDto;
import com.system.demo.dto.specific.ProgramDetailedOccupationalDto;
import com.system.demo.dto.specific.ProgramOccupationalRegisterDto;
import com.system.demo.dto.specific.ProgramPeriodDto;
import com.system.demo.dto.specific.ProgramPeriodEnrollmentDto;
import com.system.demo.dto.specific.ProgramPeriodHeaderDto;
import com.system.demo.dto.specific.ProgramPeriodNewRegisterDto;
import com.system.demo.dto.specific.ProgramPeriodSelectRegisterDto;
import com.system.demo.persistence.entity.Course;
import com.system.demo.persistence.entity.CourseDetail;
import com.system.demo.persistence.entity.EnrollmentProgram;
import com.system.demo.persistence.entity.OccupationalField;
import com.system.demo.persistence.entity.Period;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.entity.Program;
import com.system.demo.persistence.entity.ProgramPeriod;
import com.system.demo.persistence.entity.ProgramPeriodPK;
import com.system.demo.persistence.entity.Role;
import com.system.demo.service.CourseDetailService;
import com.system.demo.service.EnrollmentProgramService;
import com.system.demo.service.OccupationalFieldService;
import com.system.demo.service.PeriodService;
import com.system.demo.service.ProgramPeriodService;
import com.system.demo.service.ProgramService;
import com.system.demo.utility.PreferenceUtility;
import com.system.demo.utility.UniqIdUtility;

@RestController
@RequestMapping(value=URL_ACADEMIC_REQUEST)
@CrossOrigin(origins = "*")
public class AcademicController {
	
	@Autowired
	UniqIdUtility uniqueId;
	@Autowired
	PreferenceUtility preference;
	
	
	@Autowired
	ProgramService programService;
	@Autowired
	ProgramPeriodService programPeriodService;
	@Autowired
	OccupationalFieldService occupationalFieldService;
	@Autowired
	PeriodService periodService;
	@Autowired
	EnrollmentProgramService enrollmentProgramService;
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
			Iterable<Period> periods = periodService.getAllPedagogicalPeriods();
			List<AcademicPeriodDto> academicPedPeriodDto = new ArrayList<>();
			Long count = 0L;
			for(Period pedPeriod:periods) {
				count = programPeriodService.getTotalProgramPeriodByPeriodId(pedPeriod.getPeriodId());
				academicPedPeriodDto.add(new AcademicPeriodDto(pedPeriod.getPeriodId(), pedPeriod.getPeriodIdentifier(), 
						pedPeriod.getPeriodYear(), pedPeriod.getPeriodName(), "", count,
						pedPeriod.getPeriodModality(), pedPeriod.getPeriodState()));
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
		Period periodEdit = null;
		try {
			periodEdit = periodService.getPeriodById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		AcademicPeriodDto resultDto = new AcademicPeriodDto(periodEdit.getPeriodId(), periodEdit.getPeriodIdentifier(), 
				periodEdit.getPeriodYear(), periodEdit.getPeriodName(), periodEdit.getPeriodDescription(), 0L,
				periodEdit.getPeriodModality(), periodEdit.getPeriodState());
		return new ResponseEntity<AcademicPeriodDto>(resultDto, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(URL_ACADEMIC_CYCLExEDIT_POST)
	public ResponseEntity<?> academicPeriodEdit(@Valid @RequestBody AcademicPeriodDto periodEditDto, BindingResult bindingResult) {
		//	Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        //	Buscamos programa por id
        Period periodEdit = null;
		try {
			periodEdit = periodService.getPeriodById(periodEditDto.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		periodEdit.setPeriodName(periodEditDto.getName());
		periodEdit.setPeriodYear(periodEditDto.getYear());
		periodEdit.setPeriodDescription(periodEditDto.getDescription());
		periodEdit.setPeriodModality(periodEditDto.getModality());
		periodEdit.setPeriodState(periodEditDto.getState());
		try {
			periodService.updatePeriod(periodEdit);
		} catch(Exception e) {
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_PERIOD), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_EDIT_PERIOD), HttpStatus.CREATED);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_ACADEMIC_CYCLExDELETE_GET)
	public ResponseEntity<?> periodDelete(@RequestParam(name="id")Long id) {
		try {
			periodService.deletePeriod(id);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_DELETE_PERIOD), HttpStatus.OK);
	}
	
	
	//-------------------------------------------------------
	
	/*
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
	*/
	
	/*
	 * ENLACE - GESTION DE PERIODOS PEDAGÓGICOS
	 */
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value = URL_ACADEMIC_CYCLExREGISTER_POST)
    public ResponseEntity<?> pedagogicalPeriodRegister(@Valid @RequestBody AcademicPeriodRegisterDto periodRegister, BindingResult bindingResult){
		try {
//			°Realizar validaciones
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
//	    	°Generar valores
	        Long idPeriod = uniqueId.getUniqId();
	        String identifierPeriod = uniqueId.getIdentifier(Arrays.asList(periodRegister.getName(), 
	        		periodRegister.getModality().toString(), Integer.toString(periodRegister.getYear())));
	        int indexPeriod = preference.getIndex(INDEX_PERIOD);
//	    	°Generar entidad
	        Period period = new Period(idPeriod, indexPeriod, identifierPeriod, periodRegister.getName(),
	        		periodRegister.getYear(), periodRegister.getModality(), SYSTEM_STATE_ACTIVE);
	        Period pedPeriod = periodService.createPeriod(period);
//	    	°Realizar registro en bloque
	       if(periodRegister.isBlockRegistration()) {
	    	   	List<Program> programs = programService.getProgramByState(SYSTEM_STATE_ACTIVE);
		        for(Program program:programs) {
//			    	°Generar valores
		        	ProgramPeriodPK idProgPeriod = new ProgramPeriodPK(program.getProgramId(), pedPeriod.getPeriodId());
		        	Integer indexProgPeriod = preference.getIndex(INDEX_PROGRAM_PERIOD);
		        	Character stateProgPeriod = SYSTEM_STATE_ACTIVE;
//			    	°Generar entidad
		        	ProgramPeriod progPeriod = new ProgramPeriod(idProgPeriod, indexProgPeriod, periodRegister.getPayEnrollmet(), 
		        			periodRegister.getPayPension(), periodRegister.getDateOpening(), periodRegister.getDateClosingEnrollmet(), 
		        			periodRegister.getDateClosing(), stateProgPeriod);
		        	programPeriodService.createProgramPeriod(progPeriod);
		        }
	       }
//	    	°Retornar mensaje
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
		Period period = null;
		try {
			period = periodService.getPeriodByIdentifier(identifier).get();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		ProgramPeriodHeaderDto progPeriodHeaderDto = new ProgramPeriodHeaderDto(period.getPeriodId(), identifier,period.getPeriodName());
		List<ProgramPeriodDto> progPeriodDtoList = new ArrayList<>();
		List<ProgramPeriod> progPeriods = programPeriodService.getProgramPeriodByPedagogicalPeriodId(period.getPeriodId());
		Long count = 0L;
		for(ProgramPeriod progPeriod:progPeriods) {
			count = 0L;
			progPeriodDtoList.add(new ProgramPeriodDto(progPeriod.getProgram().getProgramId(), progPeriod.getProgram().getProgramIdentifier(), 
					progPeriod.getProgramPeriodIndex(), progPeriod.getProgram().getProgramName(), progPeriod.getProgramPeriodOpening(), 
					progPeriod.getProgramPeriodClosing(), count, progPeriod.getProgramPeriodState()));
		}
		progPeriodHeaderDto.setProgramPeriods(progPeriodDtoList);
		return new ResponseEntity<ProgramPeriodHeaderDto>(progPeriodHeaderDto, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_ACADEMIC_CYCLE_PROGRAMxREGISTER_GET)
	public ResponseEntity<?> personRolesRegisterForm(@PathVariable(name ="cycle")String identifier) {
		try {
			List<DropdownDataDto> programsDto = new ArrayList<>();
			Period period = null;
			try {
				period = periodService.getPeriodByIdentifier(identifier).get();
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
			}
			Iterable<Program> programsNotPeriod = programService.getProgramByNotPedagogicalPeriodId(period.getPeriodId());
			for(Program prorgam: programsNotPeriod) {
				programsDto.add(new DropdownDataDto(prorgam.getProgramId(), prorgam.getProgramName()));
			}
			return new ResponseEntity<List<DropdownDataDto>>(programsDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value = URL_ACADEMIC_CYCLE_PROGRAMxREGISTERxSELECT_POST)
    public ResponseEntity<?> periodProgramRegisterSelect(@Valid @RequestBody ProgramPeriodSelectRegisterDto progPeriodRegister, BindingResult bindingResult){
		try {
//			°Realizar validaciones
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
//			°Generar valores
	        ProgramPeriodPK idProgPeriod = new ProgramPeriodPK(progPeriodRegister.getIdProgram(), progPeriodRegister.getIdPeriod());
	        Integer indexProgPeriod = preference.getIndex(INDEX_PROGRAM_PERIOD);
	        Character stateProgPeriod = SYSTEM_STATE_ACTIVE;
//			°Generar entidad
	        ProgramPeriod programPeriod = new ProgramPeriod(idProgPeriod, indexProgPeriod, progPeriodRegister.getPayEnrollmet(), 
	        		progPeriodRegister.getPayPension(), progPeriodRegister.getDateOpening(), progPeriodRegister.getDateClosingEnrollmet(), 
	        		progPeriodRegister.getDateClosing(), stateProgPeriod);
	        programPeriodService.createProgramPeriod(programPeriod);
//			°Retornar mensaje
	        return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_PROGRAM), HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value = URL_ACADEMIC_CYCLE_PROGRAMxREGISTERxNEW_POST)
    public ResponseEntity<?> periodProgramRegisterNew(@Valid @RequestBody ProgramPeriodNewRegisterDto progPeriodRegister, BindingResult bindingResult){
		try {
//			°Realizar validaciones
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
//			°Generar valores
	        Long idProgram = uniqueId.getUniqId();
	        String identifierProgram = uniqueId.getIdentifier(Arrays.asList(progPeriodRegister.getName()));
	        Integer indexProgram = preference.getIndex(INDEX_PROGRAM);
	        Character stateProgram = SYSTEM_STATE_ACTIVE;
//			°Generar entidad
	        Program program = new Program(idProgram, indexProgram, identifierProgram,  progPeriodRegister.getName(),  
	        		progPeriodRegister.getAcronym(), progPeriodRegister.getArea(), stateProgram);
	        program.setProgramDescription(progPeriodRegister.getDescription());
	        try {
				programService.createProgram(program);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			°Generar valores
	        ProgramPeriodPK idProgPeriod = new ProgramPeriodPK(program.getProgramId(), progPeriodRegister.getIdPeriod());
	        Integer indexProgPeriod = preference.getIndex(INDEX_PROGRAM_PERIOD);
	        Character stateProgPeriod = SYSTEM_STATE_ACTIVE;
//			°Generar entidad
	        ProgramPeriod programPeriod = new ProgramPeriod(idProgPeriod, indexProgPeriod, progPeriodRegister.getPayEnrollmet(), 
	        		progPeriodRegister.getPayPension(), progPeriodRegister.getDateOpening(), progPeriodRegister.getDateClosingEnrollmet(), 
	        		progPeriodRegister.getDateClosing(), stateProgPeriod);
	        programPeriodService.createProgramPeriod(programPeriod);
//			°Retornar mensaje
	        return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_PROGRAM), HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_ACADEMIC_CYCLE_PROGRAMxDELETE_GET)
	public ResponseEntity<?> periodProrgamDelete(@PathVariable(name ="cycle")String cycle, @RequestParam(name="programId")Long programId) {
		try {
			Period period = periodService.getPeriodByIdentifier(cycle).get();
			programPeriodService.deleteProgramPeriod(programId, period.getPeriodId());;
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_DELETE_PROGRAM), HttpStatus.OK);
	}
	
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_ACADEMIC_CYCLE_PROGRAM_ENROLLED_GET)
	public ResponseEntity<?> academicProgramPeriodView(@PathVariable(name ="cycle")String cycle, @PathVariable(name ="program")String prog) {
		Program program = null;
		Period period = null;
		try {
			program = programService.getProgramByIdentifier(prog).get();
			period = periodService.getPeriodByIdentifier(cycle).get();
			Iterable<EnrollmentProgram> enrollProgList = enrollmentProgramService.getEnrollmentProgramPeriodByProgramPeriodId(program.getProgramId(), period.getPeriodId());
			List<ProgramPeriodEnrollmentDto> progEnrollDto = new ArrayList<>();
			for(EnrollmentProgram enrollProg:enrollProgList) {
				Person person = enrollProg.getPerson();
				progEnrollDto.add(new ProgramPeriodEnrollmentDto(person.getPersonName(), person.getPersonLastnameFather(),
						person.getPersonLastnameMother(), enrollProg.getEnrollmentProgramDate()));
			}
			return new ResponseEntity<List<ProgramPeriodEnrollmentDto>>(progEnrollDto, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_ACADEMIC_CYCLE_PROGRAM_COURSE_GET)
	public ResponseEntity<?> getAcademicCycleProgramCourse(@PathVariable(name ="cycle")String cycle, @PathVariable(name ="program")String prog) {
		ProgramPeriod progPeriod = null;
		Program program = null;
		Period period = null;
		try {
			program = programService.getProgramByIdentifier(prog).get();
			period = periodService.getPeriodByIdentifier(cycle).get();
			progPeriod = programPeriodService.getProgramPeriodById(program.getProgramId(), period.getPeriodId()).get();
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		HeaderDataDto cycleProgramHeaderDto = new HeaderDataDto<CourseDetailListDto>(progPeriod.getProgram().getProgramIdentifier(),
				progPeriod.getProgram().getProgramName());
		List<CourseDetailListDto> courseListDto = new ArrayList<>();
		Iterable<CourseDetail> courseDetailList = courseDetailService.getCourseDetailsByProgramPeriodId(program.getProgramId(), period.getPeriodId());
		for(CourseDetail courseDetail:courseDetailList) {
			Course course = courseDetail.getCourseId();
			courseListDto.add(new CourseDetailListDto(courseDetail.getCourseDetailId(), course.getCourseName(),
					courseDetail.getCourseDetailCapacity(), courseDetail.getCourseDetailState()));
		}
		cycleProgramHeaderDto.setList(courseListDto);
		return new ResponseEntity<HeaderDataDto>(cycleProgramHeaderDto, HttpStatus.OK);
	}

}
