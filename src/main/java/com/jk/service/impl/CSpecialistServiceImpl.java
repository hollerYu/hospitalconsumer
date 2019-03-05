package com.jk.service.impl;

import com.jk.bean.CSpecialist;
import com.jk.mapper.CSpecialistMapper;
import com.jk.service.CSpecialistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CSpecialistServiceImpl implements CSpecialistService {

    @Resource
    private CSpecialistMapper cSpecialistMapper;

    @Override
    public List<CSpecialist> queryCSpecialist() {
        return cSpecialistMapper.queryCSpecialist();
    }

    @Override
    public CSpecialist getDetailById(Integer id) {
        cSpecialistMapper.updateLookById(id);
        return cSpecialistMapper.selectByPrimaryKey(id);
    }
}
