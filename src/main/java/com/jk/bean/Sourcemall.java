/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Sourcemall
 * Author:   SWORD
 * Date:     2019/3/8 18:52
 * Description: 积分商城
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈积分商城〉
 *
 * @author SWORD
 * @create 2019/3/8
 * @since 1.0.0
 */
@Data
public class Sourcemall implements Serializable {

    private Integer id;

    private Integer source;

    private String imgpath;

    private String titlename;

    private Integer kucun;

}