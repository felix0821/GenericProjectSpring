package com.system.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.system.demo.dto.JwtDto;
import com.system.demo.dto.Message;
import com.system.demo.dto.PersonLoginDto;
import com.system.demo.model.Person;
import com.system.demo.security.JwtProvider;
import com.system.demo.service.PersonService;
import com.system.demo.utility.EncripId;

import static com.system.demo.GenericProjectSystemStatement.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value=URL_AUTH_REQUEST)
@CrossOrigin
public class AuthenticationController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    EncripId encripId;
    
    @Autowired
	PersonService personService;
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(URL_AUTH_LOGIN_POST)
    public ResponseEntity<?> login(@Valid @RequestBody PersonLoginDto userLogin, BindingResult bindingResult) throws Exception{
        try {
        	if(bindingResult.hasErrors())
                return new ResponseEntity(new Message(bindingResult.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            String key = encripId.encript(userDetails.getUsername());
            Person person = personService.getPersonByUsername(userDetails.getUsername()).get();
            JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), key, userDetails.getAuthorities(), person.getPersonUrlProfilepicture());
            return new ResponseEntity<JwtDto>(jwtDto, HttpStatus.OK);
            //return new ResponseEntity(new Message("ACCEPT"), HttpStatus.OK);
        }
        
        catch (Exception e) {
        	System.out.println(e);
        	return new ResponseEntity(new Message("BLOQUED"), HttpStatus.BAD_REQUEST);
        }
    }
}