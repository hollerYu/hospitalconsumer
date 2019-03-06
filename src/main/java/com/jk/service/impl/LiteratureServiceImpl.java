/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LiteratureServiceImpl
 * Author:   SWORD
 * Date:     2019/3/6 11:13
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.bean.Literature;
import com.jk.mapper.LiteratureMapper;
import com.jk.service.LiteratureService;
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
public class LiteratureServiceImpl implements LiteratureService {

    @Autowired
    private LiteratureMapper literatureMapper;

    @Override
    public List querylinzhuang(Literature literature) {
        return literatureMapper.querylinzhuang(literature);
    }
}