package com.system.demo.service.method;


import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.Person;
import com.system.demo.persistence.entity.PersonRole;
import com.system.demo.persistence.repository.PersonRepository;
import com.system.demo.persistence.repository.PersonRoleRepository;
import com.system.demo.security.JwtUser;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	@Autowired
    PersonRepository personRepository;
	
	@Autowired
	PersonRoleRepository personRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String personUsername) throws UsernameNotFoundException {
    	Person person = personRepository.findByPersonUsername(personUsername).get();
    	Collection<PersonRole> personRoles = new ArrayList<PersonRole>();
    	personRoleRepository.findByPersonId(person.getPersonId()).forEach(personRoles::add);
        return JwtUser.build(person, personRoles);
    }
}