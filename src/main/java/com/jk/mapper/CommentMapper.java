package com.jk.mapper;

import com.jk.bean.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/6 10:53
 * @Description:
 */
public interface CommentMapper {

    //根据  文章id  查询相关评论
    List queryComment(Integer hotPointId);

    //新增 用户评论
    void addComment(@Param("comment") Comment comment, @Param("id") Integer id);

}
