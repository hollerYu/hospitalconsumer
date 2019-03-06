/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LiteratureController
 * Author:   SWORD
 * Date:     2019/3/6 11:10
 * Description: 临床Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.Literature;
import com.jk.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈临床Controller〉
 *
 * @author SWORD
 * @create 2019/3/6
 * @since 1.0.0
 */
@Controller
public class LiteratureController {

    @Autowired
    private LiteratureService literatureService;

    @RequestMapping("querylinzhuang")
    @ResponseBody
    public List querylinzhuang(Literature literature){
        List<Literature> list = literatureService.querylinzhuang(literature);
        return list;
    }
}