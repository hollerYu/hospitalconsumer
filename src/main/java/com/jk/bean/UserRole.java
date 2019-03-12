/**
 * <pre>项目名称:maven_dmo 
 * 文件名称:UserRole.java 
 * 包名:com.jk.pojo 
 * 创建日期:2018年12月17日下午10:21:53 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */  
package com.jk.bean;

import lombok.Data;

/** 
 * <pre>项目名称：maven_dmo    
 * 类名称：UserRole    
 * 类描述：    
 * 创建人：yjm   
 * 创建时间：2018年12月17日 下午10:21:53    
 * 修改人：yjm    
 * 修改时间：2018年12月17日 下午10:21:53    
 * 修改备注：       
 * @version </pre>    
 */
@Data
public class UserRole {
	
	private Integer userRoleId;
	
	private Integer userId;    //用户  id
	
	private Integer roleId;    //角色  id

}
