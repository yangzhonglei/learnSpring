package com.yzl.study.logindemo.service;

import com.yzl.study.logindemo.dao.UserDao;
import com.yzl.study.logindemo.model.User;
import com.yzl.study.logindemo.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public int create(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return  userDao.insert(user);
    }

    @Override
    public User findbyName(User user) {

        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(user.getName());
        List<User> list = userDao.selectByExample(example);
        if(list!=null &&  !list.isEmpty()){

            return list.get(0);
        }
        return null;

    }

    @Override
    public User login(User user) {

        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(user.getName());
        List<User> list = userDao.selectByExample(example);
        if(list!=null &&  !list.isEmpty()){
            User entity = list.get(0);
            if( bCryptPasswordEncoder.matches(user.getPassword(),entity.getPassword())){
               return entity;
            }
        }
        return null;
    }
}
