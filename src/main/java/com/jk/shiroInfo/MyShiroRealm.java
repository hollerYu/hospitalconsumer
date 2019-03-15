package com.jk.shiroInfo;

import com.jk.bean.User;
import com.jk.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: yjm
 * @Date: 2019/2/28 17:14
 * @Description:
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private LoginService loginService;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    //    System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        User user = (User)principals.getPrimaryPrincipal();

        List<String> keyList=loginService.puerybyid(user.getId());
        //创建授权
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermissions(keyList);

        return simpleAuthorizationInfo;
    }

    /**
     * 认证   登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
      //  System.err.println("getCredentials =====>"+ token.getPrincipal());
        //当前登录的用户名
        String username = token.getPrincipal().toString();
        User password=loginService.selectPwdByUserName(username);
      //  System.err.println("password===>"+password);
        //  User userData= loginService.checkUserMch(userName);
        if(password == null){
            return null;
        }

        //wo ->  guster  ps:123456    实参 -> guster  abcpassword123
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, password.getYhMm(), this.getName());
        //SimpleAuthenticationInfo 构造方法中只需放入正确的用户名和密码即可

        //清之前的授权信息
        super.clearCachedAuthorizationInfo(simpleAuthenticationInfo.getPrincipals());
        //获取SESSION 存入对象
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        HttpSession session = request.getSession();
        session.setAttribute("user",password);

        return simpleAuthenticationInfo;//如果此处返回null 会报UnknownAccountException 没有此账号的异常
        //如果用户名和密码不匹配会抛出 IncorrectCredentialsException异常
    }


}
