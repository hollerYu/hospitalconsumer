package com.jk.controller;

import com.jk.bean.HotPoint;
import com.jk.bean.User;
import com.jk.service.HotPointService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.tree.Tree;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Resource
    private RedisTemplate<String ,Integer> redisTemplate;

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
    public String toHotPointMore(Integer id, ModelMap modelMap, HttpSession session){
        User user=(User)session.getAttribute("user");

        if( user!=null){
            if(!redisTemplate.hasKey("toHotPointMore"+user.getId())){   //如果不存在   浏览次数就加 1
                //增加  观看次数
                hotPointService.increatCount(id);
                redisTemplate.opsForValue().set("toHotPointMore"+user.getId(),1,40, TimeUnit.SECONDS);
            }
        }
        //评论表 id
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
