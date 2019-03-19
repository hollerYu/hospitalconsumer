package com.jk.service.impl;

import com.jk.bean.User;
import com.jk.bean.Vip;
import com.jk.mapper.VipMapper;
import com.jk.service.VipService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {

    @Resource
    private VipMapper vipMapper;

    @Override
    public void saveVip(Vip vip) {
        vipMapper.insertSelective(vip);
    }

    @Override
    public List<Vip> getVip() {
        return vipMapper.getVip();
    }

    @Override
    public User getUserById(Integer userId) {
        return vipMapper.getUserById(userId);
    }

    @Override
    public void updateSendEmail(Integer id) {
        vipMapper.updateSendEmail(id);
    }
}
