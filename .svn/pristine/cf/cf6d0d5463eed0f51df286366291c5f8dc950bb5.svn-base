/**
 * 
 */
package com.qinfenqi.black.user.service;

import java.util.List;

import com.qinfenqi.black.user.bean.User;
import com.qinfenqi.black.user.query.UserQuery;


/**
 * @Title:
 * @Description:  
 * @Copyright: Copyright (c) 2015 - 2015 
 * @Company: Qinfenqi Technology Co.Ltd. Beijing
 * @bulid: 2015年5月27日 上午11:11:33
 * @author Chang Yuxin
 * @version 1.0 
 */
public interface UserService {

	/**
	 * @param userName
	 * @return
	 */
	List<User> getUserByUserName(String userName);

	/**
	 * @param userQuery
	 * @return
	 */
	List<UserQuery> getAllUserList(UserQuery userQuery);

	/**
	 * @param userQuery
	 * @return
	 */
	int getAllUserCount(UserQuery userQuery);

	/**
	 * @param userQuery
	 * @return
	 */
	UserQuery getUserByUserId(UserQuery userQuery);

	/**
	 * @param user
	 */
	boolean updateUser(User user);

	/**
	 * @param userQuery
	 * @return
	 */
	boolean createUser(UserQuery userQuery);


}
