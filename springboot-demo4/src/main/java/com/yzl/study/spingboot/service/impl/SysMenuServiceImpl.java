package com.yzl.study.spingboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzl.study.spingboot.dao.BaseDAO;
import com.yzl.study.spingboot.dao.SysMenuMapper;
import com.yzl.study.spingboot.model.SysMenu;
import com.yzl.study.spingboot.model.SysMenuExample;
import com.yzl.study.spingboot.service.SysMenuService;

@Service
public class SysMenuServiceImpl extends AbstractBaseService<SysMenu,SysMenuExample>  implements SysMenuService  {


	@Autowired
	private SysMenuMapper  sysMenuMapper ;
	
	
	@Override
	protected BaseDAO<SysMenu, SysMenuExample> getBaseDAO() {
		// TODO Auto-generated method stub
		return sysMenuMapper;
	}


	@Override
	public List<SysMenu> selectByExample(SysMenuExample example) {
		 
		return sysMenuMapper.selectByExample(example);
	}


	
	
	
}
