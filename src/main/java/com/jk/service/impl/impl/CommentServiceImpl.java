package com.jk.service.impl.impl;

import com.jk.bean.Comment;
import com.jk.mapper.CommentMapper;
import com.jk.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 10:52
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    //根据  文章id  查询相关评论
    @Override
    public List queryComment(Integer hotPointId) {
        return commentMapper.queryComment(hotPointId);
    }

    //新增评论
    @Override
    public void addComment(Comment comment, Integer id) {
        commentMapper.addComment(comment,id);
    }
}
