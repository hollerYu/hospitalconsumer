package com.jk.mapper;

import com.jk.bean.CLive;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface CLiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CLive record);

    int insertSelective(CLive record);

    CLive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CLive record);

    int updateByPrimaryKeyWithBLOBs(CLive record);

    int updateByPrimaryKey(CLive record);

    @Select("select count(*) from c_live")
    int getLiveToTalCount();

    List<CLive> getLive(HashMap<String, Object> hashMap);

    List<CLive> getLiveAll();
}