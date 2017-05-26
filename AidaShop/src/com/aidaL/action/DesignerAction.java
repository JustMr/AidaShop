package com.aidaL.action;

import java.util.ArrayList;
import java.util.List;

import com.aidaL.bean.AdArticle;
import com.aidaL.bean.AdCustomer;
import com.aidaL.bean.AdDesginerinfo;
import com.aidaL.bean.AdGoodsmatch;
import com.aidaL.bean.AdImageFile;
import com.aidaL.bean.AdProductInfo;
import com.aidaL.bean.AdStore;
import com.aidaL.db.TextFilter;
import com.aidaL.service.ActionManager;
import com.aidaL.service.DesignerManage;
import com.aidaL.service.ShopManager;
import com.aidaL.util.Json;

public class DesignerAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -91139860810358332L;

	private DesignerManage desinfomgr;
	private DesignerManage articlemgr;
	private DesignerManage matchmgr;
	private ShopManager goodmgr;
	private ActionManager stmgr;
	private ShopManager imagemgr;
	private ActionManager custmgr;
	
	private AdDesginerinfo desinfo;
	private AdArticle article;
	private AdGoodsmatch gm;
	private List<AdDesginerinfo> desinfos = new ArrayList<AdDesginerinfo>();
	private List<AdArticle> articles = new ArrayList<AdArticle>();
	private List<AdGoodsmatch> gms = new ArrayList<AdGoodsmatch>();
	private AdProductInfo good;
	private AdImageFile image;
	private AdStore store;
	private List<AdImageFile> images = new ArrayList<AdImageFile>();
	private List<AdProductInfo> goods = new ArrayList<AdProductInfo>();
	private AdCustomer cust;
	private List<AdCustomer> custs;

	private Integer cusId;
	private String cusNickName;
	private Integer UStylingDesigner;
	private String styleName;

	private Integer UId;
	private Integer arId;
	
	private String arTitle;
    private String arMain;
	
	
	//发表文章
	public void pubArticle() {
		Json json = new Json();
		
		String pIds = request.getParameter("ids");
		String[] Pids = pIds.split(",");
		System.out.println("Pids:"+Pids);
		
		
		//创建文章表
		UId = (Integer) session.getAttribute("cusId");
		AdArticle newArt = new AdArticle();
		newArt.setArTitle(arTitle);
		newArt.setArMain(arMain);
		newArt.setArHateCount(0);
		newArt.setArLikeCount(0);
		newArt.setArReadCount(0);
		newArt.setUId(UId);
		arId = this.articlemgr.addArticleRetArid(newArt);
		
		
		//创建商品搭配表，记录相关商品
		if (Pids.length>0) {
			for (int i = 0; i < Pids.length; i++) {
				Integer pid =  Integer.valueOf(Pids[i]);
				System.out.println(pid);
				AdGoodsmatch newMatch = new AdGoodsmatch();
				newMatch.setArId(arId);
				newMatch.setPId(pid);
				this.matchmgr.addGoodsMatch(newMatch);
			}
		}
		
		
		//更新造型师文章统计信息
		desinfo = this.desinfomgr.findDesginerInfoByUId(UId);
		Integer count = desinfo.getDiArticleCount() + 1;
		desinfo.setDiArticleCount(count);
		this.desinfomgr.saveOrUpdateDesginerInfo(desinfo);
		
		
		json.setSuccess(true);
		
		
		writeJson(json);
		
	}
	
	//c查看文章详情
	public String viArticle() {
		article = this.articlemgr.findArticleById(arId);
		desinfo = this.desinfomgr.findDesginerInfoByUId(article.getUId());
		
		//文章浏览数跟新
		Integer read = article.getArReadCount() + 1;
		article.setArReadCount(read);
		this.articlemgr.saveOrUpdateArticle(article);
		
		//跟新造型师信息浏览总数
		Integer read1 = desinfo.getDiReadCount() + 1;
		desinfo.setDiReadCount(read1);
		this.desinfomgr.saveOrUpdateDesginerInfo(desinfo);
		
		//获取商品信息和缩略图路径
		gms = this.matchmgr.findGoodsMatchByArId(arId);
		System.out.println("gms:"+gms);
		goods = new ArrayList<AdProductInfo>();
		List<String> paths = new ArrayList<String>();
		if (gms.size()>0) {
			for (int j = 0; j < gms.size(); j++) {
				good = this.goodmgr.findGoodById(gms.get(j).getPId());
				goods.add(good);
				image = this.imagemgr.findImageListOneByPId(good.getPId());
//				System.out.println("image"+i+":"+image);
				if (image!=null) {
					String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
					path = path.replaceAll("\\\\", "/");
					paths.add(path);
				}else {
					paths.add("nopath");
				}
			}
		}
		article.setGood(goods);
		article.setPath(paths);
		
		return "viarticle";
	}
	
	//查看设计师详情
	public String viDesign() {
		
		return "videsign";
	}
	
	//跳转到搭配中心
    public String dapeiCenter() {
    	
    	
    	//获取当前用户ID和昵称
    	cusId = (Integer) session.getAttribute("cusId");
    	cusNickName = (String) session.getAttribute("cusNickName");
//    	System.out.println("cusId:"+cusId);
    	
    	
    	//获取个人信息框中内容
    	if (cusId!=null) {
    		//已登录
    		//得到造型师信息表，没有添加
    		desinfo = this.desinfomgr.findDesginerInfoByUId(cusId);
    		if (desinfo==null) {
				//造型师信息表为空，创新新信息
    			AdDesginerinfo newdi = new AdDesginerinfo();
    			newdi.setUId(cusId);
    			newdi.setDiArticleCount(0);
    			newdi.setDiHateCount(0);
    			newdi.setDiLikeCount(0);
    			newdi.setDiReadCount(0);
    			newdi.setDiState(0);
    			this.desinfomgr.addDesginerInfo(newdi);
    			
    			desinfo = this.desinfomgr.findDesginerInfoByUId(cusId);
    			//第一登录反馈
    			request.setAttribute("msg", "one");
			}else {
				//非第一次登录
				request.setAttribute("msg", "more");
			}
    		
    		//获取个人信息
    		cust = this.custmgr.findCustById(cusId);
    		UStylingDesigner = cust.getUStylingDesigner();
    		if (UStylingDesigner==0) {
				styleName = "普通用户";
			}else if (UStylingDesigner==1) {
				styleName = "平台认证";
			}else if (UStylingDesigner==2) {
				styleName = "国家认证";
			}else if (UStylingDesigner==3) {
				styleName = "国家认证审核中";
			}else if (UStylingDesigner==4) {
				styleName = "平台认证审核中";
			}
    		
    	}else {
    		//未登录
    		styleName = "登录加入我们";
    		request.setAttribute("msg", "unlog");
		}
    	
    	
    	//造型师排行，查找点赞最高的7个造型师
    	desinfos = this.desinfomgr.findSevenDesigner();
//    	System.out.println("desinfos:"+desinfos);
    	if (desinfos.size()>0) {
    		//获取昵称
			for (int i = 0; i < desinfos.size(); i++) {
				cust = this.custmgr.findCustById(desinfos.get(i).getUId());
				desinfos.get(i).setNickName(cust.getUNickName());
			}
		}
    	
    	
    	//查询文章列表
    	articles = this.articlemgr.findAllArticle();
//    	System.out.println("articles:"+articles);
    	if (articles.size()>0) {
    		//将goods添加到articles中
    		for (int i = 0; i < articles.size(); i++) {
    			gms = this.matchmgr.findGoodsMatchByArId(articles.get(i).getArId());
    			System.out.println("gms:"+gms);
    			goods = new ArrayList<AdProductInfo>();
    			List<String> paths = new ArrayList<String>();
    			if (gms.size()>0) {
					for (int j = 0; j < gms.size(); j++) {
						good = this.goodmgr.findGoodById(gms.get(j).getPId());
						goods.add(good);
						image = this.imagemgr.findImageListOneByPId(good.getPId());
//						System.out.println("image"+i+":"+image);
						if (image!=null) {
							String path = "." + image.getIfFilepath().substring(image.getIfFilepath().indexOf("\\upload\\"));
							path = path.replaceAll("\\\\", "/");
							paths.add(path);
						}else {
							paths.add("nopath");
						}
					}
				}
    			articles.get(i).setGood(goods);
    			articles.get(i).setPath(paths);
    			
    			
    			//设置摘要
    			String digest = articles.get(i).getArMain();
    			TextFilter textFilter = new TextFilter();
    			digest = textFilter.stripHtml(digest);
    			articles.get(i).setDigest(digest);
        	}
		}
    	
    	
    	return "dapeicenter";
    }
	
	
	public Integer getUId() {
		return UId;
	}

	public void setUId(Integer uId) {
		UId = uId;
	}

	public Integer getUStylingDesigner() {
		return UStylingDesigner;
	}


	public void setUStylingDesigner(Integer uStylingDesigner) {
		UStylingDesigner = uStylingDesigner;
	}


	public AdCustomer getCust() {
		return cust;
	}


	public void setCust(AdCustomer cust) {
		this.cust = cust;
	}


	public List<AdCustomer> getCusts() {
		return custs;
	}


	public void setCusts(List<AdCustomer> custs) {
		this.custs = custs;
	}


	public DesignerManage getDesinfomgr() {
		return desinfomgr;
	}
	public void setDesinfomgr(DesignerManage desinfomgr) {
		this.desinfomgr = desinfomgr;
	}
	public DesignerManage getArticlemgr() {
		return articlemgr;
	}
	public void setArticlemgr(DesignerManage articlemgr) {
		this.articlemgr = articlemgr;
	}
	public DesignerManage getMatchmgr() {
		return matchmgr;
	}
	public void setMatchmgr(DesignerManage matchmgr) {
		this.matchmgr = matchmgr;
	}
	public AdDesginerinfo getDesinfo() {
		return desinfo;
	}
	public void setDesinfo(AdDesginerinfo desinfo) {
		this.desinfo = desinfo;
	}
	public AdArticle getArticle() {
		return article;
	}
	public void setArticle(AdArticle article) {
		this.article = article;
	}
	public AdGoodsmatch getGm() {
		return gm;
	}
	public void setGm(AdGoodsmatch gm) {
		this.gm = gm;
	}
	public List<AdDesginerinfo> getDesinfos() {
		return desinfos;
	}
	public void setDesinfos(List<AdDesginerinfo> desinfos) {
		this.desinfos = desinfos;
	}
	public List<AdArticle> getArticles() {
		return articles;
	}
	public void setArticles(List<AdArticle> articles) {
		this.articles = articles;
	}
	public List<AdGoodsmatch> getGms() {
		return gms;
	}
	public void setGms(List<AdGoodsmatch> gms) {
		this.gms = gms;
	}


	public ShopManager getGoodmgr() {
		return goodmgr;
	}


	public void setGoodmgr(ShopManager goodmgr) {
		this.goodmgr = goodmgr;
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


	public AdProductInfo getGood() {
		return good;
	}


	public void setGood(AdProductInfo good) {
		this.good = good;
	}


	public AdImageFile getImage() {
		return image;
	}


	public void setImage(AdImageFile image) {
		this.image = image;
	}


	public AdStore getStore() {
		return store;
	}


	public void setStore(AdStore store) {
		this.store = store;
	}


	public List<AdImageFile> getImages() {
		return images;
	}


	public void setImages(List<AdImageFile> images) {
		this.images = images;
	}


	public List<AdProductInfo> getGoods() {
		return goods;
	}


	public void setGoods(List<AdProductInfo> goods) {
		this.goods = goods;
	}


	public Integer getCusId() {
		return cusId;
	}


	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}


	public String getCusNickName() {
		return cusNickName;
	}


	public void setCusNickName(String cusNickName) {
		this.cusNickName = cusNickName;
	}


	public ActionManager getCustmgr() {
		return custmgr;
	}


	public void setCustmgr(ActionManager custmgr) {
		this.custmgr = custmgr;
	}


	public String getStyleName() {
		return styleName;
	}


	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}

	public Integer getArId() {
		return arId;
	}

	public void setArId(Integer arId) {
		this.arId = arId;
	}

	public String getArTitle() {
		return arTitle;
	}

	public void setArTitle(String arTitle) {
		this.arTitle = arTitle;
	}

	public String getArMain() {
		return arMain;
	}

	public void setArMain(String arMain) {
		this.arMain = arMain;
	}
	
	
	
}
