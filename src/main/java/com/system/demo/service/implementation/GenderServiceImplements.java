package com.system.demo.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.Gender;
import com.system.demo.persistence.repository.GenderRepository;
import com.system.demo.service.GenderService;

@Service
@Transactional
public class GenderServiceImplements implements GenderService{
	
	@Autowired
	GenderRepository genderRepository;

	@Override
	public Optional<Gender> getGenderById(String genderId) {
		return genderRepository.findById(genderId);
	}

}
