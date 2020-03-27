//package com.yzl.study.spingboot.dao;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import org.apache.ibatis.session.RowBounds;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Order;
//import org.springframework.test.annotation.Commit;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.alibaba.fastjson.JSON;
//import com.yzl.study.spingboot.model.Station;
//import com.yzl.study.spingboot.model.User;
//
//import lombok.extern.slf4j.Slf4j;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class StationRepositoryTest {
//	
//	
//	@Autowired
//	StationRepository stationRepository ;
//	
//	
//	
//	@Test
//	public void findOneTest() {
//		
//		Station u = stationRepository.findOne(1) ;
//		System.out.println(JSON.toJSONString(u));
//		
//	}
//	@Test
//	@Transactional
//	@Rollback
//	public void saveAndFlushTest() {
//		
//		Station  entity  = new Station();
//		entity.setAddress("aaa");
//		entity.setCreatedAt(new Date());
//		entity.setName("aaa");
//		entity.setStatus(0);
//		entity.setUpdatedAt(new Date());
//		entity.setCode("888999777");
//		Station u = stationRepository.saveAndFlush( entity  );
//		System.out.println(JSON.toJSONString(u));
//		
//	}
//	
//		
//		
//		
//		
//		  
//	    
//		  
//}
