package framgiavn.project01.web.business.impl;

import java.util.List;

import framgiavn.project01.web.business.TaskBusiness;
import framgiavn.project01.web.dao.TaskDAO;
import framgiavn.project01.web.model.Task;

class TaskBusinessImpl implements TaskBusiness {
	
	private TaskDAO taskDAO;	

	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	@Override
	public List<Task> listTasks() {
		return taskDAO.listTask();
	}

	@Override
	public void addTask(Task task) {
		taskDAO.addTask(task);
	}

	@Override
	public void updateTask(Task task) throws Exception {
		try {
			Task taskDB = taskDAO.findById(task.getId(), true);
			taskDB.setId(task.getId());
			taskDB.setName(task.getName());
			taskDB.setDetail(task.getDetail());
			taskDB.setSubject_id(task.getSubject_id());
			taskDAO.updateTask(taskDB);
		} catch (Exception e) {
			throw e;
		}		
	}

	@Override
	public void deleteTask(Integer id) {
		taskDAO.deleteTask(id);		
	}		
}