package com.jk.controller;

import com.jk.bean.Comment;
import com.jk.bean.SensitiveWord;
import com.jk.bean.User;
import com.jk.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 10:51
 * @Description:
 */
@Controller
@RequestMapping("commentYjm")
public class CommentController {

    @Resource
    private CommentService commentService;



    //根据  文章id  查询相关评论
    @RequestMapping("queryComment")
    @ResponseBody
    public List queryComment(Integer hotPointId){
        List list=commentService.queryComment(hotPointId);
        return list;
    }

    //去新增评论页面
    @RequestMapping("toCommentAdd")
    public String toCommentAdd(Integer hotPointId, ModelMap modelMap){
        modelMap.addAttribute("hotPointId",hotPointId);
        return "addComment";
    }

    //新增评论
    @RequestMapping("addComment")
    @ResponseBody
    public String addComment(Comment comment, HttpSession session){
        User user = (User)session.getAttribute("user");
        //查询敏感词
       List<SensitiveWord> list= commentService.selectSensitiveword();
       StringBuilder aa=new StringBuilder();
        String s =null;
       // 未填写 评论 内容
        if(comment.getUserContent()!=null && comment.getUserContent()!=""){
            for (SensitiveWord sensitiveWord : list) {
                Boolean  equals = sensitiveWord.getSensitiveName().contains(comment.getUserContent().trim());
                s=aa.append(equals == null ? equals : "," + equals).toString();
            }
            if(s.contains("true")){    //不包含  敏感词
                comment.setState(2);
                //新增评论
                commentService.addComment(comment,user.getId());
                return "0";
            }else{
                comment.setState(1);
                //新增评论
                commentService.addComment(comment,user.getId());
                return "1";      //不包含  敏感词
            }
        }
        return "2";  //未填写内容
    }


}
