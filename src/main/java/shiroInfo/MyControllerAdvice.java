package shiroInfo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.apache.shiro.authc.AuthenticationException;

/**
 * @Auther: yjm
 * @Date: 2019/3/13 13:42
 * @Description:
 */
@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(value = AuthenticationException.class)
    public String errorHandler(Exception ex) {
        System.out.println("查询全局异常了");
        return "weishouquan";
    }
}
