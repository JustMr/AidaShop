package com.aidaL.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdLogistics;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdLogistics entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.aidaL.dao.impl.AdLogistics
 * @author MyEclipse Persistence Tools
 */
public class AdLogisticsDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdLogisticsDAO.class);
	// property constants
	public static final String LG_COMPABY = "lgCompaby";
	public static final String LG_NUMBER = "lgNumber";
	public static final String _OID = "OId";

	protected void initDao() {
		// do nothing
	}

	public void save(AdLogistics transientInstance) {
		log.debug("saving AdLogistics instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdLogistics persistentInstance) {
		log.debug("deleting AdLogistics instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdLogistics findById(java.lang.Integer id) {
		log.debug("getting AdLogistics instance with id: " + id);
		try {
			AdLogistics instance = (AdLogistics) getHibernateTemplate().get(
					"com.aidaL.bean.AdLogistics", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdLogistics instance) {
		log.debug("finding AdLogistics instance by example");
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
		log.debug("finding AdLogistics instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AdLogistics as model where model."
					+ propertyName + "= "+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByLgCompaby(Object lgCompaby) {
		return findByProperty(LG_COMPABY, lgCompaby);
	}

	public List<?> findByLgNumber(Object lgNumber) {
		return findByProperty(LG_NUMBER, lgNumber);
	}

	public List<?> findByOId(Object OId) {
		return findByProperty(_OID, OId);
	}

	public List<?> findAll() {
		log.debug("finding all AdLogistics instances");
		try {
			String queryString = "from AdLogistics";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdLogistics merge(AdLogistics detachedInstance) {
		log.debug("merging AdLogistics instance");
		try {
			AdLogistics result = (AdLogistics) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdLogistics instance) {
		log.debug("attaching dirty AdLogistics instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdLogistics instance) {
		log.debug("attaching clean AdLogistics instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdLogisticsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdLogisticsDAO) ctx.getBean("AdLogisticsDAO");
	}
}