package com.aidaL.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.aidaL.bean.AdImageFile;
import com.aidaL.bean.AdProductInfo;
import com.aidaL.bean.AdProductcategory;
import com.aidaL.bean.AdStore;
import com.aidaL.bean.BrandAD;
import com.aidaL.db.FileIODB;
import com.aidaL.service.ActionManager;
import com.aidaL.service.ShopManager;
import com.aidaL.util.Json;
import com.aidaL.util.JsonMultiObj;

public class GoodAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3202568516590984150L;
	
	private ShopManager shopmgr;
	private ActionManager brmgr;
	private ActionManager catemgr;
	private ActionManager stmgr;
	private ShopManager imagemgr;
	
	
	private AdProductcategory adProductcategory;
	private AdProductInfo good;
	private BrandAD brandAD;
	private AdImageFile image;
	private AdStore store;
	private List<AdImageFile> images = new ArrayList<AdImageFile>();
	private List<AdProductInfo> goods = new ArrayList<AdProductInfo>();
	private List<AdProductcategory> cates = new ArrayList<AdProductcategory>();
	

	private Integer PId;
	private String PName;
	private String PDescription;
	private Timestamp PCreateTime;
	private Double PBaseprice;
	private Double PMarketprice;
	private Double PSellprice;
	private String PSexrequest;
	private String PPlace;
	private Integer PCount;
	private Integer PCommend;
	private Integer PClickcount;
	private Integer PSellCount;
	private Integer stId;
	private Integer brId;
	private Integer cgId;
	private Integer PState;

	
	private	List<File> fileLZ;
	private List<String> fileLZFileName;
	private List<String> fileLZContentType;
    private List<File> fileXQ;            //文件  
    private List<String> fileXQFileName;  //文件名   
    private List<String> fileXQContentType;        //文件路径
    private	List<File> fileLZG;
	private List<String> fileLZGFileName;
	private List<String> fileLZGContentType;
    private List<File> fileXQG;            //文件  
    private List<String> fileXQGFileName;  //文件名   
    private List<String> fileXQGContentType;        //文件路径
    
    
    private Integer countLZg;
    private Integer countXQg;
    
    private String page;
    
    
  //限制上传类型
  	private Set<String> allowType = new HashSet<String>();
  	
  	
    private void init() {
    	allowType.add("jpg");
		allowType.add("jpeg");
		allowType.add("gif");
		allowType.add("bmp");
		allowType.add("png");
	}
    
    
    //详情页显示
    public String detail() {
    	
		good = this.shopmgr.findGoodById(PId);
		
		List<String> lzpaths = new ArrayList<String>();
		List<String> xqpaths = new ArrayList<String>();
		
		if (good!=null) {
			images = this.imagemgr.findImageByPIdGrouPAndOrder(PId);
			System.out.println(images);
			if (images!=null) {
				for (int i = 0; i < images.size(); i++) {
					System.out.println(images.get(i).getIfPosition()+","+images.get(i).getIfSn());
					Integer position = images.get(i).getIfPosition();
					String oldpath = images.get(i).getIfFilepath();
					if (position==0) {
						if (oldpath!=null&&oldpath!="") {
							String path = "." + oldpath.substring(oldpath.indexOf("\\upload\\"));
							path = path.replaceAll("\\\\", "/");
							lzpaths.add(path);
						}
					}else {
						if (oldpath!=null&&oldpath!="") {
							String path = "." + oldpath.substring(oldpath.indexOf("\\upload\\"));
							path = path.replaceAll("\\\\", "/");
							xqpaths.add(path);
						}
					}
				}
			}
			
			store = this.stmgr.findStoreById(good.getStId());
		}
		
		request.setAttribute("lzpaths", lzpaths);
		request.setAttribute("xqpaths", xqpaths);
    	
    	return "detail";
	}
    
    //头部搜索框搜索
    public String allsearch() {
    	try {
			PName = java.net.URLDecoder.decode(PName,"utf-8");
			System.out.println("after pname:"+PName);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String preprice = request.getParameter("preprice");
    	Integer prepri = Integer.valueOf(preprice);
    	
    	String nextprice = request.getParameter("nextprice");
    	Integer nextpri = Integer.valueOf(nextprice);
    	
    	//价格区间判断
    	if (nextpri!=0&&prepri!=0) {
			if (prepri.equals(nextpri)) {
				if (prepri>0&&prepri<=100) {
					prepri = 0;
				}else {
					prepri = prepri - 100;
				}
				nextpri = nextpri + 100;
			}
		}
    	
    	
    	//模糊查询
    	//按商品名查询
//    	goods = this.shopmgr.findGoodByUnSureName(PName);
    	goods = this.shopmgr.findGoodByUnSureNameWithCgBrPPNP(PName, cgId, brId, prepri, nextpri);
    	
    	System.out.println("goods1:"+goods);
    	//按标签查询
    	cates = this.catemgr.findPcategoryByUnSureName(PName);
//    	System.out.println("cates:"+cates);
    	
    	List<AdProductInfo> goods2 = new ArrayList<AdProductInfo>();
    	if (cates!=null) {
			for (int i = 0; i < cates.size(); i++) {
				List<AdProductInfo> listg = new ArrayList<AdProductInfo>();
				listg = this.shopmgr.findGoodByCgBrPPNP(cates.get(i).getCgId(), brId, prepri, nextpri);
				//不确定能否查出
				if (listg!=null) {
					goods2.addAll(listg);
				}
			}
			if (goods2.size()>0) {
				for (int i = 0; i < goods2.size(); i++) {
					int flag = 0;
					for (int j = 0; j < goods.size(); j++) {
						if (goods.get(j).getPId().equals(goods2.get(i).getPId())) {
							flag = 1;
						}
					}
					if (flag == 0) {
						goods.add(goods2.get(i));
					}
				}
			}
			
		}
    	
    	
    	//第一个轮转图片路径
    	List<String> pathList = new ArrayList<String>();
    	//店铺名称
    	List<String> storName = new ArrayList<String>();
    	
    	//获取第一个轮转图片，并改变地址格式
    	if (goods!=null) {
			for (int i = 0; i < goods.size(); i++) {
//				System.out.println("image Pid:"+goods.get(i).getPId());
				image = this.imagemgr.findImageListOneByPId(goods.get(i).getPId());
//				System.out.println("image"+i+":"+image);
				if (image!=null) {
					String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
					path = path.replaceAll("\\\\", "/");
					pathList.add(path);
				}else {
					pathList.add("nopath");
				}
				
				//得到店铺名称
				store = this.stmgr.findStoreById(goods.get(i).getStId());
				if (store!=null) {
					storName.add(store.getStName());
				}else {
					storName.add("自营");
				}
				
			}
    	}
    	
    	request.setAttribute("pathList", pathList);
    	request.setAttribute("storName", storName);
    	
		return "search";
	}
    
    
    //一级分类搜索
    public String onesearch() {
    	String preprice = request.getParameter("preprice");
    	Integer prepri = Integer.valueOf(preprice);
    	
    	String nextprice = request.getParameter("nextprice");
    	Integer nextpri = Integer.valueOf(nextprice);
    	
    	//价格区间判断
    	if (nextpri!=0&&prepri!=0) {
			if (prepri.equals(nextpri)) {
				if (prepri>0&&prepri<=100) {
					prepri = 0;
				}else {
					prepri = prepri - 100;
				}
				nextpri = nextpri + 100;
			}
		}
    	
    	
    	List<AdProductcategory> twocate = new ArrayList<AdProductcategory>();
    	List<AdProductcategory> threecate = new ArrayList<AdProductcategory>();
    	
    	//得到所有的三级分类标签
    	twocate = this.catemgr.findLvOneOrThree(cgId);
    	if (twocate!=null) {
			for (int i = 0; i < twocate.size(); i++) {
				List<AdProductcategory> catelist = new ArrayList<AdProductcategory>();
				catelist = this.catemgr.findLvOneOrThree(twocate.get(i).getCgId());
				if (catelist!=null) {
					threecate.addAll(catelist);
				}
			}
		}
    	
    	System.out.println("threecate:"+threecate);
    	System.out.println("threecate size:"+threecate.size());
    	
    	//得到相应商品列表
    	goods = new ArrayList<AdProductInfo>();
    	if (threecate!=null) {
			for (int i = 0; i < threecate.size(); i++) {
				List<AdProductInfo> goodlist = new ArrayList<AdProductInfo>();
//				goodlist = this.shopmgr.findGoodByCgId(threecate.get(i).getCgId());
				goodlist = this.shopmgr.findGoodByCgBrPPNP(threecate.get(i).getCgId(), brId, prepri, nextpri);
				if (goodlist!=null) {
					goods.addAll(goodlist);
				}
			}
		}
    	
    	//第一个轮转图片路径
    	List<String> pathList = new ArrayList<String>();
    	//店铺名称
    	List<String> storName = new ArrayList<String>();
    	
    	//获取第一个轮转图片，并改变地址格式
    	if (goods!=null) {
			for (int i = 0; i < goods.size(); i++) {
				image = this.imagemgr.findImageListOneByPId(goods.get(i).getPId());
				if (image!=null) {
					String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
					path = path.replaceAll("\\\\", "/");
					pathList.add(path);
				}else {
					pathList.add("nopath");
				}
				
				//得到店铺名称
				store = this.stmgr.findStoreById(goods.get(i).getStId());
				if (store!=null) {
					storName.add(store.getStName());
				}else {
					storName.add("自营");
				}
				
			}
    	}
    	
    	request.setAttribute("pathList", pathList);
    	request.setAttribute("storName", storName);
		
    	return "search";
	}
    
    //二级分类搜索
    public String twosearch() {
    	String preprice = request.getParameter("preprice");
    	Integer prepri = Integer.valueOf(preprice);
    	
    	String nextprice = request.getParameter("nextprice");
    	Integer nextpri = Integer.valueOf(nextprice);
    	
    	//价格区间判断
    	if (nextpri!=0&&prepri!=0) {
			if (prepri.equals(nextpri)) {
				if (prepri>0&&prepri<=100) {
					prepri = 0;
				}else {
					prepri = prepri - 100;
				}
				nextpri = nextpri + 100;
			}
		}
    	
    	//得到所有的三级分类标签
    	List<AdProductcategory> threecate = new ArrayList<AdProductcategory>();
    	threecate = this.catemgr.findLvOneOrThree(cgId);
    	
    	//得到相应商品列表
    	goods = new ArrayList<AdProductInfo>();
    	if (threecate!=null) {
    		for (int i = 0; i < threecate.size(); i++) {
				List<AdProductInfo> goodlist = new ArrayList<AdProductInfo>();
				goodlist = this.shopmgr.findGoodByCgBrPPNP(threecate.get(i).getCgId(), brId, prepri, nextpri);
				if (goodlist!=null) {
					goods.addAll(goodlist);
				}
			}
		}
    	
    	System.out.println("threecate:"+threecate);
    	System.out.println("threecate size:"+threecate.size());
    	
    	//第一个轮转图片路径
    	List<String> pathList = new ArrayList<String>();
    	//店铺名称
    	List<String> storName = new ArrayList<String>();
    	
    	//获取第一个轮转图片，并改变地址格式
    	if (goods!=null) {
			for (int i = 0; i < goods.size(); i++) {
				image = this.imagemgr.findImageListOneByPId(goods.get(i).getPId());
				if (image!=null) {
					String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
					path = path.replaceAll("\\\\", "/");
					pathList.add(path);
				}else {
					pathList.add("nopath");
				}
				
				//得到店铺名称
				store = this.stmgr.findStoreById(goods.get(i).getStId());
				if (store!=null) {
					storName.add(store.getStName());
				}else {
					storName.add("自营");
				}
				
			}
    	}
    	
    	request.setAttribute("pathList", pathList);
    	request.setAttribute("storName", storName);
    	
    	return "search";
	}
    
    //三级分类搜索
    public String threesearch() {
    	String preprice = request.getParameter("preprice");
    	Integer prepri = Integer.valueOf(preprice);
    	
    	String nextprice = request.getParameter("nextprice");
    	Integer nextpri = Integer.valueOf(nextprice);
    	
    	//价格区间判断
    	if (nextpri!=0&&prepri!=0) {
			if (prepri.equals(nextpri)) {
				if (prepri>0&&prepri<=100) {
					prepri = 0;
				}else {
					prepri = prepri - 100;
				}
				nextpri = nextpri + 100;
			}
		}
    	
    	goods = this.shopmgr.findGoodByCgBrPPNP(cgId, brId, prepri, nextpri);
    	
    	//第一个轮转图片路径
    	List<String> pathList = new ArrayList<String>();
    	//店铺名称
    	List<String> storName = new ArrayList<String>();
    	
    	//获取第一个轮转图片，并改变地址格式
    	if (goods!=null) {
			for (int i = 0; i < goods.size(); i++) {
				image = this.imagemgr.findImageListOneByPId(goods.get(i).getPId());
				if (image!=null) {
					String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
					path = path.replaceAll("\\\\", "/");
					pathList.add(path);
				}else {
					pathList.add("nopath");
				}
				
				//得到店铺名称
				store = this.stmgr.findStoreById(goods.get(i).getStId());
				if (store!=null) {
					storName.add(store.getStName());
				}else {
					storName.add("自营");
				}
				
			}
    	}
    	
    	request.setAttribute("pathList", pathList);
    	request.setAttribute("storName", storName);
    	
    	return "search";
	}
    
    
    //发表搭配时，搜索商品
    public void search() {
    	
    	JsonMultiObj json = new JsonMultiObj();
    	
    	//模糊查询
    	//按商品名查询
    	goods = this.shopmgr.findGoodByUnSureName(PName);
    	System.out.println("goods1:"+goods);
    	//按标签查询
    	cates = this.catemgr.findPcategoryByUnSureName(PName);
//    	System.out.println("cates:"+cates);
    	
    	List<AdProductInfo> goods2 = new ArrayList<AdProductInfo>();
    	if (cates!=null) {
			for (int i = 0; i < cates.size(); i++) {
				List<AdProductInfo> listg = new ArrayList<AdProductInfo>();
				listg = this.shopmgr.findGoodByCgId(cates.get(i).getCgId());
				//不确定能否查出
				if (listg!=null) {
					goods2.addAll(listg);
				}
			}
			if (goods2.size()>0) {
				for (int i = 0; i < goods2.size(); i++) {
					int flag = 0;
					for (int j = 0; j < goods.size(); j++) {
						if (goods.get(j).getPId().equals(goods2.get(i).getPId())) {
							flag = 1;
						}
					}
					if (flag == 0) {
						goods.add(goods2.get(i));
					}
				}
			}
			
		}
    	
    	
    	//第一个轮转图片路径
    	List<String> pathList = new ArrayList<String>();
    	//店铺名称
    	List<String> storName = new ArrayList<String>();
    	
    	//获取第一个轮转图片，并改变地址格式
    	if (goods!=null) {
			for (int i = 0; i < goods.size(); i++) {
//				System.out.println("image Pid:"+goods.get(i).getPId());
				image = this.imagemgr.findImageListOneByPId(goods.get(i).getPId());
//				System.out.println("image"+i+":"+image);
				if (image!=null) {
					String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
					path = path.replaceAll("\\\\", "/");
					pathList.add(path);
				}else {
					pathList.add("nopath");
				}
				
				//得到店铺名称
				store = this.stmgr.findStoreById(goods.get(i).getStId());
				if (store!=null) {
					storName.add(store.getStName());
				}else {
					storName.add("自营");
				}
				
			}
			json.setMsg("success");
			json.setObj(goods);
			json.setObj1(pathList);
			json.setObj2(storName);
			json.setSuccess(true);
    	}else {
    		json.setMsg("empty");
    		json.setSuccess(false);
		}
    	
    	writeJson(json);
    	
	}
    
    public String superGAList() {
		
    	goods = this.shopmgr.findAllGoodOnlyAuth();
    	//第一个轮转图片路径
    	List<String> pathList = new ArrayList<String>();
    	
    	//获取第一个轮转图片，并改变地址格式
    	if (goods!=null) {
			for (int i = 0; i < goods.size(); i++) {
//				System.out.println("image Pid:"+goods.get(i).getPId());
				image = this.imagemgr.findImageListOneByPId(goods.get(i).getPId());
//				System.out.println("image"+i+":"+image);
				if (image!=null) {
					String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
					path = path.replaceAll("\\\\", "/");
					pathList.add(path);
				}else {
					pathList.add("nopath");
				}
			}
    	}
    	
    	session.setAttribute("page1", "supergalist");
    	
    	System.out.println("pathList:"+pathList);
    	request.setAttribute("pathList", pathList);
    	
    	return "superagall";
	}
    
    public String superUpdate() {
    	
    	AdProductInfo prInfo = this.shopmgr.findGoodById(good.getPId());
    	prInfo.setPState(good.getPState());
    	this.shopmgr.saveOrUpdateGood(prInfo);
    	
    	page=(String) session.getAttribute("page1");
    	
    	if (page.equals("superlist")) {
    		return "superglist";
		}else if (page.equals("supergalist")) {
			return "supergalist";
		}
    	
		return "superglist";
	}
    
    public String superDel() {
    	
    	this.shopmgr.deleteGood(PId);
		images = this.imagemgr.findImageByPId(PId);
		int l = images.size();
		FileIODB fiIodb = new FileIODB();
		if (l>0) {
			for (int i = 0; i < l; i++) {
				fiIodb.deleteFile(images.get(i).getIfFilepath());
				this.imagemgr.deleteImage(images.get(i));
			}
		}
		
//		page = (String) session.getAttribute("page1");
//		
//		System.out.println("superlist:"+page);
//		if (page.equals("superglist")) {
//			return "superglist";
//		}else if (page.equals("supergalist")) {
//			return "supergalist";
//		}
    	
		return "supergall";
	}
    
    
    /**
     * 超管显示商品该详细信息
     * @return
     */
    public String supervi() {
    	
    	good = this.shopmgr.findGoodById(PId);
    	images = this.imagemgr.findImageListByPId(PId);
    	
    	List<String> lzpath = new ArrayList<String>();
    	List<String> xqpath = new ArrayList<String>();
    	
    	if (images.size()>0) {
			for (int i = 0; i < images.size(); i++) {
				String path = "." + images.get(i).getIfFilepath().substring(images.get(i).getIfFilepath().indexOf("\\upload\\"));
				path = path.replaceAll("\\\\", "/");
				
				if (images.get(i).getIfPosition()==0) {
					lzpath.add(path);
				}else {
					xqpath.add(path);
				}
			}
		}
    	
    	//获得所属店铺信息
    	store = this.stmgr.findStoreById(good.getStId());
    	
    	System.out.println(lzpath);
    	System.out.println(xqpath);
    	
    	request.setAttribute("lzpath", lzpath);
    	request.setAttribute("xqpath", xqpath);
    	
    	return "supervi";
    }
    
    
    /**
     * 超管查看商品列表，无申请中或未通过商品
     * @return 商品列表和图片路径
     */
    public String superList() {
    	
    	
    	goods = this.shopmgr.findAllGoodWithNoAuth();
    	//第一个轮转图片路径
    	List<String> pathList = new ArrayList<String>();
    	
    	//获取第一个轮转图片，并改变地址格式
    	if (goods!=null) {
			for (int i = 0; i < goods.size(); i++) {
//				System.out.println("image Pid:"+goods.get(i).getPId());
				image = this.imagemgr.findImageListOneByPId(goods.get(i).getPId());
//				System.out.println("image"+i+":"+image);
				if (image!=null) {
					String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
					path = path.replaceAll("\\\\", "/");
					pathList.add(path);
				}else {
					pathList.add("nopath");
				}
			}
    	}
    	
    	session.setAttribute("page1", "superglist");
    	System.out.println("pathList:"+pathList);
    	request.setAttribute("pathList", pathList);
    	
		return "supergall";
	}
    
 
    /**
     * 店铺管理员修改商品的名称、、描述和图片信息
     * @throws IOException
     */
    public void mianEdit() throws IOException {
    	Json json = new Json();
    	int flag = 0;
    	
//		System.out.println("fileLZG:"+fileLZG+",fileXQG:"+fileXQG);
//		System.out.println("fileLZFileNameG:"+fileLZGFileName+",fileXQFileNameG:"+fileXQGFileName);
//		System.out.println("fileLZGContentType:"+fileLZGContentType+",fileXQGContentType:"+fileXQGContentType);

		//修改商品表
		good = this.shopmgr.findGoodById(PId);
//		System.out.println(PName+"'"+PBaseprice+"'"+PSexrequest);
		good.setPName(PName);
		good.setPDescription(PDescription);
		good.setPState(1);
		this.shopmgr.saveOrUpdateGood(good);
		
		if (fileLZG!=null) {
			
		
			//添加该商品图片
			//轮转图片添加
			for (int i = 0; i < fileLZG.size(); i++) {
				//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
				String filename = fileLZGFileName.get(i).substring(fileLZGFileName.get(i).lastIndexOf("\\")+1);
	//			System.out.println("fileFileName:"+filename);
				
				if (filename==null || filename.trim().equals("")) {
					json.setMsg("wrong");
					json.setSuccess(false);
					flag=1;
					writeJson(json);
				}
				
				if (flag==0) {
					//得到上传文件的扩展名
					String fileExtName = fileLZGFileName.get(i).substring(fileLZGFileName.get(i).lastIndexOf(".")+1);
					//如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
		//			System.out.println("上传的文件扩展名为："+fileExtName);
					init();
					if (!allowType.contains(fileExtName)) {
						json.setMsg("wrong");
						json.setSuccess(false);
						flag = 1;
						writeJson(json);
					}
				}
				
				
				if (flag==0) {
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
			        FileInputStream fis=new FileInputStream(fileLZG.get(i));
			        //得到文件保存的名称
			        String saveFileName = fileIODB.makeFileName(fileLZGFileName.get(i));
	//		        System.out.println("saveFileName:"+saveFileName);
			        //得到文件的保存目录
			        String realSavePath = fileIODB.makePath(saveFileName, savePath);
	//		        System.out.println("realSavePath:"+realSavePath);
			        //保存文件
			        FileOutputStream fos=new FileOutputStream(realSavePath +"\\"+saveFileName);
			        //保存文件地址,保存图片信息
			        String path = realSavePath +"\\"+saveFileName;
			        AdImageFile newImage = new AdImageFile();
			        newImage.setIfFilepath(path);
			        newImage.setIfPosition(0);
			        newImage.setIfPid(PId);
			        newImage.setIfSn(i+countLZg);
			        this.imagemgr.addImage(newImage);
			        
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
				
				
			}
			
			if (flag==0) {
				if (fileXQG!=null) {
					
					//详情展示图片添加
					for (int i = 0; i < fileXQG.size(); i++) {
						//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
						String filename = fileXQGFileName.get(i).substring(fileXQGFileName.get(i).lastIndexOf("\\")+1);
			//					System.out.println("fileFileName:"+filename);
						
						if (filename==null || filename.trim().equals("")) {
							json.setMsg("wrong");
							json.setSuccess(false);
							flag = 1;
							writeJson(json);
						}
						
						
						//得到上传文件的扩展名
						String fileExtName = fileXQGFileName.get(i).substring(fileXQGFileName.get(i).lastIndexOf(".")+1);
						//如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
			//					System.out.println("上传的文件扩展名为："+fileExtName);
						init();
						if (!allowType.contains(fileExtName)) {
							json.setMsg("wrong");
							json.setSuccess(false);
							flag = 1;
							writeJson(json);
						}
						
						if (flag==0) {
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
					        FileInputStream fis=new FileInputStream(fileXQG.get(i));
					        //得到文件保存的名称
					        String saveFileName = fileIODB.makeFileName(fileXQGFileName.get(i));
			//				        System.out.println("saveFileName:"+saveFileName);
					        //得到文件的保存目录
					        String realSavePath = fileIODB.makePath(saveFileName, savePath);
			//				        System.out.println("realSavePath:"+realSavePath);
					        //保存文件
					        FileOutputStream fos=new FileOutputStream(realSavePath +"\\"+saveFileName);
					        //保存文件地址,保存图片信息
					        AdImageFile newImage = new AdImageFile();
					        newImage.setIfPid(PId);
					        newImage.setIfFilepath(realSavePath +"\\"+saveFileName);
					        newImage.setIfPosition(1);
					        newImage.setIfSn(i+countXQg);
					        this.imagemgr.addImage(newImage);
					        
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
						
						
					}
				}
			}
			}
			
		
		if (flag==0) {
			json.setMsg("success");
			json.setSuccess(true);
		}
		
		
		writeJson(json);
		
	}
    
    /**
     * 其他信息提交修改
     */
    public void qtEdit() {
    	Json json = new Json();
		good = this.shopmgr.findGoodById(PId);
		good.setPCount(PCount);
		good.setPBaseprice(PBaseprice);
		good.setPMarketprice(PMarketprice);
		good.setPSellprice(PSellprice);
		good.setPSexrequest(PSexrequest);
		good.setPCommend(PCommend);
		good.setPState(PState);
		this.shopmgr.saveOrUpdateGood(good);
		json.setSuccess(true);
		writeJson(json);
	}
    
    
    /**
     * 删除商品及相关图片
     */
    public void delete() {
    	Json json = new Json();
		this.shopmgr.deleteGood(PId);
		images = this.imagemgr.findImageByPId(PId);
		int l = images.size();
		FileIODB fiIodb = new FileIODB();
		if (l>0) {
			for (int i = 0; i < l; i++) {
				fiIodb.deleteFile(images.get(i).getIfFilepath());
				this.imagemgr.deleteImage(images.get(i));
			}
		}
		json.setSuccess(true);
		writeJson(json);
	}
 
    
    /**
     * 查看该商品及其所有的商品图片
     */
    public void viGoodAndImage() {
    	JsonMultiObj json = new JsonMultiObj();
		good = this.shopmgr.findGoodById(PId);
		System.out.println("good:"+good);
		images = this.imagemgr.findImageListByPId(PId);
		System.out.println("images:"+images);
		
		json.setObj(good);
		json.setObj1(images);
		json.setSuccess(true);
		
		if (images.size()>0) {
			json.setMsg("success");
		}else {
			json.setMsg("error");
		}
		
		writeJson(json);
    }
    
    
    /**
     * 显示所有的商品申请表
     */
    public void listGoodAuth() {
    	
    	JsonMultiObj json = new JsonMultiObj();
		List<String> pathList = new ArrayList<String>();
		stId = (Integer) session.getAttribute("cusStore");
//		System.out.println("stId:"+stId);
		goods = this.shopmgr.findGoodAuthByStId(stId);
		System.out.println("goods:"+goods);
		if (goods!=null) {
			for (int i = 0; i < goods.size(); i++) {
				System.out.println("image Pid:"+goods.get(i).getPId());
				image = this.imagemgr.findImageListOneByPId(goods.get(i).getPId());
				System.out.println("image"+i+":"+image);
				if (image!=null) {
					pathList.add(image.getIfFilepath());
				}else {
					pathList.add("nopath");
				}
			}
			json.setMsg("success");
			json.setObj(goods);
			json.setObj1(pathList);
			json.setSuccess(true);
		}else {
			json.setMsg("false");
			json.setSuccess(false);
		}
		writeJson(json);
    	
    }
    
    
	/**
	 * 添加商品并添加商品
	 * @throws IOException 
	 */
	public void addGood() throws IOException {
		
		int flag = 0;
		Json json = new Json();
		stId = (Integer) session.getAttribute("cusStore");
		
		
		//上架是否重复判断
		AdProductInfo judGood = this.shopmgr.findGoodByNameWithStId(PName, stId);
		System.out.println("judGood:"+judGood);
		if (judGood!=null) {
			json.setMsg("exist");
			json.setSuccess(false);
			writeJson(json);
			flag=1;
		}
				
		if (flag==0) {
		
			//添加商品表
			Date date = new Date();       
			PCreateTime = new Timestamp(date.getTime());
			AdProductInfo newGood = new AdProductInfo();
//			System.out.println(PName+"'"+PBaseprice+"'"+PSexrequest);
			newGood.setPName(PName);
			newGood.setPDescription(PDescription);
			newGood.setPCreateTime(PCreateTime);
			newGood.setPBaseprice(PBaseprice);
			newGood.setPMarketprice(PMarketprice);
			newGood.setPSellprice(PSellprice);
			newGood.setPSexrequest(PSexrequest);
			newGood.setStId(stId);
			newGood.setPCount(0);
			newGood.setPCommend(0);
			newGood.setPClickcount(0);
			newGood.setPSellCount(0);
			newGood.setPState(1);
			adProductcategory = this.catemgr.findPCategoryById(cgId);
			brandAD = this.brmgr.findBrandById(brId);
			newGood.setAdProductcategory(adProductcategory);
			newGood.setBrandAD(brandAD);
			PId = this.shopmgr.addGoodRetPid(newGood);
		
		}
		
		if (flag==0) {
			
		
			//添加该商品图片
			//轮转图片添加
			for (int i = 0; i < fileLZ.size(); i++) {
				//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
				String filename = fileLZFileName.get(i).substring(fileLZFileName.get(i).lastIndexOf("\\")+1);
	//			System.out.println("fileFileName:"+filename);
				
				if (filename==null || filename.trim().equals("")) {
					json.setMsg("wrong");
					json.setSuccess(false);
					flag = 1;
					writeJson(json);
				}
				
				
				//得到上传文件的扩展名
				String fileExtName = fileLZFileName.get(i).substring(fileLZFileName.get(i).lastIndexOf(".")+1);
				//如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
	//			System.out.println("上传的文件扩展名为："+fileExtName);
				init();
				if (!allowType.contains(fileExtName)) {
					json.setMsg("wrong");
					json.setSuccess(false);
					flag = 1;
					writeJson(json);
				}
				
				if (flag==0) {
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
			        FileInputStream fis=new FileInputStream(fileLZ.get(i));
			        //得到文件保存的名称
			        String saveFileName = fileIODB.makeFileName(fileLZFileName.get(i));
	//		        System.out.println("saveFileName:"+saveFileName);
			        //得到文件的保存目录
			        String realSavePath = fileIODB.makePath(saveFileName, savePath);
	//		        System.out.println("realSavePath:"+realSavePath);
			        //保存文件
			        FileOutputStream fos=new FileOutputStream(realSavePath +"\\"+saveFileName);
			        //保存文件地址,保存图片信息
			        String path = realSavePath +"\\"+saveFileName;
			        AdImageFile newImage = new AdImageFile();
			        newImage.setIfFilepath(path);
			        newImage.setIfPosition(0);
			        newImage.setIfPid(PId);
			        newImage.setIfSn(i);
			        this.imagemgr.addImage(newImage);
			        
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
				
				
			}
			
			if (flag==0) {
			
				//详情展示图片添加
				for (int i = 0; i < fileXQ.size(); i++) {
					//处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					String filename = fileXQFileName.get(i).substring(fileXQFileName.get(i).lastIndexOf("\\")+1);
		//					System.out.println("fileFileName:"+filename);
					
					if (filename==null || filename.trim().equals("")) {
						json.setMsg("wrong");
						json.setSuccess(false);
						flag = 1;
						writeJson(json);
					}
					
					
					//得到上传文件的扩展名
					String fileExtName = fileXQFileName.get(i).substring(fileXQFileName.get(i).lastIndexOf(".")+1);
					//如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
		//					System.out.println("上传的文件扩展名为："+fileExtName);
					init();
					if (!allowType.contains(fileExtName)) {
						json.setMsg("wrong");
						json.setSuccess(false);
						flag = 1;
						writeJson(json);
					}
					
					if (flag==0) {
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
				        FileInputStream fis=new FileInputStream(fileXQ.get(i));
				        //得到文件保存的名称
				        String saveFileName = fileIODB.makeFileName(fileXQFileName.get(i));
		//				        System.out.println("saveFileName:"+saveFileName);
				        //得到文件的保存目录
				        String realSavePath = fileIODB.makePath(saveFileName, savePath);
		//				        System.out.println("realSavePath:"+realSavePath);
				        //保存文件
				        FileOutputStream fos=new FileOutputStream(realSavePath +"\\"+saveFileName);
				        //保存文件地址,保存图片信息
				        AdImageFile newImage = new AdImageFile();
				        newImage.setIfPid(PId);
				        newImage.setIfFilepath(realSavePath +"\\"+saveFileName);
				        newImage.setIfPosition(1);
				        newImage.setIfSn(i);
				        this.imagemgr.addImage(newImage);
				        
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
					
					
				}
			}
		}
		
		if (flag==0) {
			json.setMsg("success");
			json.setSuccess(true);
			writeJson(json);
		}
		
	}
	
	
	/**
	 * 找到当前店铺的ID查找商品列表和该列的显示图片路径
	 * @return 
	 */
	public void stFind() {
		JsonMultiObj json = new JsonMultiObj();
		List<String> pathList = new ArrayList<String>();
		stId = (Integer) session.getAttribute("cusStore");
//		System.out.println("stId:"+stId);
		goods = this.shopmgr.findGoodByStId(stId);
		System.out.println("goods:"+goods);
		if (goods!=null) {
			for (int i = 0; i < goods.size(); i++) {
				System.out.println("image Pid:"+goods.get(i).getPId());
				image = this.imagemgr.findImageListOneByPId(goods.get(i).getPId());
				System.out.println("image"+i+":"+image);
				if (image!=null) {
					pathList.add(image.getIfFilepath());
				}else {
					pathList.add("nopath");
				}
			}
			json.setMsg("success");
			json.setObj(goods);
			json.setObj1(pathList);
			json.setSuccess(true);
		}else {
			json.setMsg("false");
			json.setSuccess(false);
		}
		writeJson(json);
	}
	
	
	public ShopManager getShopmgr() {
		return shopmgr;
	}

	public void setShopmgr(ShopManager shopmgr) {
		this.shopmgr = shopmgr;
	}

	public ActionManager getBrmgr() {
		return brmgr;
	}

	public void setBrmgr(ActionManager brmgr) {
		this.brmgr = brmgr;
	}

	public ActionManager getCatemgr() {
		return catemgr;
	}

	public void setCatemgr(ActionManager catemgr) {
		this.catemgr = catemgr;
	}

	public ActionManager getStmgr() {
		return stmgr;
	}

	public void setStmgr(ActionManager stmgr) {
		this.stmgr = stmgr;
	}


	public AdProductcategory getAdProductcategory() {
		return adProductcategory;
	}


	public void setAdProductcategory(AdProductcategory adProductcategory) {
		this.adProductcategory = adProductcategory;
	}


	public BrandAD getBrandAD() {
		return brandAD;
	}


	public void setBrandAD(BrandAD brandAD) {
		this.brandAD = brandAD;
	}


	public Integer getPId() {
		return PId;
	}


	public void setPId(Integer pId) {
		PId = pId;
	}


	public String getPName() {
		return PName;
	}


	public void setPName(String pName) {
		PName = pName;
	}


	public String getPDescription() {
		return PDescription;
	}


	public void setPDescription(String pDescription) {
		PDescription = pDescription;
	}


	public Timestamp getPCreateTime() {
		return PCreateTime;
	}


	public void setPCreateTime(Timestamp pCreateTime) {
		PCreateTime = pCreateTime;
	}


	public Double getPBaseprice() {
		return PBaseprice;
	}


	public void setPBaseprice(Double pBaseprice) {
		PBaseprice = pBaseprice;
	}


	public Double getPMarketprice() {
		return PMarketprice;
	}


	public void setPMarketprice(Double pMarketprice) {
		PMarketprice = pMarketprice;
	}


	public Double getPSellprice() {
		return PSellprice;
	}


	public void setPSellprice(Double pSellprice) {
		PSellprice = pSellprice;
	}


	public String getPSexrequest() {
		return PSexrequest;
	}


	public void setPSexrequest(String pSexrequest) {
		PSexrequest = pSexrequest;
	}


	public String getPPlace() {
		return PPlace;
	}


	public void setPPlace(String pPlace) {
		PPlace = pPlace;
	}


	public Integer getPCount() {
		return PCount;
	}


	public void setPCount(Integer pCount) {
		PCount = pCount;
	}


	public Integer getPCommend() {
		return PCommend;
	}


	public void setPCommend(Integer pCommend) {
		PCommend = pCommend;
	}


	public Integer getPClickcount() {
		return PClickcount;
	}


	public void setPClickcount(Integer pClickcount) {
		PClickcount = pClickcount;
	}


	public Integer getPSellCount() {
		return PSellCount;
	}


	public void setPSellCount(Integer pSellCount) {
		PSellCount = pSellCount;
	}


	public Integer getStId() {
		return stId;
	}


	public void setStId(Integer stId) {
		this.stId = stId;
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


	public ShopManager getImagemgr() {
		return imagemgr;
	}


	public void setImagemgr(ShopManager imagemgr) {
		this.imagemgr = imagemgr;
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

	public List<File> getFileLZ() {
		return fileLZ;
	}

	public void setFileLZ(List<File> fileLZ) {
		this.fileLZ = fileLZ;
	}

	public List<String> getFileLZFileName() {
		return fileLZFileName;
	}

	public void setFileLZFileName(List<String> fileLZFileName) {
		this.fileLZFileName = fileLZFileName;
	}

	public List<String> getFileLZContentType() {
		return fileLZContentType;
	}

	public void setFileLZContentType(List<String> fileLZContentType) {
		this.fileLZContentType = fileLZContentType;
	}

	public List<File> getFileXQ() {
		return fileXQ;
	}

	public void setFileXQ(List<File> fileXQ) {
		this.fileXQ = fileXQ;
	}

	public List<String> getFileXQFileName() {
		return fileXQFileName;
	}

	public void setFileXQFileName(List<String> fileXQFileName) {
		this.fileXQFileName = fileXQFileName;
	}

	public List<String> getFileXQContentType() {
		return fileXQContentType;
	}

	public void setFileXQContentType(List<String> fileXQContentType) {
		this.fileXQContentType = fileXQContentType;
	}

	public Set<String> getAllowType() {
		return allowType;
	}

	public void setAllowType(Set<String> allowType) {
		this.allowType = allowType;
	}

	public Integer getBrId() {
		return brId;
	}

	public void setBrId(Integer brId) {
		this.brId = brId;
	}

	public Integer getCgId() {
		return cgId;
	}

	public void setCgId(Integer cgId) {
		this.cgId = cgId;
	}

	public Integer getPState() {
		return PState;
	}

	public void setPState(Integer pState) {
		PState = pState;
	}


	public List<File> getFileLZG() {
		return fileLZG;
	}


	public void setFileLZG(List<File> fileLZG) {
		this.fileLZG = fileLZG;
	}


	public List<String> getFileLZGFileName() {
		return fileLZGFileName;
	}


	public void setFileLZGFileName(List<String> fileLZGFileName) {
		this.fileLZGFileName = fileLZGFileName;
	}


	public List<String> getFileLZGContentType() {
		return fileLZGContentType;
	}


	public void setFileLZGContentType(List<String> fileLZGContentType) {
		this.fileLZGContentType = fileLZGContentType;
	}


	public List<File> getFileXQG() {
		return fileXQG;
	}


	public void setFileXQG(List<File> fileXQG) {
		this.fileXQG = fileXQG;
	}


	public List<String> getFileXQGFileName() {
		return fileXQGFileName;
	}


	public void setFileXQGFileName(List<String> fileXQGFileName) {
		this.fileXQGFileName = fileXQGFileName;
	}


	public List<String> getFileXQGContentType() {
		return fileXQGContentType;
	}


	public void setFileXQGContentType(List<String> fileXQGContentType) {
		this.fileXQGContentType = fileXQGContentType;
	}


	public Integer getCountLZg() {
		return countLZg;
	}


	public void setCountLZg(Integer countLZg) {
		this.countLZg = countLZg;
	}


	public Integer getCountXQg() {
		return countXQg;
	}


	public void setCountXQg(Integer countXQg) {
		this.countXQg = countXQg;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public AdStore getStore() {
		return store;
	}

	public void setStore(AdStore store) {
		this.store = store;
	}

	public List<AdProductcategory> getCates() {
		return cates;
	}

	public void setCates(List<AdProductcategory> cates) {
		this.cates = cates;
	}

	
	
}
