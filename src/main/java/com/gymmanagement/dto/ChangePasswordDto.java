package com.gymmanagement.dto;

public class ChangePasswordDto {
	
	private int customerId;
	
	private String mobileNo;
	
	private String oldPassword;
	
	private String newPassword;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "ChangePasswordDto [customerId=" + customerId + ", mobileNo=" + mobileNo + ", oldPassword=" + oldPassword
				+ ", newPassword=" + newPassword + "]";
	}
	
}
