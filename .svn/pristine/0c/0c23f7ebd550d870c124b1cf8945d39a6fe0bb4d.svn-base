/**
 * 
 */
package com.qinfenqi.black.admin.user;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.qinfenqi.black.admin.common.BaseActionEx;
import com.qinfenqi.black.user.query.UserQuery;
import com.qinfenqi.black.user.service.UserService;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.,Ltd. Beijing
 * @bulid: 2015年8月10日 上午10:59:26
 * @author Chang Yuxin
 * @version 1.0
 */
public class UserAction extends BaseActionEx {

	/**  */
	private static final long serialVersionUID = 7019594951775848845L;
	@Resource
	private UserService userService;

	private UserQuery userQuery = new UserQuery();
	private List<UserQuery> userList;

	/**
	 * 用户管理首页
	 * 
	 * @return
	 */
	public String index() {
		return "index";
	}

	/**
	 * 用户列表
	 * 
	 * @return
	 */
	public String getUserPage() {
		userQuery.setOrderField("create_time");
		userList = userService.getAllUserList(userQuery);
		double total = userService.getAllUserCount(userQuery);
		double pageSize = userQuery.getPageSize();
		// 页数
		int pageTotal = (int) Math.ceil(total / pageSize);
		userQuery.setPageTotal(pageTotal);
		userQuery.setTotal((int) total);
		return "manage";
	}

	/**
	 * 审核通过
	 * 
	 * @return
	 */
	public String auditPass() {
		JSONObject json = new JSONObject();
		userQuery.setAuditStatus(1);
		boolean result = userService.updateUser(userQuery);
		json.put("result", result ? SUCCESS : FAILURE);
		ajaxReturnValue = json.toString();
		return AJAX;
	}
	
	/**
	 * 审核不通过
	 * 
	 * @return
	 */
	public String auditNoPass() {
		JSONObject json = new JSONObject();
		userQuery.setAuditStatus(2);
		boolean result = userService.updateUser(userQuery);
		json.put("result", result ? SUCCESS : FAILURE);
		ajaxReturnValue = json.toString();
		return AJAX;
	}
	
	/**
	 * 查看用户
	 * @return
	 */
	public String showUserInfo(){
		userQuery = userService.getUserByUserId(userQuery);
		return "detail";
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
	 * @return the userList
	 */
	public List<UserQuery> getUserList() {
		return userList;
	}

	/**
	 * @param userList
	 *            the userList to set
	 */
	public void setUserList(List<UserQuery> userList) {
		this.userList = userList;
	}

}
