package com.aidaL.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdLikearticle;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdLikearticle entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.aidaL.dao.impl.AdLikearticle
 * @author MyEclipse Persistence Tools
 */
public class AdLikearticleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdLikearticleDAO.class);
	// property constants
	public static final String AR_ID = "arId";
	public static final String _UID = "UId";

	protected void initDao() {
		// do nothing
	}

	public void save(AdLikearticle transientInstance) {
		log.debug("saving AdLikearticle instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdLikearticle persistentInstance) {
		log.debug("deleting AdLikearticle instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void delete(Integer id) {
		log.debug("deleting AdLikearticle instance");
		try {
			getHibernateTemplate().delete(getHibernateTemplate().get(AdLikearticle.class, id));
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdLikearticle findById(java.lang.Integer id) {
		log.debug("getting AdLikearticle instance with id: " + id);
		try {
			AdLikearticle instance = (AdLikearticle) getHibernateTemplate()
					.get("com.aidaL.bean.AdLikearticle", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdLikearticle instance) {
		log.debug("finding AdLikearticle instance by example");
		try {
			List<?> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<?> findByProperty(String propertyName, Object value) {
		log.debug("finding AdLikearticle instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdLikearticle as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByArId(Object arId) {
		return findByProperty(AR_ID, arId);
	}

	public List<?> findByUId(Object UId) {
		return findByProperty(_UID, UId);
	}

	public List<?> findAll() {
		log.debug("finding all AdLikearticle instances");
		try {
			String queryString = "from AdLikearticle";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdLikearticle merge(AdLikearticle detachedInstance) {
		log.debug("merging AdLikearticle instance");
		try {
			AdLikearticle result = (AdLikearticle) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdLikearticle instance) {
		log.debug("attaching dirty AdLikearticle instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdLikearticle instance) {
		log.debug("attaching clean AdLikearticle instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdLikearticleDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdLikearticleDAO) ctx.getBean("AdLikearticleDAO");
	}

	@SuppressWarnings("unchecked")
	public boolean findLikeByUIdAndArId(Integer arId, Integer uId) {
		boolean jud = false;
		
		String queryString = "from AdLikearticle as model where model.arId = "+arId+" and model.UId = "+uId;
		List<AdLikearticle> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			jud=true;
		}
		
		return jud;
	}

	@SuppressWarnings("unchecked")
	public AdLikearticle findLike(Integer arId, Integer uId) {
		String queryString = "from AdLikearticle as model where model.arId = "+arId+" and model.UId = "+uId;
		List<AdLikearticle> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}