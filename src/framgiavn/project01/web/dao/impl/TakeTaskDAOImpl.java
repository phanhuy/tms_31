package framgiavn.project01.web.dao.impl;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import framgiavn.project01.web.dao.TakeTaskDAO;
import framgiavn.project01.web.model.Subject;
import framgiavn.project01.web.model.TakeTask;
import framgiavn.project01.web.ulti.Logit2;

public class TakeTaskDAOImpl extends HibernateDaoSupport implements TakeTaskDAO {

	private static final Logit2 log = Logit2.getInstance(TakeTaskDAOImpl.class);

	@Override
	public void takeTask(TakeTask takeTask) {
		try {
			getHibernateTemplate().save(takeTask);
		} catch (RuntimeException re) {			
			throw re;
		}		
	}
	
	public void updateTask(TakeTask takeTask) {
		try {
			getHibernateTemplate().update(takeTask);
		} catch (RuntimeException re) {			
			throw re;
		}
	}

	@Override
	public Integer checkTakeTask(Integer taskId, Integer userId) {
		Query query = getSession().getNamedQuery("TakeTask.SelectTakeTask");
		query.setParameter("taskId", taskId);			
		query.setParameter("userId", userId);		
		TakeTask taketask = (TakeTask) query.uniqueResult();		
		if(query.list().size()==0)
			return -1;
		else{
			return taketask.getFinished();
		}
	}

	@Override
	public TakeTask selectById(Integer taskId, Integer userId,Boolean lock ) {
		try {
			Query query = getSession().getNamedQuery("TakeTask.SelectTasksById");
			if (lock)
				query.setLockMode("takeTask", LockMode.UPGRADE);
			query.setParameter("taskId", taskId);
			query.setParameter("userId", userId);
			return (TakeTask) query.uniqueResult();
		} catch (RuntimeException re) {			
			throw re;
		}
	}
		
}