package framgiavn.project01.web.business;

import java.util.List;

import framgiavn.project01.web.model.*;

public interface TakeCourseBusiness {
	public List<TakeCourse> selectTakeCourseByUserId(Integer user_id);
}
