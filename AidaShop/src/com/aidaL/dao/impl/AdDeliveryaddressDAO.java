package com.aidaL.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdDeliveryaddress;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdDeliveryaddress entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.aidaL.dao.impl.AdDeliveryaddress
 * @author MyEclipse Persistence Tools
 */
public class AdDeliveryaddressDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdDeliveryaddressDAO.class);
	// property constants
	public static final String SH_NAME = "shName";
	public static final String SH_PHONE = "shPhone";
	public static final String SH_ADDRESS = "shAddress";
	public static final String SH_STATE = "shState";
	public static final String _UID = "UId";

	protected void initDao() {
		// do nothing
	}

	public void save(AdDeliveryaddress transientInstance) {
		log.debug("saving AdDeliveryaddress instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdDeliveryaddress persistentInstance) {
		log.debug("deleting AdDeliveryaddress instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdDeliveryaddress findById(java.lang.Integer id) {
		log.debug("getting AdDeliveryaddress instance with id: " + id);
		try {
			AdDeliveryaddress instance = (AdDeliveryaddress) getHibernateTemplate()
					.get("com.aidaL.bean.AdDeliveryaddress", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdDeliveryaddress instance) {
		log.debug("finding AdDeliveryaddress instance by example");
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
		log.debug("finding AdDeliveryaddress instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdDeliveryaddress as model where model."
					+ propertyName + "="+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByShName(Object shName) {
		return findByProperty(SH_NAME, shName);
	}

	public List<?> findByShPhone(Object shPhone) {
		return findByProperty(SH_PHONE, shPhone);
	}

	public List<?> findByShAddress(Object shAddress) {
		return findByProperty(SH_ADDRESS, shAddress);
	}

	public List<?> findByShState(Object shState) {
		return findByProperty(SH_STATE, shState);
	}

	public List<?> findByUId(Object UId) {
		return findByProperty(_UID, UId);
	}

	public List<?> findAll() {
		log.debug("finding all AdDeliveryaddress instances");
		try {
			String queryString = "from AdDeliveryaddress";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdDeliveryaddress merge(AdDeliveryaddress detachedInstance) {
		log.debug("merging AdDeliveryaddress instance");
		try {
			AdDeliveryaddress result = (AdDeliveryaddress) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdDeliveryaddress instance) {
		log.debug("attaching dirty AdDeliveryaddress instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdDeliveryaddress instance) {
		log.debug("attaching clean AdDeliveryaddress instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdDeliveryaddressDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdDeliveryaddressDAO) ctx.getBean("AdDeliveryaddressDAO");
	}

	@SuppressWarnings("unchecked")
	public List<AdDeliveryaddress> findAddressByUId(Integer uId) {
		String queryString = "from AdDeliveryaddress as model where model.UId = "+uId;
		List<AdDeliveryaddress> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public AdDeliveryaddress findAddressDefault(Integer uId) {
		String queryString = "from AdDeliveryaddress as model where model.UId = "+uId+" and model.shState = 1";
		List<AdDeliveryaddress> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}