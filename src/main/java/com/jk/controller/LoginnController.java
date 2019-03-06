/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginnController
 * Author:   SWORD
 * Date:     2019/3/6 9:42
 * Description: 刘兴博-登录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈刘兴博-登录〉
 *
 * @author SWORD
 * @create 2019/3/6
 * @since 1.0.0
 */
@Controller
public class LoginnController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("tologin")
    public String login(){
        return "login";
    }

    @RequestMapping("Login")
    @ResponseBody
    public String LoginUserByYhMchByYhMm(User user, HttpSession session){
        User user1 = loginService.LoginUserByYhMchByYhMm(user);
        session.setAttribute("user",user1);
        if (user1 != null){
            return "1";
        }
           return "0";
    }

}