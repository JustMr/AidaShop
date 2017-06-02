package com.aidaL.service.impl;

import java.util.List;

import com.aidaL.bean.AdDeliveryaddress;
import com.aidaL.bean.AdOrder;
import com.aidaL.bean.AdOrderitem;
import com.aidaL.dao.impl.AdDeliveryaddressDAO;
import com.aidaL.dao.impl.AdOrderDAO;
import com.aidaL.dao.impl.AdOrderitemDAO;
import com.aidaL.service.OrderManager;

public class OrderManagerImpl implements OrderManager {

	private AdOrderDAO orderDAO;
	private AdOrderitemDAO orderitemDAO;
	private AdDeliveryaddressDAO deliveryaddressDAO;
	
	
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
	public AdOrderitem findOrderitemByCoIdAndUId(Integer coId, Integer pId) {
		return this.orderitemDAO.findOrderitemByCoIdAndUId(coId, pId);
	}

	
}
