package com.aidaL.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.BrandAD;
import com.aidaL.dao.AdBrandDAO;

public class AdBrandDAOImpl extends HibernateDaoSupport implements AdBrandDAO {

	@Override
	public BrandAD get(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(BrandAD.class, id);
	}

	@Override
	public void save(BrandAD brand) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().save(brand);
	}

	@Override
	public void update(BrandAD brand) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().saveOrUpdate(brand);
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(getHibernateTemplate().get(BrandAD.class, id));
	}

	@Override
	public void delete(BrandAD brand) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().delete(brand);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BrandAD> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from BrandAD au where au.brState  not in (3,4)");
	}

	@Override
	public BrandAD findBrandById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("AdBrandDAOImpl,id:"+id);
		@SuppressWarnings("unchecked")
		List<BrandAD> list = this.getHibernateTemplate().find("from com.aidaL.bean.BrandAD au where au.brId = '" + id + "'");
		System.out.println("AdStoreDAOImpl,name:"+list.get(0).getBrName());
		if (list.size()==1) {
			return (BrandAD)list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BrandAD findBrandByName(String brName) {
		// TODO Auto-generated method stub
		List<BrandAD> list = this.getHibernateTemplate().find("from com.aidaL.bean.BrandAD au where au.brName = '" + brName + "'");
		if (list.size()==1) {
			return (BrandAD)list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BrandAD> findBrandByStId(Integer stId) {
		List<BrandAD> list = this.getHibernateTemplate().find("from com.aidaL.bean.BrandAD au where au.stId = " + stId);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BrandAD> findBrandAuth() {
		List<BrandAD> list = this.getHibernateTemplate().find("from com.aidaL.bean.BrandAD au where au.brState = "+3);
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BrandAD> findBrandAuthByName(String brName, String brEngName) {
		String sql = "from com.aidaL.bean.BrandAD au where (au.brName='" + brName + "' or au.brEngName = '"+ brEngName +"') and au.brState not in (3,4)";
		Session session = this.getSession();
		Query query = session.createQuery(sql);
		List<BrandAD> list1 = query.list();
		session.clear();
		session.close();
		if (list1.size()>0) {
			return list1;
		}
		return null;
	}

}
