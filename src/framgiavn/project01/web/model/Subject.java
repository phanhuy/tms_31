package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.List;


public class Subject implements Serializable {
	
	private Integer id;
	private String name;
	private String detail;
	private List<SubjectCourse> subjectCourses;

	private List<Task> tasks;
	private List<String> listTaskName;
	private List<String> listTaskDetail;
	private List<Integer> listTaskID;
	
	public List<SubjectCourse> getSubjectCourses() {
		return subjectCourses;
	}
	public void setSubjectCourses(List<SubjectCourse> subjectCourses) {
		this.subjectCourses = subjectCourses;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Subject() {

	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<String> getListTaskName() {
		return listTaskName;
	}
	public void setListTaskName(List<String> listTaskName) {
		this.listTaskName = listTaskName;
	}
	public List<String> getListTaskDetail() {
		return listTaskDetail;
	}
	public void setListTaskDetail(List<String> listTaskDetail) {
		this.listTaskDetail = listTaskDetail;
	}
	public List<Integer> getListTaskID() {
		return listTaskID;
	}
	public void setListTaskID(List<Integer> listTaskID) {
		this.listTaskID = listTaskID;
	}	
}
