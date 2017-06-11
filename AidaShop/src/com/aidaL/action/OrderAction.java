package com.aidaL.action;

import java.awt.Font;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;

import cn.itcast.utils.PayConfig;
import cn.itcast.utils.PaymentUtil;

import com.aidaL.bean.AdCustomer;
import com.aidaL.bean.AdDeliveryaddress;
import com.aidaL.bean.AdImageFile;
import com.aidaL.bean.AdOrder;
import com.aidaL.bean.AdOrderitem;
import com.aidaL.bean.AdProductInfo;
import com.aidaL.service.ActionManager;
import com.aidaL.service.DesignerManage;
import com.aidaL.service.OrderManager;
import com.aidaL.service.ShopManager;
import com.aidaL.util.Json;
import com.aidaL.util.JsonMultiObj;

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
	private List<AdCustomer> custs = new ArrayList<AdCustomer>();
	private AdProductInfo good;
	private List<AdProductInfo> goods;
	private AdImageFile image;
	private List<AdImageFile> images = new ArrayList<AdImageFile>();
	
	
	private List<Integer> Pids;
	
	private List<AdOrder> newOrders = new ArrayList<AdOrder>();
	private List<AdOrder> nopayOrders = new ArrayList<AdOrder>();
	private List<AdOrder> paidOrders = new ArrayList<AdOrder>();
	private List<AdOrder> finishOrders = new ArrayList<AdOrder>();
	
	private String fileName;
	
	
	//普通用户查看订单详情
	public String viorder() {
		order = this.ordermgr.findOrderBycoId(coId);
		orderitems = this.orderItemgr.findOrderItemByCoId(coId);
		UId = order.getAdCustomer().getUId();
		//第一个轮转图片路径
    	List<String> pathList = new ArrayList<String>();
    	//价格小计
    	List<Double> pricelist = new ArrayList<Double>();
    	
    	order.setOrderitems(orderitems);
		
		for (int i = 0; i < orderitems.size(); i++) {
			good = orderitems.get(i).getAdProductInfo();
	    	//获取第一个轮转图片，并改变地址格式
	    	if (good!=null) {
				image = this.imagemgr.findImageListOneByPId(good.getPId());
				if (image!=null) {
					String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
					path = path.replaceAll("\\\\", "/");
					pathList.add(path);
				}else {
					pathList.add("nopath");
				}
	    	}
	    	
	    	//加入每一项价格
	    	Double priceone = good.getPSellprice()*orderitems.get(i).getOAmount();
	    	pricelist.add(priceone);
		}
		
		//获取默认收货地址
		address = this.adressmgr.findAddressDefault(UId);
	
		
		request.setAttribute("pathList", pathList);
		request.setAttribute("pricelist", pricelist);
			
		return "viorder";
	}
	
	
	//综合管理订单统计
	public String statistics() {
		
		// A网站的访问量统计  
        TimeSeries timeSeries=new TimeSeries("A网站访问量统计", Month.class);  
        // 添加数据  如果你是从数据库中获取数据，你就写个循环塞值就行了。  
        timeSeries.add(new Month(1,2013), 100);  
        timeSeries.add(new Month(2,2013), 200);  
        timeSeries.add(new Month(3,2013), 300);  
        timeSeries.add(new Month(4,2013), 400);  
        timeSeries.add(new Month(5,2013), 560);  
        timeSeries.add(new Month(6,2013), 600);  
        timeSeries.add(new Month(7,2013), 750);  
        timeSeries.add(new Month(8,2013), 890);  
        timeSeries.add(new Month(9,2013), 120);  
        timeSeries.add(new Month(10,2013), 400);  
        timeSeries.add(new Month(11,2013), 1200);  
        timeSeries.add(new Month(12,2013), 1600);  
          
        // B网站的访问量统计  
        //如果有更多的就继续添加就行了  
        TimeSeries timeSeries2=new TimeSeries("B网站访问量统计", Month.class);  
        // 添加数据  
        timeSeries2.add(new Month(1,2013), 50);  
        timeSeries2.add(new Month(2,2013), 100);  
        timeSeries2.add(new Month(3,2013), 150);  
        timeSeries2.add(new Month(4,2013), 200);  
        timeSeries2.add(new Month(5,2013), 220);  
        timeSeries2.add(new Month(6,2013), 300);  
        timeSeries2.add(new Month(7,2013), 340);  
        timeSeries2.add(new Month(8,2013), 400);  
        timeSeries2.add(new Month(9,2013), 450);  
        timeSeries2.add(new Month(10,2013), 500);  
        timeSeries2.add(new Month(11,2013), 70);  
        timeSeries2.add(new Month(12,2013), 800);  
          
        // 定义时间序列的集合  
        TimeSeriesCollection lineDataset=new TimeSeriesCollection();  
        lineDataset.addSeries(timeSeries);  
        lineDataset.addSeries(timeSeries2);  
          
        JFreeChart chart=ChartFactory.createTimeSeriesChart("访问量统计时间折线图", "月份", "访问量", lineDataset, true, true, true);  
          
        //设置主标题  
        chart.setTitle(new TextTitle("A,B网站访问量统计对比图", new Font("隶书", Font.ITALIC, 15)));   
        //设置子标题  
        TextTitle subtitle = new TextTitle("2016年度", new Font("黑体", Font.BOLD, 12));  
        chart.addSubtitle(subtitle);   
        chart.setAntiAlias(true);   
          
        //设置时间轴的范围。  
        XYPlot plot = (XYPlot) chart.getPlot();   
        DateAxis dateaxis = (DateAxis)plot.getDomainAxis();  
        dateaxis.setDateFormatOverride(new java.text.SimpleDateFormat("M月"));  
        dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.MONTH,1));   
          
        //设置曲线是否显示数据点  
        XYLineAndShapeRenderer xylinerenderer = (XYLineAndShapeRenderer)plot.getRenderer();  
        xylinerenderer.setBaseShapesVisible(true);   
          
        //设置曲线显示各数据点的值  
        XYItemRenderer xyitem = plot.getRenderer();   
        xyitem.setBaseItemLabelsVisible(true);  
        xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));   
        xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());  
        xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 12));   
        plot.setRenderer(xyitem);  
          
        //最后返回组成的折线图数值  
        try {
        	fileName=ServletUtilities.saveChartAsPNG(chart, 700, 500, session);
        	System.out.println("fileName:"+fileName);
        	request.setAttribute("filename", fileName);
//        	ActionContext.getContext().put("filename", fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return "statistics";
	}
	
	
	//综合管理获得所有订单列表
	public String superlist() {
		orders = this.ordermgr.findAllOrder();
		
		return "superlist";
	}
	
	
	//综合管理获得未收货订单
	public String paid() {
		orders = this.ordermgr.findOrderByState("paid");

		return "superlist";
	}
	
	//综合管理获得未付款订单
	public String nonpay() {
		orders = this.ordermgr.findOrderByState("nonpay");

		return "superlist";
	}
	
	//综合管理获得已完成订单
	public String findish() {
		
		orders = this.ordermgr.findOrderByState("finished");
		
		return "superlist";
	}
	
	
	
	//普通用户个人中心获得订单列表
	public String list() {
		
		UId = (Integer) session.getAttribute("cusId");
		
		nopayOrders = this.ordermgr.findOrderByUId(UId, "nonpay");
		paidOrders = this.ordermgr.findOrderByUId(UId, "paid");
		finishOrders = this.ordermgr.findOrderByUId(UId, "finished");
		
		return "list";
	}
	
	
	//处理支付请求
	public String payrequest() {
		String p0_Cmd = "Buy";
		String p1_MerId = PayConfig.getValue("p1_MerId");	//合作者ID
		String keyValue = PayConfig.getValue("keyValue");	//合作者KEY
		String p2_Order = request.getParameter("orderid");	//订单号
		String p3_Amt = request.getParameter("money");	//订单金额
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		String p8_Url = PayConfig.getValue("responseURL");
		String p9_SAF = "";
		String pa_MP = "";
		String pd_FrpId = request.getParameter("pd_FrpId");	//所选银行编号
		String pr_NeedResponse = "1";
		
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		
	
		request.setAttribute("p0_Cmd", p0_Cmd);
		request.setAttribute("p1_MerId", p1_MerId);
		request.setAttribute("p2_Order", p2_Order);
		request.setAttribute("p3_Amt", p3_Amt);
		request.setAttribute("p4_Cur", p4_Cur);
		request.setAttribute("p5_Pid", p5_Pid);
		request.setAttribute("p6_Pcat",p6_Pcat);
		request.setAttribute("p7_Pdesc", p7_Pdesc);
		request.setAttribute("p8_Url", p8_Url);
		request.setAttribute("p9_SAF", p9_SAF);
		request.setAttribute("pa_MP", pa_MP);
		request.setAttribute("pd_FrpId", pd_FrpId);
		request.setAttribute("pr_NeedResponse", pr_NeedResponse);
		request.setAttribute("hmac", hmac);

		return "payrequest";
	}
	
	//PaymentResponse
	public String paymentresponse() {
		
		response.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=gb2312");
		
		String p1_MerId = PayConfig.getValue("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String  r8_MP= request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");
		String hmac = request.getParameter("hmac");
		
		String keyValue = PayConfig.getValue("keyValue");
		
		boolean b = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);
		if(!b){
//			response.getWriter().write("交易签名已被修改！！！");
//			return ;
		}
		
		if("1".equals(r1_Code)){  //处理支付成功
			if("1".equals(r9_BType)){
//				response.getWriter().write("支付成功！！");
//				return;
			}
			if("2".equals(r9_BType)){
//				response.getWriter().write("success");
			}
		}
		
		return "response";
	}
	
	//提交订单
	public String suborder() {
		
		UId = (Integer) session.getAttribute("cusId");
		//第一个轮转图片路径
    	List<String> pathList = new ArrayList<String>();
    	//价格小计
    	List<Double> pricelist = new ArrayList<Double>();
    	
		order = this.ordermgr.findOrderBycoId(coId);
		if (order.getCoOrderState().equals("new")) {
			orderitems = this.orderItemgr.findOrderItemByCoId(coId);
			order.setOrderitems(orderitems);
			
			Double totalprice = 0.00;
			for (int i = 0; i < orderitems.size(); i++) {
				good = orderitems.get(i).getAdProductInfo();
		    	//获取第一个轮转图片，并改变地址格式
		    	if (good!=null) {
					image = this.imagemgr.findImageListOneByPId(good.getPId());
					if (image!=null) {
						String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
						path = path.replaceAll("\\\\", "/");
						pathList.add(path);
					}else {
						pathList.add("nopath");
					}
		    	}
		    	
		    	//加入每一项价格
		    	Double priceone = good.getPSellprice()*orderitems.get(i).getOAmount();
		    	pricelist.add(priceone);
		    	
		    	//计算总价
		    	totalprice += priceone;
			}
			//更新订单创建时间为现在
	    	//获取创建时间
	    	Date now = new Date();
			Timestamp coCreateTime = new Timestamp(now.getTime());
			order.setCoCreateTime(coCreateTime);
			//更新总价
			order.setCoTotalPrice(totalprice);
			//更新邮费,实际价格
			Double max = 99.00;
			BigDecimal data1 = new BigDecimal(totalprice);  
			BigDecimal data2 = new BigDecimal(max); 
			if (data1.compareTo(data2) > 0) {
				//超过最低运费所需价格,运费为零
				order.setCoFreightCharge(0.00);
			}else {
				order.setCoFreightCharge(8.00);
			}
			Double realprice = order.getCoTotalPrice()-order.getCoDiscountPrice()+order.getCoFreightCharge();
			order.setCoRealPrice(realprice);
			//更新订单号
			//获取当前时间再加上用户ID作为订单编号
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String coName = sdf.format(now)+UId;
			order.setCoName(coName);
			//更新订单状态为未支付
			order.setCoOrderState("nonpay");
			
			//获取默认收货地址
			address = this.adressmgr.findAddressDefault(UId);
			if (address!=null) {
				order.setShId(address.getShId());
			}
			this.ordermgr.saveOrUpdateOrder(order);
		}else {
			orderitems = this.orderItemgr.findOrderItemByCoId(coId);
			order.setOrderitems(orderitems);
			
			for (int i = 0; i < orderitems.size(); i++) {
				good = orderitems.get(i).getAdProductInfo();
		    	//获取第一个轮转图片，并改变地址格式
		    	if (good!=null) {
					image = this.imagemgr.findImageListOneByPId(good.getPId());
					if (image!=null) {
						String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
						path = path.replaceAll("\\\\", "/");
						pathList.add(path);
					}else {
						pathList.add("nopath");
					}
		    	}
		    	
		    	//加入每一项价格
		    	Double priceone = good.getPSellprice()*orderitems.get(i).getOAmount();
		    	pricelist.add(priceone);
			}
			
			//获取默认收货地址
			address = this.adressmgr.findAddressDefault(UId);
		}
		
		
		request.setAttribute("pathList", pathList);
		request.setAttribute("pricelist", pricelist);
		
		
		return "suborder";
	}
	
	//某一项减一
	public String reduceone() {

		System.out.println("PId:"+PId);
		
		//找到购物车状态订单
		UId = (Integer) session.getAttribute("cusId");
		orders = this.ordermgr.findOrderByUId(UId, "new");
		if (orders!=null) {
			order = orders.get(0);
			
			//找到属于该订单包含该商品的具体项
			orderitem = this.orderItemgr.findOrderitemByCoIdAndPId(order.getCoId(), PId);
			
			Integer count = orderitem.getOAmount()-1;
			if (count<=0) {
				//等于零删除该项商品
				this.orderItemgr.deleteOrderItem(orderitem);
			}else {
				//更改该项商品数量
				orderitem.setOAmount(count);
				this.orderItemgr.saveOrUpdateOrderItem(orderitem);
			}

		}
		
		return "itemlist";
	}
	
	//某一项数量加一
	public String addone() {
		
		System.out.println("PId:"+PId);
		
		//找到购物车状态订单
		UId = (Integer) session.getAttribute("cusId");
		orders = this.ordermgr.findOrderByUId(UId, "new");
		if (orders!=null) {
			order = orders.get(0);
			
			//找到属于该订单包含该商品的具体项
			orderitem = this.orderItemgr.findOrderitemByCoIdAndPId(order.getCoId(), PId);
			Integer count = orderitem.getOAmount()+1;
			orderitem.setOAmount(count);
			this.orderItemgr.saveOrUpdateOrderItem(orderitem);
			
		}
		
		return "itemlist";
	}
	
	//删除某一项商品	
	public String deleteoi() {
		
		System.out.println("PId:"+PId);
		
		//找到购物车状态订单
		UId = (Integer) session.getAttribute("cusId");
		orders = this.ordermgr.findOrderByUId(UId, "new");
		if (orders!=null) {
			order = orders.get(0);
			
			//找到属于该订单包含该商品的具体项,并删除
			orderitem = this.orderItemgr.findOrderitemByCoIdAndPId(order.getCoId(), PId);
			this.orderItemgr.deleteOrderItem(orderitem);
		}
		
		return "itemlist";
	}
	
	//mini购物车
	public void headshopshow() {
		JsonMultiObj json = new JsonMultiObj();
		UId = (Integer) session.getAttribute("cusId");
		
		orders = this.ordermgr.findOrderByUId(UId, "new");
		if (orders!=null) {
			order = orders.get(0);
			orderitems = this.orderItemgr.findOrderItemByCoId(order.getCoId());
			if (orderitems!=null) {
				order.setOrderitems(orderitems);
				json.setObj(order);
				json.setSuccess(true);
				
				//第一个轮转图片路径
		    	List<String> pathList = new ArrayList<String>();
				for (int i = 0; i < orderitems.size(); i++) {
					good = orderitems.get(i).getAdProductInfo();
			    	//获取第一个轮转图片，并改变地址格式
			    	if (good!=null) {
						image = this.imagemgr.findImageListOneByPId(good.getPId());
						if (image!=null) {
							String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
							path = path.replaceAll("\\\\", "/");
							pathList.add(path);
						}else {
							pathList.add("nopath");
						}
			    	}
				}
				json.setObj1(pathList);
			}
		}else {
			json.setSuccess(false);
		}
		
		writeJson(json);
		
	}
	
	
	//购物车详情页
	public String vishopcar() {
		UId = (Integer) session.getAttribute("cusId");
		//第一个轮转图片路径
    	List<String> pathList = new ArrayList<String>();
    	//价格小计
    	List<Double> pricelist = new ArrayList<Double>();
    	
		orders = this.ordermgr.findOrderByUId(UId, "new");
		if (orders!=null) {
			order = orders.get(0);
			orderitems = this.orderItemgr.findOrderItemByCoId(order.getCoId());
			if (orderitems!=null) {
				order.setOrderitems(orderitems);
				
				for (int i = 0; i < orderitems.size(); i++) {
					good = orderitems.get(i).getAdProductInfo();
			    	//获取第一个轮转图片，并改变地址格式
			    	if (good!=null) {
						image = this.imagemgr.findImageListOneByPId(good.getPId());
						if (image!=null) {
							String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
							path = path.replaceAll("\\\\", "/");
							pathList.add(path);
						}else {
							pathList.add("nopath");
						}
			    	}
			    	
			    	//加入价格
			    	Double priceone = good.getPSellprice()*orderitems.get(i).getOAmount();
			    	pricelist.add(priceone);
				}
			}
		}
		request.setAttribute("pathList", pathList);
		request.setAttribute("pricelist", pricelist);
		
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
				orderitem = this.orderItemgr.findOrderitemByCoIdAndPId(order.getCoId(), Pids.get(i));
				if (orderitem==null) {
					AdOrderitem newitem = new AdOrderitem();
					newitem.setAdOrder(order);
					newitem.setAdProductInfo(good);
					newitem.setOAmount(1);
					newitem.setOState("new");
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
				newitem.setOState("new");
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
			orderitem = this.orderItemgr.findOrderitemByCoIdAndPId(order.getCoId(), PId);
			if (orderitem==null) {
				AdOrderitem newitem = new AdOrderitem();
				newitem.setAdOrder(order);
				newitem.setAdProductInfo(good);
				newitem.setOAmount(OAmount);
				newitem.setOState("new");
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
			newitem.setOState("new");
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

	public AdImageFile getImage() {
		return image;
	}

	public void setImage(AdImageFile image) {
		this.image = image;
	}

	public List<AdImageFile> getImages() {
		return images;
	}

	public void setImages(List<AdImageFile> images) {
		this.images = images;
	}


	public List<AdOrder> getNewOrders() {
		return newOrders;
	}


	public void setNewOrders(List<AdOrder> newOrders) {
		this.newOrders = newOrders;
	}


	public List<AdOrder> getNopayOrders() {
		return nopayOrders;
	}


	public void setNopayOrders(List<AdOrder> nopayOrders) {
		this.nopayOrders = nopayOrders;
	}


	public List<AdOrder> getPaidOrders() {
		return paidOrders;
	}


	public void setPaidOrders(List<AdOrder> paidOrders) {
		this.paidOrders = paidOrders;
	}


	public List<AdOrder> getFinishOrders() {
		return finishOrders;
	}


	public void setFinishOrders(List<AdOrder> finishOrders) {
		this.finishOrders = finishOrders;
	}

	public List<AdCustomer> getCusts() {
		return custs;
	}

	public void setCusts(List<AdCustomer> custs) {
		this.custs = custs;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
