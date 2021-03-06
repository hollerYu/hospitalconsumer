/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginServiceImpl
 * Author:   SWORD
 * Date:     2019/3/6 9:50
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.bean.User;
import com.jk.mapper.LoginMapper;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author SWORD
 * @create 2019/3/6
 * @since 1.0.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User LoginUserByYhMchByYhMm(User user) {
        return loginMapper.LoginUserByYhMchByYhMm(user);
    }

    @Override
    public List queryoneUser(Integer userid) {
        return loginMapper.queryoneUser(userid);
    }

    @Override
    public User checkUserMch(String userName) {

        return loginMapper.checkUserMch(userName);
    }

    @Override
    public List<String> puerybyid(Integer id) {
        return loginMapper.puerybyid(id);
    }

    @Override
    public User selectPwdByUserName(String username) {
        return loginMapper.selectPwdByUserName(username);
    }

    @Override
    public User toLoginByQQ(String openId) {
        return loginMapper.toLoginByQQ(openId);
    }
}