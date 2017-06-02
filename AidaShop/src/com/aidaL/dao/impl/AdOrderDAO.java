package com.aidaL.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdOrder;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdOrder entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.aidaL.dao.impl.AdOrder
 * @author MyEclipse Persistence Tools
 */
public class AdOrderDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(AdOrderDAO.class);
	// property constants
	public static final String CO_NAME = "coName";
	public static final String CO_TOTAL_PRICE = "coTotalPrice";
	public static final String CO_DISCOUNT_PRICE = "coDiscountPrice";
	public static final String CO_FREIGHT_CHARGE = "coFreightCharge";
	public static final String CO_REAL_PRICE = "coRealPrice";
	public static final String CO_PAYMENT_WAY = "coPaymentWay";
	public static final String CO_ORDER_STATE = "coOrderState";
	public static final String SH_ID = "shId";

	protected void initDao() {
		// do nothing
	}

	public void save(AdOrder transientInstance) {
		log.debug("saving AdOrder instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdOrder persistentInstance) {
		log.debug("deleting AdOrder instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdOrder findById(java.lang.Integer id) {
		log.debug("getting AdOrder instance with id: " + id);
		try {
			AdOrder instance = (AdOrder) getHibernateTemplate().get(
					"com.aidaL.bean.AdOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdOrder instance) {
		log.debug("finding AdOrder instance by example");
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
		log.debug("finding AdOrder instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AdOrder as model where model."
					+ propertyName + "= "+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByCoName(Object coName) {
		return findByProperty(CO_NAME, coName);
	}

	public List<?> findByCoTotalPrice(Object coTotalPrice) {
		return findByProperty(CO_TOTAL_PRICE, coTotalPrice);
	}

	public List<?> findByCoDiscountPrice(Object coDiscountPrice) {
		return findByProperty(CO_DISCOUNT_PRICE, coDiscountPrice);
	}

	public List<?> findByCoFreightCharge(Object coFreightCharge) {
		return findByProperty(CO_FREIGHT_CHARGE, coFreightCharge);
	}

	public List<?> findByCoRealPrice(Object coRealPrice) {
		return findByProperty(CO_REAL_PRICE, coRealPrice);
	}

	public List<?> findByCoPaymentWay(Object coPaymentWay) {
		return findByProperty(CO_PAYMENT_WAY, coPaymentWay);
	}

	public List<?> findByCoOrderState(Object coOrderState) {
		return findByProperty(CO_ORDER_STATE, coOrderState);
	}

	public List<?> findByShId(Object shId) {
		return findByProperty(SH_ID, shId);
	}

	public List<?> findAll() {
		log.debug("finding all AdOrder instances");
		try {
			String queryString = "from AdOrder";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdOrder merge(AdOrder detachedInstance) {
		log.debug("merging AdOrder instance");
		try {
			AdOrder result = (AdOrder) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdOrder instance) {
		log.debug("attaching dirty AdOrder instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdOrder instance) {
		log.debug("attaching clean AdOrder instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdOrderDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AdOrderDAO) ctx.getBean("AdOrderDAO");
	}

	@SuppressWarnings("unchecked")
	public List<AdOrder> findOrderByUId(Integer uId, String state) {
		String queryString = "from AdOrder as model LEFT OUTER JOIN fetch model.adCustomer where model.adCustomer.UId = "+uId+" and model.coOrderState = '"+state+"'";
		List<AdOrder> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	public Integer addOrderResCoId(AdOrder neworder) {
		Integer coId;
		this.getHibernateTemplate().save(neworder);
		coId = neworder.getCoId();
		return coId;
	}
}