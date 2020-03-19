package study.yzl.com.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study.yzl.com.dao.BaseDAO;
import study.yzl.com.dao.StationMapper;
import study.yzl.com.dao.SysMenuMapper;
import study.yzl.com.model.Station;
import study.yzl.com.model.StationExample;
import study.yzl.com.model.SysMenu;
import study.yzl.com.model.SysMenuExample;
import study.yzl.com.service.SysMenuService;

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
