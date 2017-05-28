package com.aidaL.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdHatearticle;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdHatearticle entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.aidaL.dao.impl.AdHatearticle
 * @author MyEclipse Persistence Tools
 */
public class AdHatearticleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdHatearticleDAO.class);
	// property constants
	public static final String AR_ID = "arId";
	public static final String _UID = "UId";

	protected void initDao() {
		// do nothing
	}

	public void save(AdHatearticle transientInstance) {
		log.debug("saving AdHatearticle instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdHatearticle persistentInstance) {
		log.debug("deleting AdHatearticle instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void delete(Integer id) {
		log.debug("deleting AdHatearticle instance");
		try {
			getHibernateTemplate().delete(getHibernateTemplate().get(AdHatearticle.class, id));
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdHatearticle findById(java.lang.Integer id) {
		log.debug("getting AdHatearticle instance with id: " + id);
		try {
			AdHatearticle instance = (AdHatearticle) getHibernateTemplate()
					.get("com.aidaL.bean.AdHatearticle", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdHatearticle instance) {
		log.debug("finding AdHatearticle instance by example");
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
		log.debug("finding AdHatearticle instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdHatearticle as model where model."
					+ propertyName + "= "+value;
			return getHibernateTemplate().find(queryString);
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
		log.debug("finding all AdHatearticle instances");
		try {
			String queryString = "from AdHatearticle";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdHatearticle merge(AdHatearticle detachedInstance) {
		log.debug("merging AdHatearticle instance");
		try {
			AdHatearticle result = (AdHatearticle) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdHatearticle instance) {
		log.debug("attaching dirty AdHatearticle instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdHatearticle instance) {
		log.debug("attaching clean AdHatearticle instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdHatearticleDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdHatearticleDAO) ctx.getBean("AdHatearticleDAO");
	}

	@SuppressWarnings("unchecked")
	public boolean findHateByUIdAndArId(Integer arId, Integer uId) {
		boolean jud = false;
		
		String queryString = "from AdHatearticle as model where model.arId = "+arId+" and model.UId = "+uId;
		List<AdHatearticle> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			jud=true;
		}
		
		return jud;
	}

	@SuppressWarnings("unchecked")
	public AdHatearticle findHate(Integer arId, Integer uId) {
		String queryString = "from AdHatearticle as model where model.arId = "+arId+" and model.UId = "+uId;
		List<AdHatearticle> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}