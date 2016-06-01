package com.qinfenqi.black.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qinfenqi.black.user.bean.User;
import com.qinfenqi.black.user.query.UserQuery;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.Ltd. Beijing
 * @bulid: 2015年5月27日 下午2:40:59
 * @author Chang Yuxin
 * @version 1.0
 */
@Repository
public interface UserDao {

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
	 * @return
	 */
	boolean updateUser(User user);

	/**
	 * @param userQuery
	 * @return
	 */
	boolean createUser(UserQuery userQuery);

}
