package framgiavn.project01.web.action;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.model.User;
import framgiavn.project01.web.ulti.Helpers;

public class UserAction extends ActionSupport {

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private Logit2 log = Logit2.getInstance(UserAction.class);

	private UserBusiness userBusiness = null;
	private User user = null;
	private Map session;

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String findUserById() {
		try {
			user = userBusiness.findById(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String findUserByName() {
		try {
			user = userBusiness.findByName(user.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String homePage() {
		return SUCCESS;
	}

	public String login() {
		return SUCCESS;
	}

	public String dologin() throws Exception {
		String input_email = user.getEmail();
		String input_pass = user.getPassword();
		user = userBusiness.login(input_email, input_pass);
		if (user == null) {
			session = ActionContext.getContext().getSession();
			session.put("logined", "false");
			return ERROR;
		} else {			
				session = ActionContext.getContext().getSession();
				session.put("logined", "true");
				session.put("context", new Date());
				return SUCCESS;			
		}
	}

	public String logout() {
		user = null;
		session = ActionContext.getContext().getSession();
		session.remove("logined");
		session.remove("context");
		return SUCCESS;
	}
}