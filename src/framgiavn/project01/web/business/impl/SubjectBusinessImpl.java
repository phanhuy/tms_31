package framgiavn.project01.web.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import framgiavn.project01.web.business.SubjectBusiness;
import framgiavn.project01.web.dao.SubjectDAO;
import framgiavn.project01.web.dao.TakeTaskDAO;
import framgiavn.project01.web.model.Subject;
import framgiavn.project01.web.model.TakeTask;
import framgiavn.project01.web.model.Task;
import framgiavn.project01.web.model.User;

class SubjectBusinessImpl implements SubjectBusiness {
	
	private SubjectDAO subjectDAO;
	private TakeTaskDAO takeTaskDAO;
	private Map<String, Object> session;

	public SubjectDAO getSubjectDAO() {
		return subjectDAO;
	}


	public void setSubjectDAO(SubjectDAO subjectDAO) {
		this.subjectDAO = subjectDAO;
	}

	@Override
	public List<Subject> listSubject() {
		return subjectDAO.listSubject();
	}


	@Override
	public void addSubject(Subject subject) {
		subjectDAO.addSubject(subject);
	}


	@Override
	public void updateSubject(Subject subject) throws Exception {
		try {
			Subject subjectDB = subjectDAO.findById(subject.getId(), true);
			subjectDB.setId(subject.getId());
			subjectDB.setName(subject.getName());
			subjectDB.setDetail(subject.getDetail());
			
			subjectDAO.updateSubject(subjectDB);
		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	public void deleteSubject(Integer id) {
		subjectDAO.deleteSubject(id);
	}


	@Override
	public Subject findById(Integer id) throws Exception {
		try{
			Subject subject;
			session = ActionContext.getContext().getSession();
			User currentUser = (User)session.get("currentUser");			
			subject = getSubjectDAO().findById(id, false);			
			for(Task task: subject.getTasks()){
				task.setUserFinished(checkTakeTask(task.getId(), currentUser.getId()));								
			}
			return subject;
		} catch (Exception e) {
			throw e;
		}
	}


	@Override
	public List<Subject> listSubjectByCoureId(Integer id) {
		return getSubjectDAO().listSubjectByCoureId(id, false);
	}


	@Override
	public List<Subject> listSubjectByNotCourseId(Integer id) {
		return getSubjectDAO().listSubjectNotByCourseId(id, false);
	}


	public TakeTaskDAO getTakeTaskDAO() {
		return takeTaskDAO;
	}


	public void setTakeTaskDAO(TakeTaskDAO takeTaskDAO) {
		this.takeTaskDAO = takeTaskDAO;
	}


	@Override
	public void addUserTakeTask(TakeTask takeTask) {
		takeTaskDAO.takeTask(takeTask);		
	}

	

	@Override
	public Integer checkTakeTask(Integer taskId, Integer userId) throws Exception {		
		return takeTaskDAO.checkTakeTask(taskId, userId); 
	}


	@Override
	public void updateUserTakeTask(TakeTask takeTask) throws Exception {
		TakeTask takeTaskDB = takeTaskDAO.selectById(takeTask.getTaskId(), takeTask.getUserId(), false);
		
		takeTaskDB.setUpdateAt(new Date());
		takeTaskDB.setFinished(takeTask.getFinished());
		System.out.println(takeTask.getTaskId());
		takeTaskDAO.updateTask(takeTaskDB);		
	}

	
	public Subject showSubject(Subject subject) {
		Subject sub;
		session = ActionContext.getContext().getSession();
		User currentUser = (User)session.get("currentUser");
		
		try {			
			sub = findById(subject.getId());			
			for(Task task: sub.getTasks()){
				task.setUserFinished(checkTakeTask(task.getId(), currentUser.getId()));								
			}
			return sub;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	
}
