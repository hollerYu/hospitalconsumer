package com.jk.service;

import com.jk.bean.*;

import java.util.List;

public interface SpecialisService {

    List<Headline> headline();

    List<Condition> title();

    void integraltwo(Source source);

    List<Condition> selectBookList(Integer id);

    User httpclientphone(String phone);

    User selectuser(Integer id);

    List<Integer> article(List list2);

    List<Affiche> affiche(Integer start);
}
