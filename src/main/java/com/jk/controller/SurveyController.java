package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.bean.QuestSurvey;
import com.jk.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 17:15
 * @Description:
 */
@Controller
@RequestMapping("surveyYjm")
public class SurveyController {

    @Resource
    private SurveyService surveyService;

    @Autowired
    private MongoTemplate mongoTemplate;

    //去问卷调查  页面
    @RequestMapping("toQuestionSurvey")
    public String toQuestionSurvey(){
        return "questionSurvey";
    }

    //问卷调查  查询
    @RequestMapping("querySurvey")
    @ResponseBody
    public List<QuestSurvey> querySurvey(ModelMap modelMap){

        List<QuestSurvey> questSurvey= surveyService.querySurvey();
      //  modelMap.addAttribute("questSurvey",questSurvey);
      //  System.err.println(questSurvey);
        return questSurvey;
    }




}
