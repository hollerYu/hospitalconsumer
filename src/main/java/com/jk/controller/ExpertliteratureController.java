/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExpertliteratureController
 * Author:   SWORD
 * Date:     2019/3/6 16:43
 * Description: 专家文献
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.service.ExpertliteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈专家文献〉
 *
 * @author SWORD
 * @create 2019/3/6
 * @since 1.0.0
 */
@Controller
public class ExpertliteratureController {

    @Autowired
    private ExpertliteratureService expertliteratureService;

    @RequestMapping("towenxian")
    public String towenxian(Integer id,Integer wenxianid, ModelMap modelMap){
            modelMap.addAttribute("wenxianid",wenxianid);
            modelMap.addAttribute("id",id);
            return "towenxian";
    }

    @RequestMapping("querywenxian")
    @ResponseBody
    public List querywenxian(Integer wenxianid){
        List list = expertliteratureService.querywenxian(wenxianid);
        return list;
    }

    @RequestMapping("editnumber")
    public String editnumber(Integer id,Integer wenxianid, ModelMap modelMap){
            expertliteratureService.editnumber(wenxianid);
            expertliteratureService.liulan(wenxianid);
        modelMap.addAttribute("wenxianid",wenxianid);
        modelMap.addAttribute("id",id);
            return "towenxian";
    }

}