/**
 * 
 */
package com.qinfenqi.black.view.black;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.qinfenqi.black.black.query.BlackQuery;
import com.qinfenqi.black.black.service.BlackService;
import com.qinfenqi.black.common.base.BaseAction;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.,Ltd Beijing
 * @bulid: 2015年10月8日 上午9:10:34
 * @author Chang Yuxin
 * @version 1.0
 */
@Action(results = { @Result(name = "success", location = "manage.html", type = "redirect") })
public class BlackAction extends BaseAction {

	/** */
	private static final long serialVersionUID = -4363943642654674027L;
	@Resource
	private BlackService blackService;
	private List<BlackQuery> blackList;
	private BlackQuery blackQuery = new BlackQuery();
	private String countStr;

	/**
	 * 黑名单详情
	 * 
	 * @return
	 */
	public String detail() {
		blackQuery = blackService.getBlackById(blackQuery);
		return "detail";
	}

	/**
	 * 黑名单详情
	 * 
	 * @return
	 */
	public String manage() {
		blackQuery.setOrderField("publish_time");
		blackQuery.setPlatform(getCurrentUser().getUserId());
		blackList = blackService.getBlackList(blackQuery);
		double total = blackService.getBlackCount(blackQuery);
		double pageSize = blackQuery.getPageSize();
		// 页数
		int pageTotal = (int) Math.ceil(total / pageSize);
		blackQuery.setPageTotal(pageTotal);
		blackQuery.setTotal((int) total);
		countStr = blackService.getBlackCounts(getCurrentUser().getUserId());
		return "manage";
	}

	/**
	 * 保存黑名单页面
	 * 
	 * @return
	 */
	public String savePage() {
		long blackId = blackQuery.getBlackId();
		if (blackId > 0) {
			blackQuery = blackService.getBlackById(blackQuery);
		}
		return "save";
	}

	/**
	 * 保存黑名单
	 * 
	 * @return
	 * @throws IOException
	 */
	public String saveBlack() throws IOException {
		long blackId = blackQuery.getBlackId();
		if (null != upload && upload.length > 0) {
			// 上传头像
			String photo = uploadPhoto(upload[0], uploadContentType[0], "photo");
			blackQuery.setPhoto(photo);

			// 上传欠款证据
			// File[] uploadFile = new File[upload.length - 1];
			// for (int i = 1; i < upload.length; i++) {
			// uploadFile[i - 1] = upload[i];
			// }
			// String[] uploadContentTypes = new String[uploadContentType.length - 1];
			// for (int i = 1; i < uploadContentType.length; i++) {
			// uploadContentTypes[i - 1] = uploadContentType[i];
			// }
			// String evidences = uploadPhotos(uploadFile, uploadContentTypes, "evidences");
			// blackQuery.setLateEvidence(StringUtil.removeLastComma(evidences));
		}
		if (blackId == 0) {
			blackService.addBlack(blackQuery);
		} else {
			blackService.editBlack(blackQuery);
		}
		return "success";
	}

	/**
	 * 删除黑名单
	 * 
	 * @return
	 */
	public String deleteBlack() {
		JSONObject json = new JSONObject();
		boolean result = blackService.deleteBlack(blackQuery);
		json.put("result", result ? SUCCESS : FAILURE);
		ajaxReturnValue = json.toString();
		return AJAX;

	}
	
	/**
	 * 关闭黑名单
	 * 
	 * @return
	 */
	public String closeBlack() {
		JSONObject json = new JSONObject();
		blackQuery.setAuditStatus(2);
		boolean result = blackService.editBlack(blackQuery);
		json.put("result", result ? SUCCESS : FAILURE);
		ajaxReturnValue = json.toString();
		return AJAX;

	}
	
	/**
	 * 发布黑名单
	 * 
	 * @return
	 */
	public String publishBlack() {
		JSONObject json = new JSONObject();
		blackQuery.setAuditStatus(1);
		boolean result = blackService.editBlack(blackQuery);
		json.put("result", result ? SUCCESS : FAILURE);
		ajaxReturnValue = json.toString();
		return AJAX;

	}
	
	/**
	 * @return the blackList
	 */
	public List<BlackQuery> getBlackList() {
		return blackList;
	}

	/**
	 * @param blackList
	 *            the blackList to set
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

}
