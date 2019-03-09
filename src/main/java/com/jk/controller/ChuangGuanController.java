package com.jk.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("chuangguan")
public class ChuangGuanController {

    @Resource
    private RedisTemplate<String,Integer> redisTemplate;



    //取值
    @RequestMapping("quzhi")
    @ResponseBody
    public String quzhi(){
        if(!redisTemplate.hasKey("a")){
            redisTemplate.opsForValue().set("a",10);
            redisTemplate.opsForValue().set("a2",9);
            redisTemplate.opsForValue().set("a3",6);
            redisTemplate.opsForValue().set("a4",6);
            redisTemplate.opsForValue().set("a5",5);
            redisTemplate.opsForValue().set("a6",4);
        }
        Integer a = redisTemplate.opsForValue().get("a");
        Integer a2 = redisTemplate.opsForValue().get("a2");
        Integer a3 = redisTemplate.opsForValue().get("a3");
        Integer a4 = redisTemplate.opsForValue().get("a4");
        Integer a5 = redisTemplate.opsForValue().get("a5");
        Integer a6 = redisTemplate.opsForValue().get("a6");
        String aa = ""+a+','+a2+','+a3+','+a4+','+a5+','+a6+"";
        return aa;
    }
}
