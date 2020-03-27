package com.yzl.study.spingboot.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.yzl.study.spingboot.model.SysLoginAcct;
import com.yzl.study.spingboot.model.SysLoginAcctExample;

public interface SysLogAcctService {

	long countByExample(SysLoginAcctExample example);

	int deleteByExample(SysLoginAcctExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SysLoginAcct record);

	int insertSelective(SysLoginAcct record);

	List<SysLoginAcct> selectByExampleWithRowbounds(SysLoginAcctExample example, RowBounds rowBounds);

	List<SysLoginAcct> selectByExample(SysLoginAcctExample example);

	SysLoginAcct selectByPrimaryKey(Integer id);

	int updateByExampleSelective(SysLoginAcct record, SysLoginAcctExample example);

	int updateByExample(SysLoginAcct record, SysLoginAcctExample example);

	int updateByPrimaryKeySelective(SysLoginAcct record);

	int updateByPrimaryKey(SysLoginAcct record);

	
	public SysLoginAcct login(SysLoginAcct acct);
	
}