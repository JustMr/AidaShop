package com.aidaL.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdArticle;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdArticle entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.aidaL.dao.impl.AdArticle
 * @author MyEclipse Persistence Tools
 */
public class AdArticleDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdArticleDAO.class);
	// property constants
	public static final String _UID = "UId";
	public static final String AR_TITLE = "arTitle";
	public static final String AR_MAIN = "arMain";
	public static final String AR_READ_COUNT = "arReadCount";
	public static final String AR_LIKE_COUNT = "arLikeCount";
	public static final String AR_HATE_COUNT = "arHateCount";

	protected void initDao() {
		// do nothing
	}

	public void save(AdArticle transientInstance) {
		log.debug("saving AdArticle instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AdArticle persistentInstance) {
		log.debug("deleting AdArticle instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void delete(Integer id) {
		log.debug("deleting AdArticle instance");
		try {
			getHibernateTemplate().delete(getHibernateTemplate().get(AdArticle.class, id));
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdArticle findById(java.lang.Integer id) {
		log.debug("getting AdArticle instance with id: " + id);
		try {
			AdArticle instance = (AdArticle) getHibernateTemplate().get(
					"com.aidaL.bean.AdArticle", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdArticle instance) {
		log.debug("finding AdArticle instance by example");
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
		log.debug("finding AdArticle instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AdArticle as model where model."
					+ propertyName + "= " + value;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<?> findByUId(Object UId) {
		return findByProperty(_UID, UId);
	}

	public List<?> findByArTitle(Object arTitle) {
		return findByProperty(AR_TITLE, arTitle);
	}

	public List<?> findByArMain(Object arMain) {
		return findByProperty(AR_MAIN, arMain);
	}

	public List<?> findByArReadCount(Object arReadCount) {
		return findByProperty(AR_READ_COUNT, arReadCount);
	}

	public List<?> findByArLikeCount(Object arLikeCount) {
		return findByProperty(AR_LIKE_COUNT, arLikeCount);
	}

	public List<?> findByArHateCount(Object arHateCount) {
		return findByProperty(AR_HATE_COUNT, arHateCount);
	}

	public List<?> findAll() {
		log.debug("finding all AdArticle instances");
		try {
			String queryString = "from AdArticle order by arId desc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdArticle merge(AdArticle detachedInstance) {
		log.debug("merging AdArticle instance");
		try {
			AdArticle result = (AdArticle) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdArticle instance) {
		log.debug("attaching dirty AdArticle instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdArticle instance) {
		log.debug("attaching clean AdArticle instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdArticleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AdArticleDAO) ctx.getBean("AdArticleDAO");
	}

	public Integer addArticleRetArid(AdArticle arc) {
		Integer arid = null;
		log.debug("saving AdArticle instance");
		try {
			getHibernateTemplate().save(arc);
			arid = arc.getArId();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		return arid;
	}

	@SuppressWarnings("unchecked")
	public List<AdArticle> findArticlesYSY() {
		String queryString = "from AdArticle as model where model.arState = 2";
		List<AdArticle> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdArticle> findArticlesNewPublish() {
		String queryString = "from AdArticle as model where model.arState = 0";
		List<AdArticle> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AdArticle> findArticlesSYHXG() {
		String queryString = "from AdArticle as model where model.arState = 1";
		List<AdArticle> list = this.getHibernateTemplate().find(queryString);
		if (list.size()>0) {
			return list;
		}
		return null;
	}
}