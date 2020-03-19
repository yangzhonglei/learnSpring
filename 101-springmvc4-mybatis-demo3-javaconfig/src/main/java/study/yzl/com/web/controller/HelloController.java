package study.yzl.com.web.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.apache.ibatis.session.RowBounds;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageRowBounds;

import lombok.extern.slf4j.Slf4j;

//import study.yzl.com.dao.BillMapper;
//import study.yzl.com.dao.DeviceMapper;
//import study.yzl.com.dao.FileMapper;
//import study.yzl.com.dao.RoleMapper;
//import study.yzl.com.model.Bill;
//import study.yzl.com.model.DevicePOJO;
//import study.yzl.com.model.File;
//import study.yzl.com.model.Lecture;
//import study.yzl.com.model.LectureExample;
//import study.yzl.com.model.Role;
//import study.yzl.com.service.LectureService;
//import study.yzl.com.service.RoleService;

@Controller
@Slf4j
@Validated
public class HelloController {

	
  @RequestMapping(path ="/hello" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody()
  public Object hello(Model model) {
  	
  	
  	return "3333" ;
  }
	
  @RequestMapping(value = "/validator2")
  public String testValidator2( @NotBlank(message = "name不能为空") @Length(min=5,max=10)  String name){
	  //System.out.println(bindingResult.hasErrors());
	  log.info("===================="+name);
      return "校验成功...";
  }
	
//	
//	@Autowired
//	RoleService roleService ;
//	@Autowired
//	LectureService lectureService ;
//	 
//
//    @RequestMapping(path ="/updateRole" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody()
//    public Object updateRole(Model model) {
//    	
//    	Role role = new Role();
//    	role.setId(2);
//    	role.setNote("new note2"+ System.currentTimeMillis());
//    	role.setRoleName("new name2"+System.currentTimeMillis());
//    	int i = roleService.updateRole(role);
//    	System.out.println(i);
//    	return role ;
//    }
//    @RequestMapping(path ="/" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody()
//    public Object home(Model model) {
//    	
//    	Role role = new Role();
//    	role.setId(2);
//    	role.setNote("new note2"+ System.currentTimeMillis());
//    	role.setRoleName("new name2"+System.currentTimeMillis());
//    	int i = roleService.updateRole(role);
//    	System.out.println(i);
//    	return role ;
//    }
//    
//    @RequestMapping(path ="/testLecture" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody()
//    public Object testLecture(Model model) {
//    	
//    	
//    	LectureExample example = new LectureExample();
//    	example.createCriteria().andIdEqualTo(1);
//    	List<Lecture> list = lectureService.selectByExample(example );
//    	
//    	return list ;
//    }
    
    
}
