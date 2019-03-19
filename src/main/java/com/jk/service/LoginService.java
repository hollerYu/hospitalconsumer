package com.jk.service;

import com.jk.bean.User;

import java.util.List;

public interface LoginService {


    User LoginUserByYhMchByYhMm(User user);

    List queryoneUser(Integer userid);

    //查询用户名是否  存在
    User checkUserMch(String userName);

    List<String> puerybyid(Integer id);

    //根据用户名查询 密码
    User selectPwdByUserName(String username);

    User toLoginByQQ(String openId);
}
