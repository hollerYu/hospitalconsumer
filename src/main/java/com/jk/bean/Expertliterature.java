/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Expertliterature
 * Author:   SWORD
 * Date:     2019/3/6 18:51
 * Description: 专家文献
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈专家文献〉
 *
 * @author SWORD
 * @create 2019/3/6
 * @since 1.0.0
 */
@Data
public class Expertliterature implements Serializable {

    private Integer id;

    private Date sysdate;

    private Integer number;

    private String dateils;

    //业务字段
    private String minTitle;

}