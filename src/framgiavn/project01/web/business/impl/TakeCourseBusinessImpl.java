package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.model.*;
import framgiavn.project01.web.dao.*;

import java.util.Iterator;
import java.util.List;

import framgiavn.project01.web.business.CourseBusiness;
import framgiavn.project01.web.business.TakeCourseBusiness;

public class TakeCourseBusinessImpl implements TakeCourseBusiness {
	
	private TakeCourseDAO takeCourseDAO; 

	public TakeCourseDAO getTakeCourseDAO() {
		return takeCourseDAO;
	}

	public void setTakeCourseDAO(TakeCourseDAO takeCourseDAO) {
		this.takeCourseDAO = takeCourseDAO;
	}

	@Override
	public List<TakeCourse> selectTakeCourseByUserId(Integer user_id) {
		return takeCourseDAO.selectTakeCourseByUserId(user_id);
	}

	



}