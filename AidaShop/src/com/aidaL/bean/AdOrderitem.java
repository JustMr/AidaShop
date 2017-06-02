package com.aidaL.bean;

/**
 * AdOrderitem entity. @author MyEclipse Persistence Tools
 */

public class AdOrderitem implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3886311221563442565L;
	private Integer OId;
	private AdProductInfo adProductInfo;
	private AdOrder adOrder;
	private Integer OAmount;

	// Constructors

	/** default constructor */
	public AdOrderitem() {
	}

	/** minimal constructor */
	public AdOrderitem(AdProductInfo adProductInfo) {
		this.adProductInfo = adProductInfo;
	}

	/** full constructor */
	public AdOrderitem(AdProductInfo adProductInfo, AdOrder adOrder,
			Integer OAmount) {
		this.adProductInfo = adProductInfo;
		this.adOrder = adOrder;
		this.OAmount = OAmount;
	}

	// Property accessors

	public Integer getOId() {
		return this.OId;
	}

	public void setOId(Integer OId) {
		this.OId = OId;
	}

	public AdProductInfo getAdProductInfo() {
		return this.adProductInfo;
	}

	public void setAdProductInfo(AdProductInfo adProductInfo) {
		this.adProductInfo = adProductInfo;
	}

	public AdOrder getAdOrder() {
		return this.adOrder;
	}

	public void setAdOrder(AdOrder adOrder) {
		this.adOrder = adOrder;
	}

	public Integer getOAmount() {
		return this.OAmount;
	}

	public void setOAmount(Integer OAmount) {
		this.OAmount = OAmount;
	}

}