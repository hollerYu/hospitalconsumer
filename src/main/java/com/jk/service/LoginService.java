package com.jk.service;

import com.jk.bean.User;

import java.util.List;

public interface LoginService {


    User LoginUserByYhMchByYhMm(User user);

    List queryoneUser(Integer userid);

    //查询用户名是否  存在
    User checkUserMch(String userName);
}
