package com.aidaL.bean;

/**
 * AdExregood entity. @author MyEclipse Persistence Tools
 */

public class AdExregood implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3784628978720247183L;
	private Integer erId;
	private String erAuth;
	private Integer OId;
	private String erReason;
	private Integer erState;
	private Integer erAmount;
	private String erFeedback;
	private Integer UId;
	private Integer stId;
	
	//ADD by myself
	private AdProductInfo good;

	// Constructors

	/** default constructor */
	public AdExregood() {
	}

	/** minimal constructor */
	public AdExregood(String erAuth) {
		this.erAuth = erAuth;
	}

	/** full constructor */
	public AdExregood(String erAuth, Integer OId, String erReason,
			Integer erState, Integer erAmount, String erFeedback, Integer UId,
			Integer stId) {
		this.erAuth = erAuth;
		this.OId = OId;
		this.erReason = erReason;
		this.erState = erState;
		this.erAmount = erAmount;
		this.erFeedback = erFeedback;
		this.UId = UId;
		this.stId = stId;
	}

	// Property accessors

	public Integer getErId() {
		return this.erId;
	}

	public void setErId(Integer erId) {
		this.erId = erId;
	}

	public String getErAuth() {
		return this.erAuth;
	}

	public void setErAuth(String erAuth) {
		this.erAuth = erAuth;
	}

	public Integer getOId() {
		return this.OId;
	}

	public void setOId(Integer OId) {
		this.OId = OId;
	}

	public String getErReason() {
		return this.erReason;
	}

	public void setErReason(String erReason) {
		this.erReason = erReason;
	}

	public Integer getErState() {
		return this.erState;
	}

	public void setErState(Integer erState) {
		this.erState = erState;
	}

	public Integer getErAmount() {
		return this.erAmount;
	}

	public void setErAmount(Integer erAmount) {
		this.erAmount = erAmount;
	}

	public String getErFeedback() {
		return this.erFeedback;
	}

	public void setErFeedback(String erFeedback) {
		this.erFeedback = erFeedback;
	}

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public Integer getStId() {
		return this.stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public AdProductInfo getGood() {
		return good;
	}

	public void setGood(AdProductInfo good) {
		this.good = good;
	}

}