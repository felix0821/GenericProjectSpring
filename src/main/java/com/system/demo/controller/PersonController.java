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
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.system.demo.model.PersonRol;
import com.system.demo.security.AclFilterVerify;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.PersonRolService;
import com.system.demo.service.PersonService;
import com.system.demo.util.ApiQueries;
import com.system.demo.util.UniqId;

import static com.system.demo.GenericProjectSystemStatement.*;

@RestController
@RequestMapping(URL_PERSON_REQUEST)
@CrossOrigin(origins = "*")
public class PersonController {
	
	@Autowired
	ApiQueries apiQueries;
	
	@Autowired
    JwtProvider jwtProvider;
	
	@Autowired
	PersonService personService;
	
	@Autowired
	PersonRolService personRolService;
	
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
			Iterable<Person> list = personService.getAllPersons();
			List<PersonListDto> listDto = new ArrayList<PersonListDto>();
			for(Person person: list) {
				//Verificar mi usuario
		        Person user = personService.getPersonByUsername(userFromToken).get();
				//Agregar a lista
				if (!user.getUsername().equals(person.getUsername()))
					listDto.add(new PersonListDto(person.getIdPerson(), person.getUsername(),person.getName(),person.getLastnameFather(),
			        		person.getLastnameMother(),person.getState()));
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
	        Person user = personService.getPersonByUsername(userFromToken).get();
	        PersonProfileDto personEditDto = new PersonProfileDto(user.getIdPerson(), user.getUsername(), user.getName(),
	        		user.getLastnameFather(), user.getLastnameMother(), user.getEmail(), user.getDni(), user.getDateBirth(),
	        		user.getUrlProfilepicture());
	        return new ResponseEntity<PersonProfileDto>(personEditDto, HttpStatus.OK);
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
        Person userEdit = null;
        try {
			userEdit = personService.getPersonById(userUpdate.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
		}
        userEdit.setUsername(userUpdate.getUsername());
        userEdit.setEmail(userUpdate.getEmail());
        userEdit.setName(userUpdate.getName());
        userEdit.setLastnameFather(userUpdate.getLastnameFather());
        userEdit.setLastnameMother(userUpdate.getLastnameMother());
        userEdit.setDateBirth(userUpdate.getDateBirth());
        userEdit.setDni(userUpdate.getDni());
        userEdit.setUrlProfilepicture(userUpdate.getUrlProfilepicture());
        
        try {
			personService.updatePerson(userEdit);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Usuario"), HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity(new Message("Usuario modificado exitosamente"), HttpStatus.CREATED);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping(value=URL_PERSON_REGISTER_POST)
    public ResponseEntity<?> save(@Valid @RequestBody PersonRegisterDto userRegister, BindingResult bindingResult) throws Exception{
		//Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        if(personService.existsByUsername(userRegister.getUsername()))
            return new ResponseEntity(new Message("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        if(personService.existsByEmail(userRegister.getEmail()))
            return new ResponseEntity(new Message("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        if(personService.existsByDni(userRegister.getDni()))
            return new ResponseEntity(new Message("Ese dni ya existe"), HttpStatus.BAD_REQUEST);
        Long idUser = uI.uniqid();
        String password = bCryptPasswordEncoder.encode(userRegister.getPassword());
        //Insertar fecha de registro
		LocalDate fechaPeru=LocalDate.now(ZoneId.of("America/Lima"));
		Date dateRegister=Date.from(fechaPeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		//Insertar nombres por dni
		String names[] = apiQueries.checkDniApiPeru(userRegister.getDni());
		Date dateBirth=new SimpleDateFormat("yyyy-MM-dd").parse(names[3]);
		String emailPerson = names[0]+"@"+names[1]+names[2];
		//Crear un usuario para persistir
        Person person =
                new Person(idUser, userRegister.getUsername(), password, names[0], names[1], 
                		names[2], emailPerson, userRegister.getDni(),dateBirth, 
                		dateRegister, 'A');
        personService.createPerson(person);
        //Agregar rol a nuevo usuario
        Long idRole = 2L;
        PersonRol personRol = new PersonRol(idUser,idRole);
		personRol.setState('A');
		personRolService.createPersonRol(personRol);
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
		Person userEdit = null;
		try {
			userEdit = personService.getPersonById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
		}
		PersonEditDto result = new PersonEditDto(userEdit.getIdPerson(), userEdit.getName(), userEdit.getLastnameFather(),
				userEdit.getLastnameMother(), userEdit.getDateBirth(), userEdit.getState());
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
        userEdit.setName(userUpdate.getName());
        userEdit.setLastnameFather(userUpdate.getLastnameFather());
        userEdit.setLastnameMother(userUpdate.getLastnameMother());
        userEdit.setDateBirth(userUpdate.getDateBirth());
        userEdit.setState(userUpdate.getState());
        try {
			personService.updatePerson(userEdit);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Usuario"), HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity(new Message("Usuario modificado exitosamente"), HttpStatus.CREATED);
	}
	
	public String usernameFromToken(HttpHeaders headers) {
		final String authorizationHeaderValue = headers.getFirst(HttpHeaders.AUTHORIZATION);
		String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
		String usernameFromToken = jwtProvider.getUsernameFromToken(token);
		return usernameFromToken;
	}

}
