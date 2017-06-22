package com.aidaL.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdOrderitem;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdOrderitem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.aidaL.dao.impl.AdOrderitem
 * @author MyEclipse Persistence Tools
 */
public class AdOrderitemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdOrderitemDAO.class);
	// property constants
	public static final String _OAMOUNT = "OAmount";

	protected void initDao() {
		// do nothing
	}

	public void save(AdOrderitem transientInstance) {
		log.debug("saving AdOrderitem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdOrderitem persistentInstance) {
		log.debug("deleting AdOrderitem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdOrderitem findById(java.lang.Integer id) {
		log.debug("getting AdOrderitem instance with id: " + id);
		try {
			AdOrderitem instance = (AdOrderitem) getHibernateTemplate().get(
					"com.aidaL.bean.AdOrderitem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdOrderitem instance) {
		log.debug("finding AdOrderitem instance by example");
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
		log.debug("finding AdOrderitem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AdOrderitem as model where model."
					+ propertyName + "= "+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByOAmount(Object OAmount) {
		return findByProperty(_OAMOUNT, OAmount);
	}

	public List<?> findAll() {
		log.debug("finding all AdOrderitem instances");
		try {
			String queryString = "from AdOrderitem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdOrderitem merge(AdOrderitem detachedInstance) {
		log.debug("merging AdOrderitem instance");
		try {
			AdOrderitem result = (AdOrderitem) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdOrderitem instance) {
		log.debug("attaching dirty AdOrderitem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdOrderitem instance) {
		log.debug("attaching clean AdOrderitem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdOrderitemDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdOrderitemDAO) ctx.getBean("AdOrderitemDAO");
	}

	@SuppressWarnings("unchecked")
	public List<AdOrderitem> findOrderItemByCoId(Integer coId) {
		String queryString = "from AdOrderitem as model LEFT OUTER JOIN fetch model.adOrder where model.adOrder.coId = "+coId;
		List<AdOrderitem> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public AdOrderitem findOrderitemByCoIdAndPId(Integer coId, Integer pId) {
		String queryString = "from AdOrderitem as model LEFT OUTER JOIN fetch model.adOrder " +
				"LEFT OUTER JOIN fetch model.adProductInfo where model.adOrder.coId = "+coId+" " +
				"and model.adProductInfo.PId = "+pId;
		List<AdOrderitem> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdOrderitem> findOrderitemByStIdAndState(Integer stId,
			String string) {
		String queryString = "from AdOrderitem as model LEFT OUTER JOIN fetch model.adProductInfo where model.OState = '"+string+"' " +
				" and model.adProductInfo.stId = "+stId+" order by model.OId desc";
		List<AdOrderitem> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdOrderitem> findOrderItemByCoIdAndState(Integer coId,
			String string) {
		String queryString = "from AdOrderitem as model LEFT OUTER JOIN fetch model.adOrder where model.adOrder.coId = "+coId+" " +
				"and model.OState = '"+string+"'";
		List<AdOrderitem> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}
}