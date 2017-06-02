package com.aidaL.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * AdOrder entity. @author MyEclipse Persistence Tools
 */

public class AdOrder implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1876908301088761329L;
	private Integer coId;
	private AdCustomer adCustomer;
	private String coName;
	private Double coTotalPrice;
	private Double coDiscountPrice;
	private Double coFreightCharge;
	private Double coRealPrice;
	private Timestamp coCreateTime;
	private String coPaymentWay;
	private String coOrderState;
	private Integer shId;
	private Set<?> adOrderitems = new HashSet<Object>(0);
	
	//add by myserlf
	private List<AdOrderitem> orderitems = new ArrayList<AdOrderitem>();

	// Constructors

	/** default constructor */
	public AdOrder() {
	}

	/** full constructor */
	public AdOrder(AdCustomer adCustomer, String coName, Double coTotalPrice,
			Double coDiscountPrice, Double coFreightCharge, Double coRealPrice,
			Timestamp coCreateTime, String coPaymentWay, String coOrderState,
			Integer shId, Set<?> adOrderitems) {
		this.adCustomer = adCustomer;
		this.coName = coName;
		this.coTotalPrice = coTotalPrice;
		this.coDiscountPrice = coDiscountPrice;
		this.coFreightCharge = coFreightCharge;
		this.coRealPrice = coRealPrice;
		this.coCreateTime = coCreateTime;
		this.coPaymentWay = coPaymentWay;
		this.coOrderState = coOrderState;
		this.shId = shId;
		this.adOrderitems = adOrderitems;
	}

	// Property accessors

	public Integer getCoId() {
		return this.coId;
	}

	public void setCoId(Integer coId) {
		this.coId = coId;
	}

	public AdCustomer getAdCustomer() {
		return this.adCustomer;
	}

	public void setAdCustomer(AdCustomer adCustomer) {
		this.adCustomer = adCustomer;
	}

	public String getCoName() {
		return this.coName;
	}

	public void setCoName(String coName) {
		this.coName = coName;
	}

	public Double getCoTotalPrice() {
		return this.coTotalPrice;
	}

	public void setCoTotalPrice(Double coTotalPrice) {
		this.coTotalPrice = coTotalPrice;
	}

	public Double getCoDiscountPrice() {
		return this.coDiscountPrice;
	}

	public void setCoDiscountPrice(Double coDiscountPrice) {
		this.coDiscountPrice = coDiscountPrice;
	}

	public Double getCoFreightCharge() {
		return this.coFreightCharge;
	}

	public void setCoFreightCharge(Double coFreightCharge) {
		this.coFreightCharge = coFreightCharge;
	}

	public Double getCoRealPrice() {
		return this.coRealPrice;
	}

	public void setCoRealPrice(Double coRealPrice) {
		this.coRealPrice = coRealPrice;
	}

	public Timestamp getCoCreateTime() {
		return this.coCreateTime;
	}

	public void setCoCreateTime(Timestamp coCreateTime) {
		this.coCreateTime = coCreateTime;
	}

	public String getCoPaymentWay() {
		return this.coPaymentWay;
	}

	public void setCoPaymentWay(String coPaymentWay) {
		this.coPaymentWay = coPaymentWay;
	}

	public String getCoOrderState() {
		return this.coOrderState;
	}

	public void setCoOrderState(String coOrderState) {
		this.coOrderState = coOrderState;
	}

	public Integer getShId() {
		return this.shId;
	}

	public void setShId(Integer shId) {
		this.shId = shId;
	}

	public Set<?> getAdOrderitems() {
		return this.adOrderitems;
	}

	public void setAdOrderitems(Set<?> adOrderitems) {
		this.adOrderitems = adOrderitems;
	}

	public List<AdOrderitem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<AdOrderitem> orderitems) {
		this.orderitems = orderitems;
	}

}