package com.yzl.study.spingboot.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.yzl.study.spingboot.model.SysMenu;
import com.yzl.study.spingboot.model.SysMenuExample;


public interface SysMenuMapper  extends BaseDAO <SysMenu , SysMenuExample >{
    
}