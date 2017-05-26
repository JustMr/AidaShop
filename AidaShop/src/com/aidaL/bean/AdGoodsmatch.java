package com.aidaL.bean;

/**
 * AdGoodsmatch entity. @author MyEclipse Persistence Tools
 */

public class AdGoodsmatch implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4975683121717483915L;
	private Integer gmId;
	private Integer arId;
	private Integer PId;

	// Constructors

	/** default constructor */
	public AdGoodsmatch() {
	}

	/** minimal constructor */
	public AdGoodsmatch(Integer PId) {
		this.PId = PId;
	}

	/** full constructor */
	public AdGoodsmatch(Integer arId, Integer PId) {
		this.arId = arId;
		this.PId = PId;
	}

	// Property accessors

	public Integer getGmId() {
		return this.gmId;
	}

	public void setGmId(Integer gmId) {
		this.gmId = gmId;
	}

	public Integer getArId() {
		return this.arId;
	}

	public void setArId(Integer arId) {
		this.arId = arId;
	}

	public Integer getPId() {
		return this.PId;
	}

	public void setPId(Integer PId) {
		this.PId = PId;
	}

}