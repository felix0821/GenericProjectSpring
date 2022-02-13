package com.system.demo.service;

import java.util.Optional;

import com.system.demo.persistence.entity.Gender;

public interface GenderService {
	
	public Optional<Gender> getGenderById(String genderId);

}
