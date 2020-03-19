package study.yzl.com.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import study.yzl.com.model.SysMenu;
import study.yzl.com.model.SysRole;
import study.yzl.com.service.BaseService;
import study.yzl.com.service.SysMenuService;
import study.yzl.com.service.SysRoleService;
import study.yzl.com.web.vo.SysMenuRequestVO;
import study.yzl.com.web.vo.SysRoleRequestVO;


@Controller
@Slf4j
@RequestMapping("/role")
@Validated
public class RoleController  extends CommonController<SysRoleRequestVO,SysRole> {

	
	
	@Autowired
	SysRoleService sysRoleService;
	
	
	@Override
	protected BaseService<SysRole> getBaseService() {
		return sysRoleService;
	}

	@Override
	public SysRole getEntityInstance() {
		return new  SysRole();
	}

	@Override
	public void createEntityProcesss(SysRole entityObject) {
		Date date = new Date();
		entityObject.setCreatedAt(date);
		entityObject.setUpdatedAt(date);
	}

	@Override
	protected void updateEntitySelectiveProcesss(SysRole entityObject) {
		
	}

	@Override
	protected void updateEntityProcesss(SysRole entityObject) {
		Date date = new Date();
		entityObject.setUpdatedAt(date);
		//TODO 逻辑上有问题  --- 先保证不报错
		entityObject.setCreatedAt(date);
	}

	@Override
	protected String getClassShortName() {
		
		String classFullName = Thread.currentThread().getStackTrace()[1].getClassName();
		String clasShortName = classFullName.substring(classFullName.lastIndexOf(".") + 1);
		return clasShortName;
	}

}
