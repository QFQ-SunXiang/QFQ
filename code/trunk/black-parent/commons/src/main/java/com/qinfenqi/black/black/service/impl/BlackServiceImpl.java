/**
 * 
 */
package com.qinfenqi.black.black.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qinfenqi.black.bean.Count;
import com.qinfenqi.black.black.dao.BlackDao;
import com.qinfenqi.black.black.query.BlackQuery;
import com.qinfenqi.black.black.service.BlackService;
import com.qinfenqi.black.common.base.BaseService;
import com.qinfenqi.black.common.constant.Symbol;
import com.qinfenqi.black.user.bean.User;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.Ltd. Beijing
 * @bulid: 2015年9月24日 上午9:27:29
 * @author Chang Yuxin
 * @version 1.0
 */
@Service("blackService")
public class BlackServiceImpl extends BaseService implements BlackService {

	@Resource
	public BlackDao blackDao;

	@Override
	public String getAllBlackCounts() {
		List<Count> list = blackDao.getAllBlackCounts();
		String[] status = { "1", "2", "3", "4" };
		return convertCountResult(status, list);
	}
	@Override
	public String getBlackCounts(long userId) {
		List<Count> list = blackDao.getBlackCounts(userId);
		String[] status = { "1", "2", "3", "4" };
		return convertCountResult(status, list);
	}

	@Override
	public List<BlackQuery> getBlackList(BlackQuery blackQuery) {
		return blackDao.getBlackList(blackQuery);
	}

	@Override
	public int getBlackCount(BlackQuery blackQuery) {
		return blackDao.getBlackCount(blackQuery);
	}

	@Override
	public BlackQuery getBlackById(BlackQuery blackQuery) {
		blackQuery = blackDao.getBlackById(blackQuery.getBlackId());
		String lateEevidence = blackQuery.getLateEvidence();
		if (null != lateEevidence && "".equals(lateEevidence) == false) {
			String[] evidences = lateEevidence.split(Symbol.COMMA);
			if (null != evidences && evidences.length > 0) {
				blackQuery.setEvidences(Arrays.asList(evidences));
			}
		}
		return blackDao.getBlackById(blackQuery.getBlackId());
	}

	@Override
	public boolean addBlack(BlackQuery blackQuery) {
		blackQuery.setAuditStatus(3);
		blackQuery.setPublishTime(new Date());
		return blackDao.createBlack(blackQuery);
	}

	@Override
	public boolean editBlack(BlackQuery blackQuery) {
		return blackDao.modifyBlack(blackQuery);
	}
	
	@Override
	public boolean deleteBlack(BlackQuery blackQuery) {
		return blackDao.deleteBlack(blackQuery);
	}
	
	@Override
	public boolean updateBlack(BlackQuery blackQuery, User user) {
		return blackDao.updateBlack(blackQuery);
	}
}
