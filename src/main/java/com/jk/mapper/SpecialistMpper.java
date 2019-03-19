package com.jk.mapper;

import com.jk.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialistMpper {

    List<Headline> headline();

    List<Condition> title();

    void integraltwo(Source source);

    List<Condition> selectBookList(Integer id);

    User httpclientphone(String phone);

    User selectuser(Integer id);

    List<Integer> article(@Param("list2")List<Integer> list2);

    List<Affiche> affiche(Integer start);
}
