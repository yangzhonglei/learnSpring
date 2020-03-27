package com.yzl.study.spingboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzl.study.spingboot.dao.SysUserMapper;
import com.yzl.study.spingboot.model.SysMenu;
import com.yzl.study.spingboot.model.SysMenuExample;
import com.yzl.study.spingboot.model.SysRoleMenuRela;
import com.yzl.study.spingboot.model.SysRoleMenuRelaExample;
import com.yzl.study.spingboot.model.SysUser;
import com.yzl.study.spingboot.model.SysUserExample;
import com.yzl.study.spingboot.model.SysUserRoleRela;
import com.yzl.study.spingboot.model.SysUserRoleRelaExample;
import com.yzl.study.spingboot.service.SysMenuService;
import com.yzl.study.spingboot.service.SysRoleMenuRelaService;
import com.yzl.study.spingboot.service.SysUserRoleRelaService;
import com.yzl.study.spingboot.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	
	
	@Autowired
	private SysMenuService  sysMenuService;
	@Autowired
	private SysRoleMenuRelaService  sysRoleMenuRelaService;
	@Autowired
	private SysUserRoleRelaService  sysUserRoleRelaService;
	
	@Autowired
	private SysUserMapper  sysUserMapper;

	@Override
	public long countByExample(SysUserExample example) {
		return sysUserMapper.countByExample(example);
	}
    @Override
	@Transactional
	public int deleteByExample(SysUserExample example) {
		return sysUserMapper.deleteByExample(example);
	}
    @Override
	@Transactional
	public int deleteByPrimaryKey(Integer id) {
		return sysUserMapper.deleteByPrimaryKey(id);
	}
    @Override
	@Transactional
	public int insert(SysUser record) {
		return sysUserMapper.insert(record);
	}
    @Override
	@Transactional
	public int insertSelective(SysUser record) {
		return sysUserMapper.insertSelective(record);
	}

	@Override
	public List<SysUser> selectByExampleWithRowbounds(SysUserExample example, RowBounds rowBounds) {
		return sysUserMapper.selectByExampleWithRowbounds(example, rowBounds);
	}

	@Override
	public List<SysUser> selectByExample(SysUserExample example) {
		return sysUserMapper.selectByExample(example);
	}

	@Override
	public SysUser selectByPrimaryKey(Integer id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
	@Override
	@Transactional
	public int updateByExampleSelective(SysUser record, SysUserExample example) {
		return sysUserMapper.updateByExampleSelective(record, example);
	}
	@Override
	@Transactional
	public int updateByExample(SysUser record, SysUserExample example) {
		return sysUserMapper.updateByExample(record, example);
	}
	@Override
	@Transactional
	public int updateByPrimaryKeySelective(SysUser record) {
		return sysUserMapper.updateByPrimaryKeySelective(record);
	}
	@Override
	@Transactional
	public int updateByPrimaryKey(SysUser record) {
		return sysUserMapper.updateByPrimaryKey(record);
	}
	
	
	
	
	@Override
	public List<SysMenu> getUserMenu(Integer userId) {
		
		List<SysMenu> listMenu = null ;
		SysUserRoleRelaExample example = new SysUserRoleRelaExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<SysUserRoleRela> urList = sysUserRoleRelaService.selectByExample(example );
		
		List<Integer> roleIdS = new ArrayList<Integer>();
		for(SysUserRoleRela s:urList) {
			
			roleIdS.add(s.getRoleId());
		}
		if(roleIdS.size()>0 ) {
			
			SysRoleMenuRelaExample example2 = new SysRoleMenuRelaExample();
			example2.createCriteria().andRoleIdIn(roleIdS);
			List<SysRoleMenuRela> rmList =  sysRoleMenuRelaService.selectByExample(example2 );
			
			List<Integer> menuIdS = new ArrayList<Integer>();
			for(SysRoleMenuRela m:rmList) {
				
				menuIdS.add(m.getMenuId());
			}
			if(menuIdS.size()>0 ) {
				SysMenuExample example3 = new SysMenuExample();
				example3.createCriteria().andIdIn(menuIdS);
				example3.setOrderByClause("id ASC,menu_id ASC");
				listMenu = sysMenuService.selectByExample(example3 );
				
			}
		}
		
		return listMenu;
	}
	
	
	
	

}
