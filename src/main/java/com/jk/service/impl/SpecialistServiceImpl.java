package com.jk.service.impl;

import com.jk.bean.Headline;
import com.jk.mapper.SpecialistMpper;
import com.jk.service.SpecialisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecialistServiceImpl implements SpecialisService{
    @Resource
    private SpecialistMpper specialistMpper;

    @Override
    public List<Headline> headline() {

        List<Headline> list =  specialistMpper.headline();

        return list;
    }
}
