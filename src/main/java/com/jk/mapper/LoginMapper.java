package com.jk.mapper;

import com.jk.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {
    User LoginUserByYhMchByYhMm(User user);

    List queryoneUser(@Param("userid") Integer userid);
}
