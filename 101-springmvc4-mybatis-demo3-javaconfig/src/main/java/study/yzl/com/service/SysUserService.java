package study.yzl.com.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;

import study.yzl.com.model.SysMenu;
import study.yzl.com.model.SysUser;
import study.yzl.com.model.SysUserExample;

public interface SysUserService {

	long countByExample(SysUserExample example);

	int deleteByExample(SysUserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	List<SysUser> selectByExampleWithRowbounds(SysUserExample example, RowBounds rowBounds);

	List<SysUser> selectByExample(SysUserExample example);

	SysUser selectByPrimaryKey(Integer id);

	int updateByExampleSelective(SysUser record, SysUserExample example);

	int updateByExample(SysUser record, SysUserExample example);

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);
	
	
	public  List<SysMenu> getUserMenu(Integer userId);

}