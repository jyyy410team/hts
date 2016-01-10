package com.jeecms.core.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CmsAuthenticationFilter自定义登录认证filter //后台登录进来了
 */
public class CmsAuthenticationFilter extends FormAuthenticationFilter {

	private Logger logger = LoggerFactory
			.getLogger(CmsAuthenticationFilter.class);

	public static final String COOKIE_ERROR_REMAINING = "_error_remaining";
	/**
	 * 验证码名称
	 */
	public static final String CAPTCHA_PARAM = "captcha";
	/**
	 * 返回URL
	 */
	public static final String RETURN_URL = "returnUrl";

	public boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {// 1
		boolean isAllowed = isAccessAllowed(request, response, mappedValue);
		// 登录跳转
		if (isAllowed && isLoginRequest(request, response)) {
			try {
				issueSuccessRedirect(request, response);
			} catch (Exception e) {
				logger.error("", e);
			}
			return false;
		}
		return isAllowed || onAccessDenied(request, response, mappedValue);
	}

	protected boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {// 2
		AuthenticationToken token = createToken(request, response);
		return true;
	}

	/**
	 * 登录失败
	 */
	private boolean onLoginFailure(AuthenticationToken token,
			boolean adminLogin, AuthenticationException e,
			ServletRequest request, ServletResponse response) {
		return true;
	}

	private boolean isCaptchaRequired(String username,
			HttpServletRequest request, HttpServletResponse response) {
		return true;
	}

	// 用户禁用返回true 未查找到用户或者非禁用返回false
	private boolean isDisabled(String username) {
		return true;
	}

}
