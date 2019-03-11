/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SourcemallController
 * Author:   SWORD
 * Date:     2019/3/8 18:55
 * Description: 积分商城
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.Sourcemall;
import com.jk.service.SourcemallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈积分商城〉
 *
 * @author SWORD
 * @create 2019/3/8
 * @since 1.0.0
 */
@Controller
public class SourcemallController {

    @Autowired
    private SourcemallService sourcemallService;

    //跳转积分商城页面
    @RequestMapping("tosourcemall")
    public String tosourcemall(ModelMap modelMap,Integer userid,Integer source){
        modelMap.addAttribute("userid",userid);
        modelMap.addAttribute("source",source);
        return "tosourcemall";
    }

    @RequestMapping("qeuryimgheader")
    @ResponseBody
    public List<Sourcemall> qeuryimgheader(Sourcemall sourcemall){
        List<Sourcemall>  sourcemall1 = sourcemallService.qeuryimgheader(sourcemall);
        return sourcemall1;
    }

    @RequestMapping("tosourcecha")
    @ResponseBody
    public void tosourcecha(Integer userid,Integer sourcenumber,String titlename,Integer mallid,Integer kucun){
        sourcemallService.tosourcecha(userid,sourcenumber,titlename);
        //库存减一
        sourcemallService.jiankucun(mallid);
    }

    //对用户表总积分做修改
    @RequestMapping("forsum")
    @ResponseBody
    public void forsum(Integer userid ,Integer sum){
        sourcemallService.forsum(userid,sum);
    }




}