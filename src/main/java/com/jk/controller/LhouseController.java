/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LhouseController
 * Author:   SWORD
 * Date:     2019/3/11 14:19
 * Description: 个人收藏
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.LhouseService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈个人收藏〉
 *
 * @author SWORD
 * @create 2019/3/11
 * @since 1.0.0
 */
@Controller
public class LhouseController {

    @Autowired
    private LhouseService lhouseService;

    @RequestMapping("toLhouse")
    public String toLhouse(ModelMap modelMap,Integer userid){
        modelMap.addAttribute("userid",userid);
        return "toCollectionhtml";
    }

    @RequestMapping("queryhouse")
    @ResponseBody
    public List queryhouse(Integer userid){
        List list = lhouseService.queryhouse(userid);
        return list;
    }

    @RequestMapping("inserthouse")
    @ResponseBody
    public void inserthouse(HttpServletRequest request,String mintitle){
        User user = (User)request.getSession().getAttribute("user");
        val userid = user.getId();
        lhouseService.inserthouse(userid,mintitle);
    }
}