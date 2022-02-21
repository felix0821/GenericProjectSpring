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

import com.system.demo.dto.generic.DropdownDataDto;
import com.system.demo.dto.generic.HeaderDataDto;
import com.system.demo.dto.generic.Message;
import com.system.demo.dto.generic.Relationship2Dto;
import com.system.demo.dto.specific.ConfigurationProgramDto;
import com.system.demo.dto.specific.ConfigurationProgramRegisterDto;
import com.system.demo.dto.specific.ConfigurationCourseListDto;
import com.system.demo.dto.specific.ConfigurationCourseRegisterDto;
import com.system.demo.dto.specific.ConfigurationGroupListDto;
import com.system.demo.dto.specific.ConfigurationModulusListDto;
import com.system.demo.dto.specific.ConfigurationModulusRegisterDto;
import com.system.demo.dto.specific.ProgramDetailedDto;
import com.system.demo.dto.specific.ProgramDetailedOccupationalDto;
import com.system.demo.dto.specific.ProgramOccupationalRegisterDto;
import com.system.demo.persistence.entity.Course;
import com.system.demo.persistence.entity.GroupTeaching;
import com.system.demo.persistence.entity.Modulus;
import com.system.demo.persistence.entity.OccupationalField;
import com.system.demo.persistence.entity.PersonRole;
import com.system.demo.persistence.entity.Program;
import com.system.demo.persistence.entity.ProgramGroup;
import com.system.demo.service.CourseService;
import com.system.demo.service.GroupTeachingService;
import com.system.demo.service.ModulusService;
import com.system.demo.service.OccupationalFieldService;
import com.system.demo.service.ProgramGroupService;
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
	@Autowired
	CourseService courseService;
	@Autowired
	ProgramGroupService programGroupService;
	@Autowired
	GroupTeachingService groupTeachingService;
	
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
	        Character stateProgram = SYSTEM_STATE_ACTIVE;
//			°Generar entidad
	        Program program = new Program(idProgram, indexProgram, identifierProgram, programRegister.getName(), programRegister.getAcronym(),
	        		programRegister.getArea(), stateProgram);
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
	
//	-------------------------------------- MODULUS --------------------------------------
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_CONFIGURATION_PROGRAM_MODULUS_GET)
	public ResponseEntity<?> programModulusView(@PathVariable(name ="program")String identifier) {
		//		Buscamos programa por id
		Program program = null;
		try {
			program = programService.getProgramByIdentifier(identifier).get();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		HeaderDataDto<ConfigurationModulusListDto> response = new HeaderDataDto(program.getProgramIdentifier(), program.getProgramName());
		List<ConfigurationModulusListDto> list = new ArrayList<>();
		Iterable<Modulus> modules = modulusService.getModulesByProgramId(program.getProgramId());
		for(Modulus modulus: modules) {
			list.add(new ConfigurationModulusListDto(modulus.getModulusId(), modulus.getModulusIdentifier(), modulus.getModulusName(), 
					modulus.getModulusIndex(), modulus.getModulusOrder(), modulus.getModulusState()));
		}
		response.setList(list);
		return new ResponseEntity<HeaderDataDto<ConfigurationModulusListDto>>(response, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked"})
	@PostMapping(value = URL_CONFIGURATION_PROGRAM_MODULUSxREGISTER_POST)
    public ResponseEntity<?> programModulusRegister(@Valid @RequestBody ConfigurationModulusRegisterDto modulusRegister, BindingResult bindingResult,
    		@PathVariable(name ="program")String programIdentifier){
		try {
//			°Realizar validaciones
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	        Program program = null;
	        try {
				program = programService.getProgramByIdentifier(programIdentifier).get();
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
			}
//			°Generar valores
	        Long idModulus = uniqueId.getUniqId();
	        String identifierModulus = uniqueId.getIdentifier(Arrays.asList(modulusRegister.getName(), 
	        		String.valueOf(modulusRegister.getOrder())));
	        Integer indexModulus = preference.getIndex(INDEX_MODULUS);
	        Character stateModulus = SYSTEM_STATE_ACTIVE;
//			°Generar entidad
	        Modulus modulus = new Modulus(idModulus, indexModulus, identifierModulus, modulusRegister.getName(), 
	        		modulusRegister.getOrder(), stateModulus);
	        modulus.setModulusDescription(modulusRegister.getDescription());
	        modulus.setProgramId(program);
	        try {
	        	modulusService.createModulus(modulus);
				return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_MODULUS), HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(new Message(SYSTEM_ERROR_REGISTER_MODULUS), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_CONFIGURATION_PROGRAM_MODULUSxDELETE_GET)
	public ResponseEntity<?> programModulusDelete(@RequestParam(name="id")Long id) {
		try {
			modulusService.deleteModulus(id);;
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_DELETE_MODULUS), HttpStatus.OK);
	}
	
//	-------------------------------------- COURSE --------------------------------------
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_CONFIGURATION_MODULUS_COURSE_GET)
	public ResponseEntity<?> modulusCourseView(@PathVariable(name ="modulus")String identifier) {
		//		Buscamos programa por id
		Modulus modulus = null;
		try {
			modulus = modulusService.getModulusByIdentifier(identifier).get();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		HeaderDataDto<ConfigurationCourseListDto> response = new HeaderDataDto(modulus.getModulusIdentifier(), modulus.getModulusName());
		List<ConfigurationCourseListDto> list = new ArrayList<>();
		Iterable<Course> courses = courseService.getCoursesByModulusId(modulus.getModulusId());
		for(Course course: courses) {
			list.add(new ConfigurationCourseListDto(course.getCourseId(), course.getCourseIdentifier(), course.getCourseName(), 
					course.getCourseIndex(), course.getCourseAcronym(), course.getCourseState()));
		}
		response.setList(list);
		return new ResponseEntity<HeaderDataDto<ConfigurationCourseListDto>>(response, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked"})
	@PostMapping(value = URL_CONFIGURATION_MODULUS_COURSExREGISTER_POST)
    public ResponseEntity<?> modulusCourseRegister(@Valid @RequestBody ConfigurationCourseRegisterDto courseRegister, BindingResult bindingResult,
    		@PathVariable(name ="modulus")String modulusIdentifier){
		try {
//			°Realizar validaciones
	        if(bindingResult.hasErrors())
	            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
	        Modulus modulus = null;
	        try {
				modulus = modulusService.getModulusByIdentifier(modulusIdentifier).get();
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
			}
//			°Generar valores
	        Long idCourse = uniqueId.getUniqId();
	        String identifierCourse = uniqueId.getIdentifier(Arrays.asList(courseRegister.getName()));
	        Integer indexCourse = preference.getIndex(INDEX_COURSE);
	        Character stateCourse = SYSTEM_STATE_ACTIVE;
//			°Generar entidad
	        Course course = new Course(idCourse, indexCourse, identifierCourse, courseRegister.getName(), 
	        		courseRegister.getAcronym(), stateCourse);
	        course.setCourseDescription(courseRegister.getDescription());
	        course.setModulusId(modulus);
	        try {
	        	courseService.createCourse(course);
				return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_COURSE), HttpStatus.CREATED);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity(new Message(SYSTEM_ERROR_REGISTER_COURSE), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_CONFIGURATION_MODULUS_COURSExDELETE_GET)
	public ResponseEntity<?> modulusCourseDelete(@RequestParam(name="id")Long id) {
		try {
			courseService.deleteCourse(id);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_DELETE_COURSE), HttpStatus.OK);
	}
	
//	-------------------------------------- PROGRAM-GROUP --------------------------------------
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(value = URL_CONFIGURATION_PROGRAM_GROUP_GET)
	public ResponseEntity<?> programGroupView(@PathVariable(name ="program")String identifier) {
		//		Buscamos programa por id
		Program program = null;
		try {
			program = programService.getProgramByIdentifier(identifier).get();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		HeaderDataDto<ConfigurationGroupListDto> response = new HeaderDataDto(program.getProgramId().toString(), program.getProgramName());
		List<ConfigurationGroupListDto> list = new ArrayList<>();
		Iterable<ProgramGroup> programGroups = programGroupService.getProgramGroupByProgramId(program.getProgramId());
		for(ProgramGroup programGroup: programGroups) {
			GroupTeaching group = programGroup.getGroupTeaching();
			list.add(new ConfigurationGroupListDto(group.getGroupId(), group.getGroupName(), programGroup.getProgramGroupCapacity(), 
					programGroup.getProgramGroupState()));
		}
		response.setList(list);
		return new ResponseEntity<HeaderDataDto<ConfigurationGroupListDto>>(response, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_CONFIGURATION_PROGRAM_GROUPxREGISTER_GET)
	public ResponseEntity<?> programGroupRegisterForm(@RequestParam(name ="programId")Long id) {
		try {
			List<DropdownDataDto> groupsDto = new ArrayList<>();
			Iterable<GroupTeaching> groupTeachingNotProgram = groupTeachingService.getGroupTeachingByNotProgramId(id);
			for(GroupTeaching groupTeaching: groupTeachingNotProgram) {
				groupsDto.add(new DropdownDataDto(groupTeaching.getGroupId(), groupTeaching.getGroupName()));
			}
			return new ResponseEntity<List<DropdownDataDto>>(groupsDto, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * @implNote <b>idOne</b> refers to the <b>programId</b>
	 * @implNote <b>idTwo</b> refers to the <b>groupId</b>
	*/
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value = URL_CONFIGURATION_PROGRAM_GROUPxREGISTER_POST)
    public ResponseEntity<?> personRoleRegister(@Valid @RequestBody Relationship2Dto programGroupRegDto, BindingResult bindingResult,
    		@RequestParam(name ="capacity")Integer capacity) {
//		Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
		try {
			ProgramGroup programGroup = new ProgramGroup(programGroupRegDto.getIdOne(), programGroupRegDto.getIdTwo());
			programGroup.setProgramGroupState(SYSTEM_STATE_ACTIVE);
			programGroup.setProgramGroupCapacity(capacity);
			programGroupService.createProgramGroup(programGroup);
			return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_PERSONxROLE), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_CONFIGURATION_PROGRAM_GROUPxDELETE_GET)
	public ResponseEntity<?> personRoleDelete(@RequestParam(name="programId")Long programId, @RequestParam(name="groupId")Long groupId){
		try {
			programGroupService.deleteProgramGroup(programId, groupId);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_DELETE_PERSONxROLE), HttpStatus.OK);
	}

}
