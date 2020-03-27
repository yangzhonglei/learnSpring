package com.yzl.study.spingboot.dao;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

import com.yzl.study.spingboot.model.UserModel;

/**
 * @author evanYang
 * @version 1.0
 * @date 08/27/2019 15:06
 */
public interface UserDao extends Mapper<UserModel> {
    List<UserModel> selectUserBy();
}