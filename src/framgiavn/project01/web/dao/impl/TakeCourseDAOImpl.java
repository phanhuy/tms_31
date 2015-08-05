package framgiavn.project01.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import framgiavn.project01.web.dao.TakeCourseDAO;
import framgiavn.project01.web.model.TakeCourse;
import framgiavn.project01.web.ulti.Logit2;

public class TakeCourseDAOImpl extends HibernateDaoSupport implements TakeCourseDAO {

	private static final Logit2 log = Logit2.getInstance(TakeCourseDAOImpl.class);	

	protected void initDAO() {
		// Do nothing
	}
	
	@Override
	public void addUserToSubject(TakeCourse takeCourse) {
		log.debug("Add user to course");
		try {
			getHibernateTemplate().save(takeCourse);
		} catch (RuntimeException re) {
			log.error("Add user to course failed", re);
			throw re;
		}
	}

	@Override
	public void removeUserFromCourse(Integer user_id, Integer course_id) {
		log.debug("Remove user from course");
		try {
			Query query = getSession().getNamedQuery("TakeCourse.DeleteRow");
			query.setParameter("user_id", user_id);
			query.setParameter("course_id", course_id);
			query.executeUpdate();
		} catch (RuntimeException re) {
			log.error("Delete failed");
			throw re;
		}
	}

	@Override
	public List<TakeCourse> selectTakeCourseByUserId(Integer user_id) {
		try {
			Query query = getSession().getNamedQuery("TakeCourse.SelectCoursesByUser");
			query.setParameter("user_id", user_id);			
			return query.list();
		} catch (RuntimeException re) {			
			throw re;
		}
	}

}