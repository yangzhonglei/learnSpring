//package com.yzl.study.spingboot.dao;
//
//import java.util.ArrayList;
//import java.util.Arrays;
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
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.alibaba.fastjson.JSON;
//import com.yzl.study.spingboot.model.User;
//
//import lombok.extern.slf4j.Slf4j;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
//public class UserRepositoryTest {
//	
//	
//	@Autowired
//	UserRepository userRepository ;
//	
//	
//	
//	@Test
//	public void findOneTest() {
//		
//		User u = userRepository.findOne(1) ;
//		System.out.println(JSON.toJSONString(u));
//		
//	}
//	
//	//findOne() 和 getOne(),就很像Hibernate中的load和get.
////	getOne：当我查询一个不存在的id数据时，直接抛出异常，因为它返回的是一个引用，简单点说就是一个代理对象。
////	所以说，如果想无论如何都有一个返回，那么就用findOne,否则使用getOne.
//	@Test
//	public void getOneTest() {
//		
//		User u = userRepository.getOne(1);
//		System.out.println(JSON.toJSONString(u));
//		
//	}
//	
//	@Test
//	public void findOneExampleTest() {
//		User uTmp = new User();
//		uTmp.setAge(5);
//		Example<User>  e =   Example.of(uTmp);
//		User u = userRepository.findOne(e);
//		System.out.println(JSON.toJSONString(u));
//	}
//	
//	@Test
//	public void findOneExampleTest2() {
//		User uTmp = new User();
//		uTmp.setName("evan");
//		
//		
//		ExampleMatcher matcher = ExampleMatcher.matching()
//				.withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());
//		Example<User>  e =   Example.of(uTmp,matcher);
//		
////		ExampleMatcher matcher = ExampleMatcher.matching()
////	            .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即{username}%
////	            .withMatcher("address" ,ExampleMatcher.GenericPropertyMatchers.contains())//全部模糊查询，即%{address}%
////	            .withIgnorePaths("password");//忽略字段，即不管password是什么值都不加入查询条件
//
//		List<User> list = userRepository.findAll(e);
//		  
//		  for (User u : list) {
//			  System.out.println(JSON.toJSONString(u));
//		}
//	
//	}
//	
//		  @Test
//		  public void findAllIdsTest() {
//			 
//			  Integer[] ids =  {6,7,8};
//			  List<Integer> list2 = Arrays.asList(ids);
//			  List<User> list = userRepository.findAll (list2);
//			  for (User u : list) {
//				  System.out.println(JSON.toJSONString(u));
//			  }
//		  }
//		  
//		  @Test
//		public void findAllSortTest() {
//	
//			Sort sort = new Sort(Sort.Direction.DESC, "name");
//			List<User> list = userRepository.findAll(sort);
//			for (User u : list) {
//				System.out.println(JSON.toJSONString(u));
//			}
//		}
//			  
//		  @Test
//		  public void countTest() {
//			  
//			    long count = userRepository.count() ;
//				  System.out.println(count);
//		  }
//		  
//		  
//		@Test
//		public void countExampleTest() {
//			User uTmp = new User();
//			uTmp.setName("evan");
//			ExampleMatcher matcher = ExampleMatcher.matching()
//					.withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());
//			Example<User>  e =   Example.of(uTmp,matcher);
//			long count = userRepository.count(e);
//			System.out.println(count);
//		}
//		
//		
//		
//		@Test
//		public void existsTest() {
//			User uTmp = new User();
//			uTmp.setName("evan");
//			ExampleMatcher matcher = ExampleMatcher.matching()
//					.withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());
//			Example<User>  e =   Example.of(uTmp,matcher);
//			boolean count = userRepository.exists(e);
//			System.out.println(count);
//		}
//		
//		@Test
//		public void findAllPageTest() {
//		
//			PageRequest prt = new PageRequest(1, 3);
//			Page<User> count = userRepository.findAll(prt);
//			System.out.println(JSON.toJSONString(count));
//		}
//		@Test
//		public void saveTest() {
//			
//			User uTmp = new User();
//			uTmp.setName("evan444");
//			 User save = userRepository.save (uTmp);
//			System.out.println(JSON.toJSONString(save));
//		}
//		//在saveAndFlush上，此命令中的更改将立即刷新到DB。使用save，就不一定了，它可能只暂时保留在内存中，直到发出flush或commit命令。
//		@Test
//		public void saveAndFlushTest() {
//			
//			User uTmp = new User();
//			uTmp.setName("evan444");
//			User save = userRepository.saveAndFlush(uTmp);
//			System.out.println(JSON.toJSONString(save));
//		}
//		  
//		@Test
//		public void saveListTest() {
//			
//			User uTmp = new User();
//			uTmp.setName("evan444");
//			User uTmp2 = new User();
//			uTmp2.setName("evan555");
//			User uTmp3 = new User();
//			uTmp3.setName("evan333");
//			
//			List<User> list = new ArrayList<User>();
//			list.add(uTmp);
//			list.add(uTmp2);
//			list.add(uTmp3);
//			
//			 List<User> save = userRepository.save(list);
//			System.out.println(JSON.toJSONString(save));
//		}
////		@Test
////		public void saveListTest() {
////			
////			User uTmp = new User();
////			uTmp.setName("evan444");
////			User uTmp2 = new User();
////			uTmp2.setName("evan555");
////			User uTmp3 = new User();
////			uTmp3.setName("evan333");
////			
////			List<User> list = new ArrayList<User>();
////			list.add(uTmp);
////			list.add(uTmp2);
////			list.add(uTmp3);
////			
////			List<User> save = userRepository
////			System.out.println(JSON.toJSONString(save));
////		}
//		
//		
//		@Test
//		public void findByNameTest() {
//			
//			List<User> save = userRepository.findByName("evan13");
//			System.out.println(JSON.toJSONString(save));
//		}
//		
//		
//		@Test
//		@Transactional
//		@Commit
//		public void updateNameByIdTest() {
//			
//			int updateNameById = userRepository.updateNameById("xxxxxx",6);
//			System.out.println(JSON.toJSONString(updateNameById));
//		}
//		
//		@Test
//		@Transactional
//		@Commit
//		public void findAndUpdateTest() {
//			
//			 User findOne = userRepository.findOne(6) ;
//			 findOne.setAge(100);
//			 userRepository.saveAndFlush(findOne);
//		}
//		
////		@Modifying
////		@Query("update ShopCoupon sc set sc.deleted = true where sc.id in :ids")
////		public void deleteByIds(@Param(value = "ids") List<String> ids);
//
//		
//		
//		
//		
//		  
//	    
//		  
//}
