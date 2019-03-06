package com.jk.controller;

import com.jk.bean.HotPoint;
import com.jk.service.HotPointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
    public List queryHotPoint(Integer page, Integer rows){
        List list = hotPointService.queryHotPoint(page, rows);
        //System.out.println("resultPage"+resultPage);
        return list;
    }

    //去资讯页面
    @RequestMapping("toHostPoint")
    public String toHostPoint(){
        return "hotPoint";
    }


    @RequestMapping("toHotPointMore")
    public String toHotPointMore(Integer id, ModelMap modelMap){
        //增加  观看次数
        hotPointService.increatCount(id);
        modelMap.addAttribute("id",id);
        return "hotPointMore";
    }

    @RequestMapping("queryHostPointById")
    @ResponseBody
    public HotPoint queryHostPointById(Integer id){
        HotPoint hotPoint=hotPointService.queryHostPointById(id);
        return hotPoint;
    }

}
