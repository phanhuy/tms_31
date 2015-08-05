package framgiavn.project01.web.action;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import framgiavn.project01.web.business.*;
import framgiavn.project01.web.model.*;

public class CourseAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CourseBusiness courseBusiness;
	SubjectBusiness subjectBusiness;
	TakeCourseBusiness takeCourseBusiness; 
	
	Course course;

	Subject subject;
	SubjectCourse subjectCourse;
	private Map<String, Object> session;
	public List<Course> courseList = new ArrayList<Course>();
	public List<Subject> subjectList = new ArrayList<Subject>();
	public List<Subject> subjectCourseList = new ArrayList<Subject>();
	public List<Subject> notSubjectCourseList = new ArrayList<Subject>();
	
	public void setSubjectBusiness(SubjectBusiness subjectBusiness) {
		this.subjectBusiness = subjectBusiness;
	}
	public void setTakeCourseBusiness(TakeCourseBusiness takeCourseBusiness) {
		this.takeCourseBusiness = takeCourseBusiness;
	}
	public List<Subject> getSubjectCourseList() {
		return subjectCourseList;
	}
	public void setSubjectCourseList(List<Subject> subjectCourseList) {
		this.subjectCourseList = subjectCourseList;
	}
	public List<Subject> getNotSubjectCourseList() {
		return notSubjectCourseList;
	}
	public void setNotSubjectCourseList(List<Subject> notSubjectCourseList) {
		this.notSubjectCourseList = notSubjectCourseList;
	}
	public SubjectCourse getSubjectCourse() {
		return subjectCourse;
	}
	public void setSubjectCourse(SubjectCourse subjectCourse) {
		this.subjectCourse = subjectCourse;
	}
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	public void setCourseBusiness(CourseBusiness courseBusiness) {
		this.courseBusiness = courseBusiness;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	

	public String listAllCourse() {						
		
		courseList = courseBusiness.listCourse(takeCourseBusiness);		
		return SUCCESS;
	}
	
	public String showCourse() {
		try {
			course = courseBusiness.findById(course.getId());			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String newCourse() throws Exception {
		course.setStartDate(new Date());
		courseBusiness.addCourse(course);
		courseList = null;
		courseList = courseBusiness.listCourse(takeCourseBusiness);
		
		return SUCCESS;
	}
	
	public String updateCourse() throws Exception {
		courseBusiness.updateCourse(course);
		courseList = null;
		courseList = courseBusiness.listCourse(takeCourseBusiness);
		
		return SUCCESS;
	}
	
	public String destroyCourse() {
		courseBusiness.deleteCourse(course.getId());
		courseList = null;
		courseList = courseBusiness.listCourse(takeCourseBusiness);
		
		return SUCCESS;
	}
	
	public String newCoursePage() {
		subjectList = subjectBusiness.listSubject();
		
		return SUCCESS;
	}
	
	public String editCoursePage() {
		try {
			course = courseBusiness.findById(course.getId());
			subjectCourseList = subjectBusiness.listSubjectByCoureId(course.getId());
			notSubjectCourseList = subjectBusiness.listSubjectByNotCourseId(course.getId()); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	
	public String addSubjectCourse() {
		courseBusiness.addSubjectCourse(subjectCourse);
		
		return SUCCESS;
	}
	
	public String removeSubjectCourse() {
		courseBusiness.removeSubjectCourse(subjectCourse.getSubject_id(), subjectCourse.getCourse_id());
		
		return SUCCESS;
	}
}
