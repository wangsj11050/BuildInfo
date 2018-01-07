package org.tinygroup.workplan.business.inter;

import java.util.List;

import org.tinygroup.workplan.dao.inter.pojo.TUserTask;

public interface UserTaskBusiness {

	TUserTask getUserTaskByKey(Integer id);
	
	TUserTask addUserTask(TUserTask userTask);
	
	int updateUserTask(TUserTask userTask);
	
	List<TUserTask> getUserTaskList(TUserTask userTask, String order, String ordertype);
}
