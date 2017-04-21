package com.aidaL.action;

import java.util.ArrayList;
import java.util.List;

import com.aidaL.bean.AdStoreAuth;
import com.aidaL.service.ActionManager;

@SuppressWarnings("serial")
public class StoreAuthAction extends BaseAction {

	private ActionManager samgr;
	private List<AdStoreAuth> storeAuths = new ArrayList<AdStoreAuth>();
	private AdStoreAuth storeAuth;
	private Integer saId;
	private Integer UId;
	private String saIdcardFront;
	private String saIdcardBack;
	private String saName;
	private String saTag;
	private Integer saStatu;
	
	
	public String add() {
		
		
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
	
	
}
