package study.yzl.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import study.yzl.com.model.SysLoginAcct;
import study.yzl.com.model.SysLoginAcctExample;

public interface SysLoginAcctMapper {
    long countByExample(SysLoginAcctExample example);

    int deleteByExample(SysLoginAcctExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysLoginAcct record);

    int insertSelective(SysLoginAcct record);

    List<SysLoginAcct> selectByExampleWithRowbounds(SysLoginAcctExample example, RowBounds rowBounds);

    List<SysLoginAcct> selectByExample(SysLoginAcctExample example);

    SysLoginAcct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysLoginAcct record, @Param("example") SysLoginAcctExample example);

    int updateByExample(@Param("record") SysLoginAcct record, @Param("example") SysLoginAcctExample example);

    int updateByPrimaryKeySelective(SysLoginAcct record);

    int updateByPrimaryKey(SysLoginAcct record);
}