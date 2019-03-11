package com.jk.service;

import com.jk.bean.Sourcemall;

import java.util.List;

public interface SourcemallService {

    List<Sourcemall> qeuryimgheader(Sourcemall sourcemall);


    void forsum(Integer userid, Integer sum);

    void tosourcecha(Integer userid, Integer sourcenumber, String titlename);

    void jiankucun(Integer mallid);
}
