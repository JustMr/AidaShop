package com.aidaL.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.aidaL.bean.AdCustomer;
import com.aidaL.bean.AdStore;
import com.aidaL.bean.AdStoreAuth;
import com.aidaL.db.FileIODB;
import com.aidaL.db.TimeIPDB;
import com.aidaL.service.ActionManager;
import com.aidaL.util.Json;

public class StoreAuthAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6841738230557516038L;
	
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
	//多文件上传
	private	List<File> file;
	private List<String> fileFileName;
	private List<String> fileContentType;
	//限制上传类型
	private Set<String> allowType = new HashSet<String>();


	/**
	 * 超管更新申请表状态
	 * @return
	 */
	public String upAll() {
		AdStoreAuth adStoreAuth = new AdStoreAuth();
		adStoreAuth = this.samgr.findStoreAuthById(storeAuth.getSaId());
		adStoreAuth.setSaStatu(storeAuth.getSaStatu());
		this.samgr.saveOrUpdateStoreAuth(adStoreAuth);
		
		AdCustomer adCustomer = new AdCustomer();
		adCustomer = this.custmgr.findCustById(storeAuth.getUId());
		if (storeAuth.getSaStatu()==0||storeAuth.getSaStatu()==1) {
			adCustomer.setUAdmin(0);
		}else {
			adCustomer.setUAdmin(1);
		}
		
		this.custmgr.saveOrUpdateCust(adCustomer);
		
		return "upAll";
	}
	
	/**
	 * 超管查看申请表详情，包括个人和申请表信息
	 * @return
	 */
	public String viAll() {
		storeAuth = this.samgr.findStoreAuthById(saId);
		cust = this.custmgr.findCustById(storeAuth.getUId());
		
		return "viall";
	}
	
	/**
	 * 超管页面更新申请表，只更新状态
	 * @return
	 */
	public String upsa() {
		AdStoreAuth adStoreAuth = new AdStoreAuth();
		adStoreAuth = this.samgr.findStoreAuthById(saId);
		adStoreAuth.setSaStatu(saStatu);
		this.samgr.saveOrUpdateStoreAuth(adStoreAuth);
		
		cust = this.custmgr.findCustById(adStoreAuth.getUId());
		if (saStatu==0||saStatu==1) {
			cust.setUAdmin(0);
		}else {
			cust.setUAdmin(1);
		}
		this.custmgr.saveOrUpdateCust(cust);
		
		
		return "upsa";
	}
	
	/**
	 * 超管用户店铺申请列表显示
	 * @return
	 */
	public String list() {
		storeAuths = this.samgr.findAllStoreAuths();
		
		return "list";
	}
	
	/**
	 * 普通用户个人中心修改申请
	 * @return
	 * @throws IOException
	 */
	public String update() throws IOException {
		AdStoreAuth aStoreAuth = new AdStoreAuth();
		aStoreAuth.setSaId(storeAuth.getSaId());
		aStoreAuth.setSaName(storeAuth.getSaName());
		aStoreAuth.setSaTag(storeAuth.getSaTag());
		aStoreAuth.setUId(storeAuth.getUId());
		aStoreAuth.setSaStatu(storeAuth.getSaStatu());
		
		//更新文件
		//上传文件
		String message = "";
		for (int i = 0; i < file.size(); i++) {
			//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
			String filename = fileFileName.get(i).substring(fileFileName.get(i).lastIndexOf("\\")+1);
//					System.out.println("fileFileName:"+filename);
			
			if (filename==null || filename.trim().equals("")) {
				message="文件名为空";
				request.setAttribute("message", message);
				return "update";
			}
			
			//得到上传文件的扩展名
			String fileExtName = fileFileName.get(i).substring(fileFileName.get(i).lastIndexOf(".")+1);
			//如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
//					System.out.println("上传的文件扩展名为："+fileExtName);
			init();
			if (!allowType.contains(fileExtName)) {
				message="文件不符合要求！";
				request.setAttribute("message", message);
				return "update";
			}
			
			byte[] buffer=new byte[1024];
	        FileIODB fileIODB = new FileIODB();
	        String savePath = fileIODB.getSavePath("/upload");
	        File saveDir = new File(savePath);
	        //检查文件夹是否存在
	        if(!saveDir.exists() && !saveDir.isDirectory()) {
	        	System.out.println(savePath+"目录不存在，需要创建");
	        	//创建目录
	        	saveDir.mkdir();
	        }
	        
	        //读取文件
	        FileInputStream fis=new FileInputStream(file.get(i));
	        //得到文件保存的名称
	        String saveFileName = fileIODB.makeFileName(fileFileName.get(i));
//			        System.out.println("saveFileName:"+saveFileName);
	        //得到文件的保存目录
	        String realSavePath = fileIODB.makePath(saveFileName, savePath);
//			        System.out.println("realSavePath:"+realSavePath);
	        //保存文件
	        FileOutputStream fos=new FileOutputStream(realSavePath +"\\"+saveFileName);
	        //保存文件地址
	        if (i==0) {
				aStoreAuth.setSaIdcardFront(realSavePath +"\\"+saveFileName);
			}else if (i==1) {
				aStoreAuth.setSaIdcardBack(realSavePath +"\\"+saveFileName);
			}
	        
	        int length=fis.read(buffer);
	        
	        while(length>0){
	            //每次写入length长度的内容
	            fos.write(buffer,0,length);
	            length=fis.read(buffer);
	        }
	        
	        fis.close();
	        fos.flush();
	        fos.close();
		}
		
		this.samgr.saveOrUpdateStoreAuth(aStoreAuth);
		
		storeAuth = this.samgr.findStoreAuthById(storeAuth.getSaId());
		
		return "update";
	}
	
	/**
	 * 个人中心查看申请详情
	 * @return
	 */
	public String sqvi() {
		System.out.println("sqvi id:"+saId);
		storeAuth = this.samgr.findStoreAuthById(saId);
		
		return "sqvi";
	}

	/**
	 * 普通用户个人中心查看申请列表
	 * @return
	 */
	public String authCenter() {
		Integer uid = (Integer) session.getAttribute("cusId");
		storeAuth = this.samgr.findStoreAuthByUId(uid);
		System.out.println("storeAuth:"+storeAuth);
		
		return "authCenter";
	}
	
	/**
	 * 设置限制上传的类型
	 */
	private void init() {
		allowType.add("jpg");
		allowType.add("jpeg");
		allowType.add("gif");
		allowType.add("bmp");
		allowType.add("png");
	}

	/**
	 * 检查该用户是否已经申请过一个商城
	 * @return
	 */
	public String isExist() {
		Integer uid = (Integer) session.getAttribute("cusId");
		AdStoreAuth aStoreAuth = null;
		aStoreAuth = this.samgr.findStoreAuthByUId(uid);
		Json json = new Json();
		if(aStoreAuth!=null) {
			//已存在，无法创建
			System.out.println("不可以创建");
			json.setMsg("0");
		}else {
			System.out.println("可以创建");
			//未存在，可以创建
			json.setMsg("1");
		}
		writeJson(json);
		return null;
	}
	
	/**
	 * 店铺申请表生成
	 * @return
	 * @throws IOException 
	 */
	public String add() throws IOException {
		Integer uid = (Integer) session.getAttribute("cusId");
		
		//创建店铺申请表
//		System.out.println("name+tag:"+saName+","+saTag);
		AdStoreAuth aStoreAuth = new AdStoreAuth();
		aStoreAuth.setSaName(saName);
		aStoreAuth.setSaTag(saTag);
		aStoreAuth.setUId(uid);
		aStoreAuth.setSaStatu(1);
		//上传文件
		String message = "";
		for (int i = 0; i < file.size(); i++) {
			//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
			String filename = fileFileName.get(i).substring(fileFileName.get(i).lastIndexOf("\\")+1);
//			System.out.println("fileFileName:"+filename);
			
			if (filename==null || filename.trim().equals("")) {
				message="文件名为空";
				request.setAttribute("message", message);
				return "add";
			}
			
			//得到上传文件的扩展名
			String fileExtName = fileFileName.get(i).substring(fileFileName.get(i).lastIndexOf(".")+1);
			//如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
//			System.out.println("上传的文件扩展名为："+fileExtName);
			init();
			if (!allowType.contains(fileExtName)) {
				message="文件不符合要求！";
				request.setAttribute("message", message);
				return "add";
			}
			
			byte[] buffer=new byte[1024];
	        FileIODB fileIODB = new FileIODB();
	        String savePath = fileIODB.getSavePath("/upload");
	        File saveDir = new File(savePath);
	        //检查文件夹是否存在
	        if(!saveDir.exists() && !saveDir.isDirectory()) {
	        	System.out.println(savePath+"目录不存在，需要创建");
	        	//创建目录
	        	saveDir.mkdir();
	        }
	        
	        //读取文件
	        FileInputStream fis=new FileInputStream(file.get(i));
	        //得到文件保存的名称
	        String saveFileName = fileIODB.makeFileName(fileFileName.get(i));
//	        System.out.println("saveFileName:"+saveFileName);
	        //得到文件的保存目录
	        String realSavePath = fileIODB.makePath(saveFileName, savePath);
//	        System.out.println("realSavePath:"+realSavePath);
	        //保存文件
	        FileOutputStream fos=new FileOutputStream(realSavePath +"\\"+saveFileName);
	        //保存文件地址
	        if (i==0) {
				aStoreAuth.setSaIdcardFront(realSavePath +"\\"+saveFileName);
			}else if (i==1) {
				aStoreAuth.setSaIdcardBack(realSavePath +"\\"+saveFileName);
			}
	        
	        int length=fis.read(buffer);
	        
	        while(length>0){
	            //每次写入length长度的内容
	            fos.write(buffer,0,length);
	            length=fis.read(buffer);
	        }
	        
	        fis.close();
	        fos.flush();
	        fos.close();
		}
		this.samgr.addStoreAuth(aStoreAuth);
		
		//创建相应店铺表，并返回店铺表ID
		AdStore aStore = new AdStore();
		aStore.setStName(saName);
		aStore.setStTag(saTag);
		aStore.setStServiceManner(0.0);
		aStore.setStServiceQuality(0.0);
		aStore.setStSpeed(0.0);
		aStore.setStFavorablerate(0.00);
		aStore.setStLevel(0);
		aStore.setStState(4);
		aStore.setStCreateTime(new Date());
		TimeIPDB timeIPDB = new TimeIPDB();
		aStore.setStEndTime(timeIPDB.stringToDate(timeIPDB.getAfterMonth(60)));	//设置结束时间为当前时间后5年
//		System.out.println("timeIPDB.stringToDate(timeIPDB.getAfterMonth(60)):"+timeIPDB.stringToDate(timeIPDB.getAfterMonth(60)));
		Integer sId = this.stormgr.addStoreResID(aStore);
		
		//修改用户表所寻的stID
		cust = this.custmgr.findCustById(uid);
		cust.setStId(sId);
		this.custmgr.saveOrUpdateCust(cust);
		
		message="申请成功！";
		request.setAttribute("message", message);
		
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

	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}
	
	
}
