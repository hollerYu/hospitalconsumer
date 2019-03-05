package com.jk.mapper;



import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConditionMapper {
    List queryCondition(@Param("id") Integer id);

}
