package com.jk.service.impl;

import com.jk.bean.AnswerSurvey;
import com.jk.bean.QuestSurvey;
import com.jk.mapper.CommentMapper;
import com.jk.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 17:17
 * @Description:
 */
@Service
public class SurveyServiceImpl implements SurveyService {

    @Resource
    private CommentMapper commentMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<QuestSurvey> querySurvey() {
        Query query = new Query();
      //  query.addCriteria(Criteria.where("ClassObj.$id").is(new ObjectId(query.geti)));

        List<QuestSurvey> logList = mongoTemplate.find(query, QuestSurvey.class);

        return logList;
    }

    @Override
    @Transactional
    public void addSurveyYjm(Integer userId, String questionOne, String answerValue) {

        String[] quest = questionOne.split(",");
        String[] answer = answerValue.split(",");

        for(int i=0;i<quest.length;i++){
            AnswerSurvey asy=new AnswerSurvey();
            asy.setUserId(userId);
            asy.setQuestionOne(quest[i]);
            asy.setAnswerValue(answer[i]);

            mongoTemplate.insert(asy);
            //添加积分
            commentMapper.addCountByUseId(userId);
        }
    }

    // 根据用户id查询 用户是否 已经 提交过问卷 了
    @Override
    public List<AnswerSurvey> selectSyrveyByUserId(Integer userId) {

        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));

        List<AnswerSurvey> ts = mongoTemplate.find(query,AnswerSurvey.class);
        return ts;
    }

}
