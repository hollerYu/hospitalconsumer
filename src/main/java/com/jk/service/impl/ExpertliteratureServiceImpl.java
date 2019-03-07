/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ExpertliteratureServiceImpl
 * Author:   SWORD
 * Date:     2019/3/6 17:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.mapper.ExpertliteratureMapper;
import com.jk.service.ExpertliteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author SWORD
 * @create 2019/3/6
 * @since 1.0.0
 */
@Service
public class ExpertliteratureServiceImpl implements ExpertliteratureService {

    @Autowired
    private ExpertliteratureMapper expertliteratureMapper;

    @Override
    public List querywenxian(Integer wenxianid) {
        return expertliteratureMapper.querywenxian(wenxianid);
    }

    @Override
    public void editnumber(Integer wenxianid) {
        expertliteratureMapper.editnumber(wenxianid);
    }

    @Override
    public void liulan(Integer wenxianid) {
        expertliteratureMapper.liulan(wenxianid);
    }
}