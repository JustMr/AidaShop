package com.aidaL.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * AdProductcategory entity. @author MyEclipse Persistence Tools
 */

public class AdProductcategory implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cgId;
	private String cgName;
	private Integer cgLevel;
	private Integer cgPid;
	private Integer cgPosition;
	private Integer cgState;
	private Set<?> adConsultthemes = new HashSet<Object>(0);
	private Set<?> adProductInfos = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public AdProductcategory() {
	}

	/** minimal constructor */
	public AdProductcategory(Integer cgId, String cgName) {
		this.cgId = cgId;
		this.cgName = cgName;
	}

	/** full constructor */
	public AdProductcategory(Integer cgId, String cgName, Integer cgLevel,
			Integer cgPid, Integer cgPosition, Integer cgState,
			Set<?> adConsultthemes, Set<?> adProductInfos) {
		this.cgId = cgId;
		this.cgName = cgName;
		this.cgLevel = cgLevel;
		this.cgPid = cgPid;
		this.cgPosition = cgPosition;
		this.cgState = cgState;
		this.adConsultthemes = adConsultthemes;
		this.adProductInfos = adProductInfos;
	}

	// Property accessors

	public Integer getCgId() {
		return this.cgId;
	}

	public void setCgId(Integer cgId) {
		this.cgId = cgId;
	}

	public String getCgName() {
		return this.cgName;
	}

	public void setCgName(String cgName) {
		this.cgName = cgName;
	}

	public Integer getCgLevel() {
		return this.cgLevel;
	}

	public void setCgLevel(Integer cgLevel) {
		this.cgLevel = cgLevel;
	}

	public Integer getCgPid() {
		return this.cgPid;
	}

	public void setCgPid(Integer cgPid) {
		this.cgPid = cgPid;
	}

	public Integer getCgPosition() {
		return this.cgPosition;
	}

	public void setCgPosition(Integer cgPosition) {
		this.cgPosition = cgPosition;
	}

	public Integer getCgState() {
		return this.cgState;
	}

	public void setCgState(Integer cgState) {
		this.cgState = cgState;
	}

	public Set<?> getAdConsultthemes() {
		return this.adConsultthemes;
	}

	public void setAdConsultthemes(Set<?> adConsultthemes) {
		this.adConsultthemes = adConsultthemes;
	}

	public Set<?> getAdProductInfos() {
		return this.adProductInfos;
	}

	public void setAdProductInfos(Set<?> adProductInfos) {
		this.adProductInfos = adProductInfos;
	}

}