package com.jk.service;

import com.jk.bean.Comment;

import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 10:52
 * @Description:
 */
public interface CommentService {

    //查询评论
    List queryComment(Integer hotPointId);

    //新增评论
    void addComment(Comment comment, Integer id);
}
