package com.jk.service.impl;

import com.jk.bean.QuestSurvey;
import com.jk.service.SurveyService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 17:17
 * @Description:
 */
@Service
public class SurveyServiceImpl implements SurveyService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<QuestSurvey> querySurvey() {
        Query query = new Query();
      //  query.addCriteria(Criteria.where("ClassObj.$id").is(new ObjectId(query.geti)));

        List<QuestSurvey> logList = mongoTemplate.find(query, QuestSurvey.class);

        return logList;
    }




}
