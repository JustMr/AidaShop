package com.aidaL.service;

import java.util.List;

import com.aidaL.bean.AdDeliveryaddress;
import com.aidaL.bean.AdOrder;
import com.aidaL.bean.AdOrderitem;

public interface OrderManager {
	
	//订单管理
	public void saveOrUpdateOrder(AdOrder order);
	public void deleteOrder(Integer coid);
	public void deleteOrder(AdOrder order);
	public void addOrder(AdOrder order);
	
	/**
	 * 属于该用户的某个状态的订单
	 * @param uId 用户ID
	 * @param state 订单状态
	 * @return
	 */
	public List<AdOrder> findOrderByUId(Integer uId,String state);
	public AdOrder findOrderBycoId(Integer coId);
	
	//订单条目管理
	public void saveOrUpdateOrderItem(AdOrderitem orderItem);
	public void deleteOrderItem(Integer oid);
	public void deleteOrderItem(AdOrderitem orderItem);
	public void addOrderItem(AdOrderitem orderItem);
	public AdOrderitem findOrderitemById(Integer oid);
	public List<AdOrderitem> findOrderItemByCoId(Integer coId);
	
	
	//收货地址管理
	public void saveOrUpdateAddress(AdDeliveryaddress address);
	public void deleteAddress(Integer shid);
	public void deleteAddress(AdDeliveryaddress address);
	public void addAddress(AdDeliveryaddress address);
	public List<AdDeliveryaddress> findAddressByUId(Integer uId);
	public AdDeliveryaddress findAddressBySHId(Integer shId);
	
	/**
	 * 找到默认收货地址
	 * @param uId 用户ID
	 * @return
	 */
	public AdDeliveryaddress findAddressDefault(Integer uId);
	
	/**
	 * 创建订单返回订单ID
	 * @param neworder
	 * @return
	 */
	public Integer addOrderResCoId(AdOrder neworder);
	
	/**
	 * 通过订单ID,商品ID查找相应订单条目
	 * @param coId
	 * @param pId
	 * @return
	 */
	public AdOrderitem findOrderitemByCoIdAndPId(Integer coId, Integer pId);
	
	/**
	 * 根据订单状态获取所有订单
	 * @param string 订单状态
	 * @return
	 */
	public List<AdOrder> findOrderByState(String string);
	
	/**
	 * 找到所有订单
	 * @return
	 */
	public List<AdOrder> findAllOrder();
	

}
