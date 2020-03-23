package com.yzl.study.spingboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzl.study.spingboot.model.Station;
import com.yzl.study.spingboot.service.StationService;
import com.yzl.study.spingboot.vo.User;

@Controller
public class HelloWorldController {
	
	
	@Autowired
	private StationService stationService ;
	
	
	
    @RequestMapping("/hello")
    @ResponseBody
    public String helloHandler () {
        return "<h1>Hello World!</h1>";
    }

    @RequestMapping(value="/json")
    @ResponseBody()
    public Object test() {
    	User user = new User("bjbj",21,"wsyzl@qq.com","yang");
//		user.setAddr("bjbj");
//		user.setAge(20);
//		user.setEmail("wsyzl@qq.com");
//		user.setName("yang");
        return user;
    }
	@RequestMapping("/")
	public String handler(Model model) {
		model.addAttribute("msg", "a jar packaging example");
		return "myView";
	}
	
	  @GetMapping("/2")
	  @ResponseBody
	  public String handle(Model model) {
	      model.addAttribute("msg", "test msg from controller");
	      return "myCustomView";
	  }
	
	
	@GetMapping("/testMysql")
	@ResponseBody
	public Object handle3(Model model) {
	 
		
		Station station = stationService.queryById(1);
		
		return station;
	}
	
	
	
	
	
	
	
	
}