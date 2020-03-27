package com.yzl.study.spingboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.yzl.study.spingboot.dao.UserDao;
import com.yzl.study.spingboot.dao.UserMapper;
import com.yzl.study.spingboot.model.User;
import com.yzl.study.spingboot.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author evanYang
 * @version 1.0
 * @date 08/27/2019 15:08
 */
@RestController
public class UserController2 {
    @Autowired
    private UserMapper userMapper;

    
//    @GetMapping("/getUser2")
//    public String index() {
//        Example example = new Example(User.class);
//        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("id", "1");
//        List<User> userModels = userMapper.    .selectByExample(example);
//        return JSONObject.toJSONString(userModels);
//    }

    @GetMapping("/selectUserByMe")
    public List<User> selectUserByMe() {
        List<User> userModels = userMapper.selectAll();
        return userModels;
    }
    @GetMapping("/myselect")
    public User myselect() {
    	User userModels = userMapper.myselect();
    	return userModels;
    }
}