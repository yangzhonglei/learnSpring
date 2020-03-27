package com.yzl.study.spingboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yzl.study.spingboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<com.yzl.study.spingboot.model.User, Integer> {

	
	
	public  List<User> findByName(String name);
	
	
	
	@Modifying
	@Query("update user as c set c.name = ?1 where c.id=?2")
	int updateNameById(String name, int id);
	
	
}
