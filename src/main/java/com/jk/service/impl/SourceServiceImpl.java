/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: SourceServiceImpl
 * Author:   SWORD
 * Date:     2019/3/8 11:13
 * Description: 个人积分
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.mapper.SourceMapper;
import com.jk.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈个人积分〉
 *
 * @author SWORD
 * @create 2019/3/8
 * @since 1.0.0
 */
@Service
public class SourceServiceImpl implements SourceService {

    @Autowired
    private SourceMapper sourceMapper;

    @Override
    public List querysourceCount(Integer userid) {
        return sourceMapper.querysourceCount(userid);
    }

    @Override
    public List querysource(Integer userid) {
        return sourceMapper.querysource(userid);
    }
}