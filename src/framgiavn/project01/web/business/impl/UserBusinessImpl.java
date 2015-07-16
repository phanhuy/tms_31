package framgiavn.project01.web.business.impl;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.UserDAO;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Helpers;
import org.hibernate.LockMode;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class UserBusinessImpl  implements UserBusiness  {

	private UserDAO userDAO;

	private Map session;
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	public User findById(Integer id) throws Exception {
		try {
			return getUserDAO().findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
	public User findByName(String name) throws Exception {
		try {
			return getUserDAO().findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public User findByEmail(String email) throws Exception {
		try {
			return getUserDAO().findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	public User login(String email, String pass) throws Exception {
		if (pass.equals("") || email.equals("")) {			
			return null;									
		}						
		//getSession().lock("User", LockMode.UPGRADE);	
		
		User user = getUserDAO().findByEmail(email);
		if (user != null && user.getPassword().equals(Helpers.encryptMd5(pass))) {										
			return user;
		}
		return null;
	}
}