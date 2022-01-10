package com.system.demo.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.system.demo.dto.UserProfileDto;
import com.system.demo.dto.UserRegisterDto;
import com.system.demo.model.Person;
import com.system.demo.model.PersonRol;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.UserRolService;
import com.system.demo.service.UserService;
import com.system.demo.util.ApiQueries;
import com.system.demo.util.UniqId;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	ApiQueries apiQueries;
	
	@Autowired
    JwtProvider jwtProvider;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRolService userRolService;
	
	@Autowired
	UniqId uI;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping//(value = {"","/"})
	@ResponseBody
    public ResponseEntity<?> list(){
		try {
			Iterable<Person> list = userService.getAllUsers();
			List<UserProfileDto> listDto = new ArrayList<UserProfileDto>();
			for(Person person: list) {
				listDto.add(new UserProfileDto(person.getIdPerson(), person.getUsername(),person.getName(),person.getLastnameFather(),
	        		person.getLastnameMother(),person.getEmail(),person.getDni(),person.getDateBirth(),person.getState(),null));
			}
	        return new ResponseEntity<List<UserProfileDto>>(listDto, HttpStatus.OK);
		}
		catch (Exception e) {
        	return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
        }
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/profile")
    public ResponseEntity<?> profile(@RequestHeader HttpHeaders headers){
		try {
			String userFromToken = usernameFromToken(headers);
	        Person user = userService.getUserByUsername(userFromToken).get();
	        return new ResponseEntity<Person>(user, HttpStatus.OK);
		}
		catch (Exception e) {
        	return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
        }
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping("/profile/edit")
	public ResponseEntity<?> updateProfile(@Valid @RequestBody Person userUpdate, BindingResult bindingResult) {
		//Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        Person userEdit = null;
        try {
			userEdit = userService.getUserById(userUpdate.getIdPerson());
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
			userService.updateUser(userEdit);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Usuario"), HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity(new Message("Usuario modificado exitosamente"), HttpStatus.CREATED);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping("/register")
    public ResponseEntity<?> save(@Valid @RequestBody UserRegisterDto userRegister, BindingResult bindingResult) throws Exception{
		//Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        if(userService.existsByUsername(userRegister.getUsername()))
            return new ResponseEntity(new Message("Ese nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        if(userService.existsByEmail(userRegister.getEmail()))
            return new ResponseEntity(new Message("Ese email ya existe"), HttpStatus.BAD_REQUEST);
        if(userService.existsByDni(userRegister.getDni()))
            return new ResponseEntity(new Message("Ese dni ya existe"), HttpStatus.BAD_REQUEST);
        Long idUser = uI.uniqid();
        String password = bCryptPasswordEncoder.encode(userRegister.getPassword());
        //Insertar fecha de registro
		LocalDate fechaPeru=LocalDate.now(ZoneId.of("America/Lima"));
		Date dateRegister=Date.from(fechaPeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		//Insertar nombres por dni
		String names[] = apiQueries.checkDniApiPeru(userRegister.getDni());
		//Crear un usuario para persistir
        Person person =
                new Person(idUser, userRegister.getUsername(), password, names[0], names[2], 
                		names[1], userRegister.getEmail(), userRegister.getDni(),userRegister.getDateBirth(), 
                		dateRegister, 'A');
        userService.createUser(person);
        //Agregar rol a nuevo usuario
        Long idRole = 2L;
        PersonRol personRol = new PersonRol(idUser,idRole);
		personRol.setState('A');
		userRolService.createPersonRol(personRol);
        return new ResponseEntity(new Message("Usted se registro exitosamente"), HttpStatus.CREATED);
    }
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping("/deleteUser/{id}")
	public ResponseEntity<?> delete(@PathVariable(name="id")Long id){
		try {
			userService.deleteUser(id);
		} 
		catch (com.system.demo.exception.UsernameOrIdNotFound uoin) {
			uoin.printStackTrace();
			return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity(new Message("Información eliminada exitosamente"), HttpStatus.CREATED);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@GetMapping("/editUser/{id}")
	public ResponseEntity<?> updateForm(@PathVariable(name ="id")Long id) {
		Person userEdit = null;
		try {
			userEdit = userService.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
		}
		UserProfileDto result = new UserProfileDto(userEdit.getIdPerson(), userEdit.getUsername(),userEdit.getName(),userEdit.getLastnameFather(),
        		userEdit.getLastnameMother(),userEdit.getEmail(),userEdit.getDni(),userEdit.getDateBirth(),userEdit.getState(),null);
		return new ResponseEntity<UserProfileDto>(result, HttpStatus.OK);
	}
	
	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	@PostMapping("/editUser")
	public ResponseEntity<?> updateData(@Valid @RequestBody UserProfileDto userUpdate, BindingResult bindingResult) {
		//Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
        Person userEdit = null;
        try {
			userEdit = userService.getUserById(userUpdate.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Id"), HttpStatus.BAD_REQUEST);
		}
        userEdit.setUsername(userUpdate.getUsername());
        userEdit.setEmail(userUpdate.getEmail());
        userEdit.setName(userUpdate.getName());
        userEdit.setLastnameFather(userUpdate.getLastname());
        userEdit.setLastnameMother(userUpdate.getLastnameMother());
        userEdit.setDateBirth(userUpdate.getDateBirth());
        try {
			userService.updateUser(userEdit);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("No existe Usuario"), HttpStatus.BAD_REQUEST);
		}
        return new ResponseEntity(new Message("Usuario modificado exitosamente"), HttpStatus.CREATED);
	}
	
	public String usernameFromToken(HttpHeaders headers) {
		final String authorizationHeaderValue = headers.getFirst(HttpHeaders.AUTHORIZATION);
		String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
		String usernameFromToken = jwtProvider.getNombreUsuarioFromToken(token);
		return usernameFromToken;
	}

}
