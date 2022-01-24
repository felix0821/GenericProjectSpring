package com.system.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.system.demo.model.Access;
import com.system.demo.model.Person;
import com.system.demo.model.PersonRole;
import com.system.demo.model.Resource;
import com.system.demo.service.AccessService;
import com.system.demo.service.PersonService;
import com.system.demo.service.ResourceService;

@Component
@Transactional(readOnly = true)
public class AclFilterVerify {
	
	private final static Logger logger = LoggerFactory.getLogger(AclFilterVerify.class);
	
	@Autowired
	ResourceService resourceService;
	
	@Autowired
	PersonService personService;
	
	@Autowired
	AccessService accessService;
	
	public boolean accessRoleForPerson(String resourceUrl, String username) {
		Resource resource = null;
		Person person = null;
		try {
			resource = resourceService.getResourceByName(resourceUrl).get();
			person = personService.getPersonByUsername(username).get();
			if (resource == null) {
				System.out.println("Recurso no definido");
				return false;
			}
			for (PersonRole personRol : person.getPersonRoleCollection()) {
				if (this.searchAccess(personRol.getRole().getRoleId(), resource.getResourceId())) {
					logger.info("confirmed access: ["+username+"->"+resourceUrl+"]");
					return true;
				}
			}
			logger.error("blocked access");
			return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			System.out.println("Limpieza de acceso");
			resource = null;
			person =  null;
		}
	}
	
	private boolean searchAccess(long idRole, long idResource) {
		Access access = null;
		try {
			access = accessService.getAccessById(idRole, idResource);
		} catch (Exception e) {
			System.out.println("No existe acceso");
			e.printStackTrace();
		}
		
		if (access!=null) {
			if (access.getAccessState() == 'A') return true;
			else System.out.println("Acceso desactivado");	
		}
		return false;
	}

}
