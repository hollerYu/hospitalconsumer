package com.jk.bean;

import lombok.Data;

@Data
public class CComment {
    private Integer id;

    private Integer userId;

    private String message;

    private Integer star;

    private Integer specialistId;

    private Integer liveId;

    /*展示临时字段*/
    private String userName;

    private String photo;

}