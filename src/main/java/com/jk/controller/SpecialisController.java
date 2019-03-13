package com.jk.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Headline;
import com.jk.bean.Specialist;
import com.jk.service.SpecialisService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SpecialisController {
    @Resource
    private MongoTemplate mongoTemplate;
    @Resource
    private SpecialisService specialisService;
   //跳转到主页的方法
   @RequestMapping("toIndex")
   public String toIndex(){

       return "index";
   }
   //查询专家
   @ResponseBody
   @RequestMapping("specialist")
   public List<Specialist> specialist(Integer assort){
       Query query = new Query();
       query.addCriteria(Criteria.where("fenlei").is(assort).and("portion").is("1"));
       List<Specialist> specialists = mongoTemplate.find(query, Specialist.class);
       return specialists;
   }
    //查询专家2
    @ResponseBody
    @RequestMapping("specialist2")
    public List<Specialist> specialist2(Integer assort){
        Query query = new Query();
        query.addCriteria(Criteria.where("fenlei").is(assort).and("portion").is("1"));
        List<Specialist> specialists = mongoTemplate.find(query, Specialist.class);

        return specialists;
    }
/*    @ResponseBody
    @RequestMapping("add")
    public String add(){
        Specialist specialist = new Specialist();
        specialist.setName("张一山");
        specialist.setAddress("东北大学医学院");
        specialist.setDataimg("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1681705484,1994333013&fm=26&gp=0.jpg");
        specialist.setFenlei(1);
        specialist.setPortion("2");
        mongoTemplate.insert(specialist);
        return "success";
    }*/
    //查询标题
    @ResponseBody
    @RequestMapping("headline")
    public List<Headline> headline(){
       List<Headline> list =   specialisService.headline();
      return list;
    }
    //模板事例
    @RequestMapping("jk")
    public String jk(Integer id, ModelMap model){
       //System.out.println(id);
       model.addAttribute("id",id);
        return "jk";
    }
    //更多专家
    @RequestMapping("more")
    public String more(Integer fenlei,ModelMap model){
        Query query = new Query();
        query.addCriteria(Criteria.where("fenlei").is(fenlei));
        List<Specialist> specialists = mongoTemplate.find(query, Specialist.class);
        model.addAttribute("specialists1",specialists);
        return "MoreExperts";
    }





}
