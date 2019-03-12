package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.jk.bean.Quizzesmar;
import com.jk.bean.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizzesmarController {
    @Resource
    private MongoTemplate mongoTemplate;

    //查询题目
    @ResponseBody
    @RequestMapping("quizzesmarselect")
    public List<Quizzesmar> quizzesmarselect(){
        Query query = new Query();
        List<Quizzesmar> quizzesmars = mongoTemplate.find(query, Quizzesmar.class);
        return quizzesmars;
    }
    //跳转路径
    @RequestMapping("select")
    public String quizzesmarselect2(){

        return "Quizzesmar";
    }
    //查询答案
    @ResponseBody
    @RequestMapping("contrast")
    public List<String> contrast(){
        ArrayList<String> aalist = new  ArrayList();
        Query query = new Query();
        List<Quizzesmar> list = mongoTemplate.find(query,Quizzesmar.class);
        for (Quizzesmar quizzesmar : list) {
            aalist.add(quizzesmar.getResult());
        }
      return aalist;
    }
    //对比
    @ResponseBody
    @RequestMapping("comparison")
    public List<Quizzesmar>  comparison(String[] lists){
        Query query = new Query();
            query.addCriteria(Criteria.where("result").ne(lists[0]));
        List<Quizzesmar> quizzesmars = mongoTemplate.find(query, Quizzesmar.class);
        return quizzesmars;
    }
    //携带数据跳页面
    @RequestMapping("Inthejump")
    public String band(String ids, String str, ModelMap model){
        System.out.println(ids+"======="+str);
        model.addAttribute("ids",ids);
        model.addAttribute("str",str);
      return "integral";
    }
    //查询错题
    @ResponseBody
    @RequestMapping("queryerror")
    public List<Quizzesmar> queryerror(String[] str){
        System.out.println(str);
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").in(str));
        List<Quizzesmar> quizzesmars = mongoTemplate.find(query, Quizzesmar.class);
        return quizzesmars;
    }
    //查询用户
    @ResponseBody
    @RequestMapping("userbb")
    public User userbb(HttpSession session){
        User user = (User)session.getAttribute("user");
        return user;
    }


}
