package com.aidaL.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aidaL.bean.BrandAD;
import com.aidaL.service.ActionManager;
import com.aidaL.util.Json;

public class BrandAction extends BaseAction {

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
    private Integer stId;
    private Timestamp brApplyTime;
    private Timestamp brEnterTime;

    
    //更新申请表
    public String updateBrandAuth() {
    	BrandAD brand = this.brandmgr.findBrandById(brandAD.getBrId());
		brand.setBrState(brandAD.getBrState());
		this.brandmgr.saveOrUpdateBrand(brand);
    	return SUCCESS;
    }
    
    //查看品牌申请表
    public String viBrandAuth() {
		this.brandAD = this.brandmgr.findBrandById(brId);
		listBrands = this.brandmgr.findBrandAuthByName(brandAD.getBrName(),brandAD.getBrEngName());
		System.out.println("viBrandAuth listBrands:"+listBrands);
		return SUCCESS;
	}
    
    //仅更改状态
    public String updateBrState() {
    	BrandAD brand = this.brandmgr.findBrandById(brId);
    	brand.setBrState(brState);
    	this.brandmgr.saveOrUpdateBrand(brand);
    	return SUCCESS;
    }
    
    //超管查看品牌申请列表
    public String listBrandAuth() {
    	listBrands = this.brandmgr.findBrandAuth();
		return SUCCESS;
	}
    
    //店铺管理员更新当前店铺品牌申请列表
    public void updateBrSt() {
    	brandAD = this.brandmgr.findBrandById(brId);
    	brandAD.setBrName(brName);
    	brandAD.setBrEngName(brEngName);
    	brandAD.setBrDiscription(brDiscription);
    	brandAD.setBrState(3);
    	this.brandmgr.saveOrUpdateBrand(brandAD);
    }
    
    //店铺管理员查看当前店铺品牌申请列表
    public String stListBr() {
    	Json json = new Json();
    	stId = (Integer) session.getAttribute("cusStore");
    	listBrands = this.brandmgr.findBrandByStId(stId);
    	if (listBrands.size()>0) {
			json.setMsg("success");
			json.setObj(listBrands);
			json.setSuccess(true);
		}else {
			json.setMsg("empty");
			json.setSuccess(false);
		}
    	System.out.println(listBrands);
    	writeJson(json);
		return null;
	}
    
    //店铺管理员添加品牌申请 
    public String addBrandStore() {
    	Json json = new Json();
    	json.setSuccess(true);
    	stId = (Integer) session.getAttribute("cusStore");
    	Date date = new Date();       
		brApplyTime = new Timestamp(date.getTime());
		BrandAD brand = new BrandAD();
		brand.setBrApplyTime(brApplyTime);
		brand.setBrName(brName);
		brand.setBrEngName(brEngName);
		brand.setBrDiscription(brDiscription);
		brand.setStId(stId);
		brand.setBrLevelGrand(2);
		brand.setBrState(3);
    	
    	this.brandmgr.addBrand(brand);
    	json.setSuccess(true);
    	writeJson(json);
		return null;
	}
    
    //添加商品显示所有品牌
    public void listBrandSt() throws Exception {
    	Json json = new Json();
		this.listBrands = this.brandmgr.findAllBrand();
		if (listBrands.size()>0) {
			json.setSuccess(true);
			json.setObj(listBrands);
		}else {
			json.setSuccess(false);
		}
		writeJson(json);
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
			Date date = new Date();       
			brEnterTime = new Timestamp(date.getTime());
			brandAD.setBrEnterTime(brEnterTime);
			brandAD.setStId(0);
			this.brandmgr.addBrand(brandAD);
			return "SUCCESS";
		}
	}
    
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
	
	public Integer getStId() {
		return stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
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

	public Timestamp getBrApplyTime() {
		return brApplyTime;
	}

	public void setBrApplyTime(Timestamp brApplyTime) {
		this.brApplyTime = brApplyTime;
	}

	public Timestamp getBrEnterTime() {
		return brEnterTime;
	}

	public void setBrEnterTime(Timestamp brEnterTime) {
		this.brEnterTime = brEnterTime;
	}
	
	
}
