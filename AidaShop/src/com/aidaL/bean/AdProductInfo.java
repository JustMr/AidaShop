package com.aidaL.bean;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * AdProductInfo entity. @author MyEclipse Persistence Tools
 */

public class AdProductInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer PId;
	private AdUploadfile adUploadfile;
	private AdProductcategory adProductcategory;
	private BrandAD brandAD;
	private String PName;
	private String PDescription;
	private Timestamp PCreateTime;
	private Double PBaseprice;
	private Double PMarketprice;
	private Double PSellprice;
	private String PSexrequest;
	private String PPlace;
	private Integer PCount;
	private Integer PCommend;
	private Integer PClickcount;
	private Integer PSellCount;
	@SuppressWarnings("rawtypes")
	private Set adOrderitems = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private Set adConsults = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private Set commentADs = new HashSet(0);
	@SuppressWarnings("rawtypes")
	private Set adWishlists = new HashSet(0);

	// Constructors

	/** default constructor */
	public AdProductInfo() {
	}

	/** minimal constructor */
	public AdProductInfo(Integer PId, String PName) {
		this.PId = PId;
		this.PName = PName;
	}

	/** full constructor */
	@SuppressWarnings("rawtypes")
	public AdProductInfo(Integer PId, AdUploadfile adUploadfile,
			AdProductcategory adProductcategory, BrandAD brandAD, String PName,
			String PDescription, Timestamp PCreateTime, Double PBaseprice,
			Double PMarketprice, Double PSellprice, String PSexrequest,
			String PPlace, Integer PCount, Integer PCommend,
			Integer PClickcount, Integer PSellCount, Set adOrderitems,
			Set adConsults, Set commentADs, Set adWishlists) {
		this.PId = PId;
		this.adUploadfile = adUploadfile;
		this.adProductcategory = adProductcategory;
		this.brandAD = brandAD;
		this.PName = PName;
		this.PDescription = PDescription;
		this.PCreateTime = PCreateTime;
		this.PBaseprice = PBaseprice;
		this.PMarketprice = PMarketprice;
		this.PSellprice = PSellprice;
		this.PSexrequest = PSexrequest;
		this.PPlace = PPlace;
		this.PCount = PCount;
		this.PCommend = PCommend;
		this.PClickcount = PClickcount;
		this.PSellCount = PSellCount;
		this.adOrderitems = adOrderitems;
		this.adConsults = adConsults;
		this.commentADs = commentADs;
		this.adWishlists = adWishlists;
	}

	// Property accessors

	public Integer getPId() {
		return this.PId;
	}

	public void setPId(Integer PId) {
		this.PId = PId;
	}

	public AdUploadfile getAdUploadfile() {
		return this.adUploadfile;
	}

	public void setAdUploadfile(AdUploadfile adUploadfile) {
		this.adUploadfile = adUploadfile;
	}

	public AdProductcategory getAdProductcategory() {
		return this.adProductcategory;
	}

	public void setAdProductcategory(AdProductcategory adProductcategory) {
		this.adProductcategory = adProductcategory;
	}

	public BrandAD getBrandAD() {
		return this.brandAD;
	}

	public void setBrandAD(BrandAD brandAD) {
		this.brandAD = brandAD;
	}

	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

	public String getPDescription() {
		return this.PDescription;
	}

	public void setPDescription(String PDescription) {
		this.PDescription = PDescription;
	}

	public Timestamp getPCreateTime() {
		return this.PCreateTime;
	}

	public void setPCreateTime(Timestamp PCreateTime) {
		this.PCreateTime = PCreateTime;
	}

	public Double getPBaseprice() {
		return this.PBaseprice;
	}

	public void setPBaseprice(Double PBaseprice) {
		this.PBaseprice = PBaseprice;
	}

	public Double getPMarketprice() {
		return this.PMarketprice;
	}

	public void setPMarketprice(Double PMarketprice) {
		this.PMarketprice = PMarketprice;
	}

	public Double getPSellprice() {
		return this.PSellprice;
	}

	public void setPSellprice(Double PSellprice) {
		this.PSellprice = PSellprice;
	}

	public String getPSexrequest() {
		return this.PSexrequest;
	}

	public void setPSexrequest(String PSexrequest) {
		this.PSexrequest = PSexrequest;
	}

	public String getPPlace() {
		return this.PPlace;
	}

	public void setPPlace(String PPlace) {
		this.PPlace = PPlace;
	}

	public Integer getPCount() {
		return this.PCount;
	}

	public void setPCount(Integer PCount) {
		this.PCount = PCount;
	}

	public Integer getPCommend() {
		return this.PCommend;
	}

	public void setPCommend(Integer PCommend) {
		this.PCommend = PCommend;
	}

	public Integer getPClickcount() {
		return this.PClickcount;
	}

	public void setPClickcount(Integer PClickcount) {
		this.PClickcount = PClickcount;
	}

	public Integer getPSellCount() {
		return this.PSellCount;
	}

	public void setPSellCount(Integer PSellCount) {
		this.PSellCount = PSellCount;
	}

	@SuppressWarnings("rawtypes")
	public Set getAdOrderitems() {
		return this.adOrderitems;
	}

	@SuppressWarnings("rawtypes")
	public void setAdOrderitems(Set adOrderitems) {
		this.adOrderitems = adOrderitems;
	}

	@SuppressWarnings("rawtypes")
	public Set getAdConsults() {
		return this.adConsults;
	}

	@SuppressWarnings("rawtypes")
	public void setAdConsults(Set adConsults) {
		this.adConsults = adConsults;
	}

	@SuppressWarnings("rawtypes")
	public Set getCommentADs() {
		return this.commentADs;
	}

	@SuppressWarnings("rawtypes")
	public void setCommentADs(Set commentADs) {
		this.commentADs = commentADs;
	}

	@SuppressWarnings("rawtypes")
	public Set getAdWishlists() {
		return this.adWishlists;
	}

	@SuppressWarnings("rawtypes")
	public void setAdWishlists(Set adWishlists) {
		this.adWishlists = adWishlists;
	}

}