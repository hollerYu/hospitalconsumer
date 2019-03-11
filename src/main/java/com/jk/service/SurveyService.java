package com.jk.service;

import com.jk.bean.AnswerSurvey;
import com.jk.bean.QuestSurvey;

import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 17:17
 * @Description:
 */
public interface SurveyService {
    List<QuestSurvey> querySurvey();

    void addSurveyYjm(Integer userId, String questionOne, String answerValue);

    List<AnswerSurvey> selectSyrveyByUserId(Integer userId);
}
