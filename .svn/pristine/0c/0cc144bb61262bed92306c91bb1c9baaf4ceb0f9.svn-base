package com.qinfenqi.black.view.common;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.qinfenqi.black.common.constant.Constant;

@Component("loginInterceptor")
public class LoginInterceptor extends MethodFilterInterceptor {
	// private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	private static final long serialVersionUID = -595527669236070035L;
	/** 合法请求后缀 */
	public static final String REQUESTURI_SUFFIX = ".do";
	/** 验证失败或超时转向 */
	public static final String INDEX = "index/index!indexPage.do";
	/** 限制访问转向 */
	public static final String FORBIDDEN_RESULT = "forbidden";

	/**
	 * 额外要放开的Action
	 */
	protected static final String[] FREE_ACTIONS = {
			// Login
			"login.do",
			"login/login!regist.do",
			"login/login!userRegist.do",
			"login/login!login.do",
			"login/login!userLogin.do",
			"login/login!findpwd.do",
			"login/login!getValidCodeImg.do",
			"login/login!checkMobileRegist.do",
			"login/login!checkValidateCode.do",
			
			
			// Index
			"index/index!index.do",
			"index/index!search.do",
			
			// Black
			"black/black!detail.do",
			"black/black!search.do"
			
			
		};

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		String result = INDEX;
		String currentURL = getCurrentURL();
		System.out.println("=======================currentURL ====================== " + currentURL + "===============================");
		if (currentURL.endsWith(REQUESTURI_SUFFIX)) {
			for (String action : FREE_ACTIONS) {
				if (currentURL.equals(action)) {
					return invocation.invoke();
				}
			}
			ActionContext ctx = invocation.getInvocationContext();
			// 如果当前用户未登录过系统
			if (ctx.getSession().get(Constant.CURRENT_USER) != null) {
				// 返回请求内容
				return invocation.invoke();
			} else {
				return "login";
			}
		}
		return result;

	}

	/**
	 * 获取当前url
	 * 
	 * @return String
	 */
	public String getCurrentURL() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentURL = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (currentURL.startsWith(contextPath)) {
			currentURL = currentURL.replaceFirst(contextPath + "/", "");
		}

		return currentURL;
	}

	/**
	 * 获取当前请求参数的Json
	 * 
	 * @return String
	 */
	public String getCurrentParameters() {
		String parameterJson = "";
		JSONObject json = new JSONObject();
		HttpServletRequest request = ServletActionContext.getRequest();
		Enumeration<?> parameterEnum = request.getParameterNames();
		while (parameterEnum.hasMoreElements()) {
			String paramName = (String) parameterEnum.nextElement();
			String[] values = request.getParameterValues(paramName);
			for (int i = 0; i < values.length; i++) {
				json.put(paramName, values);
			}
		}
		if (json.size() > 0) {
			parameterJson = json.toString();
		}
		return parameterJson;
	}

}
