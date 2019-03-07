package com.jk.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.NoArgsConstructor;

/**
 * @Auther: yjm
 * @Date: 2019/3/7 16:29
 * @Description:
 */
@Data
@Document(collection="AnswerSurvey")
@AllArgsConstructor
@NoArgsConstructor
public class AnswerSurvey {

    @Id
    private String id;

    private String questId;   //问题  id

    private String answerNum;    //选项  的  序号  例如  "  A B C D "

    private String  answerValue;   //对应问题的选项  内容


}
