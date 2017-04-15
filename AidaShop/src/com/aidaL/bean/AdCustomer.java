package com.aidaL.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AdCustomer entity. @author MyEclipse Persistence Tools
 */

public class AdCustomer implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2250930823488454917L;
	private Integer UId;
	private String UName;
	private String UNickName;
	private String UPassword;
	private String URelaname;
	private String USex;
	private Date UBirthday;
	private String UAddress;
	private String UCardId;
	private String UEmail;
	private String UMobile;
	private Integer UStylingDesigner;
	private Integer UState;
	private Integer UAdmin;
	private Integer stId;
	private Set<?> adWishlists = new HashSet<Object>(0);
	private Set<?> adComments = new HashSet<Object>(0);
	private Set<?> adConsults = new HashSet<Object>(0);
	private Set<?> adOrders = new HashSet<Object>(0);

	// Constructors

	/** default constructor */
	public AdCustomer() {
	}

	/** minimal constructor */
	public AdCustomer(Integer UId, String UName, String UPassword, String USex,
			Integer UState) {
		this.UId = UId;
		this.UName = UName;
		this.UPassword = UPassword;
		this.USex = USex;
		this.UState = UState;
	}

	/** full constructor */
	public AdCustomer(Integer UId, String UName, String UNickName,
			String UPassword, String URelaname, String USex, Date UBirthday,
			String UAddress, String UCardId, String UEmail, String UMobile,
			Integer UStylingDesigner, Integer UState, Integer UAdmin,
			Integer stId, Set<?> adWishlists, Set<?> adComments, Set<?> adConsults,
			Set<?> adOrders) {
		this.UId = UId;
		this.UName = UName;
		this.UNickName = UNickName;
		this.UPassword = UPassword;
		this.URelaname = URelaname;
		this.USex = USex;
		this.UBirthday = UBirthday;
		this.UAddress = UAddress;
		this.UCardId = UCardId;
		this.UEmail = UEmail;
		this.UMobile = UMobile;
		this.UStylingDesigner = UStylingDesigner;
		this.UState = UState;
		this.UAdmin = UAdmin;
		this.stId = stId;
		this.adWishlists = adWishlists;
		this.adComments = adComments;
		this.adConsults = adConsults;
		this.adOrders = adOrders;
	}

	// Property accessors

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUNickName() {
		return this.UNickName;
	}

	public void setUNickName(String UNickName) {
		this.UNickName = UNickName;
	}

	public String getUPassword() {
		return this.UPassword;
	}

	public void setUPassword(String UPassword) {
		this.UPassword = UPassword;
	}

	public String getURelaname() {
		return this.URelaname;
	}

	public void setURelaname(String URelaname) {
		this.URelaname = URelaname;
	}

	public String getUSex() {
		return this.USex;
	}

	public void setUSex(String USex) {
		this.USex = USex;
	}

	public Date getUBirthday() {
		return this.UBirthday;
	}

	public void setUBirthday(Date UBirthday) {
		this.UBirthday = UBirthday;
	}

	public String getUAddress() {
		return this.UAddress;
	}

	public void setUAddress(String UAddress) {
		this.UAddress = UAddress;
	}

	public String getUCardId() {
		return this.UCardId;
	}

	public void setUCardId(String UCardId) {
		this.UCardId = UCardId;
	}

	public String getUEmail() {
		return this.UEmail;
	}

	public void setUEmail(String UEmail) {
		this.UEmail = UEmail;
	}

	public String getUMobile() {
		return this.UMobile;
	}

	public void setUMobile(String UMobile) {
		this.UMobile = UMobile;
	}

	public Integer getUStylingDesigner() {
		return this.UStylingDesigner;
	}

	public void setUStylingDesigner(Integer UStylingDesigner) {
		this.UStylingDesigner = UStylingDesigner;
	}

	public Integer getUState() {
		return this.UState;
	}

	public void setUState(Integer UState) {
		this.UState = UState;
	}

	public Integer getUAdmin() {
		return this.UAdmin;
	}

	public void setUAdmin(Integer UAdmin) {
		this.UAdmin = UAdmin;
	}

	public Integer getStId() {
		return this.stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public Set<?> getAdWishlists() {
		return this.adWishlists;
	}

	public void setAdWishlists(Set<?> adWishlists) {
		this.adWishlists = adWishlists;
	}

	public Set<?> getAdComments() {
		return this.adComments;
	}

	public void setAdComments(Set<?> adComments) {
		this.adComments = adComments;
	}

	public Set<?> getAdConsults() {
		return this.adConsults;
	}

	public void setAdConsults(Set<?> adConsults) {
		this.adConsults = adConsults;
	}

	public Set<?> getAdOrders() {
		return this.adOrders;
	}

	public void setAdOrders(Set<?> adOrders) {
		this.adOrders = adOrders;
	}

}