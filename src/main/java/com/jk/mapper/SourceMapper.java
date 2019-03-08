package com.jk.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourceMapper {
    List querysourceCount(@Param("userid") Integer userid);

    List querysource(@Param("userid") Integer userid);
}
