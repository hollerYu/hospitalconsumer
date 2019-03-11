/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SourcemallServiceImpl
 * Author:   SWORD
 * Date:     2019/3/8 18:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.bean.Sourcemall;
import com.jk.mapper.SourcemallMapper;
import com.jk.service.SourcemallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author SWORD
 * @create 2019/3/8
 * @since 1.0.0
 */
@Service
public class SourcemallServiceImpl implements SourcemallService {

    @Autowired
    private SourcemallMapper sourcemallMapper;


    @Override
    public List<Sourcemall> qeuryimgheader(Sourcemall sourcemall) {
        return sourcemallMapper.qeuryimgheader(sourcemall);
    }


    @Override
    public void forsum(Integer userid, Integer sum) {
        sourcemallMapper.forsum(userid,sum);
    }

    @Override
    public void tosourcecha(Integer userid, Integer sourcenumber, String titlename) {
        sourcemallMapper.tosourcecha(userid,sourcenumber,titlename);
    }

    @Override
    public void jiankucun(Integer mallid) {
        sourcemallMapper.jiankucun(mallid);
    }

}