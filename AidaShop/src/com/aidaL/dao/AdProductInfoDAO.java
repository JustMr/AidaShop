package com.aidaL.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdProductInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdProductInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.aidaL.bean.AdProductInfo
 * @author MyEclipse Persistence Tools
 */
public class AdProductInfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdProductInfoDAO.class);
	// property constants
	public static final String _PNAME = "PName";
	public static final String _PDESCRIPTION = "PDescription";
	public static final String _PBASEPRICE = "PBaseprice";
	public static final String _PMARKETPRICE = "PMarketprice";
	public static final String _PSELLPRICE = "PSellprice";
	public static final String _PSEXREQUEST = "PSexrequest";
	public static final String _PPLACE = "PPlace";
	public static final String _PCOUNT = "PCount";
	public static final String _PCOMMEND = "PCommend";
	public static final String _PCLICKCOUNT = "PClickcount";
	public static final String _PSELL_COUNT = "PSellCount";
	public static final String ST_ID = "stId";

	protected void initDao() {
		// do nothing
	}

	public void save(AdProductInfo transientInstance) {
		log.debug("saving AdProductInfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdProductInfo persistentInstance) {
		log.debug("deleting AdProductInfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void delete(java.lang.Integer id) {
		log.debug("deleting AdProductInfo instance with id:" + id);
		try {
			getHibernateTemplate().delete(getHibernateTemplate().get(AdProductInfo.class, id));
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdProductInfo findById(java.lang.Integer id) {
		log.debug("getting AdProductInfo instance with id: " + id);
		try {
			AdProductInfo instance = (AdProductInfo) getHibernateTemplate()
					.get("com.aidaL.bean.AdProductInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AdProductInfo> findByExample(AdProductInfo instance) {
		log.debug("finding AdProductInfo instance by example");
		try {
			List<AdProductInfo> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<AdProductInfo> findByProperty(String propertyName, Object value) {
		log.debug("finding AdProductInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdProductInfo as model where model."
					+ propertyName + "="+value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<AdProductInfo> findByPName(Object PName) {
		return findByProperty(_PNAME, PName);
	}

	public List<AdProductInfo> findByPDescription(Object PDescription) {
		return findByProperty(_PDESCRIPTION, PDescription);
	}

	public List<AdProductInfo> findByPBaseprice(Object PBaseprice) {
		return findByProperty(_PBASEPRICE, PBaseprice);
	}

	public List<AdProductInfo> findByPMarketprice(Object PMarketprice) {
		return findByProperty(_PMARKETPRICE, PMarketprice);
	}

	public List<AdProductInfo> findByPSellprice(Object PSellprice) {
		return findByProperty(_PSELLPRICE, PSellprice);
	}

	public List<AdProductInfo> findByPSexrequest(Object PSexrequest) {
		return findByProperty(_PSEXREQUEST, PSexrequest);
	}

	public List<AdProductInfo> findByPPlace(Object PPlace) {
		return findByProperty(_PPLACE, PPlace);
	}

	public List<AdProductInfo> findByPCount(Object PCount) {
		return findByProperty(_PCOUNT, PCount);
	}

	public List<AdProductInfo> findByPCommend(Object PCommend) {
		return findByProperty(_PCOMMEND, PCommend);
	}

	public List<AdProductInfo> findByPClickcount(Object PClickcount) {
		return findByProperty(_PCLICKCOUNT, PClickcount);
	}

	public List<AdProductInfo> findByPSellCount(Object PSellCount) {
		return findByProperty(_PSELL_COUNT, PSellCount);
	}

	public List<AdProductInfo> findByStId(Object stId) {
		return findByProperty(ST_ID, stId);
	}

	@SuppressWarnings("unchecked")
	public List<AdProductInfo> findAll() {
		log.debug("finding all AdProductInfo instances");
		try {
			String queryString = "from AdProductInfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdProductInfo merge(AdProductInfo detachedInstance) {
		log.debug("merging AdProductInfo instance");
		try {
			AdProductInfo result = (AdProductInfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdProductInfo instance) {
		log.debug("attaching dirty AdProductInfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdProductInfo instance) {
		log.debug("attaching clean AdProductInfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdProductInfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdProductInfoDAO) ctx.getBean("AdProductInfoDAO");
	}

	public Integer addGoodRetPid(AdProductInfo good) {
		this.getHibernateTemplate().save(good);
		Integer pid = good.getPId();
		return pid;
	}

	@SuppressWarnings("unchecked")
	public AdProductInfo findGoodByNameWithStId(String pName, Integer stId) {
		String queryString = "from AdProductInfo as model where model.PName = '"+ pName + "' and model.stId = " + stId;
		List<AdProductInfo> good = this.getHibernateTemplate().find(queryString);
		if (good.size()>0) {
			return good.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdProductInfo> findGoodAuthByStId(Integer stId) {
		String queryString = "from AdProductInfo as model where model.PState = 1 and model.stId = " + stId;
		List<AdProductInfo> goods = this.getHibernateTemplate().find(queryString);
		if (goods.size()>0) {
			return goods;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdProductInfo> findByStIdNoAuth(Integer stId) {
		String queryString = "from AdProductInfo as model where model.PState not in (0,1) and model.stId = " + stId;
		List<AdProductInfo> goods = this.getHibernateTemplate().find(queryString);
		System.out.println("findByStIdNoAuth goods:"+goods);
		if (goods.size()>0) {
			return goods;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdProductInfo> findAllGoodWithNoAuth() {
		String queryString = "from AdProductInfo as model where model.PState not in (0,1)";
		List<AdProductInfo> goods = this.getHibernateTemplate().find(queryString);
		if (goods.size()>0) {
			return goods;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdProductInfo> findAllGoodOnlyAuth() {
		String queryString = "from AdProductInfo as model where model.PState = 1";
		List<AdProductInfo> goods = this.getHibernateTemplate().find(queryString);
		if (goods.size()>0) {
			return goods;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdProductInfo> findGoodByUnSureName(String pName) {
		String queryString = "from AdProductInfo as model where model.PName like '%"+pName+"%' and model.PState not in (0,1)";
		List<AdProductInfo> goods = this.getHibernateTemplate().find(queryString);
		if (goods.size()>0) {
			return goods;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdProductInfo> findGoodByCgId(Integer cgId) {
		//外键查询
		String queryString = "from AdProductInfo as model LEFT OUTER JOIN fetch model.adProductcategory where model.adProductcategory.cgId = "+cgId+" and model.PState not in (0,1)";
		List<AdProductInfo> goods = this.getHibernateTemplate().find(queryString);
		if (goods.size()>0) {
			return goods;
		}
		return null;
	}
	
	
}