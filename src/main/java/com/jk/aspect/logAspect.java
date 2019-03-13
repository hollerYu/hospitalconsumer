/**
 * <pre>项目名称:mongodb_demo
 * 文件名称:Aspect.java
 * 包名:com.jk.aspect
 * 创建日期:2019年1月6日下午6:00:39
 * Copyright (c) 2019, All Rights Reserved.</pre>
 */
package com.jk.aspect;

import com.jk.bean.Log;
import com.jk.bean.User;
import com.jk.utils.CusAccessObjectUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Aspect // 标示这是一个切面类
@Component // 交给spring进行管理
public class logAspect {

	@Autowired
	private MongoTemplate mongoTemplate;

	// 要拦截指定的方法 给方法增加一些功能 通过切入点找到指定方法
	@Pointcut("execution(* com.jk.controller.LoginnController.*(..))")
	public void Pointcut() {// 定义一个切点

	}

	// 通知 给连接点的方法增强功能
	@Before(value = "Pointcut()")
	public void testBefore(JoinPoint joinPoint) {// 给TreeServiceImpl 下面所有的方法
		// 执行前增加功能
		// 获取被增强的方法相关信息 getSignature()
		System.err.println("这是方法调用前执行的方法" + joinPoint.getSignature().getName());
	}

	@After(value = "Pointcut()")
	public void testAfter(JoinPoint joinPoint) {

		System.err.println("访问LoginServiceImpl类的" + joinPoint.getSignature().getName() + "的方法了!!!!");
	}

	@AfterReturning(value = "Pointcut()", returning = "returnData") // returning  返回值
	public void AfterReturning(JoinPoint joinPoint, String returnData) {
		// 获取连接点所在的目标对象 getTarget()
		String className = joinPoint.getTarget().getClass().getSimpleName();
		String method = joinPoint.getSignature().getName(); // 方法名
		Object[] args = joinPoint.getArgs(); // jp.getArgs() 参数对象

		String str = "{";
		for (Object object : args) {
			str += object + ",";
		}
		str += "}";
		System.out.println("请求的参数 ====>  " + str);

		//为了通过获取session
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		String ipAddress = null;
		String url = null;
		User user = null;

		if (servletRequestAttributes == null) {

			System.out.println("空的,谨慎操作");
		} else {
			//获取session对象
			HttpServletRequest request = servletRequestAttributes.getRequest();
			HttpSession session = request.getSession();

			url = request.getRequestURL().toString(); // 获取请求中的url并拼接起来
			user =(User) session.getAttribute("user");
			String referer = request.getHeader("Referer");
			String agent = request.getHeader("User-Agent");
			 //System.out.println("获取的agent====>"+agent);
			ipAddress = CusAccessObjectUtil.getIpAddress(request);

		}
		//如果user 为空值则报空指针,初始化   赋初始值
		if(user==null){
			user=new User();
			user.setId(-1);
			user.setYhMch("未登录");
		}
		String qqq="";
		if(returnData.equals("2")){
			qqq="密码正确!!!";
		}
		if(returnData.equals("-2")){
			qqq="用户名 密码错误!!";
		}
		if(returnData.equals("-1")){
			qqq="用户名 不存在!!";
		}
		Log log = new Log(user.getId() + "", user.getYhMch(), className, method, str, qqq==null?"没有返回值":qqq, new Date(), ipAddress, url);
		mongoTemplate.save(log);
	}


}
