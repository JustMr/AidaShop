package com.aidaL.dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdDesginerinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * AdDesginerinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.aidaL.dao.impl.AdDesginerinfo
 * @author MyEclipse Persistence Tools
 */
public class AdDesginerinfoDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(AdDesginerinfoDAO.class);
	// property constants
	public static final String _UID = "UId";
	public static final String DI_ARTICLE_COUNT = "diArticleCount";
	public static final String DI_READ_COUNT = "diReadCount";
	public static final String DI_LIKE_COUNT = "diLikeCount";
	public static final String DI_HATE_COUNT = "diHateCount";
	public static final String DI_STATE = "diState";

	protected void initDao() {
		// do nothing
	}

	public void save(AdDesginerinfo transientInstance) {
		log.debug("saving AdDesginerinfo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void delete(Integer id) {
		log.debug("deleting AdDesginerinfo instance");
		try {
			getHibernateTemplate().delete(getHibernateTemplate().get(AdDesginerinfo.class, id));
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public void delete(AdDesginerinfo persistentInstance) {
		log.debug("deleting AdDesginerinfo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AdDesginerinfo findById(java.lang.Integer id) {
		log.debug("getting AdDesginerinfo instance with id: " + id);
		try {
			AdDesginerinfo instance = (AdDesginerinfo) getHibernateTemplate()
					.get("com.aidaL.dao.impl.AdDesginerinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<?> findByExample(AdDesginerinfo instance) {
		log.debug("finding AdDesginerinfo instance by example");
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
		log.debug("finding AdDesginerinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AdDesginerinfo as model where model."
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

	public List<?> findByDiArticleCount(Object diArticleCount) {
		return findByProperty(DI_ARTICLE_COUNT, diArticleCount);
	}

	public List<?> findByDiReadCount(Object diReadCount) {
		return findByProperty(DI_READ_COUNT, diReadCount);
	}

	public List<?> findByDiLikeCount(Object diLikeCount) {
		return findByProperty(DI_LIKE_COUNT, diLikeCount);
	}

	public List<?> findByDiHateCount(Object diHateCount) {
		return findByProperty(DI_HATE_COUNT, diHateCount);
	}

	public List<?> findByDiState(Object diState) {
		return findByProperty(DI_STATE, diState);
	}

	public List<?> findAll() {
		log.debug("finding all AdDesginerinfo instances");
		try {
			String queryString = "from AdDesginerinfo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AdDesginerinfo merge(AdDesginerinfo detachedInstance) {
		log.debug("merging AdDesginerinfo instance");
		try {
			AdDesginerinfo result = (AdDesginerinfo) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AdDesginerinfo instance) {
		log.debug("attaching dirty AdDesginerinfo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AdDesginerinfo instance) {
		log.debug("attaching clean AdDesginerinfo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdDesginerinfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AdDesginerinfoDAO) ctx.getBean("AdDesginerinfoDAO");
	}

	public Integer addDesginerInfoRetDIid(AdDesginerinfo desinfo) {
		Integer diId = null;
		log.debug("saving AdDesginerinfo instance");
		try {
			getHibernateTemplate().save(desinfo);
			diId = desinfo.getDiId();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		return diId;
	}

	@SuppressWarnings("unchecked")
	public List<AdDesginerinfo> findSevenDesigner() {
		//获取点赞最高的7条信息
		String sql = "from AdDesginerinfo model where model.diState <> 2 order by model.diLikeCount desc";
		Session session = this.getSession();
		Query query = session.createQuery(sql);
		query.setFirstResult(0);
		query.setMaxResults(7);
		List<AdDesginerinfo> list = query.list();
		session.clear();
		session.close();
		return list;
	}
}