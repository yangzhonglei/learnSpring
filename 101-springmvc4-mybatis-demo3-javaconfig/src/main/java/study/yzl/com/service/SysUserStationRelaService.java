package study.yzl.com.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import study.yzl.com.model.SysUserStationRela;
import study.yzl.com.model.SysUserStationRelaExample;

public interface SysUserStationRelaService {

	long countByExample(SysUserStationRelaExample example);

	int deleteByExample(SysUserStationRelaExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(SysUserStationRela record);

	int insertSelective(SysUserStationRela record);

	List<SysUserStationRela> selectByExampleWithRowbounds(SysUserStationRelaExample example, RowBounds rowBounds);

	List<SysUserStationRela> selectByExample(SysUserStationRelaExample example);

	SysUserStationRela selectByPrimaryKey(Integer id);

	int updateByExampleSelective(SysUserStationRela record, SysUserStationRelaExample example);

	int updateByExample(SysUserStationRela record, SysUserStationRelaExample example);

	int updateByPrimaryKeySelective(SysUserStationRela record);

	int updateByPrimaryKey(SysUserStationRela record);

}