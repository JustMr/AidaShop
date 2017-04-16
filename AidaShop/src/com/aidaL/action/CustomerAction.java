package com.aidaL.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.aidaL.bean.AdCustomer;
import com.aidaL.service.ActionManager;

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


	/**
	 * 个人中心
	 * @return
	 */
	public String personal() {
		Integer uid =  (Integer) session.getAttribute("cusId");
		viCust = this.usermgr.findCustById(uid);
		session.setAttribute("page", "personal");
		session.setAttribute("messageCenter", "");
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
		this.usermgr.saveOrUpdateCust(viCust);
		session.setAttribute("messageCenter", "修改成功!");
		
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
	
	
}
