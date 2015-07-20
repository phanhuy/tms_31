package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.User;

public interface UserDAO {
	public User findById(Integer id) throws Exception;
	public User findByName(String name) throws Exception;
	public User findByEmail(String email) throws Exception;
}