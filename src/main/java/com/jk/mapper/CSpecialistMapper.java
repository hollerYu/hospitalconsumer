package com.jk.mapper;

import com.jk.bean.CSpecialist;
import com.jk.bean.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CSpecialistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CSpecialist record);

    int insertSelective(CSpecialist record);

    CSpecialist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CSpecialist record);

    int updateByPrimaryKeyWithBLOBs(CSpecialist record);

    int updateByPrimaryKey(CSpecialist record);

    @Select("select * from c_specialist where status  = 1")
    List<CSpecialist> queryCSpecialist();

    void updateLookById(Integer id);

    @Select("select * from t_mall_user_account where id = #{id}")
    User getUserVip(@Param("id") Integer id);

    @Update(" update t_mall_user_account set sumsource = sumsource - #{jifen} where id = ${userId}")
    void updateJiFen(@Param("jifen") int jifen,@Param("userId") int userId);

    @Update(" update t_mall_user_account set sumsource = sumsource + #{jifen} where id = ${userId}")
    void updateJiFen02(@Param("jifen")int jifen,@Param("userId") Integer userId);

    @Update(" update t_mall_user_account set vip = 1 where id = ${id}")
    void updateUserVip(@Param("id") Integer id);
}