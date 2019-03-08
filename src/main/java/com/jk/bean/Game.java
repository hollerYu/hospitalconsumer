package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Game implements Serializable {

    private Integer id;

    private String title;

    private String photo;
}
