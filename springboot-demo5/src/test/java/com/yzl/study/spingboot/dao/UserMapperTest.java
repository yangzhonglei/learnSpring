package com.yzl.study.spingboot.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.yzl.study.spingboot.model.User;
import com.yzl.study.spingboot.service.StationServiceImplTest;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapperTest {
	
	
	@Autowired
	UserMapper userMapper ;
	
	
	
	@Test
	public void selectTest() {
		
		User record =new User();
		record.setName("evan12");
		record.setAge(22);
		List<User> list = userMapper.select(record );
		for (User u : list) {
			System.out.println(JSON.toJSONString(u));
		}
	}
	
	
	
	
	@Test
	public void selectAllTest() {
		
		User record =new User();
		record.setName("evan12");
		record.setAge(22);
		List<User> list = userMapper.selectAll();
		for (User u : list) {
			System.out.println(JSON.toJSONString(u));
			
		}
		
	}		
	
	@Test
	public void selectByPrimaryKeyTest() {
		
		User record =new User();
		record.setName("evan12");
		record.setAge(22);
		 User u = userMapper.selectByPrimaryKey(1);
			System.out.println(JSON.toJSONString(u));
	}
	
	
	@Test
	public void selectOneTest() {
		
		User record =new User();
		record.setName("evan12");
		record.setAge(44);
		User u = userMapper.selectOne(record);
		System.out.println(JSON.toJSONString(u));
	}
	
	@Test
	public void selectCountTest() {
		
		User record =new User();
		record.setName("evan12");
		record.setAge(44);
		 userMapper.selectCount(record);
	}
	
	
	
	@Test
	public void selectByRowBoundsTest() {
		
		User record =new User();
		record.setName("evan12");
		record.setAge(22);
		RowBounds  rowBounds = new RowBounds(0,1);
		List<User> list = userMapper.selectByRowBounds(record, rowBounds);
		for (User u : list) {
			System.out.println(JSON.toJSONString(u));
		}
	}
	
	
	@Test
	public void insertTest() {
		
		User record =new User();
		record.setName("evan12");
		record.setAge(22);
		RowBounds  rowBounds = new RowBounds(0,1);
		int list = userMapper.insert(record);
		 
	}
	@Test
	public void insertSelectiveTest() {
		
		User record =new User();
		record.setName("evan12");
//		record.setAge(22);
		RowBounds  rowBounds = new RowBounds(0,1);
		int list = userMapper.insertSelective(record);
		
	}
	
	@Test
	public void deleteTest() {
		
		User record =new User();
		record.setName("evan12");
		record.setAge(22);
		int list = userMapper.delete(record);
		
	}
	@Test
	public void deleteTest2() {
		
		User record =new User();
		record.setName("evan12");
		int list = userMapper.delete(record);
		
	}
	
	
	@Test
	public void deleteByPrimaryKeyTest() {
		
		int list = userMapper.deleteByPrimaryKey(3);
	}
	
	
	
}
