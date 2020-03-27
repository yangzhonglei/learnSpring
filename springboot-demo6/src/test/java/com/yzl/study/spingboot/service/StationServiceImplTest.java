//package com.yzl.study.spingboot.service;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.yzl.study.spingboot.model.Station;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class StationServiceImplTest {
//	
//	
//	@Autowired
//	StationService stationService ;
//	
//	
//	@Test
//	@Rollback
//	@Transactional
//	public void createTest(){
//		 
//		Station entity  = new Station();
//		entity.setCode("20001");
//		entity.setName("testName");
//		entity.setStatus(0);
//		entity.setCreatedAt(new Date());
//		entity.setUpdatedAt(new Date());
//		int i = stationService.create(entity);
//		System.out.println("============"+i);
//		 assertEquals(i, 1);
//	}
//	
//	@Test
//	@Rollback
//	@Transactional
//	public void  removTest(){
//		
//		int i = stationService.remove(2);
//		System.out.println("============"+i);
//		assertEquals(i, 1);
//	}
//	
//	
//	@Test
//	@Rollback
//	@Transactional
//	public void  deleteByIdInBatchTest(){
//		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		int i = stationService.deleteByIdInBatch(list );
//		System.out.println("============"+i);
//		assertEquals(i, 2);
//	}
//	
//	
//	@Test
//	@Rollback
//	@Transactional
//	public void  updateByIdTest(){
//		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		list.add(2);
//		Station entity=stationService.queryById(2);
//		entity.setAddress("北京北京北京北京北京北京");
//		int i = stationService.updateById(entity);
//		Station entity2=stationService.queryById(2);
//		assertEquals(entity2.getAddress(), "北京北京北京北京北京北京");
//	}
//	@Test
//	@Rollback
//	@Transactional
//	public void updateByIdSelectiveTest(){
//		
//		Station entity=stationService.queryById(2);
//		entity.setAddress("北京北京北京北京北京北京");
//		
//		Station entity2= new Station();
//		entity2.setId(entity.getId());
//		entity2.setName(null);
//		entity2.setAddress(entity.getAddress()+"address");
//		int i = stationService.updateByIdSelective(entity2);
//		assertEquals(i, 1);
//		
//		Station entity3=stationService.queryById(2);
//		
//		assertEquals(entity3.getName(), entity.getName());
//		assertEquals(entity3.getAddress(), entity.getAddress()+"address");
//		
//	}
//	
////	@Test
////	public void  queryAllPagedTest(){
////		
////		Page  pageRowBounds = new Page (1,3,null,null) ;
////		List<Station> list  = stationService.queryAllPaged(pageRowBounds);
////		
////		assertEquals(list.size(), 3);
////	}
//	@Test
//	public void  queryByIdTest(){
//		
//		 Station s  = stationService.queryById(1);
//		 assertNotNull(s);
//	}
//		  
//
//}
