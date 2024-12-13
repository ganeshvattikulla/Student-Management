package com.st.API;

import org.springframework.stereotype.Component;

@Component
public class Admin {

	private int deptId;
	private String adminName;
	private String adminPassword;
	private String deptName;// ECE,CSC,MECH,CIVIL,EEE
	private String adminRole;// Super_Admin or Dept_Admin;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAdminRole() {
		return adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

	@Override
	public String toString() {
		return "Admin [deptId=" + deptId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", deptName=" + deptName + ", adminRole=" + adminRole + "]";
	}

}
