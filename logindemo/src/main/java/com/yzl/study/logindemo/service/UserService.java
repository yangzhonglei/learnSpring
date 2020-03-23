package com.yzl.study.logindemo.service;

import com.yzl.study.logindemo.model.User;

public interface UserService {

  public int  create(User user);

   public User findbyName(User user);

    public User login(User user);

}
