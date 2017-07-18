package com.beisun.dinghao.realm;

import com.beisun.dinghao.model.UserModel;
import com.beisun.dinghao.service.UserService;
import com.beisun.dinghao.util.passwordEncry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by DingHao on 2017/7/11.
 */
public class CustomRealm extends AuthorizingRealm {
    private static final Logger log = LogManager.getLogger(CustomRealm.class);

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("======用户授权认证======");
        String userName = principalCollection.getPrimaryPrincipal().toString();

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(userService.queryRolesByName(userName));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("======用户登陆认证======");
        String userName = authenticationToken.getPrincipal().toString();
        UserModel user = userService.queryUserByName(userName);
        if (user == null) {
            throw new UnknownAccountException();    //没找到帐号
        }else if ("1".equals(user.getStatus())){
            throw new LockedAccountException();     //帐号锁定
        }else if("2".equals(user.getStatus())){
            throw new DisabledAccountException();   //账号禁用
        }
        //throw  new ExpiredCredentialsException();//账号过期

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName());
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

    public static void main(String[] args) {
        UserModel use = new UserModel();
        use.setUserName("guest");
        use.setPassword("guest");
        //passwordEncry pe = new passwordEncry();
        UserModel newUse = new passwordEncry().encrypt(use);

        System.out.println(newUse.getUserName());
        System.out.println(newUse.getPassword());
        System.out.println(newUse.getSalt());

    }
}
