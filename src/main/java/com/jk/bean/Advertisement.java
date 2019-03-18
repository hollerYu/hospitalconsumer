/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Advertisement
 * Author:   SWORD
 * Date:     2019/3/18 21:52
 * Description: 广告
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈广告〉
 *
 * @author SWORD
 * @create 2019/3/18
 * @since 1.0.0
 */
@Data
public class Advertisement implements Serializable {

    private Integer id;

    private String title;

    private String pathurl;

    private String jianjie;

}