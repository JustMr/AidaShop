package com.aidaL.service.impl;

import com.aidaL.bean.AdHatearticle;
import com.aidaL.bean.AdLikearticle;
import com.aidaL.dao.impl.AdHatearticleDAO;
import com.aidaL.dao.impl.AdLikearticleDAO;
import com.aidaL.service.LikeHateManager;

public class LikeHateManagerImpl implements LikeHateManager {

	private AdLikearticleDAO likeDao;
	private AdHatearticleDAO hateDao;
	
	@Override
	public void saveOrUpdateLike(AdLikearticle like) {
		this.likeDao.attachDirty(like);
	}

	@Override
	public void deleteLike(Integer id) {
		this.likeDao.delete(id);
	}

	@Override
	public void deleteLike(AdLikearticle like) {
		this.likeDao.delete(like);
	}

	@Override
	public void addLike(AdLikearticle like) {
		this.likeDao.save(like);
	}

	@Override
	public boolean findLikeByUIdAndArId(Integer arId, Integer uId) {
		return this.likeDao.findLikeByUIdAndArId(arId, uId);
	}

	@Override
	public void saveOrUpdateHate(AdHatearticle hate) {
		this.hateDao.attachDirty(hate);
	}

	@Override
	public void deleteHate(Integer id) {
		this.hateDao.delete(id);
	}

	@Override
	public void deleteHate(AdHatearticle hate) {
		this.hateDao.delete(hate);
	}

	@Override
	public void addHate(AdHatearticle hate) {
		this.hateDao.save(hate);
	}

	@Override
	public boolean findHateByUIdAndArId(Integer arId, Integer uId) {
		return this.hateDao.findHateByUIdAndArId(arId, uId);
	}

	public AdLikearticleDAO getLikeDao() {
		return likeDao;
	}

	public void setLikeDao(AdLikearticleDAO likeDao) {
		this.likeDao = likeDao;
	}

	public AdHatearticleDAO getHateDao() {
		return hateDao;
	}

	public void setHateDao(AdHatearticleDAO hateDao) {
		this.hateDao = hateDao;
	}

	@Override
	public AdLikearticle findLike(Integer arId, Integer uId) {
		return this.likeDao.findLike(arId, uId);
	}

	@Override
	public AdHatearticle findHate(Integer arId, Integer uId) {
		return this.hateDao.findHate(arId, uId);
	}

}
