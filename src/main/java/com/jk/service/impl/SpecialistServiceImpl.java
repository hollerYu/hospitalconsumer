package com.jk.service.impl;

import com.jk.bean.Condition;
import com.jk.bean.Headline;
import com.jk.bean.Source;
import com.jk.mapper.SpecialistMpper;
import com.jk.service.SpecialisService;
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
    //查询标题
    @Override
    public List<Condition> title() {
        List<Condition> list = specialistMpper.title();
        return list;
    }

    @Override
    public void integraltwo(Source source) {
        specialistMpper.integraltwo(source);
    }

    @Override
    public List<Condition> selectBookList(Integer id) {
        List<Condition> list =specialistMpper.selectBookList(id);
        return list;
    }
}
