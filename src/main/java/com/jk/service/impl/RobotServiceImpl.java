package com.jk.service.impl;

import com.jk.bean.User;
import com.jk.mapper.RobotMapper;
import com.jk.service.RobotService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RobotServiceImpl implements RobotService {

    @Resource
    private RobotMapper robotMapper;


}
