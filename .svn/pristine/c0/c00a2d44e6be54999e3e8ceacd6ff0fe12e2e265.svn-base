package com.qinfenqi.black.admin.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.qinfenqi.black.common.constant.Constant;
import com.qinfenqi.black.user.bean.User;

@Component("loginInterceptor")
public class LoginInterceptor extends MethodFilterInterceptor {
	// private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	private static final long serialVersionUID = -595527669236070035L;
	/** 合法请求后缀 */
	public static final String REQUESTURI_SUFFIX = ".do";
	/** 验证失败或超时转向 */
	public static final String TIMEOUT_RESULT = "timeout";
	/** 限制访问转向 */
	public static final String FORBIDDEN_RESULT = "forbidden";
	/**
	 * 额外要放开的Action
	 */
	private static final String[] FREE_ACTIONS = { "login.do", "login!logout.do" };

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		String result = TIMEOUT_RESULT;
		String currentURL = getCurrentURL();
		System.out.println("==================== currentURL =====================" + currentURL);
		if (currentURL.endsWith(REQUESTURI_SUFFIX)) {
			for (String action : FREE_ACTIONS) {
				if (currentURL.equals(action)) {
					return invocation.invoke();
				}
			}
			ActionContext ctx = invocation.getInvocationContext();
			User user = (User) ctx.getSession().get(Constant.CURRENT_USER);
			// 如果当前用户未登录过系统
			if (user != null) {
				// 返回请求内容
				return invocation.invoke();
			} else {
				return TIMEOUT_RESULT;
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


}
