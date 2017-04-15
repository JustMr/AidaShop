package com.aidaL.bean;

import java.sql.Timestamp;

/**
 * AdComment entity. @author MyEclipse Persistence Tools
 */

public class AdComment implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer comId;
	private AdCustomer adCustomer;
	private AdProductInfo adProductInfo;
	private String comContent;
	private Timestamp comTime;
	private Integer comPstate;
	private Integer comLove;
	private Integer comPid;

	// Constructors

	/** default constructor */
	public AdComment() {
	}

	/** minimal constructor */
	public AdComment(Integer comId, AdCustomer adCustomer,
			AdProductInfo adProductInfo, String comContent) {
		this.comId = comId;
		this.adCustomer = adCustomer;
		this.adProductInfo = adProductInfo;
		this.comContent = comContent;
	}

	/** full constructor */
	public AdComment(Integer comId, AdCustomer adCustomer,
			AdProductInfo adProductInfo, String comContent, Timestamp comTime,
			Integer comPstate, Integer comLove, Integer comPid) {
		this.comId = comId;
		this.adCustomer = adCustomer;
		this.adProductInfo = adProductInfo;
		this.comContent = comContent;
		this.comTime = comTime;
		this.comPstate = comPstate;
		this.comLove = comLove;
		this.comPid = comPid;
	}

	// Property accessors

	public Integer getComId() {
		return this.comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public AdCustomer getAdCustomer() {
		return this.adCustomer;
	}

	public void setAdCustomer(AdCustomer adCustomer) {
		this.adCustomer = adCustomer;
	}

	public AdProductInfo getAdProductInfo() {
		return this.adProductInfo;
	}

	public void setAdProductInfo(AdProductInfo adProductInfo) {
		this.adProductInfo = adProductInfo;
	}

	public String getComContent() {
		return this.comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public Timestamp getComTime() {
		return this.comTime;
	}

	public void setComTime(Timestamp comTime) {
		this.comTime = comTime;
	}

	public Integer getComPstate() {
		return this.comPstate;
	}

	public void setComPstate(Integer comPstate) {
		this.comPstate = comPstate;
	}

	public Integer getComLove() {
		return this.comLove;
	}

	public void setComLove(Integer comLove) {
		this.comLove = comLove;
	}

	public Integer getComPid() {
		return this.comPid;
	}

	public void setComPid(Integer comPid) {
		this.comPid = comPid;
	}

}