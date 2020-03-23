package com.yzl.study.spingboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.yzl.study.spingboot.model.SysUserStationRela;
import com.yzl.study.spingboot.model.SysUserStationRelaExample;

public interface SysUserStationRelaMapper {
    long countByExample(SysUserStationRelaExample example);

    int deleteByExample(SysUserStationRelaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserStationRela record);

    int insertSelective(SysUserStationRela record);

    List<SysUserStationRela> selectByExampleWithRowbounds(SysUserStationRelaExample example, RowBounds rowBounds);

    List<SysUserStationRela> selectByExample(SysUserStationRelaExample example);

    SysUserStationRela selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUserStationRela record, @Param("example") SysUserStationRelaExample example);

    int updateByExample(@Param("record") SysUserStationRela record, @Param("example") SysUserStationRelaExample example);

    int updateByPrimaryKeySelective(SysUserStationRela record);

    int updateByPrimaryKey(SysUserStationRela record);
}