package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.*;

public interface CourseDAO {

	public List<Course> listCourse();
	
	public List<Course> listUsersCourse(Integer userId);
	
	public Course findById( Integer id, boolean lock) throws Exception;
	
	public void addCourse(Course course);
	
	public void updateCourse(Course course);
	
	public void deleteCourse(Integer id);
		
}
