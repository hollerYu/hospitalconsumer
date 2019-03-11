package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.bean.AnswerSurvey;
import com.jk.bean.QuestSurvey;
import com.jk.bean.User;
import com.jk.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public List querySurvey(){

        List questSurvey= surveyService.querySurvey();

        return questSurvey;
    }

    //提交测评
    @RequestMapping("addSurveyYjm")
    @ResponseBody
    public String addSurveyYjm(HttpSession session,String questionOne,String answerValue){   //问题   answerValue==>  勾选项
        User user = (User)session.getAttribute("user");

        // 根据用户id查询 用户是否 已经 提交过问卷 了
        List<AnswerSurvey> answerSurvey= surveyService.selectSyrveyByUserId(user.getId());
        if(answerSurvey.size()>0){
            return "-1";   //已经评论过
        }else {
            // 提交 问卷
            surveyService.addSurveyYjm(user.getId(), questionOne, answerValue);

            return  "1";   //问卷提交成功
        }
    }


}
