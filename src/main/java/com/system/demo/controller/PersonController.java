package com.system.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.Message;
import com.system.demo.dto.PersonEditDto;
import com.system.demo.dto.PersonListDto;
import com.system.demo.dto.PersonProfileDto;
import com.system.demo.dto.PersonRegisterDto;
import com.system.demo.model.Person;
import com.system.demo.model.PersonIdentificationDocument;
import com.system.demo.model.PersonRole;
import com.system.demo.security.AclFilterVerify;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.PersonIdentificationDocumentService;
import com.system.demo.service.PersonRoleService;
import com.system.demo.service.PersonService;
import com.system.demo.utility.ApiQueries;
import com.system.demo.utility.UniqId;

import static com.system.demo.GenericProjectSystemStatement.*;

@RestController
@RequestMapping(value=URL_PERSON_REQUEST)
@CrossOrigin(origins = "*")
public class PersonController {
	
	@Autowired
	ApiQueries apiQueries;
	
	@Autowired
    JwtProvider jwtProvider;
	
	@Autowired
	PersonService personService;
	
	@Autowired
	PersonRoleService personRoleService;
	
	@Autowired
	PersonIdentificationDocumentService personIdentDocService;
	
	@Autowired
	UniqId uI;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
				//Verificar mi usuario
		        Person user = personService.getPersonByUsername(userFromToken).get();
				//Agregar a lista
				if (!user.getPersonUsername().equals(person.getPersonUsername()))
					listDto.add(new PersonListDto(person.getPersonId(), person.getPersonUsername(),person.getPersonName(),person.getPersonLastnameFather(),
			        		person.getPersonLastnameMother(),person.getPersonState()));
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
	        PersonIdentificationDocument dniFromPerson = null;
	        String dni=null;
	        try {
	        	dniFromPerson = personIdentDocService.personIdentificationDocumentById(1L, person.getPersonId());
	        	dni = dniFromPerson.getPersonIdentificationDocumentValue();
	        } catch (Exception e) {
	        	System.out.println(e);
	        }
	        
	        PersonProfileDto personProfileDto = new PersonProfileDto(person.getPersonId(), person.getPersonUsername(), person.getPersonName(),
	        		person.getPersonLastnameFather(), person.getPersonLastnameMother(), person.getPersonEmail(), dni, 
	        		person.getPersonDateBirth(), person.getPersonUrlProfilepicture());
	        return new ResponseEntity<PersonProfileDto>(personProfileDto, HttpStatus.OK);
	        //return new ResponseEntity(new Message("BLOQUEDasa"), HttpStatus.OK);
		}
		catch (Exception e) {
        	return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
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
		//Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        if(personService.existsByUsername(personRegister.getUsername()))
            return new ResponseEntity(new Message("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        if(personService.existsByEmail(personRegister.getEmail()))
            return new ResponseEntity(new Message("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        /*if(personService.existsByDni(userRegister.getDni()))
            return new ResponseEntity(new Message("Ese dni ya existe"), HttpStatus.BAD_REQUEST);*/
        Long idUser = uI.uniqid();
        String password = bCryptPasswordEncoder.encode(personRegister.getPassword());
        //Insertar fecha de registro
		LocalDate fechaPeru=LocalDate.now(ZoneId.of("America/Lima"));
		Date dateRegister=Date.from(fechaPeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		//Insertar nombres por dni
		String dniQuery[] = apiQueries.checkDniApiPeru(personRegister.getDni());
		Date dateBirth=new SimpleDateFormat("yyyy-MM-dd").parse(dniQuery[3]);
		String emailPerson = personRegister.getEmail();
		char gender = 'X';
		if (dniQuery[4].equals("MASCULINO")) gender = 'M';
		else gender = 'F';
		//Crear un usuario para persistir
        Person person =
                new Person(idUser, personRegister.getUsername(), password, dniQuery[0], dniQuery[1], 
                		dniQuery[2], gender, dateRegister, emailPerson, 'A');
        person.setPersonDateBirth(dateBirth);
        personService.createPerson(person);
        //Agregar documento de identidad a nuevo usuario
        PersonIdentificationDocument personIdentificationDocument = new PersonIdentificationDocument(1L,idUser);
        personIdentificationDocument.setPersonIdentificationDocumentValue(personRegister.getDni());
        personIdentDocService.createPersonIdentificationDocument(personIdentificationDocument);
        //Agregar rol a nuevo usuario
        Long idRole = 2L;
        PersonRole personRol = new PersonRole(idUser,idRole);
		personRol.setPersonRoleState('A');
		personRoleService.createPersonRol(personRol);
        return new ResponseEntity(new Message("Usted se registro exitosamente"), HttpStatus.CREATED);
    }
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping(URL_PERSON_DELETE_GET)
	public ResponseEntity<?> delete(@PathVariable(name="id")Long id){
		try {
			personService.deletePerson(id);
		} 
		catch (com.system.demo.exception.UsernameOrIdNotFound uoin) {
			uoin.printStackTrace();
			return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message("Información eliminada exitosamente"), HttpStatus.CREATED);
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
	
	//---------------------------JWT_UTIL--------------------------------------------------------
	public String usernameFromToken(HttpHeaders headers) {
		final String authorizationHeaderValue = headers.getFirst(HttpHeaders.AUTHORIZATION);
		String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
		String usernameFromToken = jwtProvider.getUsernameFromToken(token);
		return usernameFromToken;
	}

}
