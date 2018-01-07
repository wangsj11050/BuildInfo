package org.tinygroup.buildinfo.app.security;

import java.util.List;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.tinygroup.buildinfo.app.util.Encodes;
import org.tinygroup.buildinfo.service.inter.SysUserService;
import org.tinygroup.buildinfo.service.inter.dto.SysUserDto;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class SystemRealm extends AuthorizingRealm {

	@Autowired
	private SysUserService sysUserService;

    public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();

        if(username != null){
        	SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            List<String> menuList = sysUserService.findPermissions(username);
            if(menuList != null){
            	authorizationInfo.addStringPermissions(menuList);
            }
            return authorizationInfo;
        }else{
        	return null;
        }
        
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String)token.getPrincipal();

        SysUserDto user = sysUserService.getSysUser(username);

        
        if(user == null) {
            throw new UnknownAccountException("用户名或密码错误");//没找到帐号
        }

        if("3".equals(user.getLockStatus())) {
            throw new LockedAccountException("用户状态不正确"); //帐号锁定
        }

        byte[] salt = Encodes.decodeHex(user.getUserPwd().substring(0, 16));
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserId(), //用户名
                user.getUserPwd(), //密码
                ByteSource.Util.bytes(salt),//salt=username+salt
                getName()  //realm name
        );
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

}
