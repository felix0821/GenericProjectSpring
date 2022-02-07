package com.system.demo.configuration;
/*
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.system.demo.persistence.entity.Person;
import com.system.demo.security.JwtUser;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        Person person = generateUser();
        
    	JwtUser basicUser = new JwtUser(person,null);
        UserActive basicActiveUser = new UserActive(basicUser, Arrays.asList(
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("PERM_FOO_READ")
        ));

       User managerUser = new UserImpl("Manager User", "manager@company.com", "password");
        UserActive managerActiveUser = new UserActive(managerUser, Arrays.asList(
                new SimpleGrantedAuthority("ROLE_MANAGER"),
                new SimpleGrantedAuthority("PERM_FOO_READ"),
                new SimpleGrantedAuthority("PERM_FOO_WRITE"),
                new SimpleGrantedAuthority("PERM_FOO_MANAGE")
        ));

        return new InMemoryUserDetailsManager(Arrays.asList(
        		basicUser
        ));
    }
    
    private Person generateUser() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		Date dateBirth=null;
		try {
			dateBirth = formatter.parse("1995-08-21");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//Insertar fecha de registro
		LocalDate datePeru=LocalDate.now(ZoneId.of("America/Lima"));
		Date dateRegister=Date.from(datePeru.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		//Crear usuario
		Person person = new Person(1L, "felix123", "123", "FELIX", "MONTALICO", "LAQUIHUANACO", 
	    		'M', dateRegister, "felixmontalico@gmail.com", 'A');
		person.setPersonDateBirth(dateBirth);
		return person;
	}
}
*/