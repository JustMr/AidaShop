package com.aidaL.service.impl;

import java.util.List;

import com.aidaL.bean.AdDeliveryaddress;
import com.aidaL.bean.AdExregood;
import com.aidaL.bean.AdLogistics;
import com.aidaL.bean.AdOrder;
import com.aidaL.bean.AdOrderitem;
import com.aidaL.dao.impl.AdDeliveryaddressDAO;
import com.aidaL.dao.impl.AdExregoodDAO;
import com.aidaL.dao.impl.AdLogisticsDAO;
import com.aidaL.dao.impl.AdOrderDAO;
import com.aidaL.dao.impl.AdOrderitemDAO;
import com.aidaL.service.OrderManager;

public class OrderManagerImpl implements OrderManager {

	private AdOrderDAO orderDAO;
	private AdOrderitemDAO orderitemDAO;
	private AdDeliveryaddressDAO deliveryaddressDAO;
	private AdExregoodDAO exregoodDAO;
	private AdLogisticsDAO logisticsDAO;
	
	
	//订单管理***************************
	@Override
	public void saveOrUpdateOrder(AdOrder order) {
		this.orderDAO.attachDirty(order);
	}

	@Override
	public void deleteOrder(Integer coid) {
		this.orderDAO.delete(this.orderDAO.findById(coid));
	}

	@Override
	public void deleteOrder(AdOrder order) {
		this.orderDAO.delete(order);
	}

	@Override
	public void addOrder(AdOrder order) {
		this.orderDAO.save(order);
	}

	@Override
	public List<AdOrder> findOrderByUId(Integer uId, String state) {
		return this.orderDAO.findOrderByUId(uId, state);
	}

	@Override
	public AdOrder findOrderBycoId(Integer coId) {
		return this.orderDAO.findById(coId);
	}

	
	//订单相关条目管理***************************
	@Override
	public void saveOrUpdateOrderItem(AdOrderitem orderItem) {
		this.orderitemDAO.attachDirty(orderItem);
	}

	@Override
	public void deleteOrderItem(Integer oid) {
		this.orderitemDAO.delete(this.orderitemDAO.findById(oid));
	}

	@Override
	public void deleteOrderItem(AdOrderitem orderItem) {
		this.orderitemDAO.delete(orderItem);
	}

	@Override
	public void addOrderItem(AdOrderitem orderItem) {
		this.orderitemDAO.save(orderItem);
	}

	@Override
	public AdOrderitem findOrderitemById(Integer oid) {
		return this.orderitemDAO.findById(oid);
	}

	@Override
	public List<AdOrderitem> findOrderItemByCoId(Integer coId) {
		return this.orderitemDAO.findOrderItemByCoId(coId);
	}

	
	//收货地址管理*******************************
	@Override
	public void saveOrUpdateAddress(AdDeliveryaddress address) {
		this.deliveryaddressDAO.attachDirty(address);
	}

	@Override
	public void deleteAddress(Integer shid) {
		this.deliveryaddressDAO.delete(this.deliveryaddressDAO.findById(shid));
	}

	@Override
	public void deleteAddress(AdDeliveryaddress address) {
		this.deliveryaddressDAO.delete(address);
	}

	@Override
	public void addAddress(AdDeliveryaddress address) {
		this.deliveryaddressDAO.save(address);
	}

	@Override
	public List<AdDeliveryaddress> findAddressByUId(Integer uId) {
		return this.deliveryaddressDAO.findAddressByUId(uId);
	}

	@Override
	public AdDeliveryaddress findAddressBySHId(Integer shId) {
		return this.deliveryaddressDAO.findById(shId); 
	}

	public AdOrderDAO getOrderDAO() {
		return orderDAO;
	}

	public void setOrderDAO(AdOrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	public AdOrderitemDAO getOrderitemDAO() {
		return orderitemDAO;
	}

	public void setOrderitemDAO(AdOrderitemDAO orderitemDAO) {
		this.orderitemDAO = orderitemDAO;
	}

	public AdDeliveryaddressDAO getDeliveryaddressDAO() {
		return deliveryaddressDAO;
	}

	public void setDeliveryaddressDAO(AdDeliveryaddressDAO deliveryaddressDAO) {
		this.deliveryaddressDAO = deliveryaddressDAO;
	}

	@Override
	public AdDeliveryaddress findAddressDefault(Integer uId) {
		return this.deliveryaddressDAO.findAddressDefault(uId);
	}

	@Override
	public Integer addOrderResCoId(AdOrder neworder) {
		return this.orderDAO.addOrderResCoId(neworder);
	}

	@Override
	public AdOrderitem findOrderitemByCoIdAndPId(Integer coId, Integer pId) {
		return this.orderitemDAO.findOrderitemByCoIdAndPId(coId, pId);
	}

	@Override
	public List<AdOrder> findOrderByState(String string) {
		return this.orderDAO.findOrderByState(string);
	}

	@Override
	public List<AdOrder> findAllOrder() {
		return this.orderDAO.findAllOrder();
	}

	//退换货申请表*******************************
	@Override
	public void saveOrUpdateEXREAuth(AdExregood good) {
		this.exregoodDAO.attachDirty(good);
	}

	@Override
	public void deleteEXREAuth(Integer erid) {
		this.exregoodDAO.delete(exregoodDAO.findById(erid));
	}

	@Override
	public void deleteEXREAuth(AdExregood good) {
		this.exregoodDAO.delete(good);
	}

	@Override
	public void addEXREAuth(AdExregood good) {
		this.exregoodDAO.save(good);
	}

	@Override
	public List<AdExregood> findEXREAuthByAuthWithState(String auth,
			Integer state) {
		return this.exregoodDAO.findEXREAuthByAuthWithState(auth, state);
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdExregood findEXREAuthByOId(Integer oId) {
		List<AdExregood> list = (List<AdExregood>) this.exregoodDAO.findByOId(oId);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public AdExregoodDAO getExregoodDAO() {
		return exregoodDAO;
	}

	public void setExregoodDAO(AdExregoodDAO exregoodDAO) {
		this.exregoodDAO = exregoodDAO;
	}

	@Override
	public List<AdExregood> findEXREAuthByOIdWithState(Integer oId, String auth) {
		return this.exregoodDAO.findEXREAuthByOIdWithState(oId, auth);
	}

	@Override
	public List<AdExregood> findEXREAuthByUId(Integer uId) {
		return this.exregoodDAO.findEXREAuthByUId(uId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdExregood> findAdExregoods() {
		List<AdExregood> list = (List<AdExregood>) this.exregoodDAO.findAll();
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@Override
	public List<AdExregood> findAdExregoodsByStId(Integer stId) {
		return this.exregoodDAO.findAdExregoodsByStId(stId);
	}

	@Override
	public List<AdExregood> findAdExregoodsByStIdWithAuth(Integer stId,
			String string) {
		return this.exregoodDAO.findAdExregoodsByStIdWithAuth(stId, string);
	}

	@Override
	public AdOrder findOrderBycoName(String coName) {
		return this.orderDAO.findOrderBycoName(coName);
	}

	@Override
	public AdExregood findEXREAuthByErId(Integer erId) {
		return this.exregoodDAO.findById(erId);
	}

	@Override
	public List<AdOrderitem> findOrderitemByStIdAndState(Integer stId,
			String string) {
		return this.orderitemDAO.findOrderitemByStIdAndState(stId, string);
	}

	@Override
	public List<AdOrderitem> findOrderItemByCoIdAndState(Integer coId,
			String string) {
		return this.orderitemDAO.findOrderItemByCoIdAndState(coId, string);
	}

	
	//物流管理
	@Override
	public void saveOrUpdatelogistics(AdLogistics lgt) {
		this.logisticsDAO.attachDirty(lgt);
	}

	@Override
	public void deletelogistics(AdLogistics lgt) {
		this.logisticsDAO.delete(lgt);
	}

	@Override
	public void addlogistics(AdLogistics lgt) {
		this.logisticsDAO.save(lgt);
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdLogistics findlogisticsByOId(Integer oId) {
		List<AdLogistics> list = (List<AdLogistics>) this.logisticsDAO.findByOId(oId);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdLogistics findLogisticsById(Integer lgId) {
		List<AdLogistics> list = (List<AdLogistics>) this.logisticsDAO.findById(lgId);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public AdLogisticsDAO getLogisticsDAO() {
		return logisticsDAO;
	}

	public void setLogisticsDAO(AdLogisticsDAO logisticsDAO) {
		this.logisticsDAO = logisticsDAO;
	}

	
}
