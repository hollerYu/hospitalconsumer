/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: User
 * Author:   SWORD
 * Date:     2019/3/6 9:45
 * Description: 用户表
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈用户表〉
 *
 * @author SWORD
 * @create 2019/3/6
 * @since 1.0.0
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String yhMch;

    private String yhNch;

    private String yhMm;

    private String yhXm;

    private String yhShjh;

    private String yhYx;

    private String yhTx;

    private Integer yhJb;  //

    private String photo;

    private String email;

    private String rememberPwd;  //记住密码
    //业务字段
    private String to;

    private int sumsource;  //积分

    //用户的角色   一对多关系
    //private List<Role> roleList;
    private int vip;

}