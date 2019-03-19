package com.jk.mapper;

import com.jk.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LoginMapper {
    User LoginUserByYhMchByYhMm(User user);

    List queryoneUser(@Param("userid") Integer userid);

    //查询用户名是否存在
    User checkUserMch(String userName);

    List<String> puerybyid(Integer id);

    //根据 用户名  查询  密码
    User selectPwdByUserName(String username);


    User toLoginByQQ(@Param("openId") String openId);
}
