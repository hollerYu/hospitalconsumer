/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RabbitMQConfig
 * Author:   SWORD
 * Date:     2019/3/12 11:34
 * Description: 标识为RabbitMQ配置文件类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.utils;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br> 
 * 〈标识为RabbitMQ配置文件类〉
 *
 * @author SWORD
 * @create 2019/3/12
 * @since 1.0.0
 */
@Configuration //标识为RabbitMQ配置文件类
public class RabbitMQConfig {

    @Bean
    public Queue queueMessage(){
        // 参数为自定义队列名称
        return new Queue("queues-emaill");
    }

}