package com.yzl.study.spingboot.service;

import java.util.List;

import com.yzl.study.spingboot.model.SysMenu;
import com.yzl.study.spingboot.model.SysMenuExample;

public interface SysMenuService  extends BaseService <SysMenu>{

	List<SysMenu> selectByExample(SysMenuExample example);


}