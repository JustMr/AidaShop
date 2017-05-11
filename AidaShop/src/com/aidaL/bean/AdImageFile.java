package com.aidaL.bean;

/**
 * AdImageFile entity. @author MyEclipse Persistence Tools
 */

public class AdImageFile implements java.io.Serializable {

	// Fields

	private Integer ifId;
	private Integer ifPosition;
	private Integer ifPid;
	private Integer ifCust;
	private Integer ifStid;
	private String ifFilepath;
	private Integer ifSn;

	// Constructors

	/** default constructor */
	public AdImageFile() {
	}

	/** minimal constructor */
	public AdImageFile(Integer ifId) {
		this.ifId = ifId;
	}

	/** full constructor */
	public AdImageFile(Integer ifId, Integer ifPosition, Integer ifPid,
			Integer ifCust, Integer ifStid, String ifFilepath, Integer ifSn) {
		this.ifId = ifId;
		this.ifPosition = ifPosition;
		this.ifPid = ifPid;
		this.ifCust = ifCust;
		this.ifStid = ifStid;
		this.ifFilepath = ifFilepath;
		this.ifSn = ifSn;
	}

	// Property accessors

	public Integer getIfId() {
		return this.ifId;
	}

	public void setIfId(Integer ifId) {
		this.ifId = ifId;
	}

	public Integer getIfPosition() {
		return this.ifPosition;
	}

	public void setIfPosition(Integer ifPosition) {
		this.ifPosition = ifPosition;
	}

	public Integer getIfPid() {
		return this.ifPid;
	}

	public void setIfPid(Integer ifPid) {
		this.ifPid = ifPid;
	}

	public Integer getIfCust() {
		return this.ifCust;
	}

	public void setIfCust(Integer ifCust) {
		this.ifCust = ifCust;
	}

	public Integer getIfStid() {
		return this.ifStid;
	}

	public void setIfStid(Integer ifStid) {
		this.ifStid = ifStid;
	}

	public String getIfFilepath() {
		return this.ifFilepath;
	}

	public void setIfFilepath(String ifFilepath) {
		this.ifFilepath = ifFilepath;
	}

	public Integer getIfSn() {
		return this.ifSn;
	}

	public void setIfSn(Integer ifSn) {
		this.ifSn = ifSn;
	}

}