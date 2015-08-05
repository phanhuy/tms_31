package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.Subject;
import framgiavn.project01.web.model.TakeTask;

public interface SubjectBusiness {
	
	List<Subject> listSubject();
	
	List<Subject> listSubjectByCoureId(Integer id);
	
	List<Subject> listSubjectByNotCourseId(Integer id);
	
	void addSubject(Subject subject);
	
	void updateSubject(Subject subject) throws Exception;
	
	void deleteSubject(Integer id) throws Exception;;

	Subject findById(Integer id) throws Exception;
	
	void addUserTakeTask(TakeTask takeTask) throws Exception;;
	void updateUserTakeTask(TakeTask takeTask) throws Exception;;
	
	Integer checkTakeTask(Integer taskId, Integer userId) throws Exception;;
	
}
