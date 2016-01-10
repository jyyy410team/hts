package com.jeecms.core.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

/**
 * 自定义DB Realm //后台登录进来了
 * 
 */
public class CmsAuthorizingRealm extends AuthorizingRealm {

	/**
	 * 登录认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(// 是否有这个用户3
			AuthenticationToken authcToken) throws AuthenticationException {
		/*
		 * UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		 * CmsUser user = cmsUserMng.findByUsername(token.getUsername()); if
		 * (user != null) { UnifiedUser unifiedUser =
		 * unifiedUserMng.findById(user.getId());
		 */
		return new SimpleAuthenticationInfo("", "", getName());
		/*
		 * } else { return null; }
		 */
	}

	/**
	 * 授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {// 把权限放入za，可以访问的地址4
		String username = (String) principals.getPrimaryPrincipal();
		/*
		 * CmsUser user = cmsUserMng.findByUsername(username); CmsSite
		 * site=CmsThreadVariable.getSite();
		 */
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		/*
		 * if (user != null) { Set<String>viewPermissionSet=new
		 * HashSet<String>(); Set<String> perms =
		 * user.getPerms(site.getId(),viewPermissionSet); if
		 * (!CollectionUtils.isEmpty(perms)) { // 权限加入AuthorizationInfo认证对象
		 * auth.setStringPermissions(perms); } }
		 */
		return auth;
	}

	public void removeUserAuthorizationInfoCache(String username) {// 移除缓存
		SimplePrincipalCollection pc = new SimplePrincipalCollection();
		pc.add(username, super.getName());
		super.clearCachedAuthorizationInfo(pc);
	}

	/*
	 * protected CmsUserMng cmsUserMng; protected UnifiedUserMng
	 * unifiedUserMng;//统一用户表
	 * 
	 * @Autowired public void setCmsUserMng(CmsUserMng cmsUserMng) {
	 * this.cmsUserMng = cmsUserMng; }
	 * 
	 * @Autowired public void setUnifiedUserMng(UnifiedUserMng unifiedUserMng) {
	 * this.unifiedUserMng = unifiedUserMng; }
	 */

}
