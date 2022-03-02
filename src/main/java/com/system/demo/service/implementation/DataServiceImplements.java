package com.system.demo.service.implementation;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.demo.persistence.entity.Data;
import com.system.demo.persistence.repository.DataRepository;
import com.system.demo.service.DataService;

@Service
@Transactional
public class DataServiceImplements implements DataService {
	
	@Autowired
	DataRepository dataRepository;

	@Override
	public Iterable<Data> getDatasByRequisitionId(Long RequisitionId) {
		// TODO Auto-generated method stub
		return dataRepository.findByRequisitionId(RequisitionId);
	}
	
	@Override
	public Data createData(Data data) throws Exception {
		// TODO Auto-generated method stub
		return dataRepository.save(data);
	}

	@Override
	public Optional<Data> getDataById(Long dataId) {
		// TODO Auto-generated method stub
		return dataRepository.findById(dataId);
	}

	@Override
	public Optional<Data> getDataByProgramIdAndReferenceId(Long programId, Long dataReferenceId) {
		// TODO Auto-generated method stub
		return dataRepository.findByProgramIdAndReferenceId(programId, dataReferenceId);
	}

	@Override
	public Optional<Data> getDataByPeriodIdAndReferenceId(Long periodId, Long dataReferenceId) {
		// TODO Auto-generated method stub
		return dataRepository.findByPeriodIdAndReferenceId(periodId, dataReferenceId);
	}

	@Override
	public Optional<Data> getDataByReferenceId(Long dataReferenceId) {
		// TODO Auto-generated method stub
		return dataRepository.findByReferenceId(dataReferenceId);
	}


}
