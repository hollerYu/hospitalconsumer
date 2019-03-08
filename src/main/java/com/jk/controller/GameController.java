package com.jk.controller;
import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Game;
import com.jk.bean.contrast;
import com.jk.service.GameService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("game")
public class GameController {

    @Resource
    private GameService gameService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    //去往冲浪闯关页面
    @RequestMapping("toGame")
    public String toGame() {
        return "game";
    }

    //查询冲浪闯关标题图片
    @RequestMapping("queryGame")
    @ResponseBody
    public List<Game> queryGame() {
        return gameService.queryGame();
    }

    //赋值name
    @RequestMapping("addGame")
    @ResponseBody
    public String addGame() {
        redisTemplate.opsForValue().set("wang", "NO1.我是泰迪犬");
        redisTemplate.opsForValue().set("dog1", "NO2.初生的太阳");
        redisTemplate.opsForValue().set("dog2", "NO3.我是no1");
        redisTemplate.opsForValue().set("dog3", "NO4.小小的太阳");
        redisTemplate.opsForValue().set("dog4", "NO5.apply派");
        redisTemplate.opsForValue().set("dog5", "NO6.太阳当空照");
        return "success";
    }

    //取值name
  @RequestMapping("addGamess")
    public String addGamess(Model model){
        String wang = redisTemplate.opsForValue().get("wang");
        String dog1 = redisTemplate.opsForValue().get("dog1");
        String dog2 = redisTemplate.opsForValue().get("dog2");
        String dog3 = redisTemplate.opsForValue().get("dog3");
        String dog4 = redisTemplate.opsForValue().get("dog4");
        String dog5 = redisTemplate.opsForValue().get("dog5");
        String aa = wang+","+dog1+","+dog2+","+dog3+","+dog4+","+dog5;
        model.addAttribute("objects",aa);
      return "game";
    }

}