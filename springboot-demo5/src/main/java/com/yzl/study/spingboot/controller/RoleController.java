package com.yzl.study.spingboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yzl.study.spingboot.model.SysRole;
import com.yzl.study.spingboot.service.BaseService;
import com.yzl.study.spingboot.service.SysRoleService;
import com.yzl.study.spingboot.vo.SysRoleRequestVO;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
@RequestMapping("/role")
@Validated
public class RoleController  {

	
	
	@Autowired
	SysRoleService sysRoleService;
	
	

}
