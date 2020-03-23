package com.yzl.study.spingboot.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzl.study.spingboot.dao.SysUserRoleRelaMapper;
import com.yzl.study.spingboot.model.SysUserRoleRela;
import com.yzl.study.spingboot.model.SysUserRoleRelaExample;
import com.yzl.study.spingboot.service.SysUserRoleRelaService;

@Service
public class SysUserRoleRelaServiceImpl implements SysUserRoleRelaService  {
	
	
	@Autowired
	private  SysUserRoleRelaMapper sysUserRoleRelaMapper ;

	@Override
	public long countByExample(SysUserRoleRelaExample example) {
		return sysUserRoleRelaMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysUserRoleRelaExample example) {
		return sysUserRoleRelaMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return sysUserRoleRelaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysUserRoleRela record) {
		return sysUserRoleRelaMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUserRoleRela record) {
		return sysUserRoleRelaMapper.insertSelective(record);
	}

	@Override
	public List<SysUserRoleRela> selectByExampleWithRowbounds(SysUserRoleRelaExample example, RowBounds rowBounds) {
		return sysUserRoleRelaMapper.selectByExampleWithRowbounds(example, rowBounds);
	}

	@Override
	public List<SysUserRoleRela> selectByExample(SysUserRoleRelaExample example) {
		return sysUserRoleRelaMapper.selectByExample(example);
	}

	@Override
	public SysUserRoleRela selectByPrimaryKey(Integer id) {
		return sysUserRoleRelaMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SysUserRoleRela record, SysUserRoleRelaExample example) {
		return sysUserRoleRelaMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(SysUserRoleRela record, SysUserRoleRelaExample example) {
		return sysUserRoleRelaMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUserRoleRela record) {
		return sysUserRoleRelaMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysUserRoleRela record) {
		return sysUserRoleRelaMapper.updateByPrimaryKey(record);
	}
	
	
	
	

}
