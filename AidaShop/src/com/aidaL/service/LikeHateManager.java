package com.aidaL.service;

import com.aidaL.bean.AdHatearticle;
import com.aidaL.bean.AdLikearticle;

public interface LikeHateManager {

	//点赞
	public void saveOrUpdateLike(AdLikearticle like);
	public void deleteLike(Integer id);
	public void deleteLike(AdLikearticle like);
	public void addLike(AdLikearticle like);
	public boolean findLikeByUIdAndArId(Integer arId, Integer uId);
	public AdLikearticle findLike(Integer arId, Integer uId);
	
	
	//不满意
	public void saveOrUpdateHate(AdHatearticle hate);
	public void deleteHate(Integer id);
	public void deleteHate(AdHatearticle hate);
	public void addHate(AdHatearticle hate);
	public boolean findHateByUIdAndArId(Integer arId, Integer uId);
	public AdHatearticle findHate(Integer arId, Integer uId);
	
}
