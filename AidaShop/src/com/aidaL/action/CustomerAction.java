package com.aidaL.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aidaL.bean.AdCustomer;
import com.aidaL.service.ActionManager;
import com.aidaL.util.SendMail;
import com.opensymphony.xwork2.ActionContext;

public class CustomerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer[] UIds;
	private Integer UId;
	private List<AdCustomer> listCuses = new ArrayList<AdCustomer>();
	private AdCustomer adCustomer;
	private AdCustomer viCust;
	private ActionManager usermgr;
	private Integer UStylingDesigner;
	private Integer UState;
	private Integer UAdmin;
	private String UName;
	private String UNickName;
	private String UPassword;
	private String URelaname;
	private String USex;
	private Date UBirthday;
	private String UAddress;
	private String UCardId;
	private String UEmail;
	private String UMobile;
	private Integer stId;
	private String UActivecode;

	
	/**
	 * 邮箱激活成功
	 * @return
	 */
	public String active() {
		AdCustomer customer = new AdCustomer();
		System.out.println("UActivecode:"+UActivecode+","+UId);
		customer = this.usermgr.findCustById(UId);
		String cusActive = customer.getUActivecode();
		
		if (customer.getUState()!=5) {
			ActionContext.getContext().put("msg", "已验证，请直接登录");
			request.setAttribute("data", "1");
			System.out.println("已验证，请直接登录");
		}else {
			if (cusActive.equals(UActivecode)) {
				ActionContext.getContext().put("msg", "验证成功，请登录");
				request.setAttribute("data", "1");
				customer.setUState(0);
				this.usermgr.saveOrUpdateCust(customer);
				System.out.println("验证通过");
			}else {
				//重新验证
				request.setAttribute("data", "2");
				System.out.println("验证失败");
				return "reactive";
			}
		}
		
		return "active";
	}
	
	/**
	 * 创建新用户，邮箱验证激活
	 * @return
	 * @throws IOException 
	 */
	public String add() throws IOException {
		response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
		Integer res = 0; //0未激活，1已激活,2激活失败
		Integer uidInteger = null;
		PrintWriter out = response.getWriter();
		AdCustomer customer = new AdCustomer();
		int randNum = 1 + (int)(Math.random() * ((99999 - 1) + 1));
		String UActivecode = String.valueOf(randNum);
		
		UNickName = URLDecoder.decode(UNickName, "UTF-8");
		customer.setUName(UName);
		System.out.println("UNickName:"+UNickName);
		customer.setUPassword(UPassword);
		customer.setUNickName(UNickName);
		customer.setUAdmin(0);
		customer.setUStylingDesigner(0);
		customer.setUState(5);
		customer.setUActivecode(UActivecode);

		try {
			uidInteger = this.usermgr.addCustRetID(customer);
			System.out.println("uidInteger:"+uidInteger);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			res = 2;
		}
		
		//邮箱验证
		String receiver = UName;
		Long activateTime = System.currentTimeMillis();
		String token = activateTime+"";
		AdCustomer customer2 = this.usermgr.findCustById(uidInteger);
		String path = request.getContextPath();
		String URL = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println(URL);
		
		String content = "<p>AidaShop爱搭商城激活<br>" +
				"<br>账户需要激活才可以正常使用<br>" +
				"<a target='_blank' href='"+URL+"activeCustomerAction?token="+token+"&UId="+uidInteger+"&UActivecode="+UActivecode+"'>" +
						""+URL+"activeCustomerAction?token="+token+"&UId="+uidInteger+"&UActivecode="+UActivecode+"</a></p>";
		System.out.println(content);
		
		//判断是否已经激活
		if (customer2.getUState()==5) {
			try {
				SendMail sendMail = new SendMail();
	            sendMail.send(receiver, content);
	            System.out.println("2");
			} catch (Exception e) {
				res = 2;
			}
		}else {
			res=1;
		}
		
		out.print(res);
		return null;
	}
	
	/**
	 * 验证是否含有相同的用户名
	 * @return
	 * @throws IOException 
	 */
	public String isSaveName() {
		response.setContentType("text/text");
        response.setCharacterEncoding("UTF-8");
		Integer res = 0;
		PrintWriter out;
		
		res =  this.usermgr.findCustByName(UName);
		
		try {
			out = response.getWriter();
			out.print(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 个人中心
	 * @return
	 */
	public String personal() {
		Integer uid =  (Integer) session.getAttribute("cusId");
		viCust = this.usermgr.findCustById(uid);
		session.setAttribute("page", "personal");
		String messageCenter = request.getParameter("messageCenter");
		if (messageCenter!=null) {
			session.setAttribute("messageCenter", messageCenter);
		}
		return "personal";
	}
	
	/**
	 * 查询所有的管理员，剔除已登录用户
	 * @return
	 */
	public String admin() {
		Integer uid =  (Integer) session.getAttribute("cusId");
		listCuses = this.usermgr.findAdminCust(uid);
		session.setAttribute("page", "admin");
		return "list";
	}
	
	/**
	 * 查询所有的超级管理员，剔除已登录用户
	 * @return
	 */
	public String sup() {
		Integer uid =  (Integer) session.getAttribute("cusId");
		listCuses = this.usermgr.findSupCust(uid);
		session.setAttribute("page", "sup");
		return "list";
	}
	
	/**
	 * 查询全部的店铺管理员
	 * @return
	 */
	public String store() {
		listCuses = this.usermgr.findStoreCust();
		session.setAttribute("page", "store");
		return "list";
	}
	
	/**
	 * 显示造型师认定中的列表，剔除已登录用户
	 * @return
	 */
	public String auth() {
		Integer uid =  (Integer) session.getAttribute("cusId");
		listCuses = usermgr.findAuthenCust(uid);
		session.setAttribute("page", "auth");
		
		return "list";
	}
	
	/**
	 * 显示造型师列表，剔除已登录用户
	 * @return
	 */
	public String style() {
		Integer uid =  (Integer) session.getAttribute("cusId");
		listCuses = usermgr.findStyleCust(uid);
		session.setAttribute("page", "style");
		
		return "list";
	}
	
	/**
	 * 查询VIP用户，剔除已登录用户
	 * @return
	 */
	public String vip() {
		Integer uid =  (Integer) session.getAttribute("cusId");
		listCuses = usermgr.findVIPCust(uid);
		session.setAttribute("page", "vip");
		return "list";
	}
	
	/**
	 * 显示所有用户信息，剔除已登录用户
	 * @return
	 */
	public String list() {
		Integer uid =  (Integer) session.getAttribute("cusId");
		listCuses = usermgr.finAllCustomer(uid);
		session.setAttribute("page", "all");
		return "list";
	}
	
	/**
	 * 查看详细信息，编辑部分信息
	 * @return
	 */
	public String vi() {
		this.viCust = usermgr.findCustById(UId);
		
		return "vi";
	}
	
	/**
	 * 获取jsp的修改信息，保存并修改
	 * @return
	 */
	public String update() {
//		AdCustomer customer = new AdCustomer();
//		customer = this.usermgr.findCustById(viCust.getUId());
		
		System.out.println("getUBirthday:"+viCust.getUBirthday());
		try {
			this.usermgr.saveOrUpdateCust(viCust);
		} catch (Exception e) {
			session.setAttribute("messageCenter", "修改失败!");
			e.printStackTrace();
		}
		
		
		String page = (String) session.getAttribute("page");
		if (page.endsWith("all")) {
			return "allist";
		}else if (page.equals("style")) {
			return "stylelist";
		}else if (page.equals("auth")) {
			return "auth";
		} else if (page.equals("admin")) {
			return "admin";
		} else if (page.equals("sup")) {
			return "sup";
		} else if (page.equals("store")) {
			return "store";
		} else if (page.equals("personal")) {
			session.setAttribute("messageCenter", "修改成功!");
			return "personalist";
		}
		return "viplist";
	}
	
	/**
	 * 改变当前页面显示标签，编辑部分信息
	 * @return
	 */
	public String edit() {
		AdCustomer adCust = new AdCustomer();
		adCust = usermgr.findCustById(UId);
		
		adCust.setUStylingDesigner(UStylingDesigner);
		adCust.setUState(UState);
		adCust.setUAdmin(UAdmin);
		System.out.println("CustomerAction:"+adCust.getUId()+","+adCust.getUStylingDesigner());
		usermgr.saveOrUpdateCust(adCust);
		
		String page = (String) session.getAttribute("page");
		if (page.endsWith("all")) {
			return "allist";
		}else if (page.equals("style")) {
			return "stylelist";
		}else if (page.equals("auth")) {
			return "auth";
		} else if (page.equals("admin")) {
			return "admin";
		} else if (page.equals("sup")) {
			return "sup";
		} else if (page.equals("store")) {
			return "store";
		}
		return "viplist";
	}
	
	
	public Integer[] getUIds() {
		return UIds;
	}
	public void setUIds(Integer[] uIds) {
		UIds = uIds;
	}
	public Integer getUId() {
		return UId;
	}
	public void setUId(Integer uId) {
		UId = uId;
	}
	public List<AdCustomer> getListCuses() {
		return listCuses;
	}
	public void setListCuses(List<AdCustomer> listCuses) {
		this.listCuses = listCuses;
	}
	public AdCustomer getAdCustomer() {
		return adCustomer;
	}
	public void setAdCustomer(AdCustomer adCustomer) {
		this.adCustomer = adCustomer;
	}

	public ActionManager getUsermgr() {
		return usermgr;
	}

	public void setUsermgr(ActionManager usermgr) {
		this.usermgr = usermgr;
	}

	public Integer getUStylingDesigner() {
		return UStylingDesigner;
	}

	public void setUStylingDesigner(Integer uStylingDesigner) {
		UStylingDesigner = uStylingDesigner;
	}

	public Integer getUState() {
		return UState;
	}

	public void setUState(Integer uState) {
		UState = uState;
	}

	public Integer getUAdmin() {
		return UAdmin;
	}

	public void setUAdmin(Integer uAdmin) {
		UAdmin = uAdmin;
	}

	public String getUName() {
		return UName;
	}

	public void setUName(String uName) {
		UName = uName;
	}

	public String getUNickName() {
		return UNickName;
	}

	public void setUNickName(String uNickName) {
		UNickName = uNickName;
	}

	public String getUPassword() {
		return UPassword;
	}

	public void setUPassword(String uPassword) {
		UPassword = uPassword;
	}

	public String getURelaname() {
		return URelaname;
	}

	public void setURelaname(String uRelaname) {
		URelaname = uRelaname;
	}

	public String getUSex() {
		return USex;
	}

	public void setUSex(String uSex) {
		USex = uSex;
	}

	public Date getUBirthday() {
		return UBirthday;
	}

	public void setUBirthday(Date uBirthday) {
		UBirthday = uBirthday;
	}

	public String getUAddress() {
		return UAddress;
	}

	public void setUAddress(String uAddress) {
		UAddress = uAddress;
	}

	public String getUCardId() {
		return UCardId;
	}

	public void setUCardId(String uCardId) {
		UCardId = uCardId;
	}

	public String getUEmail() {
		return UEmail;
	}

	public void setUEmail(String uEmail) {
		UEmail = uEmail;
	}

	public String getUMobile() {
		return UMobile;
	}

	public void setUMobile(String uMobile) {
		UMobile = uMobile;
	}

	public Integer getStId() {
		return stId;
	}

	public void setStId(Integer stId) {
		this.stId = stId;
	}

	public AdCustomer getViCust() {
		return viCust;
	}

	public void setViCust(AdCustomer viCust) {
		this.viCust = viCust;
	}

	public String getUActivecode() {
		return UActivecode;
	}

	public void setUActivecode(String uActivecode) {
		UActivecode = uActivecode;
	}
	
	
}
