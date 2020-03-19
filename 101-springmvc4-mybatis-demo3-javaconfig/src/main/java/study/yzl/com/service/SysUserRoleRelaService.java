package study.yzl.com.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import study.yzl.com.model.SysUserRoleRela;
import study.yzl.com.model.SysUserRoleRelaExample;

public interface SysUserRoleRelaService {

	long countByExample(SysUserRoleRelaExample example);

	int deleteByExample(SysUserRoleRelaExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SysUserRoleRela record);

	int insertSelective(SysUserRoleRela record);

	List<SysUserRoleRela> selectByExampleWithRowbounds(SysUserRoleRelaExample example, RowBounds rowBounds);

	List<SysUserRoleRela> selectByExample(SysUserRoleRelaExample example);

	SysUserRoleRela selectByPrimaryKey(Integer id);

	int updateByExampleSelective(SysUserRoleRela record, SysUserRoleRelaExample example);

	int updateByExample(SysUserRoleRela record, SysUserRoleRelaExample example);

	int updateByPrimaryKeySelective(SysUserRoleRela record);

	int updateByPrimaryKey(SysUserRoleRela record);

}