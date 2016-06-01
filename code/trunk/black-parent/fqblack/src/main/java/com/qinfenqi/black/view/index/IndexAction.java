/**
 * 
 */
package com.qinfenqi.black.view.index;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.qinfenqi.black.black.query.BlackQuery;
import com.qinfenqi.black.black.service.BlackService;
import com.qinfenqi.black.common.base.BaseAction;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.Ltd. Beijing
 * @bulid: 2015年5月30日 上午10:02:23
 * @author Chang Yuxin
 * @version 1.0
 */
@Action(results = { @Result(name = "success", location = "index.html", type = "redirect") })
public class IndexAction extends BaseAction {

	/** */
	private static final long serialVersionUID = 7478097343675206642L;
	@Resource
	private BlackService blackService;
	private List<BlackQuery> blackList;
	private BlackQuery blackQuery = new BlackQuery();
	/**
	 * 首页
	 * 
	 * @return
	 */
	public String index() {
		blackQuery.setOrderField("publish_time");
		blackQuery.setAuditStatus(1);
		blackList = blackService.getBlackList(blackQuery);
		double total = blackService.getBlackCount(blackQuery);
		double pageSize = blackQuery.getPageSize();
		// 页数
		int pageTotal = (int) Math.ceil(total / pageSize);
		blackQuery.setPageTotal(pageTotal);
		blackQuery.setTotal((int) total);
		return "index";
	}
	
	/**
	 * 黑名单搜索
	 * 
	 * @return
	 */
	public String search() {
		blackQuery.setOrderField("publish_time");
		blackList = blackService.getBlackList(blackQuery);
		double total = blackService.getBlackCount(blackQuery);
		double pageSize = blackQuery.getPageSize();
		// 页数
		int pageTotal = (int) Math.ceil(total / pageSize);
		blackQuery.setPageTotal(pageTotal);
		blackQuery.setTotal((int) total);
		return "success";
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
	 * @param blackQuery the blackQuery to set
	 */
	public void setBlackQuery(BlackQuery blackQuery) {
		this.blackQuery = blackQuery;
	}
	
}
