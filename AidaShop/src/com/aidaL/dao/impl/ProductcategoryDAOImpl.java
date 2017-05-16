package com.aidaL.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.aidaL.bean.AdProductcategory;

public class ProductcategoryDAOImpl extends HibernateDaoSupport implements com.aidaL.dao.ProductcategoryDAO {

	@Override
	public AdProductcategory get(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(AdProductcategory.class, id);
	}

	@Override
	public void save(AdProductcategory cate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(cate);
	}

	@Override
	public void update(AdProductcategory cate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(cate);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(getHibernateTemplate().get(AdProductcategory.class, id));
	}

	@Override
	public void delete(AdProductcategory cate) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(cate);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdProductcategory> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from AdProductcategory");
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdProductcategory findcateById(Integer id) {
		// TODO Auto-generated method stub
		List<AdProductcategory> list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgId = '"+id+"'");
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdProductcategory findcateByName(String cgName) {
		// TODO Auto-generated method stub
		List<AdProductcategory> list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgName ='"+cgName+"'");
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdProductcategory> findLvOne() {
		// TODO Auto-generated method stub
		List<AdProductcategory> list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgLevel="+0+" and pc.cgState <>"+0);
		if (list.size()>0) {
			return list;
		}
		return null; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdProductcategory> findLvTwoOrThree(Integer cgPid) {
		// TODO Auto-generated method stub
		List<AdProductcategory> list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgPid="+cgPid+" and pc.cgState <>"+0+" order by pc.cgPosition asc");
		if (list.size()>0) {
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void UpdateState(Integer cgPosition, Integer cgState) {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Iterator<AdProductcategory> cates = session.createQuery("from AdProductcategory pc where pc.cgPosition = "+ cgPosition +" and pc.cgState >= "+cgState+" and pc.cgLevel = "+0).list().iterator();
		while (cates.hasNext()) {
			AdProductcategory cate = (AdProductcategory) cates.next();
			cate.setCgState(cate.getCgState()+1);
		}
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void UpdatePosition(Integer cgPid, Integer cgPosition) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Iterator<AdProductcategory> cates = session.createQuery("from AdProductcategory pc where pc.cgPid = "+ cgPid +" and pc.cgPosition >= "+cgPosition).list().iterator();
		while (cates.hasNext()) {
			AdProductcategory cate = (AdProductcategory) cates.next();
			cate.setCgPosition(cate.getCgPosition()+1);
		}
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteMove(Integer cgPid, Integer cgPosition) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Iterator<AdProductcategory> cates = session.createQuery("from AdProductcategory pc where pc.cgPid = "+ cgPid +" and pc.cgPosition > "+cgPosition).list().iterator();
		while (cates.hasNext()) {
			AdProductcategory cate = (AdProductcategory) cates.next();
			cate.setCgPosition(cate.getCgPosition()-1);
		}
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteFirstMove(Integer cgPosition, Integer cgState) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Iterator<AdProductcategory> cates = session.createQuery("from AdProductcategory pc where pc.cgPosition = "+ cgPosition +" and pc.cgState > "+cgState+" and pc.cgLevel = "+0).list().iterator();
		while (cates.hasNext()) {
			AdProductcategory cate = (AdProductcategory) cates.next();
			cate.setCgState(cate.getCgState()-1);
		}
		tx.commit();
		session.close();
	}

	@Override
	public void deletePCategoryByPID(Integer cgPid) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		String sql = "Delete FROM AdProductcategory pc Where pc.cgPid = " + cgPid;
		Query query = session.createQuery(sql);
		query.executeUpdate();
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean judgeFirstLast(Integer cgPosition, Integer cgState) {
		boolean bottom = true;
		List<AdProductcategory> list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgPosition > "+ cgPosition +" and pc.cgLevel = "+0);
		if (list.size()>0) {
			//有比其大的行
			bottom = false;
		}else {
			//无比其大的行，有比其大的列
			List<AdProductcategory> list1 = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgPosition = "+ cgPosition +" and pc.cgState > "+cgState+" and pc.cgLevel = "+0);
			if (list1.size()>0) {
				bottom = false;
			}
		}
		return bottom;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdProductcategory judgeFirstLastState(Integer cgPosition, Integer cgState) {
		AdProductcategory last = null;
		Integer next = cgState + 1;
		List<AdProductcategory> list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgPosition = "+ cgPosition +" and pc.cgState = "+next+" and pc.cgLevel = "+0);
		if (list.size()>0) {
			//下一个为同行下一个
			last = list.get(0);
		}else {
			//下一个为下一行第一个
			next = cgPosition+1;
			list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgPosition = "+ next +" and pc.cgState = "+1+" and pc.cgLevel = "+0);
			if (list.size()>0) {
				last = list.get(0);
			}
		}
		return last;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdProductcategory judgeLast(Integer cgPid, Integer cgPosition) {
		Integer next = cgPosition + 1;
		List<AdProductcategory> list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgPid = "+ cgPid +" and pc.cgPosition = "+next);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdProductcategory judgeFirstPre(Integer cgPosition, Integer cgState) {
		List<AdProductcategory> list = null;
		Integer per;
		if (cgState==1) {
			//在该行的第一个
			per = cgPosition-1;
			list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgPosition = "+ per +" and pc.cgLevel = "+0+" order by pc.cgState desc"); 
			if (list.size()>0) {
				return list.get(0);
			}
		}else {
			per = cgState - 1;
			list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgPosition = "+ cgPosition +" and pc.cgState = "+per+" and pc.cgLevel = "+0);
			if (list.size()>0) {
				return list.get(0);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AdProductcategory judgePre(Integer cgPid, Integer cgPosition) {
		Integer pre = cgPosition - 1;
		List<AdProductcategory> list = this.getHibernateTemplate().find("from AdProductcategory pc where pc.cgPid = "+ cgPid +" and pc.cgPosition = "+pre);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void BackwardPosition(Integer cgPosition) {
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		Iterator<AdProductcategory> cates = session.createQuery("from AdProductcategory pc where pc.cgPosition > "+ cgPosition +" and pc.cgLevel = "+0).list().iterator();
		while (cates.hasNext()) {
			AdProductcategory cate = (AdProductcategory) cates.next();
			cate.setCgPosition(cate.getCgPosition()-1);
		}
		tx.commit();
		session.close();
	}

}
