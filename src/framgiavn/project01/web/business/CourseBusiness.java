package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.*;

public interface CourseBusiness {
	
	List<Course> listCourse(TakeCourseBusiness takeCourseBusiness);	
	
	List<Subject> listSubjectInCourse();
	
	Course findById(Integer id) throws Exception;

	void addCourse(Course course);
	
	void updateCourse(Course course) throws Exception;
	
	void deleteCourse(Integer id);
	
	void addSubjectCourse(SubjectCourse subjectCourse);
	
	void removeSubjectCourse(Integer subject_id, Integer course_id);
}
