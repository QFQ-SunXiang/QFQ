/**
 * 
 */
package com.qinfenqi.black.black.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qinfenqi.black.bean.Count;
import com.qinfenqi.black.black.query.BlackQuery;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.Ltd. Beijing
 * @bulid: 2015年9月24日 上午9:28:27
 * @author Chang Yuxin
 * @version 1.0
 */
@Repository
public interface BlackDao {

	/**
	 * @return
	 */
	List<Count> getAllBlackCounts();
	/**
	 * @return
	 */
	List<Count> getBlackCounts(long userId);

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
	 * @param blackId
	 * @return
	 */
	BlackQuery getBlackById(long blackId);

	/**
	 * @param blackQuery
	 * @return
	 */
	boolean createBlack(BlackQuery blackQuery);

	/**
	 * @param blackQuery
	 * @return
	 */
	boolean modifyBlack(BlackQuery blackQuery);

	/**
	 * @param blackQuery
	 * @return
	 */
	boolean deleteBlack(BlackQuery blackQuery);
	/**
	 * @param blackQuery
	 * @return
	 */
	boolean updateBlack(BlackQuery blackQuery);

}
