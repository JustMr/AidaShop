package com.aidaL.service;

import java.util.List;

import com.aidaL.bean.AdImageFile;
import com.aidaL.bean.AdProductInfo;

public interface ShopManager {

	//商品管理
	public void saveOrUpdateGood(AdProductInfo pro);
	public void deleteGood(Integer id);
	public void deleteGood(AdProductInfo pro);
	public void addGood(AdProductInfo pro);
	public AdProductInfo findGoodById(Integer id);
	public List<AdProductInfo> findAllGood();
	public List<AdProductInfo> findGoodByStId(Integer stId);
	public Integer addGoodRetPid(AdProductInfo good);
	/**
	 * 查询当前店铺的申请的商品列表
	 * @param stId 店铺ID
	 * @return 申请的商品列表
	 */
	public List<AdProductInfo> findGoodAuthByStId(Integer stId);
	
	
	//商品图片存储路径管理
	public void saveOrUpdateImage(AdImageFile image);
	public void deleteImage(Integer id);
	public void deleteImage(AdImageFile image);
	public void addImage(AdImageFile image);
	public AdImageFile findImageById(Integer id);
	public List<AdImageFile> findAllImage();
	public List<AdImageFile> findImageByPId(Integer pid);
	public AdImageFile findImageListOneByPId(Integer pid);
	
	
	/**
	 * 通过商品名称查询该店是否已经存在相同商品
	 * @param pName 商品名称
	 * @param stId 店铺ID
	 * @return 已存在返回AdProductInfo，不存在返回null
	 */
	public AdProductInfo findGoodByNameWithStId(String pName, Integer stId);
	
	
	/**
	 * 通过商品ID找到所有的该商品图片
	 * @param pId 商品ID
	 * @return 该商品的所有图片
	 */
	public List<AdImageFile> findImageListByPId(Integer pId);
	
	
	/**
	 * 超管查询所有的商品，已经通过审核的商品
	 * @return 已经通过审核的商品
	 */
	public List<AdProductInfo> findAllGoodWithNoAuth();
	
	/**
	 * 查询所有的代审核商品
	 * @return 代审核商品列表
	 */
	public List<AdProductInfo> findAllGoodOnlyAuth();
	
	
}
