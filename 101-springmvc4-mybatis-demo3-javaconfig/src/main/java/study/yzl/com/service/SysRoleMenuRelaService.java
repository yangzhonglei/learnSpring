package study.yzl.com.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import study.yzl.com.model.SysRoleMenuRela;
import study.yzl.com.model.SysRoleMenuRelaExample;

public interface SysRoleMenuRelaService {

	long countByExample(SysRoleMenuRelaExample example);

	int deleteByExample(SysRoleMenuRelaExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SysRoleMenuRela record);

	int insertSelective(SysRoleMenuRela record);

	List<SysRoleMenuRela> selectByExampleWithRowbounds(SysRoleMenuRelaExample example, RowBounds rowBounds);

	List<SysRoleMenuRela> selectByExample(SysRoleMenuRelaExample example);

	SysRoleMenuRela selectByPrimaryKey(Integer id);

	int updateByExampleSelective(SysRoleMenuRela record, SysRoleMenuRelaExample example);

	int updateByExample(SysRoleMenuRela record, SysRoleMenuRelaExample example);

	int updateByPrimaryKeySelective(SysRoleMenuRela record);

	int updateByPrimaryKey(SysRoleMenuRela record);

}