package com.yzl.study.spingboot.dao;

import org.springframework.stereotype.Repository;

import com.yzl.study.spingboot.model.User;

import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User> {
	
	
	public  User myselect();
	
}