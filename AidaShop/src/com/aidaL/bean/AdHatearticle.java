package com.aidaL.bean;

/**
 * AdHatearticle entity. @author MyEclipse Persistence Tools
 */

public class AdHatearticle implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2035138330030842522L;
	private Integer haId;
	private Integer arId;
	private Integer UId;

	// Constructors

	/** default constructor */
	public AdHatearticle() {
	}

	/** full constructor */
	public AdHatearticle(Integer arId, Integer UId) {
		this.arId = arId;
		this.UId = UId;
	}

	// Property accessors

	public Integer getHaId() {
		return this.haId;
	}

	public void setHaId(Integer haId) {
		this.haId = haId;
	}

	public Integer getArId() {
		return this.arId;
	}

	public void setArId(Integer arId) {
		this.arId = arId;
	}

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

}