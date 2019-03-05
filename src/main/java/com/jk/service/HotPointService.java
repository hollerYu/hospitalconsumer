package com.jk.service;

import com.jk.utils.ResultPage;

/**
 * @Auther: yjm
 * @Date: 2019/3/5 16:20
 * @Description:
 */
public interface HotPointService {

    //热点资讯查询
    ResultPage queryHotPoint(Integer page, Integer rows);

}
