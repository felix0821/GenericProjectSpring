package com.system.demo.service.method;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.repository.PersonRepository;
import com.system.demo.security.JwtUser;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	@Autowired
    PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String personUsername) throws UsernameNotFoundException {
    	Person person = personRepository.findByPersonUsername(personUsername).get();
        return JwtUser.build(person);
    }
}