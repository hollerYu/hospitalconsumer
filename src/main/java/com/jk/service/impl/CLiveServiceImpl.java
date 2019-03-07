package com.jk.service.impl;

import com.jk.bean.CLive;
import com.jk.mapper.CLiveMapper;
import com.jk.service.CLiveService;
import com.jk.utils.PageUtil;
import com.jk.utils.ResultPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class CLiveServiceImpl implements CLiveService {


    @Resource
    private CLiveMapper liveMapper;

    @Override
    public List<CLive> getLive(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int count = liveMapper.getLiveToTalCount();
        PageUtil<CLive> pageUtil = new PageUtil<>(count, page, rows);
        hashMap.put("start",pageUtil.getStartIndex());
        hashMap.put("end",pageUtil.getEndIndex());
        List<CLive> list = liveMapper.getLive(hashMap);
        return list;
    }

    @Override
    public List<CLive> getLiveAll() {
        return liveMapper.getLiveAll();
    }

    @Override
    public CLive getLiveById(Integer id) {
        return liveMapper.selectByPrimaryKey(id);
    }
}
