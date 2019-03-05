package com.jk.mapper;

import com.jk.bean.CSpecialist;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CSpecialistMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CSpecialist record);

    int insertSelective(CSpecialist record);

    CSpecialist selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CSpecialist record);

    int updateByPrimaryKeyWithBLOBs(CSpecialist record);

    int updateByPrimaryKey(CSpecialist record);

    @Select("select * from c_specialist")
    List<CSpecialist> queryCSpecialist();

    void updateLookById(Integer id);
}