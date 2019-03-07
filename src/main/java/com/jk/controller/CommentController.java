package com.jk.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jk.bean.Comment;
import com.jk.bean.HotPoint;
import com.jk.bean.User;
import com.jk.service.CommentService;
import com.jk.service.HotPointService;
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
    public Boolean addComment(Comment comment, HttpSession session){
        User user = (User)session.getAttribute("user");
        //新增评论
        try {
            commentService.addComment(comment,user.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
