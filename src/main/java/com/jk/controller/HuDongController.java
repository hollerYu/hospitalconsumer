package com.jk.controller;

import com.jk.bean.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    @ResponseBody
    @RequestMapping("queryRedis")
    public void queryRedis(ModelMap modelMap, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user.getId()==10){
            Integer a = redisTemplate.opsForValue().get("a");
            a++;
            redisTemplate.opsForValue().set("a",a);
        }if(user.getId()==9){
            Integer a = redisTemplate.opsForValue().get("a2");
            a++;
            redisTemplate.opsForValue().set("a2",a);
        }if(user.getId()==8){
            Integer a = redisTemplate.opsForValue().get("a3");
            a++;
            redisTemplate.opsForValue().set("a3",a);
        }if(user.getId()==7){
            Integer a = redisTemplate.opsForValue().get("a4");
            a++;
            redisTemplate.opsForValue().set("a4",a);
        }if(user.getId()==6){
            Integer a = redisTemplate.opsForValue().get("a5");
            a++;
            redisTemplate.opsForValue().set("a4",a);
        }if(user.getId()==5){
            Integer a = redisTemplate.opsForValue().get("a6");
            a++;
            redisTemplate.opsForValue().set("a6",a);
        }

    }
}
