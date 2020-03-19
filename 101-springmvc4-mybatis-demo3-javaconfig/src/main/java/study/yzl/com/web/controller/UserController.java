package study.yzl.com.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.metadata.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageRowBounds;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;
import study.yzl.com.model.SysMenu;
import study.yzl.com.model.SysUser;
import study.yzl.com.model.SysUserExample;
import study.yzl.com.service.SysUserService;
import study.yzl.com.utils.ResponseMessage;
import study.yzl.com.web.Page;
import study.yzl.com.web.vo.UserRequestVO;
import study.yzl.com.web.vo.validateGroup.UserAddUser;
import study.yzl.com.web.vo.validateGroup.UserFindByConditionPaged;
import study.yzl.com.web.vo.validateGroup.UserUpdateUser;

@Slf4j
@Controller
@RequestMapping("/user")
@Validated
public class UserController {
	
	
  @Autowired
  private SysUserService sysUserService ;
  
  
  
  @GetMapping(path ="/getUserMenu" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(value = "查询用户菜单", notes = "查询用户菜单notes" )
  public Object getUserMenu(@Validated() @NotNull @Digits(integer = 7, fraction = 0) Integer userId , @ApiIgnore  HttpSession session ) {
  	
	log.info("login para:{}");
	 SysUser sysUser =(SysUser) session.getAttribute("sysUser");
	 //测试注释掉
//	 if(sysUser == null ||  sysUser.getId() == userId ) {
//		 
//		 return  ResponseMessage.successMessage("只允许获取当前已登录用户的数据");
//		 
//	 }
	 List<SysMenu> menuList = sysUserService.getUserMenu(userId);
	 List<SysMenu> treeMenu = SysMenu.parseMenuTree(menuList);
  	return  ResponseMessage.successMessage(treeMenu);
  }
  
  
  
  
//  ​@ApiOperation(value="Find pet by Status",​notes="${SomeController.findPetsByStatus.notes}")
//  ​@RequestMapping(value ="/findByStatus",method=RequestMethod.POST, params = {"status"})
  
  @PostMapping(path ="/addUser" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
  @ResponseBody()
  public Object addUser(@Validated({UserAddUser.class}) UserRequestVO userRequestVO ) {
	  
	  log.info("======login para:{}",JSON.toJSON(userRequestVO));
	  
	  Date date = new Date();
	  SysUser usr = new SysUser();
	  usr.setCellphone(userRequestVO.getCellphone());
	  usr.setCode(userRequestVO.getCode());
	  usr.setDept(userRequestVO.getDept());
	  usr.setEmail(userRequestVO.getEmail());
	  usr.setName(userRequestVO.getName());
	  usr.setSex(userRequestVO.getSex());
	  usr.setTel(userRequestVO.getTel());
	  usr.setUpdatedAt(date);
	  usr.setCreatedAt(date);
	  
	  sysUserService.insert(usr);
	  Map map = new HashMap();
	  map.put("userId", usr.getId());
	  return  ResponseMessage.successMessage(usr);
  }
  
  
  @PostMapping(path ="/delUser" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
  @ResponseBody()
  public Object delUser(@Validated() @NotNull  @Digits(integer = 7, fraction = 0) Integer userId) {
	  
	  log.info("login para:{}",userId);
	  
	  //真的删除
	  //sysUserService.deleteByPrimaryKey(userId);
	  //标记状态  
	  SysUser record = new SysUser();
	  record.setId(userId);
	  record.setUpdatedAt( new Date());
	  record.setDeletedAt( new Date());
	  
	  int updateRows=sysUserService.updateByPrimaryKeySelective(record);
	  if(updateRows==0) {
		  return  ResponseMessage.failMessage("要删除的记录不存在");
	  }
	  
	  return  ResponseMessage.successMessage(null);
  }
  
  @PostMapping(path ="/updateUser" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
  @ResponseBody()
  public Object updateUser(@Validated({UserUpdateUser.class}) UserRequestVO userRequestVO) {
	  
	  log.info("login para:{}",JSON.toJSON(userRequestVO));
	  
	    SysUser record = new SysUser();
	    record.setId(userRequestVO.getId());
	    record.setName(userRequestVO.getName());
	    record.setSex(userRequestVO.getSex());
	    record.setDept(userRequestVO.getDept());
	    record.setTel(userRequestVO.getTel());
	    record.setCellphone(userRequestVO.getCellphone());
	    record.setEmail(userRequestVO.getEmail());
	    record.setUserAddr(userRequestVO.getUserAddr());
	    record.setUpdatedAt(new Date());
	    
	  int updateRows=sysUserService.updateByPrimaryKeySelective(record);
	  if(updateRows==0) {
		  return  ResponseMessage.failMessage("要修改的记录不存在");
	  }
	  
	  return  ResponseMessage.successMessage(null);
  }
  
  //这里应当严格限制  这样暴露不好
  //TODO   condition 统一条件查询
  @GetMapping(path ="/findUserById" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
  @ResponseBody()
  public Object findUserById(@Validated()   @NotNull  @Digits(integer = 7, fraction = 0) Integer userId ) {
	  
	  log.info("login para:{}",JSON.toJSON(userId));
	  
	  SysUserExample example = new SysUserExample();
	  example.createCriteria().andIdEqualTo(userId);
	  List<SysUser>  list = sysUserService.selectByExample(example );
	  if(list!=null && list.size()==1) {
		  return   ResponseMessage.successMessage(list.get(0));
	  }
	  return  ResponseMessage.successMessage(null);
	  
  }
  //这里应当严格限制  这样暴露不好
  //TODO   condition 统一条件查询
  @PostMapping(path ="/findByConditionPaged" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
  @ResponseBody()
  public Object findByConditionPaged(@Validated({UserFindByConditionPaged.class}) UserRequestVO userRequestVO ,@Validated Page<List<SysUser>> page) {
	  
	  log.info("login para:{}",JSON.toJSON(userRequestVO));
	  SysUserExample example = new SysUserExample();
	  example.or().andNameLike("%" + userRequestVO.getName() + "%");
	  example.or().andCellphoneLike("%" + userRequestVO.getCellphone() + "%");
	  PageRowBounds pageRowBounds = new PageRowBounds((page.getPageNo()-1)*page.getPageSize(), page.getPageSize()) ;
	  List<SysUser>  list = sysUserService.selectByExampleWithRowbounds(example, pageRowBounds);
	  page.setObject(list);
	  page.setTotal(pageRowBounds.getTotal().intValue());
	  return  ResponseMessage.successMessage(page);
  }
  
  
  
}
