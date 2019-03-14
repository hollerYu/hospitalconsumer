package com.jk.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;

/**
 * 业精于勤荒于嬉,行成于思毁于随
 *
 * @Date 2019/2/28 15:13
 * @Created by wuzhuang
 */

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(value = AuthenticationException.class)
    public String errorHandler(Exception ex) {
        System.out.println("查询全局异常了");
        return "weishouquan";
    }

}
