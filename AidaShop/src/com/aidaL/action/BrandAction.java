package com.aidaL.action;

import java.util.ArrayList;
import java.util.List;

import com.aidaL.bean.BrandAD;
import com.aidaL.service.ActionManager;
import com.opensymphony.xwork2.ActionSupport;

public class BrandAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7280318286405674302L;

	protected ActionManager brandmgr;
	private List<BrandAD> listBrands = new ArrayList<BrandAD>();
	private Integer[] brIds;
	private Integer brId;
	private BrandAD brandAD;
	private String brName;
	private Integer brLevelGrand;
    private Integer brState;
    private String brEngName;
    private String brDiscription;

	public String getBrName() {
		return brName;
	}

	public void setBrName(String brName) {
		this.brName = brName;
	}

	public BrandAD getBrandAD() {
		return brandAD;
	}

	public void setBrandAD(BrandAD brandAD) {
		this.brandAD = brandAD;
	}

	public Integer getBrId() {
		return brId;
	}

	public void setBrId(Integer brId) {
		this.brId = brId;
	}

	public Integer[] getBrIds() {
		return brIds;
	}

	public void setBrIds(Integer[] brIds) {
		this.brIds = brIds;
	}

	public List<BrandAD> getListBrands() {
		return listBrands;
	}

	public void setListBrands(List<BrandAD> listBrands) {
		this.listBrands = listBrands;
	}

	public ActionManager getBrandmgr() {
		return brandmgr;
	}

	public void setBrandmgr(ActionManager brandmgr) {
		this.brandmgr = brandmgr;
	}
	
	//查找所有品牌信息
	public String listBrand() throws Exception {
		this.listBrands = this.brandmgr.findAllBrand();
		return "SUCCESS";
	}
	
	//删除或批量删除品牌信息
	public String deleteBrand() {
		if (null!=this.brId) {
			this.brandmgr.deteleBrand(this.brId);
			return "SUCCESS";
		} else{
			if (brIds.length > 0) {
				for (Integer idString : brIds) {
					this.brandmgr.deteleBrand(idString);
				}
				return "SUCCESS";
			}
		}
		return INPUT;
	}
	
	//更新品牌信息
	public String saveBrand() {
		Integer bridInteger = this.brandAD.getBrId();
		brandAD = this.brandmgr.findBrandById(bridInteger);
		return "SUCCESS";
	}
	
	public String updateBrand() {
		BrandAD brand = this.brandmgr.findBrandById(brandAD.getBrId());
		brand.setBrName(brandAD.getBrName());
		brand.setBrEngName(brandAD.getBrEngName());
		brand.setBrDiscription(brandAD.getBrDiscription());
		brand.setBrState(brandAD.getBrState());
		brand.setBrLevelGrand(brandAD.getBrLevelGrand());
		
		this.brandmgr.saveOrUpdateBrand(brand);
		return "SUCCESS";
	}
	
	public String editBrand() {
		this.brandAD = this.brandmgr.findBrandById(brId);
		return "SUCCESS";
	}
	
	//增加品牌信息
	public String addBrand() {
		System.out.println("addBrand");
		if (this.brandmgr.findBrandByName(brName)!=null) {
			return "INPUT";
		} else {
			this.brandmgr.addBrand(brandAD);
			return "SUCCESS";
		}
	}

	public Integer getBrLevelGrand() {
		return brLevelGrand;
	}

	public void setBrLevelGrand(Integer brLevelGrand) {
		this.brLevelGrand = brLevelGrand;
	}

	public Integer getBrState() {
		return brState;
	}

	public void setBrState(Integer brState) {
		this.brState = brState;
	}

	public String getBrEngName() {
		return brEngName;
	}

	public void setBrEngName(String brEngName) {
		this.brEngName = brEngName;
	}

	public String getBrDiscription() {
		return brDiscription;
	}

	public void setBrDiscription(String brDiscription) {
		this.brDiscription = brDiscription;
	}
	
	
}
