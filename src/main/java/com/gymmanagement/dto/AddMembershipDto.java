package com.gymmanagement.dto;

public class AddMembershipDto {
	
	private String clientId;
	private String paymentStatus;
	private int packageId;

	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	@Override
	public String toString() {
		return "AddMembershipDto [clientId=" + clientId + ", paymentStatus=" + paymentStatus + ", packageId="
				+ packageId + "]";
	}
	
}
