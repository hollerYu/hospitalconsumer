/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Source
 * Author:   SWORD
 * Date:     2019/3/8 11:10
 * Description: 个人积分
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈个人积分〉
 *
 * @author SWORD
 * @create 2019/3/8
 * @since 1.0.0
 */
@Data
public class Source implements Serializable {

    private Integer id;

    private String sourcename;

    private Integer source;

    private Integer userid;

}