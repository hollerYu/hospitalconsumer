package com.jk.config;

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
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @Auther: yjm
 * @Date: 2019/2/28 17:14
 * @Description:
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    private LoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo  = (User)principals.getPrimaryPrincipal();
       /* for(SysRole role:userInfo.getRoleList()){
            authorizationInfo.addRole(role.getRole());
            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }*/
        return authorizationInfo;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       // UsernamePasswordToken token1 = (UsernamePasswordToken) token;
      //  System.out.println("getCredentials =====>"+ token.getCredentials());

        String userName=(String)token.getPrincipal();   //LoginUserByYhMchByYhMm

        User userMch= loginService.checkUserMch(userName);
        if(userMch == null){
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userMch.getYhMch(), //用户名
                userMch.getYhMm(), //密码
               // ByteSource.Util.bytes(userMch.getCredentialsSalt()),//salt=username+salt
                userMch.getPhoto()   //realm name
        );
        return authenticationInfo;
    }


}
