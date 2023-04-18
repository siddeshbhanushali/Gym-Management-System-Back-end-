package com.gymmanagement.dto;

public class CustomerMembershipDetailResponse {
	
	private String clientId;
	
	private String customerPic;
	
	private String customerName;
	
	private String packageName;
	
	private String price;
	
	private String startDate;
	
	private String endDate;
	
	private String paymentStatus;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getCustomerPic() {
		return customerPic;
	}

	public void setCustomerPic(String customerPic) {
		this.customerPic = customerPic;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "CustomerMembershipDetailResponse [clientId=" + clientId + ", customerPic=" + customerPic
				+ ", customerName=" + customerName + ", packageName=" + packageName + ", price=" + price
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", paymentStatus=" + paymentStatus + "]";
	}

}
