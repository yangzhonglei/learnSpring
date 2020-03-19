package study.yzl.com.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import study.yzl.com.model.Station;
import study.yzl.com.service.BaseService;
import study.yzl.com.service.StationService;
import study.yzl.com.service.SysLogAcctService;
import study.yzl.com.service.impl.AbstractBaseService;
import study.yzl.com.utils.ResponseMessage;
import study.yzl.com.web.SysConstants;
import study.yzl.com.web.vo.RequestVO;
import study.yzl.com.web.vo.StationRequestVO;

@Controller
@Slf4j
@RequestMapping("/station")
@Validated
public class StationController extends CommonController<StationRequestVO,Station> {
	
	
	@Autowired
	StationService  stationService ;
	
	@Override
	protected String getClassShortName() {
		
		String classFullName = Thread.currentThread().getStackTrace()[1].getClassName();
		String clasShortName = classFullName.substring(classFullName.lastIndexOf(".") + 1);
		return clasShortName;
	}

	@Override
	protected BaseService getBaseService() {
		return   stationService;
	}

	@Override
	public Station getEntityInstance() {
		return new Station();
	}

	@Override
	public void createEntityProcesss(Station entityObject) {
		Date date = new Date();
		entityObject.setCreatedAt(date);
		entityObject.setUpdatedAt(date);
		entityObject.setStatus(0);
		
	}
	
	@Override
	public Object removeById(Integer id) {
		
		return "555";
	}

	@Override
	protected void updateEntityProcesss(Station entityObject) {
		 
		entityObject.setUpdatedAt(new Date());
		entityObject.setCreatedAt(new Date());
	}

	@Override
	protected void updateEntitySelectiveProcesss(Station entityObject) {
//		entityObject.setId(9);
//		entityObject.setName("tomcat111");
//		System.out.println("============="+entityObject.getCode());
		
	}

}
