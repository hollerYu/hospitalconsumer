package com.jk.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpertliteratureMapper {
    List querywenxian(@Param("wenxianid") Integer wenxianid);


    void editnumber(@Param("id") Integer wenxianid);

    void liulan(@Param("wenxianid") Integer wenxianid);
}
