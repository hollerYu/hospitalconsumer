package com.jk.bean;

import lombok.Data;

import java.util.Date;

/**
 * 热点资讯
 */
@Data
public class HotPoint {

    private Integer id;

    private String title; //标题

    private String total; //图片

    private String video; //视频

    private Integer seeCount; //观看人数

    private Date time; //时间

    private String content; //文章

}
