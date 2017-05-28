package com.aidaL.service;

import java.util.List;

import com.aidaL.bean.AdArticle;
import com.aidaL.bean.AdDesginerinfo;
import com.aidaL.bean.AdGoodsmatch;

public interface DesignerManage {

	
	//造型师相关信息统计
	public void saveOrUpdateDesginerInfo(AdDesginerinfo desinfo);
	public void deleteDesginerInfo(Integer id);
	public void deleteDesginerInfo(AdDesginerinfo desinfo);
	public void addDesginerInfo(AdDesginerinfo desinfo);
	public AdDesginerinfo findDesginerInfoById(Integer id);
	public List<AdDesginerinfo> findAllDesginerInfo();
	public AdDesginerinfo findDesginerInfoByUId(Integer uId);
	public Integer addDesginerInfoRetDIid(AdDesginerinfo desinfo);
	
	//文章管理
	public void saveOrUpdateArticle(AdArticle arc);
	public void deleteArticle(Integer id);
	public void deleteArticle(AdArticle arc);
	public void addArticle(AdArticle arc);
	public AdArticle findArticleById(Integer id);
	public List<AdArticle> findAllArticle();
	public List<AdArticle> findArticleByUId(Integer uId);
	public Integer addArticleRetArid(AdArticle arc);
	
	//商品搭配表
	public void saveOrUpdateGoodsMatch(AdGoodsmatch gm);
	public void deleteGoodsMatch(Integer id);
	public void deleteGoodsMatch(AdGoodsmatch gm);
	public void addGoodsMatch(AdGoodsmatch gm);
	public AdGoodsmatch findGoodsMatchById(Integer id);
	public List<AdGoodsmatch> findAllGoodsMatch();
	public List<AdGoodsmatch> findGoodsMatchByArId(Integer arId);
	public Integer addGoodsMatchRetGmid(AdGoodsmatch gm);
	
	/**
	 * 找到点赞数最高的7个造型师
	 * @return 造型师列表
	 */
	public List<AdDesginerinfo> findSevenDesigner();
	
	/**
	 * 查看已经审阅的文章列表
	 * @return
	 */
	public List<AdArticle> findArticlesYSY();
	
	/**
	 * 查看新发表的文章列表
	 * @return
	 */
	public List<AdArticle> findArticlesNewPublish();
	
	/**
	 * 审阅后又修改的文章列表
	 * @return
	 */
	public List<AdArticle> findArticlesSYHXG();
	
	
}
