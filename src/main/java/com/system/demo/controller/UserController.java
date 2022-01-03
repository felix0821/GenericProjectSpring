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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.demo.dto.Message;
import com.system.demo.dto.UserProfileDto;
import com.system.demo.dto.UserRegisterDto;
import com.system.demo.model.User;
import com.system.demo.model.UserRol;
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
	
	@GetMapping({"/","/index",""})
    public ResponseEntity<List<UserProfileDto>> list(){
		Iterable<User> list = userService.getAllUsers();
		List<UserProfileDto> listDto = new ArrayList<UserProfileDto>();
		for(User user: list) {
			listDto.add(new UserProfileDto(user.getUsername(),user.getName(),user.getLastname(),
        		user.getLastnameMother(),user.getEmail(),user.getDni(),user.getDateBirth(),user.getState(),null));
		}
        return new ResponseEntity<List<UserProfileDto>>(listDto, HttpStatus.OK);
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/register")
    public ResponseEntity<?> save(@Valid @RequestBody UserRegisterDto userRegister, BindingResult bindingResult) throws Exception{
		//Realizamos las validaciones pertinentes
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("Hay campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
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
		Date fechaRegistro=Date.from(fechaPeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		//Insertar nombres por dni
		String names[] = apiQueries.checkDniApiPeru(userRegister.getDni());
		//Crear un usuario para persistir
        User user =
                new User(idUser, userRegister.getUsername(), password, names[0], names[2], 
                		names[1], userRegister.getEmail(), userRegister.getDni(),userRegister.getDateBirth(), 
                		fechaRegistro, 'A');
        userService.createUser(user);
        //Agregar rol a nuevo usuario
        Long idRole = 2L;
        UserRol userRol = new UserRol(idUser,idRole);
		userRol.setState('A');
		userRolService.createUserRol(userRol);
        return new ResponseEntity(new Message("Usted se registro exitosamente"), HttpStatus.CREATED);
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/deleteUser/{id}")
	public ResponseEntity<?> delete(){
		
		return new ResponseEntity(new Message("Información eliminada exitosamente"), HttpStatus.CREATED);
	}
	
	public String usernameFromToken(HttpHeaders headers) {
		final String authorizationHeaderValue = headers.getFirst(HttpHeaders.AUTHORIZATION);
		String token = authorizationHeaderValue.substring(7, authorizationHeaderValue.length());
		String usernameFromToken = jwtProvider.getNombreUsuarioFromToken(token);
		return usernameFromToken;
	}

}
