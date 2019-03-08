/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SourceController
 * Author:   SWORD
 * Date:     2019/3/8 11:12
 * Description: 个人积分
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.SourceService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈个人积分〉
 *
 * @author SWORD
 * @create 2019/3/8
 * @since 1.0.0
 */
@Controller
public class SourceController {

    @Autowired
    private SourceService sourceService;

    @RequestMapping("toSpecialHtml")
    public String toSpecialHtml(HttpServletRequest request, ModelMap modelMap){
        User user = (User)request.getSession().getAttribute("user");
        val userid = user.getId();
        modelMap.addAttribute("userid",userid);
        return "toSpecial";
    }
    //跳转我的积分页面
    @RequestMapping("toSource")
    public String toSource(Integer userid,ModelMap modelMap){
        modelMap.addAttribute("userid",userid);
        return "source";
    }

    //查询个人积分总数
    @RequestMapping("querysourceCount")
    @ResponseBody
    public List querysourceCount(Integer userid){
        List list = sourceService.querysourceCount(userid);
        return list;
    }

    //返回
    @RequestMapping("jifenfanhui")
    public String jifenfanhui(Integer userid,ModelMap map){
        map.addAttribute("userid",userid);
        return "toSpecial";
    }
    //查询积分详情
    @RequestMapping("querysource")
    @ResponseBody
    public List querysource(Integer userid){
        List list = sourceService.querysource(userid);
        return list;
    }

}