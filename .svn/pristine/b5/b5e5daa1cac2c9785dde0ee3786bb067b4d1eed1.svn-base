/**
 * 
 */
package com.qinfenqi.black.view.login;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.qinfenqi.black.common.base.BaseAction;
import com.qinfenqi.black.user.bean.User;
import com.qinfenqi.black.user.query.UserQuery;
import com.qinfenqi.black.user.service.UserService;
import com.qinfenqi.black.util.CreateImageCode;
import com.qinfenqi.black.util.ValidateCode;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.Ltd. Beijing
 * @bulid: 2015年6月4日 上午9:35:12
 * @author Chang Yuxin
 * @version 1.0
 */
public class LoginAction extends BaseAction {

	/**  */
	private static final long serialVersionUID = 6029336344794945384L;

	private static final String VALIDATE_CODE_KEY = "validateCode";
	@Resource
	private UserService userService;

	private UserQuery userQuery;

	/** 验证码图片 */
	private InputStream inputStream;

	private String message;

	/**
	 * 注册
	 * 
	 * @return
	 */
	public String regist() {
		return "regist";
	}

	/**
	 * 注册用户
	 * 
	 * @return
	 */
	public String userRegist() {
		JSONObject json = new JSONObject();
		userQuery.setRegisterIp(request.getRemoteAddr());
		boolean result = userService.createUser(userQuery);
		getUserLoginInfo(userQuery);
		// 更新当前登录用户的登录信息
		userService.updateUser(userQuery);
		// 保存用户到session
		setCurrentUser(userQuery);
		json.put("result", result ? SUCCESS : FAILURE);
		ajaxReturnValue = json.toString();
		return AJAX;
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String login() {
		return "login";
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String userLogin() {
		JSONObject json = new JSONObject();
		List<User> users = userService.getUserByUserName(userQuery.getUserName());
		if (users == null || users.size() == 0) {
			message = "账号不存在!";
		} else {
			User user = users.get(0);
			if (user.getPassword().equals(user.getPassword()) == false) {
				message = "密码不正确!";
			} else {
				user.setPassword(null);
				// 将上次当前登陆的属性保存到上次登录的属性中
				user.setLastLoginIp(user.getCurrentLoginIp());
				user.setLastLoginTime(user.getCurrentLoginTime());
				setCurrentUser(user);
			}
			getUserLoginInfo(user);
			// 更新当前登录用户的登录信息
			userService.updateUser(user);
			// userService.saveLog(user, message);// 记录登录日志
		}
		json.put("result", StringUtils.isNotBlank(message) ? FAILURE : SUCCESS);
		json.put("message", message);
		ajaxReturnValue = json.toString();
		return AJAX;

	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	public String logout(){
		request.getSession().invalidate();
		JSONObject json = new JSONObject();
		json.put("result", SUCCESS);
		ajaxReturnValue = json.toString();
		return AJAX;
	}
	
	/**
	 * 忘记密码
	 * 
	 * @return
	 */
	public String findpwd() {
		return "findpwd";
	}

	/**
	 * 生成验证码图片
	 * 
	 * @return
	 */
	public String getValidCodeImg() {
		String validateCode = ValidateCode.getValidateCode();
		session.put(VALIDATE_CODE_KEY, validateCode.toLowerCase());
		inputStream = CreateImageCode.getImageAsInputStream(validateCode);
		return "picDisplay";
	}

	/**
	 * 校验验证码是否正确
	 * 
	 * @return
	 */
	public String checkValidateCode() {
		JSONObject json = new JSONObject();
		json.put("code", 0);
		String validateCode = userQuery.getValidateCode();
		if (validateCode == null || validateCode.length() == 0) {
			json.put("code", -1);
		} else {
			if (!session.get(VALIDATE_CODE_KEY).equals(validateCode.toLowerCase())) {
				json.put("code", -2);
			}
		}
		ajaxReturnValue = json.toString();
		return AJAX;
	}

	/**
	 * 检查手机号是否注册过
	 * 
	 * @return
	 */
	public String checkMobileRegist() {
		JSONObject json = new JSONObject();
		List<User> users = userService.getUserByUserName(userQuery.getUserName());
		json.put("result", users.size() > 0 ? FAILURE : SUCCESS);
		ajaxReturnValue = json.toString();
		return AJAX;
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream
	 *            the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * @return the userQuery
	 */
	public UserQuery getUserQuery() {
		return userQuery;
	}

	/**
	 * @param userQuery
	 *            the userQuery to set
	 */
	public void setUserQuery(UserQuery userQuery) {
		this.userQuery = userQuery;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
