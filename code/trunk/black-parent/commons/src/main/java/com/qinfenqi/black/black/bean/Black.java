/**
 * 
 */
package com.qinfenqi.black.black.bean;

import java.util.Date;

import com.qinfenqi.black.common.base.BaseBean;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.Ltd. Beijing
 * @bulid: 2015年9月24日 上午9:34:50
 * @author Chang Yuxin
 * @version 1.0
 */
public class Black extends BaseBean {
	/** 唯一ID */
	private long blackId;
	/** 真实姓名 */
	private String trueName;
	/** 性别 */
	private int sex;
	/** 照片 */
	private String photo;
	/** 手机 */
	private String mobile;
	/** 身份证号 */
	private String idCard;
	/** 身份证地址 */
	private String idCardAddress;
	/** 邮箱  */
	private String email;
	/** QQ号 */
	private String qq;
	/** 微信号 */
	private String wechat;
	/** 家庭地址 */
	private String homeAddress;
	/** 父母姓名  */
	private String parentName;
	/** 父母电话 */
	private String parentMobile;
	/** 公司（学校）名称 */
	private String companyName;
	/** 公司（学校）地址 */
	private String companyAddress;
	/** 公司（学校）职务 */
	private String companyPosition;
	/** 欠款总金额 */
	private double totalArrears;
	/** 总罚息 */
	private double totalPenalty;
	/** 逾期笔数 */
	private int lateTimes;
	/** 逾期天数 */
	private int lateDays;
	/** 逾期证据 */
	private String lateEvidence;
	/** 状态 */
	private int status;
	/** 发布人所属平台 */
	private long platform;
	/** 发布时间 */
	private Date publishTime;
	/** 发布意见 */
	private String publishOpinion;
	/** 审核状态。1：已发布，2：已关闭，3：待审核，4：审核不通过 */
	private int auditStatus;
	/** 审核意见 */
	private String auditOpinion;
	/** 审核时间 */
	private Date auditTime;
	/** 更新时间 */
	private Date modifyTime;
	
	/**
	 * @return the blackId
	 */
	public long getBlackId() {
		return blackId;
	}
	/**
	 * @param blackId the blackId to set
	 */
	public void setBlackId(long blackId) {
		this.blackId = blackId;
	}
	/**
	 * @return the trueName
	 */
	public String getTrueName() {
		return trueName;
	}
	/**
	 * @param trueName the trueName to set
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * @return the idCardAddress
	 */
	public String getIdCardAddress() {
		return idCardAddress;
	}
	/**
	 * @param idCardAddress the idCardAddress to set
	 */
	public void setIdCardAddress(String idCardAddress) {
		this.idCardAddress = idCardAddress;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * @return the wechat
	 */
	public String getWechat() {
		return wechat;
	}
	/**
	 * @param wechat the wechat to set
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}
	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}
	/**
	 * @param parentName the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	/**
	 * @return the parentMobile
	 */
	public String getParentMobile() {
		return parentMobile;
	}
	/**
	 * @param parentMobile the parentMobile to set
	 */
	public void setParentMobile(String parentMobile) {
		this.parentMobile = parentMobile;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}
	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * @return the companyPosition
	 */
	public String getCompanyPosition() {
		return companyPosition;
	}
	/**
	 * @param companyPosition the companyPosition to set
	 */
	public void setCompanyPosition(String companyPosition) {
		this.companyPosition = companyPosition;
	}
	/**
	 * @return the totalArrears
	 */
	public double getTotalArrears() {
		return totalArrears;
	}
	/**
	 * @param totalArrears the totalArrears to set
	 */
	public void setTotalArrears(double totalArrears) {
		this.totalArrears = totalArrears;
	}
	/**
	 * @return the totalPenalty
	 */
	public double getTotalPenalty() {
		return totalPenalty;
	}
	/**
	 * @param totalPenalty the totalPenalty to set
	 */
	public void setTotalPenalty(double totalPenalty) {
		this.totalPenalty = totalPenalty;
	}
	/**
	 * @return the lateTimes
	 */
	public int getLateTimes() {
		return lateTimes;
	}
	/**
	 * @param lateTimes the lateTimes to set
	 */
	public void setLateTimes(int lateTimes) {
		this.lateTimes = lateTimes;
	}
	/**
	 * @return the lateDays
	 */
	public int getLateDays() {
		return lateDays;
	}
	/**
	 * @param lateDays the lateDays to set
	 */
	public void setLateDays(int lateDays) {
		this.lateDays = lateDays;
	}
	
	/**
	 * @return the lateEvidence
	 */
	public String getLateEvidence() {
		return lateEvidence;
	}
	/**
	 * @param lateEvidence the lateEvidence to set
	 */
	public void setLateEvidence(String lateEvidence) {
		this.lateEvidence = lateEvidence;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the platform
	 */
	public long getPlatform() {
		return platform;
	}
	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(long platform) {
		this.platform = platform;
	}
	/**
	 * @return the auditStatus
	 */
	public int getAuditStatus() {
		return auditStatus;
	}
	/**
	 * @param auditStatus the auditStatus to set
	 */
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * @return the auditOpinion
	 */
	public String getAuditOpinion() {
		return auditOpinion;
	}
	/**
	 * @param auditOpinion the auditOpinion to set
	 */
	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}

	/**
	 * @return the publishTime
	 */
	public Date getPublishTime() {
		return publishTime;
	}
	/**
	 * @param publishTime the publishTime to set
	 */
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	/**
	 * @return the publishOpinion
	 */
	public String getPublishOpinion() {
		return publishOpinion;
	}
	/**
	 * @param publishOpinion the publishOpinion to set
	 */
	public void setPublishOpinion(String publishOpinion) {
		this.publishOpinion = publishOpinion;
	}
	/**
	 * @return the auditTime
	 */
	public Date getAuditTime() {
		return auditTime;
	}
	/**
	 * @param auditTime the auditTime to set
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
	/**
	 * @return the modifyTime
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * @param modifyTime the modifyTime to set
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
}
