package com.system.demo.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.PersonGender;
import com.system.demo.persistence.repository.PersonGenderRepository;
import com.system.demo.service.PersonGenderService;

@Service
@Transactional
public class GenderServiceImplements implements PersonGenderService{
	
	@Autowired
	PersonGenderRepository personGenderRepository;

	@Override
	public Optional<PersonGender> getGenderById(String genderId) {
		return personGenderRepository.findById(genderId);
	}

}
