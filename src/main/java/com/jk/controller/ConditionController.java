/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ConditionController
 * Author:   SWORD
 * Date:     2019/3/5 16:22
 * Description: 刘-牛奶蛋白过敏
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈刘兴博-牛奶蛋白过敏〉
 *
 * @author SWORD
 * @create 2019/3/5
 * @since 1.0.0
 */
@Controller
public class ConditionController {

    @Autowired
    private ConditionService conditionService;

    @RequestMapping("toCondition")
    public String toCondition(Integer id,ModelMap modelMap){
        modelMap.addAttribute("id",id);
        return "/tocondition";
    }

    @RequestMapping("queryCondition")
    @ResponseBody
    public List queryCondition(Integer id){
        List list = conditionService.queryCondition(id);
        return list;
    }

    //跳转临床文献界面
    @RequestMapping("tolinchuangwenxian")
    public String tolinchuangwenxian(Integer id,ModelMap modelMap){
        modelMap.addAttribute("id",id);
        return "tolinchuangwenxian";
    }


    //根据首页id跳转页面
    @RequestMapping("toLiu")
    public String toLiu(Integer id, ModelMap modelMap){
        modelMap.addAttribute("id",id);
        return "tocondition";
    }
    //广告
    @RequestMapping("queryAdvertisement")
    @ResponseBody
    public List queryAdvertisement(){
        List list =conditionService.queryAdvertisement();
        return list;
    }

    //专家留言
    @RequestMapping("queryLeave")
    @ResponseBody
    public List queryLeave(){
        List list = conditionService.queryLeave();
        return list;
    }

}