/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Literature
 * Author:   SWORD
 * Date:     2019/3/6 11:07
 * Description: 临床
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
 * 〈临床〉
 *
 * @author SWORD
 * @create 2019/3/6
 * @since 1.0.0
 */
@Data
public class Literature implements Serializable {

    private Integer id;

    private String maxTitle;

    private Date sysDate;

    private Integer browseNumber;
}