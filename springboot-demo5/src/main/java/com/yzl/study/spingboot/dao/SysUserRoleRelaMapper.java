package com.yzl.study.spingboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.yzl.study.spingboot.model.SysUserRoleRela;
import com.yzl.study.spingboot.model.SysUserRoleRelaExample;

public interface SysUserRoleRelaMapper {
    long countByExample(SysUserRoleRelaExample example);

    int deleteByExample(SysUserRoleRelaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRoleRela record);

    int insertSelective(SysUserRoleRela record);

    List<SysUserRoleRela> selectByExampleWithRowbounds(SysUserRoleRelaExample example, RowBounds rowBounds);

    List<SysUserRoleRela> selectByExample(SysUserRoleRelaExample example);

    SysUserRoleRela selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUserRoleRela record, @Param("example") SysUserRoleRelaExample example);

    int updateByExample(@Param("record") SysUserRoleRela record, @Param("example") SysUserRoleRelaExample example);

    int updateByPrimaryKeySelective(SysUserRoleRela record);

    int updateByPrimaryKey(SysUserRoleRela record);
}