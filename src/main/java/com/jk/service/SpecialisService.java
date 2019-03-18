package com.jk.service;

import com.jk.bean.Condition;
import com.jk.bean.Headline;
import com.jk.bean.Source;
import com.jk.bean.User;

import java.util.List;

public interface SpecialisService {

    List<Headline> headline();

    List<Condition> title();

    void integraltwo(Source source);

    List<Condition> selectBookList(Integer id);

    User httpclientphone(String phone);

    User selectuser(Integer id);
}
