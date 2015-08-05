package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.TakeTask;

public interface TakeTaskDAO {
	public TakeTask selectById(Integer taskId, Integer userId,Boolean lock);
	public void takeTask(TakeTask takeTask);
	public void updateTask(TakeTask takeTask);
	public Integer checkTakeTask(Integer taskId, Integer userId);
}