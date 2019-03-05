package com.jk.service.impl;

import com.jk.bean.HotPoint;
import com.jk.mapper.HotPointMapper;
import com.jk.service.HotPointService;
import com.jk.utils.PageUtil;
import com.jk.utils.ResultPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
    public ResultPage queryHotPoint(Integer page, Integer rows) {
        ResultPage resultPage = new ResultPage();
        HashMap<String,Object> hashMap = new HashMap<>();
        int count = hotPointMapper.queryListTotalCount();
        PageUtil<HotPoint> pageUtil = new PageUtil<>(count, page, rows);
        hashMap.put("start",pageUtil.getStartIndex());
        hashMap.put("end",pageUtil.getEndIndex());
        List<HotPoint> hotpoint = hotPointMapper.queryHotPoint(hashMap);
        resultPage.setTotal(count);
        resultPage.setRows(hotpoint);
        return resultPage;
    }
}
