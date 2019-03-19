package com.jk.mapper;

import com.jk.bean.User;
import com.jk.bean.Vip;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface VipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Vip record);

    int insertSelective(Vip record);

    Vip selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Vip record);

    int updateByPrimaryKey(Vip record);

    @Select("select * from c_vip")
    List<Vip> getVip();

    @Select("select * from t_mall_user_account where id = #{userId}")
    User getUserById(@Param("userId") Integer userId);

    @Update("update c_vip set end_email = 1 where id = {id}")
    void updateSendEmail(@Param("id") Integer id);
}