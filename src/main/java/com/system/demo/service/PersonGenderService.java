package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.PersonGender;

public interface PersonGenderService {
	
	public Optional<PersonGender> getGenderById(String genderId);

}
