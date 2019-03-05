package com.jk.controller;

import com.jk.service.HotPointService;
import com.jk.utils.ResultPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //热点资讯查询的跳转路径
    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }
    //热点资讯查询
    @RequestMapping("queryHotPoint")
    @ResponseBody
    public ResultPage queryHotPoint(Integer page, Integer rows){
        return hotPointService.queryHotPoint(page, rows);


    }

}
