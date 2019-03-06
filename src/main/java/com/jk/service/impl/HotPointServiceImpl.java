package com.jk.service.impl;

import com.jk.bean.HotPoint;
import com.jk.mapper.HotPointMapper;
import com.jk.service.HotPointService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/3/5 16:21
 * @Description:
 */
@Service
public class HotPointServiceImpl implements HotPointService {

    @Resource
    private HotPointMapper hotPointMapper;

    //热点资讯查询
    @Override
    public List queryHotPoint(Integer page, Integer rows) {

        List list=hotPointMapper.queryHotPoint();
        return list;
    }

    @Override
    public void increatCount(Integer id) {
        hotPointMapper.increatCount(id);
    }

    @Override
    public HotPoint toHotPointMore(Integer id) {
       return hotPointMapper.toHotPointMore(id);
    }

}
