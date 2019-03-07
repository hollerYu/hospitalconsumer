package com.jk.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 15:56
 * @Description:
 */
@Data
@Document(collection="QuestSurvey")
@AllArgsConstructor
@NoArgsConstructor
public class QuestSurvey {

    @Id
    private String id; // 对应 选项表  的(questId)  字段

    private String questSurveyTitle;    //标题

    private String questionNum;    //问题 序号

    private List questvalue;   //问题  题目

    private List answerNum;    //选项  的  序号  例如  "  A B C D "

    private List answerValue;   //对应问题的选项  内容



}
