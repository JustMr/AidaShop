package com.aidaL.bean;

/**
 * AdDesginerinfo entity. @author MyEclipse Persistence Tools
 */

public class AdDesginerinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1609302610150966500L;
	private Integer diId;
	private Integer UId;
	private Integer diArticleCount;
	private Integer diReadCount;
	private Integer diLikeCount;
	private Integer diHateCount;
	private Integer diState;

	
	//add by myself
	private String nickName;
	
	// Constructors

	/** default constructor */
	public AdDesginerinfo() {
	}

	/** minimal constructor */
	public AdDesginerinfo(Integer UId) {
		this.UId = UId;
	}

	/** full constructor */
	public AdDesginerinfo(Integer UId, Integer diArticleCount,
			Integer diReadCount, Integer diLikeCount, Integer diHateCount,
			Integer diState) {
		this.UId = UId;
		this.diArticleCount = diArticleCount;
		this.diReadCount = diReadCount;
		this.diLikeCount = diLikeCount;
		this.diHateCount = diHateCount;
		this.diState = diState;
	}

	// Property accessors

	public Integer getDiId() {
		return this.diId;
	}

	public void setDiId(Integer diId) {
		this.diId = diId;
	}

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public Integer getDiArticleCount() {
		return this.diArticleCount;
	}

	public void setDiArticleCount(Integer diArticleCount) {
		this.diArticleCount = diArticleCount;
	}

	public Integer getDiReadCount() {
		return this.diReadCount;
	}

	public void setDiReadCount(Integer diReadCount) {
		this.diReadCount = diReadCount;
	}

	public Integer getDiLikeCount() {
		return this.diLikeCount;
	}

	public void setDiLikeCount(Integer diLikeCount) {
		this.diLikeCount = diLikeCount;
	}

	public Integer getDiHateCount() {
		return this.diHateCount;
	}

	public void setDiHateCount(Integer diHateCount) {
		this.diHateCount = diHateCount;
	}

	public Integer getDiState() {
		return this.diState;
	}

	public void setDiState(Integer diState) {
		this.diState = diState;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}