/**
 * 
 */
package com.qinfenqi.black.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinfenqi.black.common.base.BaseService;
import com.qinfenqi.black.common.constant.Symbol;
import com.qinfenqi.black.common.ip.IPSeeker;
import com.qinfenqi.black.user.bean.User;
import com.qinfenqi.black.user.dao.UserDao;
import com.qinfenqi.black.user.query.UserQuery;
import com.qinfenqi.black.user.service.UserService;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.Ltd. Beijing
 * @bulid: 2015年5月27日 上午11:12:53
 * @author Chang Yuxin
 * @version 1.0
 */
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {

	@Autowired
	public UserDao userDao;

	@Resource
	private IPSeeker ipSeeker;

	@Override
	public List<User> getUserByUserName(String userName) {
		return userDao.getUserByUserName(userName);
	}

	@Override
	public List<UserQuery> getAllUserList(UserQuery userQuery) {
		List<UserQuery> list = userDao.getAllUserList(userQuery);
		for (UserQuery user : list) {
			dealUserIpInfo(user);
		}
		return list;
	}

	/**
	 * 处理用户的IP信息
	 * 
	 * @param user
	 */
	public void dealUserIpInfo(UserQuery user) {
		String currentLoginIp = user.getCurrentLoginIp();
		String lastLoginIp = user.getLastLoginIp();
		String registIp = user.getRegisterIp();
		// 当前IP所在地
		if (null != currentLoginIp && !"".equals(currentLoginIp)) {
			user.setCurrentIpArea(ipSeeker.getCountry(currentLoginIp) + Symbol.COLON + ipSeeker.getArea(currentLoginIp));
		}
		// 上次IP所在地
		if (null != lastLoginIp && !"".equals(lastLoginIp)) {
			user.setLastIpArea(ipSeeker.getCountry(lastLoginIp) + Symbol.COLON + ipSeeker.getArea(lastLoginIp));
		}
		// 注册IP所在地
		if (null != registIp && !"".equals(registIp)) {
			user.setRegistIpArea(ipSeeker.getCountry(registIp) + Symbol.COLON + ipSeeker.getArea(registIp));
		}
	}

	@Override
	public int getAllUserCount(UserQuery userQuery) {
		return userDao.getAllUserCount(userQuery);
	}

	@Override
	public UserQuery getUserByUserId(UserQuery userQuery) {
		userQuery = userDao.getUserByUserId(userQuery);
		dealUserIpInfo(userQuery);
		return userQuery;
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public boolean createUser(UserQuery userQuery) {
		userQuery.setUserStyle(1);
		return userDao.createUser(userQuery);
	}

}
