package com.jk.service.impl;

import com.jk.mapper.HotPointMapper;
import com.jk.service.HotPointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Auther: yjm
 * @Date: 2019/3/5 16:21
 * @Description:
 */
@Service
public class HotPointServiceImpl implements HotPointService {

    @Resource
    private HotPointMapper hotPointMapper;
}
