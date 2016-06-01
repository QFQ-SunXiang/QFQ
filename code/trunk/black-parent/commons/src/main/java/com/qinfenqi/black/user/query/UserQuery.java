/**
 * 
 */
package com.qinfenqi.black.user.query;

import com.qinfenqi.black.user.bean.User;

/**
 * @Title:
 * @Description:
 * @Copyright: Copyright (c) 2015 - 2015
 * @Company: Qinfenqi Technology Co.Ltd. Beijing
 * @bulid: 2015年6月5日 下午2:14:01
 * @author Chang Yuxin
 * @version 1.0
 */
public class UserQuery extends User {

	private String deptName;
	
	private String roleName;

	private String confirmPass;
	
	private String currentIpArea;
	private String lastIpArea;
	private String registIpArea;

	private String validateCode;

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the confirmPass
	 */
	public String getConfirmPass() {
		return confirmPass;
	}

	/**
	 * @param confirmPass the confirmPass to set
	 */
	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	/**
	 * @return the currentIpArea
	 */
	public String getCurrentIpArea() {
		return currentIpArea;
	}

	/**
	 * @param currentIpArea the currentIpArea to set
	 */
	public void setCurrentIpArea(String currentIpArea) {
		this.currentIpArea = currentIpArea;
	}

	/**
	 * @return the lastIpArea
	 */
	public String getLastIpArea() {
		return lastIpArea;
	}

	/**
	 * @param lastIpArea the lastIpArea to set
	 */
	public void setLastIpArea(String lastIpArea) {
		this.lastIpArea = lastIpArea;
	}

	/**
	 * @return the registIpArea
	 */
	public String getRegistIpArea() {
		return registIpArea;
	}

	/**
	 * @param registIpArea the registIpArea to set
	 */
	public void setRegistIpArea(String registIpArea) {
		this.registIpArea = registIpArea;
	}

	/**
	 * @return the validateCode
	 */
	public String getValidateCode() {
		return validateCode;
	}

	/**
	 * @param validateCode the validateCode to set
	 */
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
}
