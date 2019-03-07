package com.jk.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpertliteratureMapper {
    List querywenxian(@Param("wenxianid") Integer wenxianid);


}
