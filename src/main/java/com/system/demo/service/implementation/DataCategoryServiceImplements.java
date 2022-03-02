package com.system.demo.service.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.DataCategory;
import com.system.demo.persistence.repository.DataCategoryRepository;
import com.system.demo.service.DataCategoryService;

@Service
@Transactional
public class DataCategoryServiceImplements implements DataCategoryService {
	
	@Autowired
	DataCategoryRepository dtaCategoryRepository;

	@Override
	public DataCategory createDataCategory(DataCategory dataCategory) throws Exception {
		// TODO Auto-generated method stub
		return dtaCategoryRepository.save(dataCategory);
	}

	@Override
	public DataCategory getDataCategoryById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return dtaCategoryRepository.findById(id).orElseThrow();
	}

}
