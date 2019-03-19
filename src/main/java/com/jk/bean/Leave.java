/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Leave
 * Author:   SWORD
 * Date:     2019/3/19 9:55
 * Description: 专家留言
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈专家留言〉
 *
 * @author SWORD
 * @create 2019/3/19
 * @since 1.0.0
 */
@Data
public class Leave implements Serializable {

    private Integer id;

    private String leavetitle;

    private String expertname;

    private Date systime;

}