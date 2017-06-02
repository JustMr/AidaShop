package com.aidaL.service.impl;

import java.util.List;

import com.aidaL.bean.AdImageFile;
import com.aidaL.bean.AdProductInfo;
import com.aidaL.dao.AdImageFileDAO;
import com.aidaL.dao.AdProductInfoDAO;
import com.aidaL.service.ShopManager;

public class ShopManagerImpl implements ShopManager {

	private AdProductInfoDAO goodDao;
	private AdImageFileDAO imageDao;
	
	//商品管理*************************
	@Override
	public void saveOrUpdateGood(AdProductInfo pro) {
		this.goodDao.attachDirty(pro);
	}

	@Override
	public void deleteGood(Integer id) {
		this.goodDao.delete(id);
	}

	@Override
	public void addGood(AdProductInfo pro) {
		this.goodDao.save(pro);
	}

	@Override
	public Integer addGoodRetPid(AdProductInfo good) {
		return this.goodDao.addGoodRetPid(good);
	}
	
	@Override
	public AdProductInfo findGoodById(Integer id) {
		return this.goodDao.findById(id);
	}

	@Override
	public List<AdProductInfo> findAllGood() {
		List<AdProductInfo> list = this.goodDao.findAll();
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	public AdProductInfoDAO getGoodDao() {
		return goodDao;
	}

	public void setGoodDao(AdProductInfoDAO goodDao) {
		this.goodDao = goodDao;
	}

	@Override
	public List<AdProductInfo> findGoodByStId(Integer stId) {
		return this.goodDao.findByStIdNoAuth(stId);
	}

	@Override
	public void deleteGood(AdProductInfo pro) {
		this.goodDao.delete(pro);
	}
	

	@Override
	public AdProductInfo findGoodByNameWithStId(String pName, Integer stId) {
		return this.goodDao.findGoodByNameWithStId(pName,stId);
	}

	@Override
	public List<AdProductInfo> findGoodAuthByStId(Integer stId) {
		// TODO Auto-generated method stub
		return this.goodDao.findGoodAuthByStId(stId);
	}
	
	@Override
	public List<AdProductInfo> findAllGoodWithNoAuth() {
		return this.goodDao.findAllGoodWithNoAuth();
	}
	
	
	//商品图片存储路径管理***********************************
	@Override
	public void saveOrUpdateImage(AdImageFile image) {
		this.imageDao.attachDirty(image);
	}

	@Override
	public void deleteImage(Integer id) {
		this.imageDao.delete(id);
	}

	@Override
	public void deleteImage(AdImageFile image) {
		this.imageDao.delete(image);
	}

	@Override
	public void addImage(AdImageFile image) {
		this.imageDao.save(image);
	}

	@Override
	public AdImageFile findImageById(Integer id) {
		return this.imageDao.findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdImageFile> findAllImage() {
		return (List<AdImageFile>) this.imageDao.findAll();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdImageFile> findImageByPId(Integer pid) {
		return (List<AdImageFile>) this.imageDao.findByIfPid(pid);
	}

	public AdImageFileDAO getImageDao() {
		return imageDao;
	}

	public void setImageDao(AdImageFileDAO imageDao) {
		this.imageDao = imageDao;
	}

	/**
	 * 找到列表展示图片既第一个商品展示轮转图
	 */
	@Override
	public AdImageFile findImageListOneByPId(Integer pid) {
		return this.imageDao.findImageListOneByPId(pid);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdImageFile> findImageListByPId(Integer pId) {
		return (List<AdImageFile>) this.imageDao.findByIfPid(pId);
	}

	@Override
	public List<AdProductInfo> findAllGoodOnlyAuth() {
		// TODO Auto-generated method stub
		return this.goodDao.findAllGoodOnlyAuth();
	}

	@Override
	public List<AdProductInfo> findGoodByUnSureName(String pName) {
		return this.goodDao.findGoodByUnSureName(pName);
	}

	@Override
	public List<AdProductInfo> findGoodByCgId(Integer cgId) {
		return this.goodDao.findGoodByCgId(cgId);
	}

	@Override
	public List<AdProductInfo> findGoodByCgBrPPNP(Integer cgId, Integer brId,
			Integer prepri, Integer nextpri) {
		return this.goodDao.findGoodByCgBrPPNP(cgId, brId, prepri, nextpri);
	}

	@Override
	public List<AdProductInfo> findGoodByUnSureNameWithCgBrPPNP(String pName,Integer cgId,
			Integer brId, Integer prepri, Integer nextpri) {
		return this.goodDao.findGoodByUnSureNameWithCgBrPPNP(pName,cgId, brId, prepri, nextpri);
	}

	@Override
	public List<AdImageFile> findImageByPIdGrouPAndOrder(Integer pId) {
		return this.imageDao.findImageByPIdGrouPAndOrder(pId);
	}






}
