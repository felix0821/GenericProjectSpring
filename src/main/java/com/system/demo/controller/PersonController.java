package com.system.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.system.demo.dto.generic.Message;
import com.system.demo.dto.generic.Relationship2Dto;
import com.system.demo.dto.specific.PersonEditDto;
import com.system.demo.dto.specific.PersonListDto;
import com.system.demo.dto.specific.PersonProfileDto;
import com.system.demo.dto.specific.PersonRegisterDto;
import com.system.demo.dto.specific.PersonRolesDetailDto;
import com.system.demo.dto.specific.PersonRolesHeaderDto;
import com.system.demo.exception.ApiDniNotFoundException;
import com.system.demo.exception.PasswordErrorException;
import com.system.demo.persistence.entity.PersonGender;
import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.entity.PersonIdentification;
import com.system.demo.persistence.entity.PersonRole;
import com.system.demo.persistence.entity.Role;
import com.system.demo.security.AclFilterVerify;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.PersonGenderService;
import com.system.demo.service.PersonIdentificationService;
import com.system.demo.service.PersonRoleService;
import com.system.demo.service.PersonService;
import com.system.demo.service.RoleService;
import com.system.demo.utility.ApiQueriesUtility;
import com.system.demo.utility.UniqIdUtility;

import static com.system.demo.GenericProjectSystemStatement.*;
import static com.system.demo.GenericProjectSystemDefinition.*;

@RestController
@RequestMapping(value=URL_PERSON_REQUEST)
@CrossOrigin(origins = "*")
public class PersonController {
	
	@Autowired
	ApiQueriesUtility apiQueriesUtility;
	
	@Autowired
    JwtProvider jwtProvider;
	
	@Autowired
	PersonService personService;
	@Autowired
	PersonRoleService personRoleService;
	@Autowired
	RoleService roleService;
	@Autowired
	PersonGenderService personGenderService;
	@Autowired
	PersonIdentificationService personIdentDocService;
	
	@Autowired
	UniqIdUtility uI;
	@Autowired
	AclFilterVerify aclFilterVerify;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping
	@ResponseBody
    public ResponseEntity<?> list(@RequestHeader HttpHeaders headers, HttpServletRequest request){
		String userFromToken = usernameFromToken(headers);
		/*if(!aclFilterVerify.accessRoleForPerson(request.getRequestURI().toString(),userFromToken)) 
			return new ResponseEntity(new Message("Unauthorized access"), HttpStatus.UNAUTHORIZED);*/
		try {
			Iterable<Person> listPerson = personService.getAllPersons();
			List<PersonListDto> listDto = new ArrayList<PersonListDto>();
			for(Person person: listPerson) {
		        Long count = personRoleService.getTotalPersonRoleByPersonId(person.getPersonId());
		        listDto.add(new PersonListDto(person.getPersonId(), person.getPersonUsername(),person.getPersonName(),person.getPersonLastnameFather(),
		        		person.getPersonLastnameMother(),count,person.getPersonState()));
			}
	        return new ResponseEntity<List<PersonListDto>>(listDto, HttpStatus.OK);
		}
		catch (Exception e) {
        	return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
        }
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value=URL_PERSON_PROFILE_GET)
    public ResponseEntity<?> profile(@RequestHeader HttpHeaders headers){
		try {
			String userFromToken = usernameFromToken(headers);
	        Person person = personService.getPersonByUsername(userFromToken).get();
	        PersonIdentification dniFromPerson = null;
	        String dni=null;
	        try {
	        	dniFromPerson = personIdentDocService.getPersonIdentificationById(SYSTEM_IDENTIFICATION_DNI, 
	        			person.getPersonId()).get();
	        	dni = dniFromPerson.getPersonIdentificationValue();
	        } catch (Exception e) {
	        	System.out.println(e);
	        }
	        PersonProfileDto personProfileDto = new PersonProfileDto(person.getPersonId(), person.getPersonUsername(), person.getPersonName(),
	        		person.getPersonLastnameFather(), person.getPersonLastnameMother(), person.getPersonEmail(), dni, 
	        		person.getPersonDateBirth(), person.getPersonUrlProfilepicture());
	        return new ResponseEntity<PersonProfileDto>(personProfileDto, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
        	return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
        }
	} 
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value=URL_PERSON_PROFILE_EDIT_POST)
	public ResponseEntity<?> updateProfile(@Valid @RequestBody PersonProfileDto userUpdate, BindingResult bindingResult) {
		//Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        Person personEdit = null;
        try {
			personEdit = personService.getPersonById(userUpdate.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
		}
        personEdit.setPersonUsername(userUpdate.getUsername());
        personEdit.setPersonEmail(userUpdate.getEmail());
        personEdit.setPersonName(userUpdate.getName());
        personEdit.setPersonLastnameFather(userUpdate.getLastnameFather());
        personEdit.setPersonLastnameMother(userUpdate.getLastnameMother());
        personEdit.setPersonDateBirth(userUpdate.getDateBirth());
        personEdit.setPersonUrlProfilepicture(userUpdate.getUrlProfilepicture());
        
        try {
			personService.updatePerson(personEdit);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Usuario"), HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity(new Message("Usuario modificado exitosamente"), HttpStatus.CREATED);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value=URL_PERSON_REGISTER_POST)
    public ResponseEntity<?> save(@Valid @RequestBody PersonRegisterDto personRegister, BindingResult bindingResult) throws Exception{
//		??Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        if(personService.existsByUsername(personRegister.getUsername()))
            return new ResponseEntity(new Message("Ese nombre de usuario o correo ya existe"), HttpStatus.BAD_REQUEST);
        /*if(personService.existsByEmail(personRegister.getEmail()))
            return new ResponseEntity(new Message("Ese email ya existe"), HttpStatus.BAD_REQUEST);*/
        if(personIdentDocService.existsPersonIdentificationByValue(personRegister.getDni()))
            return new ResponseEntity(new Message("Ese dni ya existe"), HttpStatus.BAD_REQUEST);
        try {
        	Long personId = uI.getUniqId();
            //Insertar fecha de registro
    		LocalDateTime fechaHoraPeru = LocalDateTime.now(ZoneId.of(ZONE_DATE_LIMA));
    		Date dateRegister = Date.from(fechaHoraPeru.atZone(ZoneId.systemDefault()).toInstant());
    		//Insertar nombres por dni
    		String dniQuery[] = apiQueriesUtility.checkDniApiPeru(personRegister.getDni());
    		Date dateBirth=new SimpleDateFormat("yyyy-MM-dd").parse(dniQuery[3]);
    		Character genderId;
    		PersonGender gender = null;
    		if (!dniQuery[4].equals(SYSTEM_GENDER_UNDEFINED.toString())) {
    			if (dniQuery[4].equals("MASCULINO")) genderId = SYSTEM_GENDER_MALE;
    			else genderId = SYSTEM_GENDER_FEMALE;
    			gender = personGenderService.getGenderById(genderId.toString()).get();
    		}
    		//Crear un usuario para persistir
            Person person =
                    new Person(personId, personRegister.getUsername(), personRegister.getPassword(), dniQuery[0], dniQuery[1], 
                    		dniQuery[2], dateRegister, SYSTEM_STATE_ACTIVE);
            person.setPersonDateBirth(dateBirth);
            person.setGenderId(gender);
            personService.createPerson(person, personRegister.getConfirmation());
            //Agregar documento de identidad a nuevo usuario
            PersonIdentification personIdentificationDocument = new PersonIdentification(personId, SYSTEM_IDENTIFICATION_DNI);
            personIdentificationDocument.setPersonIdentificationValue(personRegister.getDni());
            personIdentDocService.createPersonIdentification(personIdentificationDocument);
            //Agregar rol a nuevo usuario
            PersonRole personRol = new PersonRole(personId,SYSTEM_ID_USER);
    		personRol.setPersonRoleState(SYSTEM_STATE_ACTIVE);
    		personRoleService.createPersonRol(personRol);
            return new ResponseEntity(new Message("Usted se registro exitosamente"), HttpStatus.CREATED);
        } catch(PasswordErrorException | ApiDniNotFoundException e) {
        	return new ResponseEntity(new Message(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
        	e.printStackTrace();
        	return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
        }
    }
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_PERSON_DELETE_GET)
	public ResponseEntity<?> delete(@RequestParam(name="personId")Long id){
		try {
			personService.deletePerson(id);
		} 
		catch (com.system.demo.exception.UsernameOrIdNotFound uoin) {
			uoin.printStackTrace();
			return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message("Informaci??n eliminada exitosamente"), HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_PERSON_EDIT_GET)
	public ResponseEntity<?> editForm(@PathVariable(name ="id")Long id) {
		Person personEdit = null;
		try {
			personEdit = personService.getPersonById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
		}
		PersonEditDto result = new PersonEditDto(personEdit.getPersonId(), personEdit.getPersonName(), personEdit.getPersonLastnameFather(),
				personEdit.getPersonLastnameMother(), personEdit.getPersonDateBirth(), personEdit.getPersonState());
		return new ResponseEntity<PersonEditDto>(result, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(URL_PERSON_EDIT_POST)
	public ResponseEntity<?> editData(@Valid @RequestBody PersonEditDto userUpdate, BindingResult bindingResult) {
		//Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        Person userEdit = null;
        try {
			userEdit = personService.getPersonById(userUpdate.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
		}
        userEdit.setPersonName(userUpdate.getName());
        userEdit.setPersonLastnameFather(userUpdate.getLastnameFather());
        userEdit.setPersonLastnameMother(userUpdate.getLastnameMother());
        userEdit.setPersonDateBirth(userUpdate.getDateBirth());
        userEdit.setPersonState(userUpdate.getState());
        try {
			personService.updatePerson(userEdit);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Usuario"), HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity(new Message("Usuario modificado exitosamente"), HttpStatus.CREATED);
	}
	
	//	Gestion de Roles para usuario
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_PERSONxROLES_GET)
	public ResponseEntity<?> personRoles(@PathVariable(name ="personId")Long id) {
		Person person = null;
		try {
			person = personService.getPersonById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		PersonRolesHeaderDto personRolesHeaderDto = new PersonRolesHeaderDto(person.getPersonId(), person.getPersonUsername());
		List<PersonRolesDetailDto> personRoleDetailsDto = new ArrayList<>();
		Iterable<PersonRole> personRoles = personRoleService.getPersonRoleByPersonId(id);
		for(PersonRole personRole: personRoles) {
			personRoleDetailsDto.add(new PersonRolesDetailDto(personRole.getPersonRolePK().getRoleId(), 
					personRole.getRole().getRoleName(),personRole.getPersonRoleState()));
		}
		personRolesHeaderDto.setRoles(personRoleDetailsDto);
		return new ResponseEntity<PersonRolesHeaderDto>(personRolesHeaderDto, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_PERSONxROLES_REGISTER_GET)
	public ResponseEntity<?> personRolesRegisterForm(@PathVariable(name ="personId")Long id) {
		try {
			List<DropdownDataDto> rolesDto = new ArrayList<>();
			Iterable<Role> rolesNotPerson = roleService.getRolesByNotPersonId(id);
			for(Role role: rolesNotPerson) {
				rolesDto.add(new DropdownDataDto(role.getRoleId(), role.getRoleName()));
			}
			return new ResponseEntity<List<DropdownDataDto>>(rolesDto, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * @implNote <b>idOne</b> refers to the <b>personId</b>
	 * @implNote <b>idTwo</b> refers to the <b>roleId</b>
	*/
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value = URL_PERSONxROLE_REGISTER_POST)
    public ResponseEntity<?> personRoleRegister(@Valid @RequestBody Relationship2Dto personRoleRegDto, BindingResult bindingResult) {
		//	Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
		try {
			PersonRole personRol = new PersonRole(personRoleRegDto.getIdOne(), personRoleRegDto.getIdTwo());
			personRol.setPersonRoleState(SYSTEM_STATE_ACTIVE);
			personRoleService.createPersonRol(personRol);
			return new ResponseEntity(new Message(SYSTEM_SUCCESS_REGISTER_PERSONxROLE), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_PERSONxROLE_DELETE_GET)
	public ResponseEntity<?> deletePersonRole(@RequestParam(name="personId")Long personId, @RequestParam(name="roleId")Long roleId){
		try {
			personRoleService.deletePersonRol(personId, roleId);
		} 
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message(SYSTEM_ERROR_NO_ID), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message(SYSTEM_SUCCESS_DELETE_PERSONxROLE), HttpStatus.OK);
	}
	
	//---------------------------JWT_UTIL--------------------------------------------------------
	public String usernameFromToken(HttpHeaders headers) {
		final String authorizationHeaderValue = headers.getFirst(HttpHeaders.AUTHORIZATION);
		String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
		//System.out.println("----------------"+jwtProvider.getIdFromToken(token));
		String usernameFromToken = jwtProvider.getUsernameFromToken(token);
		return usernameFromToken;
	}

}
