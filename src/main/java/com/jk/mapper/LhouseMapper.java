package com.jk.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LhouseMapper {
    List queryhouse(@Param("userid") Integer userid);

    void inserthouse(@Param("userid") Integer userid,@Param("mintitle") String mintitle);
}
