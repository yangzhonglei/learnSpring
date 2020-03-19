package study.yzl.com.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import study.yzl.com.model.SysMenu;
import study.yzl.com.service.BaseService;
import study.yzl.com.service.SysMenuService;
import study.yzl.com.web.vo.SysMenuRequestVO;


@Controller
@Slf4j
@RequestMapping("/menu")
@Validated
public class MenuController  extends CommonController<SysMenuRequestVO,SysMenu> {

	
	
	@Autowired
	SysMenuService sysMenuService;
	
	
	@Override
	protected BaseService<SysMenu> getBaseService() {
		return sysMenuService;
	}

	@Override
	public SysMenu getEntityInstance() {
		return new  SysMenu();
	}

	@Override
	public void createEntityProcesss(SysMenu entityObject) {
		Date date = new Date();
		entityObject.setCreatedAt(date);
		entityObject.setUpdatedAt(date);
	}

	@Override
	protected void updateEntitySelectiveProcesss(SysMenu entityObject) {
		
	}

	@Override
	protected void updateEntityProcesss(SysMenu entityObject) {
		Date date = new Date();
		entityObject.setUpdatedAt(date);
	}

	@Override
	protected String getClassShortName() {
		
		String classFullName = Thread.currentThread().getStackTrace()[1].getClassName();
		String clasShortName = classFullName.substring(classFullName.lastIndexOf(".") + 1);
		return clasShortName;
	}

}
