package com.aidaL.bean;

/**
 * AdLogistics entity. @author MyEclipse Persistence Tools
 */

public class AdLogistics implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4843432091233098825L;
	private Integer lgId;
	private String lgCompaby;
	private String lgNumber;
	private Integer OId;

	// Constructors

	/** default constructor */
	public AdLogistics() {
	}

	/** full constructor */
	public AdLogistics(String lgCompaby, String lgNumber, Integer OId) {
		this.lgCompaby = lgCompaby;
		this.lgNumber = lgNumber;
		this.OId = OId;
	}

	// Property accessors

	public Integer getLgId() {
		return this.lgId;
	}

	public void setLgId(Integer lgId) {
		this.lgId = lgId;
	}

	public String getLgCompaby() {
		return this.lgCompaby;
	}

	public void setLgCompaby(String lgCompaby) {
		this.lgCompaby = lgCompaby;
	}

	public String getLgNumber() {
		return this.lgNumber;
	}

	public void setLgNumber(String lgNumber) {
		this.lgNumber = lgNumber;
	}

	public Integer getOId() {
		return this.OId;
	}

	public void setOId(Integer OId) {
		this.OId = OId;
	}

}