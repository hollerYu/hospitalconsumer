package com.jk.service;

import com.jk.bean.CSpecialist;

import java.util.List;

public interface CSpecialistService {
    List<CSpecialist> queryCSpecialist();

    CSpecialist getDetailById(Integer id);
}
