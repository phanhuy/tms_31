package framgiavn.project01.web.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Set;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.*;
import framgiavn.project01.web.model.Subject;
import framgiavn.project01.web.model.Task;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.*;
import framgiavn.project01.web.model.Subject;
import framgiavn.project01.web.model.TakeTask;
import framgiavn.project01.web.model.Task;
import framgiavn.project01.web.model.User;


public class SubjectAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SubjectBusiness subjectBusiness;
	TaskBusiness taskBusiness;
	Subject subject;

	TakeTask takeTask;
	private Map<String, Object> session;
	
	
	public TakeTask getTakeTask() {
		return takeTask;
	}

	public void setTakeTask(TakeTask takeTask) {
		this.takeTask = takeTask;
	}


	public void setTaskBusiness(TaskBusiness taskBusiness) {
		this.taskBusiness = taskBusiness;
	}

	public List<Subject> subjectList = new ArrayList<Subject>();

	public void setSubjectBusiness(SubjectBusiness subjectBusiness) {
		this.subjectBusiness = subjectBusiness;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	public String listAllSubject() {
		subjectList = subjectBusiness.listSubject();

		return SUCCESS;
	}

	public String showSubject() {						
		try {			
			subject = subjectBusiness.findById(subject.getId());						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String newSubject() {
		subjectBusiness.addSubject(subject);

		for (int i = 0; i < subject.getListTaskName().size(); i++) {
			Task task = new Task();
			task.setName(subject.getListTaskName().get(i));
			task.setDetail(subject.getListTaskDetail().get(i));
			task.setSubjects(subject);

			if (!task.getName().equals(""))
				taskBusiness.addTask(task);
		}

		subjectList = null;
		subjectList = subjectBusiness.listSubject();

		return SUCCESS;
	}

	public String updateSubject() throws Exception {		
		subjectBusiness.updateSubject(subject);				
		List<Integer> listTaskBeRemove = new ArrayList<Integer>();		
		
		for(Task t:taskBusiness.listTasks()){
			if(t.getSubjects().getId().equals(subject.getId()))
				listTaskBeRemove.add(t.getId());
		}			
		
		for(int i=0;i<subject.getListTaskName().size();i++){
			Task task = new Task();
			task.setName(subject.getListTaskName().get(i));
			task.setDetail(subject.getListTaskDetail().get(i));
			task.setSubjects(subject);
			
			if(!task.getName().equals("")){								
				if(subject.getListTaskID().get(i)!=null){
					task.setId(subject.getListTaskID().get(i));
					taskBusiness.updateTask(task);
					listTaskBeRemove.remove(task.getId());					
				}					
				else
					taskBusiness.addTask(task);				
			}
		}
		
		for(Integer taskIdBeRemove : listTaskBeRemove){
			taskBusiness.deleteTask(taskIdBeRemove);
		}
		
		subject = subjectBusiness.findById(subject.getId());
		return SUCCESS;
	}

	public String destroySubject() {
		try {
			subjectBusiness.deleteSubject(subject.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		subjectList = null;
		subjectList = subjectBusiness.listSubject();

		return SUCCESS;
	}

	public String editSubjectPage() {
		try {
			subject = subjectBusiness.findById(subject.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	
	public  String takeTask() throws Exception{
		takeTask.setCreateAt(new Date());		
		subjectBusiness.addUserTakeTask(takeTask);
		return SUCCESS;
	}
	
	public  String updateTask() throws Exception{
		subjectBusiness.updateUserTakeTask(takeTask);		
		return SUCCESS;
	}

}