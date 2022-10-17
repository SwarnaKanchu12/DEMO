package com.demo.spring.jpa.h2.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tifID;

	@Column(name = "customerId")
	private String customerID;

	@Column(name = "appRefID")
	private long appRefID;

	@Column(name = "customerName")
	private String customerName;

	@Column(name = "mobile")
	private long mobile;

	@Column(name = "loanAmt")
	private long loanAmt;

	@Column(name = "address")
	private String address;

	public Customer() {

	}

	public Customer(long tifID, String customerID, long appRefID, String customerName, long mobile, long loanAmt,
			String address) {
		super();
		this.tifID = tifID;
		this.customerID = customerID;
		this.appRefID = appRefID;
		this.customerName = customerName;
		this.mobile = mobile;
		this.loanAmt = loanAmt;
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Customer [tifID=" + tifID + ", customerID=" + customerID + ", appRefID=" + appRefID + ", customerName="
				+ customerName + ", mobile=" + mobile + ", loanAmt=" + loanAmt + ", address=" + address + "]";
	}

	public long getTifID() {
		return tifID;
	}

	public void setTifID(long tifID) {
		this.tifID = tifID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public long getAppRefID() {
		return appRefID;
	}

	public void setAppRefID(long appRefID) {
		this.appRefID = appRefID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getLoanAmt() {
		return loanAmt;
	}

	public void setLoanAmt(long loanAmt) {
		this.loanAmt = loanAmt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}