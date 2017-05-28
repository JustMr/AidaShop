package com.aidaL.bean;

/**
 * AdLikearticle entity. @author MyEclipse Persistence Tools
 */

public class AdLikearticle implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7395324968528117725L;
	private Integer laId;
	private Integer arId;
	private Integer UId;

	// Constructors

	/** default constructor */
	public AdLikearticle() {
	}

	/** full constructor */
	public AdLikearticle(Integer arId, Integer UId) {
		this.arId = arId;
		this.UId = UId;
	}

	// Property accessors

	public Integer getLaId() {
		return this.laId;
	}

	public void setLaId(Integer laId) {
		this.laId = laId;
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