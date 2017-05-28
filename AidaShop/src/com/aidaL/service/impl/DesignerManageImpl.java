package com.aidaL.service.impl;

import java.util.List;

import com.aidaL.bean.AdArticle;
import com.aidaL.bean.AdDesginerinfo;
import com.aidaL.bean.AdGoodsmatch;
import com.aidaL.dao.impl.AdArticleDAO;
import com.aidaL.dao.impl.AdDesginerinfoDAO;
import com.aidaL.dao.impl.AdGoodsmatchDAO;
import com.aidaL.service.DesignerManage;

public class DesignerManageImpl implements DesignerManage {

	private AdArticleDAO articleDao;
	private AdDesginerinfoDAO desginerinfoDao;
	private AdGoodsmatchDAO gmDao;
	
	

	public AdArticleDAO getArticleDao() {
		return articleDao;
	}

	public void setArticleDao(AdArticleDAO articleDao) {
		this.articleDao = articleDao;
	}

	public AdDesginerinfoDAO getDesginerinfoDao() {
		return desginerinfoDao;
	}

	public void setDesginerinfoDao(AdDesginerinfoDAO desginerinfoDao) {
		this.desginerinfoDao = desginerinfoDao;
	}

	public AdGoodsmatchDAO getGmDao() {
		return gmDao;
	}

	public void setGmDao(AdGoodsmatchDAO gmDao) {
		this.gmDao = gmDao;
	}
	
	
	//****************** 设计师详细信息管理 ********************
	
	@Override
	public void saveOrUpdateDesginerInfo(AdDesginerinfo desinfo) {
		this.desginerinfoDao.attachDirty(desinfo);
	}

	@Override
	public void deleteDesginerInfo(Integer id) {
		this.desginerinfoDao.delete(id);
	}

	@Override
	public void deleteDesginerInfo(AdDesginerinfo desinfo) {
		this.desginerinfoDao.delete(desinfo);
	}

	@Override
	public void addDesginerInfo(AdDesginerinfo desinfo) {
		this.desginerinfoDao.save(desinfo);
	}

	@Override
	public AdDesginerinfo findDesginerInfoById(Integer id) {
		return this.desginerinfoDao.findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdDesginerinfo> findAllDesginerInfo() {
		return (List<AdDesginerinfo>) this.desginerinfoDao.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdDesginerinfo findDesginerInfoByUId(Integer uId) {
		List<AdDesginerinfo> list = (List<AdDesginerinfo>) this.desginerinfoDao.findByUId(uId);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Integer addDesginerInfoRetDIid(AdDesginerinfo desinfo) {
		return this.desginerinfoDao.addDesginerInfoRetDIid(desinfo);
	}
	
	@Override
	public List<AdDesginerinfo> findSevenDesigner() {
		return this.desginerinfoDao.findSevenDesigner();
	}
	
	//************* 文章管理 **************************
	@Override
	public void saveOrUpdateArticle(AdArticle arc) {
		this.articleDao.attachDirty(arc);
	}

	@Override
	public void deleteArticle(Integer id) {
		this.articleDao.delete(id);
	}

	@Override
	public void deleteArticle(AdArticle arc) {
		this.articleDao.delete(arc);
	}

	@Override
	public void addArticle(AdArticle arc) {
		this.articleDao.save(arc);
	}

	@Override
	public AdArticle findArticleById(Integer id) {
		return this.articleDao.findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdArticle> findAllArticle() {
		return (List<AdArticle>) this.articleDao.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdArticle> findArticleByUId(Integer uId) {
		return (List<AdArticle>) this.articleDao.findByUId(uId);
	}

	@Override
	public Integer addArticleRetArid(AdArticle arc) {
		return this.articleDao.addArticleRetArid(arc);
	}

	
	//************* 搭配商品条目表管理 **************************
	@Override
	public void saveOrUpdateGoodsMatch(AdGoodsmatch gm) {
		this.gmDao.attachDirty(gm);
	}

	@Override
	public void deleteGoodsMatch(Integer id) {
		this.gmDao.delete(id);
	}

	@Override
	public void deleteGoodsMatch(AdGoodsmatch gm) {
		this.gmDao.delete(gm);
	}

	@Override
	public void addGoodsMatch(AdGoodsmatch gm) {
		this.gmDao.save(gm);
	}

	@Override
	public AdGoodsmatch findGoodsMatchById(Integer id) {
		return this.gmDao.findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdGoodsmatch> findAllGoodsMatch() {
		// TODO Auto-generated method stub
		return (List<AdGoodsmatch>) this.gmDao.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdGoodsmatch> findGoodsMatchByArId(Integer arId) {
		return (List<AdGoodsmatch>) this.gmDao.findByArId(arId);
	}

	@Override
	public Integer addGoodsMatchRetGmid(AdGoodsmatch gm) {
		return this.gmDao.addGoodsMatchRetGmid(gm);
	}

	@Override
	public List<AdArticle> findArticlesYSY() {
		return this.articleDao.findArticlesYSY();
	}

	@Override
	public List<AdArticle> findArticlesNewPublish() {
		return this.articleDao.findArticlesNewPublish();
	}

	@Override
	public List<AdArticle> findArticlesSYHXG() {
		return this.articleDao.findArticlesSYHXG();
	}


	


}
