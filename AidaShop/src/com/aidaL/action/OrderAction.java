package com.aidaL.action;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aidaL.bean.AdCustomer;
import com.aidaL.bean.AdDeliveryaddress;
import com.aidaL.bean.AdOrder;
import com.aidaL.bean.AdOrderitem;
import com.aidaL.bean.AdProductInfo;
import com.aidaL.service.ActionManager;
import com.aidaL.service.DesignerManage;
import com.aidaL.service.OrderManager;
import com.aidaL.service.ShopManager;
import com.aidaL.util.Json;

public class OrderAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8469797934771030226L;

	private OrderManager ordermgr;
	private OrderManager orderItemgr;
	private OrderManager adressmgr;
	private ActionManager stmgr;
	private ShopManager imagemgr;
	private ShopManager goodmgr;
	private ActionManager custmgr;
	private DesignerManage matchmgr;
	
	private Integer coId;
	private Integer shId;
	private Integer PId;
	private Integer UId;
	private Integer stId;
	
	private String shName;
	private String shPhone;
	private String shAddress;
	private Integer shState;
	
	private Integer OAmount;
	
	private List<AdDeliveryaddress> adresses = new ArrayList<AdDeliveryaddress>();
	private AdDeliveryaddress address;
	private AdOrder order;
	private List<AdOrder> orders = new ArrayList<AdOrder>();
	private AdOrderitem orderitem;
	private List<AdOrderitem> orderitems = new ArrayList<AdOrderitem>();
	private AdCustomer cust;
	private AdProductInfo good;
	private List<AdProductInfo> goods;
	
	
	private List<Integer> Pids;
	
	
	public String vishopcar() {
		
		UId = (Integer) session.getAttribute("cusId");
		
		orders = this.ordermgr.findOrderByUId(UId, "new");
		order = orders.get(0);
		if (orders!=null) {
			orderitems = this.orderItemgr.findOrderItemByCoId(order.getCoId());
			order.setOrderitems(orderitems);
		}
		
		return "vishopcar";
	}
	
	
	//商品搭配一键购买
	public String gmshop() {
		UId = (Integer) session.getAttribute("cusId");
		
		for (int i = 0; i < Pids.size(); i++) {
//			System.out.println(Pids.get(i));
			good = this.goodmgr.findGoodById(Pids.get(i));
			orders = this.ordermgr.findOrderByUId(UId, "new");
			if (orders!=null) {
				//得到唯一的一个new订单为购物车订单
				order = orders.get(0);
				
				//增加订单条目或更新条目数量
				//根据订单编号和商品ID查找订单条目
				orderitem = this.orderItemgr.findOrderitemByCoIdAndUId(order.getCoId(), Pids.get(i));
				if (orderitem==null) {
					AdOrderitem newitem = new AdOrderitem();
					newitem.setAdOrder(order);
					newitem.setAdProductInfo(good);
					newitem.setOAmount(1);
					this.orderItemgr.addOrderItem(newitem);
				}else {
					//更新订单条目商品数量
					Integer count = orderitem.getOAmount() + 1;
					orderitem.setOAmount(count);
					this.orderItemgr.saveOrUpdateOrderItem(orderitem);
				}
				
				//更新订单总价格和邮费
				Double totalprice = order.getCoTotalPrice() + good.getPSellprice();
				order.setCoTotalPrice(totalprice);
				Double max = 99.00;
				BigDecimal data1 = new BigDecimal(totalprice);  
				BigDecimal data2 = new BigDecimal(max); 
				if (data1.compareTo(data2) > 0) {
					//超过最低运费所需价格,运费为零
					order.setCoFreightCharge(0.00);
				}else {
					order.setCoFreightCharge(8.00);
				}
				this.ordermgr.saveOrUpdateOrder(order);
				
			}else {
				
				//设置所属会员
				AdOrder neworder = new AdOrder();
				cust = this.custmgr.findCustById(UId);
				neworder.setAdCustomer(cust);
				//获取当前时间再加上用户ID作为订单编号
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String coName = sdf.format(now)+UId;
				System.out.println("coName:"+coName);
				neworder.setCoName(coName);
				//记录总价、折扣和运费
				Double price = 0.00 + good.getPSellprice();
				neworder.setCoTotalPrice(price);
				neworder.setCoDiscountPrice(0.00);
				Double max = 99.00;
				BigDecimal data1 = new BigDecimal(price);  
				BigDecimal data2 = new BigDecimal(max); 
				if (data1.compareTo(data2) > 0) {
					//超过最低运费所需价格,运费为零
					neworder.setCoFreightCharge(0.00);
				}else {
					neworder.setCoFreightCharge(8.00);
				}
				neworder.setCoOrderState("new");
				//获取创建时间
				Timestamp coCreateTime = new Timestamp(now.getTime());
				neworder.setCoCreateTime(coCreateTime);
				//创建订单返回订单号作为订单条目的外键
				coId = this.ordermgr.addOrderResCoId(neworder);
				
				System.out.println("coId:"+coId);
				neworder = this.ordermgr.findOrderBycoId(coId);
				System.out.println(neworder.getCoId());
				
				//根据商品ID常见订单条目表，与上面的订单ID绑定
				AdOrderitem newitem = new AdOrderitem();
				newitem.setAdProductInfo(good);
				newitem.setAdOrder(neworder);
				newitem.setOAmount(1);
				this.orderItemgr.addOrderItem(newitem);
				
			}
		}
		
		return "shopcar";
	}
	
	
	//添加到购物车
	public String shopcar() {
		UId = (Integer) session.getAttribute("cusId");
//		System.out.println("OAmount:"+OAmount);
//		System.out.println("PId:"+PId);
		
		good = this.goodmgr.findGoodById(PId);
		orders = this.ordermgr.findOrderByUId(UId, "new");
		if (orders!=null) {
			//得到唯一的一个new订单为购物车订单
			order = orders.get(0);
			
			//增加订单条目或更新条目数量
			//根据订单编号和商品ID查找订单条目
			orderitem = this.orderItemgr.findOrderitemByCoIdAndUId(order.getCoId(), PId);
			if (orderitem==null) {
				AdOrderitem newitem = new AdOrderitem();
				newitem.setAdOrder(order);
				newitem.setAdProductInfo(good);
				newitem.setOAmount(OAmount);
				this.orderItemgr.addOrderItem(newitem);
			}else {
				//更新订单条目商品数量
				Integer count = orderitem.getOAmount() + OAmount;
				orderitem.setOAmount(count);
				this.orderItemgr.saveOrUpdateOrderItem(orderitem);
			}
			
			//更新订单总价格和邮费
			Double totalprice = order.getCoTotalPrice() + good.getPSellprice()*OAmount;
			order.setCoTotalPrice(totalprice);
			Double max = 99.00;
			BigDecimal data1 = new BigDecimal(totalprice);  
			BigDecimal data2 = new BigDecimal(max); 
			if (data1.compareTo(data2) > 0) {
				//超过最低运费所需价格,运费为零
				order.setCoFreightCharge(0.00);
			}else {
				order.setCoFreightCharge(8.00);
			}
			this.ordermgr.saveOrUpdateOrder(order);
			
		}else {
			
			//设置所属会员
			AdOrder neworder = new AdOrder();
			cust = this.custmgr.findCustById(UId);
			neworder.setAdCustomer(cust);
			//获取当前时间再加上用户ID作为订单编号
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String coName = sdf.format(now)+UId;
			System.out.println("coName:"+coName);
			neworder.setCoName(coName);
			//记录总价、折扣和运费
			Double price = 0.00 + good.getPSellprice()*OAmount;
			neworder.setCoTotalPrice(price);
			neworder.setCoDiscountPrice(0.00);
			Double max = 99.00;
			BigDecimal data1 = new BigDecimal(price);  
			BigDecimal data2 = new BigDecimal(max); 
			if (data1.compareTo(data2) > 0) {
				//超过最低运费所需价格,运费为零
				neworder.setCoFreightCharge(0.00);
			}else {
				neworder.setCoFreightCharge(8.00);
			}
			neworder.setCoOrderState("new");
			//获取创建时间
			Timestamp coCreateTime = new Timestamp(now.getTime());
			neworder.setCoCreateTime(coCreateTime);
			//创建订单返回订单号作为订单条目的外键
			coId = this.ordermgr.addOrderResCoId(neworder);
			
			System.out.println("coId:"+coId);
			neworder = this.ordermgr.findOrderBycoId(coId);
			System.out.println(neworder.getCoId());
			
			//根据商品ID常见订单条目表，与上面的订单ID绑定
			AdOrderitem newitem = new AdOrderitem();
			newitem.setAdProductInfo(good);
			newitem.setAdOrder(neworder);
			newitem.setOAmount(OAmount);
			this.orderItemgr.addOrderItem(newitem);
			
		}
		
		
		return "shopcar";
	}
	
	
	//设置默认收货地址
	public void setdefault() {
		Json json = new Json();
		UId = (Integer) session.getAttribute("cusId");
		System.out.println("shId:"+shId);
		AdDeliveryaddress oldadd = new AdDeliveryaddress();
		oldadd = this.adressmgr.findAddressDefault(UId);
		System.out.println("oldadd:"+oldadd);
		if (oldadd!=null) {
			if (!oldadd.getShId().equals(shId)) {
				oldadd.setShState(0);
				this.adressmgr.saveOrUpdateAddress(oldadd);
				address = this.adressmgr.findAddressBySHId(shId);
				System.out.println("address0:"+address);
				address.setShState(1);
				this.adressmgr.saveOrUpdateAddress(address);
			}
		}else {
			address = this.adressmgr.findAddressBySHId(shId);
			System.out.println("address1:"+address);
			address.setShState(1);
			this.adressmgr.saveOrUpdateAddress(address);
		}
		
		json.setSuccess(true);
		writeJson(json);
		
	}
	
	//添加收货地址
	public String addAddress() {
		UId = (Integer) session.getAttribute("cusId");
		AdDeliveryaddress newaddress = new AdDeliveryaddress();
		newaddress.setShName(shName);
		newaddress.setShPhone(shPhone);
		newaddress.setShAddress(shAddress);
		newaddress.setShState(0);
		newaddress.setUId(UId);
		this.adressmgr.addAddress(newaddress);
		return "addAddress";
	}
	
	
	//查看收货地址列表
	public String addresslist() {
		UId = (Integer) session.getAttribute("cusId");
		
		adresses = this.adressmgr.findAddressByUId(UId);
		
		return "addresslist";
	}

	
	public OrderManager getOrdermgr() {
		return ordermgr;
	}

	public void setOrdermgr(OrderManager ordermgr) {
		this.ordermgr = ordermgr;
	}

	public OrderManager getOrderItemgr() {
		return orderItemgr;
	}

	public void setOrderItemgr(OrderManager orderItemgr) {
		this.orderItemgr = orderItemgr;
	}

	public OrderManager getAdressmgr() {
		return adressmgr;
	}

	public void setAdressmgr(OrderManager adressmgr) {
		this.adressmgr = adressmgr;
	}

	public ActionManager getStmgr() {
		return stmgr;
	}

	public void setStmgr(ActionManager stmgr) {
		this.stmgr = stmgr;
	}

	public ShopManager getImagemgr() {
		return imagemgr;
	}

	public void setImagemgr(ShopManager imagemgr) {
		this.imagemgr = imagemgr;
	}

	public ShopManager getGoodmgr() {
		return goodmgr;
	}

	public void setGoodmgr(ShopManager goodmgr) {
		this.goodmgr = goodmgr;
	}

	public ActionManager getCustmgr() {
		return custmgr;
	}

	public void setCustmgr(ActionManager custmgr) {
		this.custmgr = custmgr;
	}

	public DesignerManage getMatchmgr() {
		return matchmgr;
	}

	public void setMatchmgr(DesignerManage matchmgr) {
		this.matchmgr = matchmgr;
	}

	public Integer getCoId() {
		return coId;
	}

	public void setCoId(Integer coId) {
		this.coId = coId;
	}

	public Integer getShId() {
		return shId;
	}

	public void setShId(Integer shId) {
		this.shId = shId;
	}

	public Integer getPId() {
		return PId;
	}

	public void setPId(Integer pId) {
		PId = pId;
	}

	public Integer getUId() {
		return UId;
	}

	public void setUId(Integer uId) {
		UId = uId;
	}

	public Integer getStId() {
		return stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public String getShName() {
		return shName;
	}

	public void setShName(String shName) {
		this.shName = shName;
	}

	public String getShPhone() {
		return shPhone;
	}

	public void setShPhone(String shPhone) {
		this.shPhone = shPhone;
	}

	public String getShAddress() {
		return shAddress;
	}

	public void setShAddress(String shAddress) {
		this.shAddress = shAddress;
	}

	public Integer getShState() {
		return shState;
	}

	public void setShState(Integer shState) {
		this.shState = shState;
	}

	public Integer getOAmount() {
		return OAmount;
	}

	public void setOAmount(Integer oAmount) {
		OAmount = oAmount;
	}

	public List<AdDeliveryaddress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<AdDeliveryaddress> adresses) {
		this.adresses = adresses;
	}


	public AdDeliveryaddress getAddress() {
		return address;
	}


	public void setAddress(AdDeliveryaddress address) {
		this.address = address;
	}


	public AdOrder getOrder() {
		return order;
	}


	public void setOrder(AdOrder order) {
		this.order = order;
	}


	public List<AdOrder> getOrders() {
		return orders;
	}


	public void setOrders(List<AdOrder> orders) {
		this.orders = orders;
	}


	public AdOrderitem getOrderitem() {
		return orderitem;
	}


	public void setOrderitem(AdOrderitem orderitem) {
		this.orderitem = orderitem;
	}


	public List<AdOrderitem> getOrderitems() {
		return orderitems;
	}


	public void setOrderitems(List<AdOrderitem> orderitems) {
		this.orderitems = orderitems;
	}


	public AdCustomer getCust() {
		return cust;
	}


	public void setCust(AdCustomer cust) {
		this.cust = cust;
	}


	public AdProductInfo getGood() {
		return good;
	}


	public void setGood(AdProductInfo good) {
		this.good = good;
	}


	public List<AdProductInfo> getGoods() {
		return goods;
	}


	public void setGoods(List<AdProductInfo> goods) {
		this.goods = goods;
	}


	public List<Integer> getPids() {
		return Pids;
	}


	public void setPids(List<Integer> pids) {
		Pids = pids;
	}
	
	
}
