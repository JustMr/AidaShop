package com.aidaL.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aidaL.bean.AdStore;
import com.aidaL.service.ActionManager;

public class StoreAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7476304005862748048L;

	private Map<String , Object> dataMap;
	private List<AdStore> stores = new ArrayList<AdStore>();
	private ActionManager mgr;
	private Integer stId;
	private AdStore store;
	private String storeName;
	private String StoreTag;
	private Integer stLevel;
	private Integer stState;

	
	/**
	 * 编辑页发送更改请求
	 * @return
	 */
	public String edit() {
		//当定义了Object对象有了getter和setter方法时，以对象传过来，其元素不需要再定义getter和setter方法
		this.mgr.saveOrUpdateStore(store);
		return SUCCESS;
	}
	
	/**
	 * 当前页面，通过改变标签，修改部分数据
	 * @return
	 */
	public String update() {
		AdStore adStore = new AdStore();
		adStore = this.mgr.findStoreById(stId);
		
		adStore.setStLevel(stLevel);
		adStore.setStState(stState);
		
		this.mgr.saveOrUpdateStore(adStore);
		return SUCCESS;
	}
	
	/**
	 * 进入编辑详情页，编辑部分信息
	 * @return
	 */
	public String vi() {
		store = this.mgr.findStoreById(stId);
		return SUCCESS;
	}
	
	/**
	 * 显示所有的店铺列表
	 * @return
	 */
	public String list() {
		stores = this.mgr.findAllStores();
		return SUCCESS;
	}
	
	/**
	 * 店铺管理,依据登录用户查询当前店铺信息
	 * @return
	 */
	public String selectStore() {
		
		Integer id = (Integer)session.getAttribute("cusStore");
		System.out.println("store:"+id);
		AdStore store = mgr.findStoreById(id);
		System.out.println(store.getStName());
		dataMap = new HashMap<String, Object>();
		dataMap.put("store", store);
		dataMap.put("success", true);
		
		return SUCCESS;
	}
	
	/**
	 * ajax更新当前店铺信息
	 * @param storeName 店铺名称
	 * @param StoreTag 店铺标签
	 * @return
	 */
	public String editStore() {
		
		Integer id = (Integer)session.getAttribute("cusStore");
		AdStore store = mgr.findStoreById(id);
		store.setStName(storeName);
		store.setStTag(StoreTag);
		
		this.mgr.saveOrUpdateStore(store);
		
		return null;
	}
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreTag() {
		return StoreTag;
	}

	public void setStoreTag(String storeTag) {
		StoreTag = storeTag;
	}

	public ActionManager getMgr() {
		return mgr;
	}

	public void setMgr(ActionManager mgr) {
		this.mgr = mgr;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public AdStore getStore() {
		return store;
	}

	public void setStore(AdStore store) {
		this.store = store;
	}

	public List<AdStore> getStores() {
		return stores;
	}

	public void setStores(List<AdStore> stores) {
		this.stores = stores;
	}

	public Integer getStId() {
		return stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public Integer getStLevel() {
		return stLevel;
	}

	public void setStLevel(Integer stLevel) {
		this.stLevel = stLevel;
	}

	public Integer getStState() {
		return stState;
	}

	public void setStState(Integer stState) {
		this.stState = stState;
	}


}
