package com.yzl.study.spingboot.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzl.study.spingboot.dao.BaseDAO;
import com.yzl.study.spingboot.dao.StationMapper;
import com.yzl.study.spingboot.model.Station;
import com.yzl.study.spingboot.model.StationExample;
import com.yzl.study.spingboot.service.StationService;

@Service
public class StationServiceImpl  extends AbstractBaseService<Station,StationExample> implements StationService {

	
	
	@Autowired
	private StationMapper  stationMapper ;
	
	@Override
	protected BaseDAO<Station, StationExample> getBaseDAO() {
		
		return stationMapper;
	}


	@Override
	@Transactional
	public int create(Station entity) {
		Date  today = new Date();
		entity.setCreatedAt(today);
		entity.setUpdatedAt(today);
		entity.setStatus(0);
		
		return getBaseDAO().insert(entity);
	}
	
	
	
	
}
