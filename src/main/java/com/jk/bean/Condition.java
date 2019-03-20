/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Condition
 * Author:   SWORD
 * Date:     2019/3/5 15:58
 * Description: 病情视频+详情
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈病情视频+详情〉
 *
 * @author SWORD
 * @create 2019/3/5
 * @since 1.0.0
 */
@Data
public class Condition implements Serializable {

    private Integer id;
    //业务字段----大标题
    private String maxTitle; //title

    private String minTitle;

    private String videoPath;

    private String details;

    //经纬度
    private String pointxs;

    private String pointys;

    private Integer map;

    private Integer number;

}