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
import com.jk.service.impl.email;
import lombok.val;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    private AmqpTemplate amqpTemplate;

    @Autowired
    private LoginService loginService;
/*
    @Autowired
    private email emailService;*/

    @RequestMapping("tologin")
    public String login(){
        return "login";
    }

    @RequestMapping("Login")
    @ResponseBody
    public String LoginUserByYhMchByYhMm(User user, HttpSession session){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getYhMch(), user.getYhMm());
        System.err.println("token=====>"+token);
        try {
            subject.login(token);//登录分两种情况 一种是成功 另一种是失败{1.账号不存在  2.密码错误}
        } catch (IncorrectCredentialsException e) { // catch只会走进其中一个代码块 所以大的异常放到小的异常下面
            System.out.println("用户名和密码不匹配");
            session.setAttribute("msg", "用户名和密码不匹配");
            return "-1";
        } catch (UnknownAccountException e) {
            System.out.println("未知账号");
            session.setAttribute("msg", "未知账号");
            return "-2";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            session.setAttribute("msg", "未知异常");
            return "0";
        }
        session.setAttribute("user",token);
           return "1";  //校验密码完成
    }

    //发送邮箱
    @RequestMapping("registertwo")
    @ResponseBody
    public String registertwo(@RequestParam("to") String to, String title){
        amqpTemplate.convertAndSend("queue-email", to,title);
        return "1";
    }

    //个人专区
    @RequestMapping("queryoneUser")
    @ResponseBody
    public List queryoneUser(Integer userid){
        List list = loginService.queryoneUser(userid);
        return list;
    }



}