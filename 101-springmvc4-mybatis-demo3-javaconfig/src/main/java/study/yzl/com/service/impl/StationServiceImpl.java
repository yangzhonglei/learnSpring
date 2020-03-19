package study.yzl.com.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study.yzl.com.dao.BaseDAO;
import study.yzl.com.dao.StationMapper;
import study.yzl.com.model.Station;
import study.yzl.com.model.StationExample;
import study.yzl.com.service.BaseService;
import study.yzl.com.service.StationService;

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
		getBaseDAO().insert(entity);
		return 0;
	}
	
	
	
	
}
