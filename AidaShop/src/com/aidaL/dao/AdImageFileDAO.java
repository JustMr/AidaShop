package com.aidaL.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdImageFile;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdImageFile entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.aidaL.dao.AdImageFile
 * @author MyEclipse Persistence Tools
 */
public class AdImageFileDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdImageFileDAO.class);
	// property constants
	public static final String IF_POSITION = "ifPosition";
	public static final String IF_PID = "ifPid";
	public static final String IF_CUST = "ifCust";
	public static final String IF_STID = "ifStid";
	public static final String IF_FILEPATH = "ifFilepath";
	public static final String IF_SN = "ifSn";

	protected void initDao() {
		// do nothing
	}

	public void save(AdImageFile transientInstance) {
		log.debug("saving AdImageFile instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdImageFile persistentInstance) {
		log.debug("deleting AdImageFile instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void delete(java.lang.Integer id) {
		log.debug("deleting AdImageFile instance with id:"+id);
		try {
			getHibernateTemplate().delete(getHibernateTemplate().get(AdImageFile.class, id));
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdImageFile findById(java.lang.Integer id) {
		log.debug("getting AdImageFile instance with id: " + id);
		try {
			AdImageFile instance = (AdImageFile) getHibernateTemplate().get(
					"com.aidaL.dao.AdImageFile", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdImageFile instance) {
		log.debug("finding AdImageFile instance by example");
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
		log.debug("finding AdImageFile instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AdImageFile as model where model."
					+ propertyName + "= "+value;
			System.out.println(queryString);
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByIfPosition(Object ifPosition) {
		return findByProperty(IF_POSITION, ifPosition);
	}

	public List<?> findByIfPid(Object ifPid) {
		return findByProperty(IF_PID, ifPid);
	}

	public List<?> findByIfCust(Object ifCust) {
		return findByProperty(IF_CUST, ifCust);
	}

	public List<?> findByIfStid(Object ifStid) {
		return findByProperty(IF_STID, ifStid);
	}

	public List<?> findByIfFilepath(Object ifFilepath) {
		return findByProperty(IF_FILEPATH, ifFilepath);
	}

	public List<?> findByIfSn(Object ifSn) {
		return findByProperty(IF_SN, ifSn);
	}

	public List<?> findAll() {
		log.debug("finding all AdImageFile instances");
		try {
			String queryString = "from AdImageFile";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdImageFile merge(AdImageFile detachedInstance) {
		log.debug("merging AdImageFile instance");
		try {
			AdImageFile result = (AdImageFile) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdImageFile instance) {
		log.debug("attaching dirty AdImageFile instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdImageFile instance) {
		log.debug("attaching clean AdImageFile instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdImageFileDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdImageFileDAO) ctx.getBean("AdImageFileDAO");
	}

	@SuppressWarnings("unchecked")
	public AdImageFile findImageListOneByPId(Integer pid) {
		String queryString = "from AdImageFile as model where model.ifPid = "+pid+" and model.ifPosition = 0 and model.ifSn = 0";
		List<AdImageFile> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}