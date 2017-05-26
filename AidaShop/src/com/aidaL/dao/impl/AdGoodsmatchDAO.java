package com.aidaL.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdGoodsmatch;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdGoodsmatch entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.aidaL.dao.impl.AdGoodsmatch
 * @author MyEclipse Persistence Tools
 */
public class AdGoodsmatchDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdGoodsmatchDAO.class);
	// property constants
	public static final String AR_ID = "arId";
	public static final String _PID = "PId";

	protected void initDao() {
		// do nothing
	}

	public void save(AdGoodsmatch transientInstance) {
		log.debug("saving AdGoodsmatch instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdGoodsmatch persistentInstance) {
		log.debug("deleting AdGoodsmatch instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void delete(Integer id) {
		log.debug("deleting AdGoodsmatch instance");
		try {
			getHibernateTemplate().delete(getHibernateTemplate().get(AdGoodsmatch.class, id));
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdGoodsmatch findById(java.lang.Integer id) {
		log.debug("getting AdGoodsmatch instance with id: " + id);
		try {
			AdGoodsmatch instance = (AdGoodsmatch) getHibernateTemplate().get(
					"com.aidaL.dao.impl.AdGoodsmatch", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdGoodsmatch instance) {
		log.debug("finding AdGoodsmatch instance by example");
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
		log.debug("finding AdGoodsmatch instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdGoodsmatch as model where model."
					+ propertyName + "= "+ value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByArId(Object arId) {
		return findByProperty(AR_ID, arId);
	}

	public List<?> findByPId(Object PId) {
		return findByProperty(_PID, PId);
	}

	public List<?> findAll() {
		log.debug("finding all AdGoodsmatch instances");
		try {
			String queryString = "from AdGoodsmatch";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdGoodsmatch merge(AdGoodsmatch detachedInstance) {
		log.debug("merging AdGoodsmatch instance");
		try {
			AdGoodsmatch result = (AdGoodsmatch) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdGoodsmatch instance) {
		log.debug("attaching dirty AdGoodsmatch instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdGoodsmatch instance) {
		log.debug("attaching clean AdGoodsmatch instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdGoodsmatchDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdGoodsmatchDAO) ctx.getBean("AdGoodsmatchDAO");
	}

	public Integer addGoodsMatchRetGmid(AdGoodsmatch gm) {
		Integer gmIdInteger = null;
		log.debug("saving AdGoodsmatch instance");
		try {
			getHibernateTemplate().save(gm);
			gmIdInteger = gm.getGmId();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		return gmIdInteger;
	}
}