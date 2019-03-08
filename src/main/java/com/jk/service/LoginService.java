package com.jk.service;

import com.jk.bean.User;

import java.util.List;

public interface LoginService {


    User LoginUserByYhMchByYhMm(User user);

    List queryoneUser(Integer userid);
}
