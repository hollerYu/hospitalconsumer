package com.jk.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection="log")
public class Log {

    @Id
    private String id;

    private String userId;

    private String userName;

    private String className;  //类名

    private String method;   //方法名

    private String reqParam;   //传递的参数

    private String respParam;   //返回值

    private Date createTime;

    private String ip;

    private String url;
    /**
     *
     * <pre>创建一个新的实例 Log.
     * @param userId
     * @param userName
     * @param className
     * @param method
     * @param reqParam
     * @param respParam
     * @param createTime
     * @param ip
     * @param url</pre>
     */
    public Log(String userId, String userName, String className, String method, String reqParam, String respParam,
               Date createTime, String ip, String url) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.className = className;
        this.method = method;
        this.reqParam = reqParam;
        this.respParam = respParam;
        this.createTime = createTime;
        this.ip = ip;
        this.url = url;
    }

}
