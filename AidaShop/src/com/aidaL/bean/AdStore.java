package com.aidaL.bean;

import java.util.Date;

/**
 * AdStore entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class AdStore implements java.io.Serializable {

	// Fields

	private Integer stId;
	private String stName;
	private String stTag;
	private Date stCreateTime;
	private Date stEndTime;
	private Double stServiceManner;
	private Double stServiceQuality;
	private Double stSpeed;
	private Integer stLevel;
	private Integer stState;
	private Double stFavorablerate;

	// Constructors

	/** default constructor */
	public AdStore() {
	}

	/** minimal constructor */
	public AdStore(Integer stId, String stName, Integer stLevel, Integer stState) {
		this.stId = stId;
		this.stName = stName;
		this.stLevel = stLevel;
		this.stState = stState;
	}

	/** full constructor */
	public AdStore(Integer stId, String stName, String stTag,
			Date stCreateTime, Date stEndTime, Double stServiceManner,
			Double stServiceQuality, Double stSpeed, Integer stLevel,
			Integer stState, Double stFavorablerate) {
		this.stId = stId;
		this.stName = stName;
		this.stTag = stTag;
		this.stCreateTime = stCreateTime;
		this.stEndTime = stEndTime;
		this.stServiceManner = stServiceManner;
		this.stServiceQuality = stServiceQuality;
		this.stSpeed = stSpeed;
		this.stLevel = stLevel;
		this.stState = stState;
		this.stFavorablerate = stFavorablerate;
	}

	// Property accessors

	public Integer getStId() {
		return this.stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public String getStName() {
		return this.stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public String getStTag() {
		return this.stTag;
	}

	public void setStTag(String stTag) {
		this.stTag = stTag;
	}

	public Date getStCreateTime() {
		return this.stCreateTime;
	}

	public void setStCreateTime(Date stCreateTime) {
		this.stCreateTime = stCreateTime;
	}

	public Date getStEndTime() {
		return this.stEndTime;
	}

	public void setStEndTime(Date stEndTime) {
		this.stEndTime = stEndTime;
	}

	public Double getStServiceManner() {
		return this.stServiceManner;
	}

	public void setStServiceManner(Double stServiceManner) {
		this.stServiceManner = stServiceManner;
	}

	public Double getStServiceQuality() {
		return this.stServiceQuality;
	}

	public void setStServiceQuality(Double stServiceQuality) {
		this.stServiceQuality = stServiceQuality;
	}

	public Double getStSpeed() {
		return this.stSpeed;
	}

	public void setStSpeed(Double stSpeed) {
		this.stSpeed = stSpeed;
	}

	public Integer getStLevel() {
		return this.stLevel;
	}

	public void setStLevel(Integer stLevel) {
		this.stLevel = stLevel;
	}

	public Integer getStState() {
		return this.stState;
	}

	public void setStState(Integer stState) {
		this.stState = stState;
	}

	public Double getStFavorablerate() {
		return this.stFavorablerate;
	}

	public void setStFavorablerate(Double stFavorablerate) {
		this.stFavorablerate = stFavorablerate;
	}

}