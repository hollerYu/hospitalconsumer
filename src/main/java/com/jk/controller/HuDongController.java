package com.jk.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("hudong")
public class HuDongController {

    int num = 0;
    @Resource
    RedisTemplate<String,Integer> redisTemplate;

    //跳转到游戏互动页面
    @RequestMapping("tohudong")
    public String tohudong(){
        return "hudong";
    }

    //Redis查询次数加一
    @RequestMapping("queryRedis")
    public String queryRedis(ModelMap modelMap){
        Integer a = redisTemplate.opsForValue().get("a");
        a++;
        redisTemplate.opsForValue().set("a",a);
        return "hudong";
    }
}
