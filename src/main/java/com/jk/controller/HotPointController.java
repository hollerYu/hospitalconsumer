package com.jk.controller;

import com.jk.service.HotPointService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Auther: yjm
 * @Date: 2019/3/5 16:11
 * @Description:
 */
@Controller
@RequestMapping("hotPointYjm")
public class HotPointController {

    @Resource
    private HotPointService hotPointService;






}
