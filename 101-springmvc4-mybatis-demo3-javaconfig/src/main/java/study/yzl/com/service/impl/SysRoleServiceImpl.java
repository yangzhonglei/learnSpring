package study.yzl.com.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study.yzl.com.dao.BaseDAO;
import study.yzl.com.dao.SysMenuMapper;
import study.yzl.com.dao.SysRoleMapper;
import study.yzl.com.model.SysMenu;
import study.yzl.com.model.SysMenuExample;
import study.yzl.com.model.SysRole;
import study.yzl.com.model.SysRoleExample;
import study.yzl.com.service.SysMenuService;
import study.yzl.com.service.SysRoleService;

@Service
public class SysRoleServiceImpl extends AbstractBaseService<SysRole,SysRoleExample>  implements SysRoleService  {

	
	@Autowired
	private SysRoleMapper  sysRoleMapper ;
	
	
	@Override
	protected BaseDAO<SysRole, SysRoleExample> getBaseDAO() {
		return sysRoleMapper;
	}
	
	 
	
	
	
	
	
	
}
