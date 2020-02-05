package com.mps.pojo;

public class Employee {
	private int eid;
	private String empFirstName;
	private String empLastName;
	private String gender;
	private String emailId;
	private String password;
	private String confirmPassword;
	private long mobileNumber;
	private String orgName;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
		
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", empFirstName=" + empFirstName
				+ ", empLastName=" + empLastName + ", gender=" + gender
				+ ", emailId=" + emailId + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", mobileNumber="
				+ mobileNumber + ", orgName=" + orgName + "]";
	}
	
}
