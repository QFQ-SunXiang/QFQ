/**
 * 
 */
package com.qinfenqi.black.black.service;

import java.util.List;

import com.qinfenqi.black.black.query.BlackQuery;
import com.qinfenqi.black.user.bean.User;

/**
 * @Title:
 * @Description:  
 * @Copyright: Copyright (c) 2015 - 2015 
 * @Company: Qinfenqi Technology Co.Ltd. Beijing
 * @bulid: 2015年9月24日 上午9:26:55
 * @author Chang Yuxin
 * @version 1.0 
 */
public interface BlackService {

	/**
	 * @return
	 */
	String getAllBlackCounts();
	/**
	 * @return
	 */
	String getBlackCounts(long userId);

	/**
	 * @param blackQuery
	 * @return
	 */
	List<BlackQuery> getBlackList(BlackQuery blackQuery);

	/**
	 * @param blackQuery
	 * @return
	 */
	int getBlackCount(BlackQuery blackQuery);

	/**
	 * @param blackQuery
	 * @return
	 */
	BlackQuery getBlackById(BlackQuery blackQuery);

	/**
	 * @param blackQuery
	 * @return
	 */
	boolean addBlack(BlackQuery blackQuery);

	/**
	 * @param blackQuery
	 * @return
	 */
	boolean editBlack(BlackQuery blackQuery);

	/**
	 * @param blackQuery
	 * @return
	 */
	boolean deleteBlack(BlackQuery blackQuery);
	/**
	 * @param blackQuery
	 * @param user
	 * @return
	 */
	boolean updateBlack(BlackQuery blackQuery, User user);

}
