package com.yzl.study.spingboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzl.study.spingboot.dao.BaseDAO;
import com.yzl.study.spingboot.dao.SysRoleMapper;
import com.yzl.study.spingboot.model.SysRole;
import com.yzl.study.spingboot.model.SysRoleExample;
import com.yzl.study.spingboot.service.SysRoleService;

@Service
public class SysRoleServiceImpl extends AbstractBaseService<SysRole,SysRoleExample>  implements SysRoleService  {

	
	@Autowired
	private SysRoleMapper  sysRoleMapper ;
	
	
	@Override
	protected BaseDAO<SysRole, SysRoleExample> getBaseDAO() {
		return sysRoleMapper;
	}
	
	 
	
	
	
	
	
	
}
