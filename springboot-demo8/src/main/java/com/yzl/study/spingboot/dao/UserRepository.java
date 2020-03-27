package com.yzl.study.spingboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzl.study.spingboot.model.User;



public interface UserRepository extends JpaRepository<User,Long>{
	
}
