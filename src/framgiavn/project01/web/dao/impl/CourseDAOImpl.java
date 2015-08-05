package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.hql.ast.util.SessionFactoryHelper;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.model.*;
import framgiavn.project01.web.dao.CourseDAO;
import framgiavn.project01.web.ulti.Logit2;

public class CourseDAOImpl extends HibernateDaoSupport implements CourseDAO {
	
	private static final Logit2 log = Logit2.getInstance(CourseDAO.class);
	
	protected void initDao() {
		// do nothing
	}

	@Override
	public List<Course> listCourse() {
		log.debug("List all course");
		try{
			Query query = getSession().getNamedQuery("Course.SelectCourseAll");
			return query.list();
		} catch (RuntimeException re) {
			log.error("List all course error!", re);
			throw re;
		}
	}
	
	@Override
	public List<Course> listUsersCourse(Integer userId) {
		try{
			Query query = getSession().getNamedQuery("Course.SelectCourseAll");
			return query.list();
		} catch (RuntimeException re) {
			log.error("List all course error!", re);
			throw re;
		}		
	}	

	public Course findById(Integer id, boolean lock) throws Exception {
		try {
			Query query = getSession().getNamedQuery("Course.SelectCourseById");
			if (lock)
				query.setLockMode("course", LockMode.UPGRADE);
			query.setParameter("id", id);
			return (Course) query.uniqueResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public void deleteCourse(Integer id) {
		log.debug("Delete a course");
		try {
			Query query = getSession().getNamedQuery("Course.DeleteCourseById");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (RuntimeException re) {
			log.error("Delete failed");
			throw re;
		}
	}

	@Override
	public void addCourse(Course course) {
		log.debug("Add course");
		try {
			getHibernateTemplate().save(course);
		} catch (RuntimeException re) {
			log.error("Add failed", re);
			throw re;
		}
		
	}

	@Override
	public void updateCourse(Course course) {
		log.debug("Update course");
		try {
			getHibernateTemplate().update(course);
		} catch (RuntimeException re) {
			log.error("Add or update failed", re);
			throw re;
		}
		
	}
	

}
