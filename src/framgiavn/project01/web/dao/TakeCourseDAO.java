package framgiavn.project01.web.dao;

import java.util.List;

import framgiavn.project01.web.model.TakeCourse;

public interface TakeCourseDAO {

	public void addUserToSubject(TakeCourse takeCourse);
	public List<TakeCourse> selectTakeCourseByUserId(Integer user_id);
	public void removeUserFromCourse(Integer user_id, Integer course_id);
}