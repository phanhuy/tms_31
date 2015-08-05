package framgiavn.project01.web.model;

import java.io.Serializable;
import java.util.Date;

public class TakeCourse implements Serializable {

	private Integer user_id;
	private Integer course_id;
	private Integer finished;
	private Date  createAt;
	private Date updateAt;
	private User users;
	private Course courseUser;
	
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getCourse_id() {
		return course_id;
	}
	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}
	public Integer getFinished() {
		return finished;
	}
	public void setFinished(Integer finished) {
		this.finished = finished;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}
	public Course getCourseUser() {
		return courseUser;
	}
	public void setCourseUser(Course courseUser) {
		this.courseUser = courseUser;
	}
}