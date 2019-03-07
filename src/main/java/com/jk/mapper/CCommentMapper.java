package com.jk.mapper;

import com.jk.bean.CComment;
import com.jk.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CComment record);

    int insertSelective(CComment record);

    CComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CComment record);

    int updateByPrimaryKey(CComment record);

    @Update("update c_specialist set medal = medal + #{star} where id = #{specialistId}")
    void addStar(@Param("star")Integer star, @Param("specialistId")Integer specialistId);

    List<CComment> getCommentById(Integer specialistId);

    List<CComment> getCommentByLiveId(Integer liveId);

    @Select("select * from c_comment where user_id = #{userId} and specialist_id = #{specialistId}")
    CComment getUserCommentById(@Param("userId")Integer userId, @Param("specialistId")Integer specialistId);

    @Select("select * from c_comment where user_id = #{userId} and live_id = #{liveId}")
    CComment getUserCommentByIdNotshowStar(@Param("userId") Integer userId, @Param("liveId")Integer liveId);
}