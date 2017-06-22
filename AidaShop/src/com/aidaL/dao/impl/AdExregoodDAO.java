package com.aidaL.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdExregood;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdExregood entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.aidaL.dao.impl.AdExregood
 * @author MyEclipse Persistence Tools
 */
public class AdExregoodDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdExregoodDAO.class);
	// property constants
	public static final String ER_AUTH = "erAuth";
	public static final String _OID = "OId";
	public static final String ER_REASON = "erReason";
	public static final String ER_STATE = "erState";

	protected void initDao() {
		// do nothing
	}

	public void save(AdExregood transientInstance) {
		log.debug("saving AdExregood instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdExregood persistentInstance) {
		log.debug("deleting AdExregood instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdExregood findById(java.lang.Integer id) {
		log.debug("getting AdExregood instance with id: " + id);
		try {
			AdExregood instance = (AdExregood) getHibernateTemplate().get(
					"com.aidaL.bean.AdExregood", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdExregood instance) {
		log.debug("finding AdExregood instance by example");
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
		log.debug("finding AdExregood instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AdExregood as model where model."
					+ propertyName + "="+value+" order by model.erId desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByErAuth(Object erAuth) {
		return findByProperty(ER_AUTH, erAuth);
	}

	public List<?> findByOId(Object OId) {
		return findByProperty(_OID, OId);
	}

	public List<?> findByErReason(Object erReason) {
		return findByProperty(ER_REASON, erReason);
	}

	public List<?> findByErState(Object erState) {
		return findByProperty(ER_STATE, erState);
	}

	public List<?> findAll() {
		log.debug("finding all AdExregood instances");
		try {
			String queryString = "from AdExregood order by erId desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdExregood merge(AdExregood detachedInstance) {
		log.debug("merging AdExregood instance");
		try {
			AdExregood result = (AdExregood) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdExregood instance) {
		log.debug("attaching dirty AdExregood instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdExregood instance) {
		log.debug("attaching clean AdExregood instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdExregoodDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AdExregoodDAO) ctx.getBean("AdExregoodDAO");
	}

	@SuppressWarnings("unchecked")
	public List<AdExregood> findEXREAuthByAuthWithState(String auth,
			Integer state) {
		String queryString = "from AdExregood as model where model.erAuth = '"+auth+"' and  model.erState="+state+" order by model.erId desc";
		List<AdExregood> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	public List<AdExregood> findEXREAuthByOIdWithState(Integer oId, String auth) {
		String queryString = "from AdExregood as model where model.OId = "+oId+" and  model.erAuth= '"+auth+"' order by model.erId desc";
		@SuppressWarnings("unchecked")
		List<AdExregood> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	public List<AdExregood> findEXREAuthByUId(Integer uId) {
		String queryString = "from AdExregood as model where model.UId = "+uId+" order by model.erId desc";
		@SuppressWarnings("unchecked")
		List<AdExregood> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdExregood> findAdExregoodsByStId(Integer stId) {
		String queryString = "from AdExregood as model where model.stId = "+stId+" order by model.erId desc";
		List<AdExregood> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdExregood> findAdExregoodsByStIdWithAuth(Integer stId,
			String string) {
		String queryString = "from AdExregood as model where model.stId = "+stId+" and model.erAuth = '"+string+"' order by model.erId desc";
		List<AdExregood> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

}