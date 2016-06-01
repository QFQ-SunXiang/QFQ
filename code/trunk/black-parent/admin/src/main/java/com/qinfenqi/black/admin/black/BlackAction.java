/**
 * 
 */
package com.qinfenqi.black.admin.black;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import com.qinfenqi.black.admin.common.BaseActionEx;
import com.qinfenqi.black.black.query.BlackQuery;
import com.qinfenqi.black.black.service.BlackService;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.,Ltd Beijing
 * @bulid: 2015年9月24日 上午9:25:47
 * @author Chang Yuxin
 * @version 1.0
 */
public class BlackAction extends BaseActionEx {

	/**  */
	private static final long serialVersionUID = -7249767878498959669L;

	@Resource
	public BlackService blackService;

	private List<BlackQuery> blackList;

	private BlackQuery blackQuery = new BlackQuery();

	private String countStr;

	/**
	 * 首页
	 * 
	 * @return
	 */
	public String index() {
		countStr = blackService.getAllBlackCounts();
		return "index";
	}

	/**
	 * 黑名单列表
	 * 
	 * @return
	 */
	public String getBlackPage() {
		blackQuery.setPageSize(blackQuery.getPageSize());
		blackQuery.setOrderField("create_time");
		blackList = blackService.getBlackList(blackQuery);
		double total = blackService.getBlackCount(blackQuery);
		double pageSize = blackQuery.getPageSize();
		// 页数
		int pageTotal = (int) Math.ceil(total / pageSize);
		blackQuery.setPageTotal(pageTotal);
		blackQuery.setTotal((int) total);
		return "manage";
	}

	/**
	 * 审核页面
	 * 
	 * @return
	 */
	public String auditPage() {
		blackQuery = blackService.getBlackById(blackQuery);
		return "audit";
	}
	
	/**
	 * 审核通过
	 */
	public String auditPass(){
		JSONObject json = new JSONObject();
		blackQuery.setAuditStatus(1);
		boolean result = blackService.updateBlack(blackQuery, getCurrentUser());
		json.put("result", result ? SUCCESS : FAILURE);
		ajaxReturnValue = json.toString();
		return AJAX;
	}
	
	/**
	 * 审核通过
	 */
	public String auditNoPass(){
		JSONObject json = new JSONObject();
		blackQuery.setAuditStatus(4);
		boolean result = blackService.updateBlack(blackQuery, getCurrentUser());
		json.put("result", result ? SUCCESS : FAILURE);
		ajaxReturnValue = json.toString();
		return AJAX;
	}
	
	
	/**
	 * @return the countStr
	 */
	public String getCountStr() {
		return countStr;
	}

	/**
	 * @param countStr
	 *            the countStr to set
	 */
	public void setCountStr(String countStr) {
		this.countStr = countStr;
	}

	/**
	 * @return the blackList
	 */
	public List<BlackQuery> getBlackList() {
		return blackList;
	}

	/**
	 * @param blackList the blackList to set
	 */
	public void setBlackList(List<BlackQuery> blackList) {
		this.blackList = blackList;
	}

	/**
	 * @return the blackQuery
	 */
	public BlackQuery getBlackQuery() {
		return blackQuery;
	}

	/**
	 * @param blackQuery
	 *            the blackQuery to set
	 */
	public void setBlackQuery(BlackQuery blackQuery) {
		this.blackQuery = blackQuery;
	}

}
