package com.aidaL.bean;

/**
 * AdDeliveryaddress entity. @author MyEclipse Persistence Tools
 */

public class AdDeliveryaddress implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1736625845816922340L;
	private Integer shId;
	private String shName;
	private String shPhone;
	private String shAddress;
	private Integer shState;
	private Integer UId;

	// Constructors

	/** default constructor */
	public AdDeliveryaddress() {
	}

	/** minimal constructor */
	public AdDeliveryaddress(String shName, String shPhone, String shAddress,
			Integer UId) {
		this.shName = shName;
		this.shPhone = shPhone;
		this.shAddress = shAddress;
		this.UId = UId;
	}

	/** full constructor */
	public AdDeliveryaddress(String shName, String shPhone, String shAddress,
			Integer shState, Integer UId) {
		this.shName = shName;
		this.shPhone = shPhone;
		this.shAddress = shAddress;
		this.shState = shState;
		this.UId = UId;
	}

	// Property accessors

	public Integer getShId() {
		return this.shId;
	}

	public void setShId(Integer shId) {
		this.shId = shId;
	}

	public String getShName() {
		return this.shName;
	}

	public void setShName(String shName) {
		this.shName = shName;
	}

	public String getShPhone() {
		return this.shPhone;
	}

	public void setShPhone(String shPhone) {
		this.shPhone = shPhone;
	}

	public String getShAddress() {
		return this.shAddress;
	}

	public void setShAddress(String shAddress) {
		this.shAddress = shAddress;
	}

	public Integer getShState() {
		return this.shState;
	}

	public void setShState(Integer shState) {
		this.shState = shState;
	}

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

}