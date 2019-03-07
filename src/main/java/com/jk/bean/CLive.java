package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CLive {
    private Integer id;

    private String title;

    private String photo;

    private String name;

    private String position;

    private String address;

    @JsonFormat(timezone = "GTM+8",pattern = "yyyy-MM-dd")
    private Date liveTime;

    private String liveExplain;

    private String doctorBackground;

    private String liveDetails;

    private Integer status;

}