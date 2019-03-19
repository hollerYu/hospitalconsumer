package com.jk.service;

import com.jk.bean.User;
import com.jk.bean.Vip;

import java.util.List;

public interface VipService {
    void saveVip(Vip vip);

    List<Vip> getVip();

    User getUserById(Integer userId);

    void updateSendEmail(Integer id);
}
