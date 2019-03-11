/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LhouseServiceImpl
 * Author:   SWORD
 * Date:     2019/3/11 14:57
 * Description: 个人收藏
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.mapper.LhouseMapper;
import com.jk.service.LhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈个人收藏〉
 *
 * @author SWORD
 * @create 2019/3/11
 * @since 1.0.0
 */
@Service
public class LhouseServiceImpl implements LhouseService {

    @Autowired
    private LhouseMapper lhouseMapper;

    @Override
    public List queryhouse(Integer userid) {
        return lhouseMapper.queryhouse(userid);
    }

    @Override
    public void inserthouse(Integer userid, String mintitle) {
        lhouseMapper.inserthouse(userid,mintitle);
    }
}