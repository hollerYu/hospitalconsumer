package com.jk.bean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Quizzesmar") //mongodb 自动生成表
@Data
public class Quizzesmar {
   private String  id;
   private String  title;  //标题
   private String  one;    //选择题a
   private String  two;    //选择题b
   private String  three;  //选择题c
   private String  five;   //选择题d
   private String  parse;  //正确解析
   private Integer userid; //关联登陆人id
   private String result; //正确答案
   private Integer start;  //状态
}
