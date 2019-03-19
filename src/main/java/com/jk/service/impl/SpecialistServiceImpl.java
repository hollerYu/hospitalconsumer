package com.jk.service.impl;

import com.jk.bean.*;
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

    @Override
    public User httpclientphone(String phone) {
        User user = specialistMpper.httpclientphone(phone);


        return user;
    }

    @Override
    public User selectuser(Integer id) {
        User user = specialistMpper.selectuser(id);
        return user;
    }
    @Override
    public List<Integer> article(List list2) {
        List<Integer> list = specialistMpper.article(list2);
        return list;
    }

    @Override
    public List<Affiche> affiche(Integer start) {
        List<Affiche> list = specialistMpper.affiche(start);
        return list;
    }
}
