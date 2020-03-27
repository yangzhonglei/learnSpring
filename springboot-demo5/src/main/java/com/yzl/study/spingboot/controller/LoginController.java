package com.yzl.study.spingboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yzl.study.spingboot.model.SysLoginAcct;
import com.yzl.study.spingboot.model.SysUser;
import com.yzl.study.spingboot.service.SysLogAcctService;
import com.yzl.study.spingboot.service.SysUserService;
import com.yzl.study.spingboot.util.ResponseMessage;
import com.yzl.study.spingboot.vo.LoginRequestVO;
import com.yzl.study.spingboot.vo.validateGroup.Login;
import com.yzl.study.spingboot.vo.validateGroup.Logout;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/login")
@Validated
public class LoginController {
	
  @Autowired
  private SysLogAcctService sysLogAcctService ;
	
  @Autowired
  private SysUserService sysUserService ;
  
  @RequestMapping(path ="/login" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody()
  public Object login(@Validated({Login.class}) LoginRequestVO  loginRequestVO ,HttpSession session) {
  	
	log.info("login para:{}",JSON.toJSON(loginRequestVO));
	SysLoginAcct acct = new SysLoginAcct();
	acct.setAcct(loginRequestVO.getAcct());
	acct.setPassword(loginRequestVO.getPassword());
	SysLoginAcct resultAcct = sysLogAcctService.login(acct);
	if(resultAcct!=null) {
		
		SysUser sysUser =sysUserService.selectByPrimaryKey(resultAcct.getUserId());
		if(sysUser!=null) {
			// spring 会注入 session  没有则会创建session
			session.setAttribute("sysLoginAcct", resultAcct);
			session.setAttribute("sysUser", sysUser);
			//合适 ？
			Map<String,String> map = new HashMap<String,String>();
			map.put("name", sysUser.getName());
			map.put("userId", sysUser.getId().toString());
			return  ResponseMessage.successMessage(map);
		}
	}
  	return  ResponseMessage.failMessage("登录失败");
  }
  
  
  @RequestMapping(path ="/logout" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody()
  public Object logout(@Validated({Logout.class})  LoginRequestVO  loginRequestVO ,HttpServletRequest request) {
	  
	  log.info("login para:{}",JSON.toJSON(loginRequestVO));
      HttpSession session = request.getSession(false);
      if(session!=null) {
    	  session.invalidate();
      }
	  return  ResponseMessage.successMessage(null);
  }
  

  
  
  
}
