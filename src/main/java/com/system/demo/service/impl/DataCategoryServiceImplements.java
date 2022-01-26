package com.system.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.model.DataCategory;
import com.system.demo.repository.DataCategoryRepository;
import com.system.demo.service.DataCategoryService;

@Service
@Transactional
public class DataCategoryServiceImplements implements DataCategoryService {
	
	@Autowired
	DataCategoryRepository dtaCategoryRepository;

	@Override
	public DataCategory createDataCategory(DataCategory dataCategory) throws Exception {
		return dtaCategoryRepository.save(dataCategory);
	}

}
