package com.aidaL.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aidaL.bean.AdCustomer;
import com.aidaL.bean.AdStore;
import com.aidaL.bean.AdStoreAuth;
import com.aidaL.db.TimeIPDB;
import com.aidaL.service.ActionManager;
import com.aidaL.util.Json;

@SuppressWarnings("serial")
public class StoreAuthAction extends BaseAction {

	private ActionManager samgr;
	private ActionManager stormgr;
	private ActionManager custmgr;
	private List<AdStoreAuth> storeAuths = new ArrayList<AdStoreAuth>();
	private AdStoreAuth storeAuth;
	private AdStore store;
	private AdCustomer cust;
	private Integer saId;
	private Integer UId;
	private String saIdcardFront;
	private String saIdcardBack;
	private String saName;
	private String saTag;
	private Integer saStatu;
	

	/**
	 * 检查该用户是否已经申请过一个商城
	 * @return
	 */
	public String isExist() {
		Integer uid = (Integer) session.getAttribute("cusId");
		AdStoreAuth aStoreAuth = this.samgr.findStoreAuthByUId(uid);
		Json json = new Json();
		if(aStoreAuth!=null) {
			//已存在，无法创建
			json.setMsg("0");
		}else {
			//未存在，可以创建
			json.setMsg("1");
		}
		writeJson(json);
		return null;
	}
	
	/**
	 * 店铺申请表生成
	 * @return
	 */
	public String add() {
		Integer uid = (Integer) session.getAttribute("cusId");
		
		//创建店铺申请表
		AdStoreAuth aStoreAuth = new AdStoreAuth();
		aStoreAuth.setSaName(saName);
		aStoreAuth.setSaTag(saTag);
		aStoreAuth.setSaIdcardFront(saIdcardFront);
		aStoreAuth.setSaIdcardBack(saIdcardBack);
		aStoreAuth.setUId(uid);
		aStoreAuth.setSaStatu(1);
		this.samgr.addStoreAuth(aStoreAuth);
		
		//创建相应店铺表，并返回店铺表ID
		store.setStName(saName);
		store.setStTag(saTag);
		store.setStServiceManner(0.0);
		store.setStServiceQuality(0.0);
		store.setStSpeed(0.0);
		store.setStFavorablerate(0.00);
		store.setStLevel(0);
		store.setStState(4);
		store.setStCreateTime(new Date());
		TimeIPDB timeIPDB = new TimeIPDB();
		store.setStEndTime(timeIPDB.stringToDate(timeIPDB.getAfterMonth(60)));
		Integer sId = this.stormgr.addStoreResID(store);
		
		//修改用户表所寻的stID
		cust = this.custmgr.findCustById(uid);
		cust.setStId(sId);
		this.custmgr.saveOrUpdateCust(cust);
		
		return "add";
	}
	
	/**
	 * 查找所有的店铺申请表
	 * @return
	 */
	public String all() {
		return "all";
	}
	
	
	public ActionManager getSamgr() {
		return samgr;
	}
	public void setSamgr(ActionManager samgr) {
		this.samgr = samgr;
	}
	public List<AdStoreAuth> getStoreAuths() {
		return storeAuths;
	}
	public void setStoreAuths(List<AdStoreAuth> storeAuths) {
		this.storeAuths = storeAuths;
	}
	public AdStoreAuth getStoreAuth() {
		return storeAuth;
	}
	public void setStoreAuth(AdStoreAuth storeAuth) {
		this.storeAuth = storeAuth;
	}
	public Integer getSaId() {
		return saId;
	}
	public void setSaId(Integer saId) {
		this.saId = saId;
	}
	public Integer getUId() {
		return UId;
	}
	public void setUId(Integer uId) {
		UId = uId;
	}
	public Integer getSaStatu() {
		return saStatu;
	}
	public void setSaStatu(Integer saStatu) {
		this.saStatu = saStatu;
	}

	public String getSaIdcardFront() {
		return saIdcardFront;
	}

	public void setSaIdcardFront(String saIdcardFront) {
		this.saIdcardFront = saIdcardFront;
	}

	public String getSaIdcardBack() {
		return saIdcardBack;
	}

	public void setSaIdcardBack(String saIdcardBack) {
		this.saIdcardBack = saIdcardBack;
	}

	public String getSaName() {
		return saName;
	}

	public void setSaName(String saName) {
		this.saName = saName;
	}

	public String getSaTag() {
		return saTag;
	}

	public void setSaTag(String saTag) {
		this.saTag = saTag;
	}

	public ActionManager getStormgr() {
		return stormgr;
	}

	public void setStormgr(ActionManager stormgr) {
		this.stormgr = stormgr;
	}

	public ActionManager getCustmgr() {
		return custmgr;
	}

	public void setCustmgr(ActionManager custmgr) {
		this.custmgr = custmgr;
	}

	public AdStore getStore() {
		return store;
	}

	public void setStore(AdStore store) {
		this.store = store;
	}

	public AdCustomer getCust() {
		return cust;
	}

	public void setCust(AdCustomer cust) {
		this.cust = cust;
	}
	
	
}
