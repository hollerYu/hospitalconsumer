package com.jk.service;

import com.jk.bean.CLive;
import com.jk.utils.ResultPage;

import java.util.List;

public interface CLiveService {

    List<CLive> getLive(Integer page, Integer rows);

    List<CLive> getLiveAll();

    CLive getLiveById(Integer id);
}
