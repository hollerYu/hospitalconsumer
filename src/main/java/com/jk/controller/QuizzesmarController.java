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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizzesmarController {
    @Resource
    private MongoTemplate mongoTemplate;



/*    @ResponseBody
    @RequestMapping("add1")
    public String  quizzesmar(){
     Quizzesmar quizzesmar = new Quizzesmar();
     quizzesmar.setTitle("1、评价儿童体格生长的参考值不是“正常标准”而是参考值范围的原因是（   ）");
     quizzesmar.setOne("A、各系统发育不平衡");
     quizzesmar.setTwo("B、体格发育是呈非匀速生长");
     quizzesmar.setThree("C、体格测量是允许误差");
     quizzesmar.setFive("D、体格生长的个体差异");
     quizzesmar.setResult(1);
     quizzesmar.setUserid(10);
     quizzesmar.setParse("正常答案A。评价儿童体格生长的参考值不是“正常标准”评价儿童体格生长的参考值不是“正常标准”评价儿童体格生长的参考值不是正常标准");
     mongoTemplate.insert(quizzesmar);
     return "success";
    }
    @ResponseBody
    @RequestMapping("add2")
    public String  quizzesmar1(){
        Quizzesmar quizzesmar = new Quizzesmar();
        quizzesmar.setTitle("2、马克思主义的产生具有深刻的社会根源、阶级基础和思想渊源。其创始人马克思1818年5月5日出生在德国特利尔城的一个律师家庭，恩格斯1820年11月28日出生在德国巴门市的一个工厂主家庭，他们放弃了舒适安逸的生活，毅然选择了充满荆棘坎坷的革命道路，创立了科学社会主义。马克思、恩格斯之所以能够创立科学社会主义，主要是因为（）");
        quizzesmar.setOne("A.他们对时代有着超越常人的认知能力");
        quizzesmar.setTwo("B.他们拥有优良的家庭背景和教育经历");
        quizzesmar.setThree("C.社会历史条件和个人努力的相互作用");
        quizzesmar.setFive("D.德国是当时最为发达的资本主义国家");
        quizzesmar.setResult(3);
        quizzesmar.setUserid(10);
        quizzesmar.setParse("正常答案C。社会历史条件和个人努力的相互作用");
        mongoTemplate.insert(quizzesmar);
        return "success";
    }
    @ResponseBody
    @RequestMapping("add3")
    public String  quizzesmar3(){
        Quizzesmar quizzesmar = new Quizzesmar();
        quizzesmar.setTitle("3.实行人民民主，保证人民当家作主，实现形式是丰富多样的。经过长期探索，我国在通过依法选举让人民的代表来参与国家生活和社会生活管理的同时，找到了一种保证人民在日常政治生活中有广泛持续深入参与权利的特有民主形式，这一特有民主形式是");
        quizzesmar.setOne("A．谈判民主");
        quizzesmar.setTwo("B．协商民主");
        quizzesmar.setThree("C．票决民主");
        quizzesmar.setFive("D．竞争性民主");
        quizzesmar.setResult(2);
        quizzesmar.setUserid(10);
        quizzesmar.setParse("正常答案B。协商民主");
        mongoTemplate.insert(quizzesmar);
        return "success";
    }
    @ResponseBody
    @RequestMapping("add4")
    public String  quizzesmar4(){
        Quizzesmar quizzesmar = new Quizzesmar();
        quizzesmar.setTitle("4.党的十八大以来，我国大力实施创新驱动发展战略，加快创新型国家建设，成果丰硕，天宫、蛟龙、天眼、悟空、墨子、大飞机等重大科技成果相继问世。我国实施创新驱动发展战略所坚持的方针是");
        quizzesmar.setOne("A．集中力量、重点突破、实现跨越式发展");
        quizzesmar.setTwo("B．企业为主体、市场为导向、产学研相结合");
        quizzesmar.setThree("C．自主创新、重点跨越、支撑发展、引领未来 ");
        quizzesmar.setFive("D．原始创新、集成创新、引进消化吸收再创新");
        quizzesmar.setResult(4);
        quizzesmar.setUserid(10);
        quizzesmar.setParse("正常答案D。原始创新、集成创新、引进消化吸收再创新");
        mongoTemplate.insert(quizzesmar);
        return "success";
    }*/
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
