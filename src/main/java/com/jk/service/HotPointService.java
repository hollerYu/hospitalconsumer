package com.jk.service;

import com.jk.bean.HotPoint;

import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/5 16:20
 * @Description:
 */
public interface HotPointService {

    //热点资讯查询
    List queryHotPoint(Integer page, Integer rows);

    //增加观看次数
    void increatCount(Integer id);


    HotPoint toHotPointMore(Integer id);
}
