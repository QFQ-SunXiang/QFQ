package com.qinfenqi.black.user.bean;

import java.util.Date;

import com.qinfenqi.black.common.base.BaseBean;



/**
 * <p>Title:</p> 
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2003 - 2008 </p>
 * <p>Company: Run Technology Co.Ltd. Beijing </p>
 * <p>bulid:  2014-4-30 上午10:10:14</p>
 * @author Yang ximing 
 * @version 1.0 
 */
public class User extends BaseBean{
	
	/** 唯一ID */
	private long userId;
	/** 登录名 */
	private String userName;
	/** 密码 */
	private String password;
	/** 角色ID */
	private int roleId;
	/** 公司名称 */
	private String companyName;
	/** 公司简称 */
	private String companyShortName;
	/** 公司营业执照号 */
	private String companyLicNum;
	/** 创建时间 */
	private Date createTime;
	/** 登录次数 */
	private int loginCount;
	/** 注册IP */
	private String registerIp;
	/** 最后登陆时间 */
	private Date lastLoginTime;
	/** 最后登录IP */
	private String lastLoginIp;
	/** 当前登录时间 */
	private Date currentLoginTime;
	/** 当前登录IP */
	private String currentLoginIp;
	/** 用户状态。1：启动，2：停用 */
	private int userStatus;
	/** 审核时间 */
	private int auditTime;
	/** 审核意见 */
	private int auditOpinion;
	/** 审核状态。1：通过，2：不通过 */
	private int auditStatus;
	/** 用户类型。0:后台用户，1:前台用户 */
	private int userStyle;
	/** 是否删除。1：未删除，2：已删除 */
	private int isDelete;
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
	 * @return the companyShortName
	 */
	public String getCompanyShortName() {
		return companyShortName;
	}
	/**
	 * @param companyShortName the companyShortName to set
	 */
	public void setCompanyShortName(String companyShortName) {
		this.companyShortName = companyShortName;
	}
	/**
	 * @return the companyLicNum
	 */
	public String getCompanyLicNum() {
		return companyLicNum;
	}
	/**
	 * @param companyLicNum the companyLicNum to set
	 */
	public void setCompanyLicNum(String companyLicNum) {
		this.companyLicNum = companyLicNum;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the loginCount
	 */
	public int getLoginCount() {
		return loginCount;
	}
	/**
	 * @param loginCount the loginCount to set
	 */
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
	/**
	 * @return the registerIp
	 */
	public String getRegisterIp() {
		return registerIp;
	}
	/**
	 * @param registerIp the registerIp to set
	 */
	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}
	/**
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * @return the lastLoginIp
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	/**
	 * @return the currentLoginTime
	 */
	public Date getCurrentLoginTime() {
		return currentLoginTime;
	}
	/**
	 * @param currentLoginTime the currentLoginTime to set
	 */
	public void setCurrentLoginTime(Date currentLoginTime) {
		this.currentLoginTime = currentLoginTime;
	}
	/**
	 * @return the currentLoginIp
	 */
	public String getCurrentLoginIp() {
		return currentLoginIp;
	}
	/**
	 * @param currentLoginIp the currentLoginIp to set
	 */
	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}
	/**
	 * @return the userStatus
	 */
	public int getUserStatus() {
		return userStatus;
	}
	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
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
	 * @return the auditTime
	 */
	public int getAuditTime() {
		return auditTime;
	}
	/**
	 * @param auditTime the auditTime to set
	 */
	public void setAuditTime(int auditTime) {
		this.auditTime = auditTime;
	}
	/**
	 * @return the auditOpinion
	 */
	public int getAuditOpinion() {
		return auditOpinion;
	}
	/**
	 * @param auditOpinion the auditOpinion to set
	 */
	public void setAuditOpinion(int auditOpinion) {
		this.auditOpinion = auditOpinion;
	}
	/**
	 * @return the userStyle
	 */
	public int getUserStyle() {
		return userStyle;
	}
	/**
	 * @param userStyle the userStyle to set
	 */
	public void setUserStyle(int userStyle) {
		this.userStyle = userStyle;
	}
	/**
	 * @return the isDelete
	 */
	public int getIsDelete() {
		return isDelete;
	}
	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
}
