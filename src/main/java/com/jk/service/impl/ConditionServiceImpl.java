/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: ConditionServiceImpl
 * Author:   SWORD
 * Date:     2019/3/5 17:08
 * Description: 刘兴博
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.mapper.ConditionMapper;
import com.jk.service.ConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈刘兴博〉
 *
 * @author SWORD
 * @create 2019/3/5
 * @since 1.0.0
 */
@Service
public class ConditionServiceImpl implements ConditionService {

    @Autowired
    private ConditionMapper conditionMapper;

    @Override
    public List queryCondition(Integer id) {
        return conditionMapper.queryCondition(id);
    }
}