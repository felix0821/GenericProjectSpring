package com.system.demo.service;

import com.system.demo.persistence.entity.DataCategory;

public interface DataCategoryService {
	
	public DataCategory createDataCategory(DataCategory dataCategory) throws Exception;
	
	public DataCategory getDataCategoryById(Long id) throws Exception;

}
