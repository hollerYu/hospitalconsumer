package com.jk.mapper;

import com.jk.bean.Sourcemall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SourcemallMapper {
    List<Sourcemall> qeuryimgheader(Sourcemall sourcemall);

    void forsum(@Param("userid") Integer userid,@Param("sum") Integer sum);

    void tosourcecha(@Param("sourcenumberqqq") Integer sourcenumber, @Param("useridqqq") Integer userid,@Param("titlename") String titlename);

    void jiankucun(@Param("mallid") Integer mallid);

    void saveRecord(@Param("titleName") String titleName,@Param("jifen") int jifen,@Param("userId") Integer userId);

    void saveRecord02(@Param("titleName")String titleName,@Param("jifen") int jifen,@Param("userId") Integer userId);
}
