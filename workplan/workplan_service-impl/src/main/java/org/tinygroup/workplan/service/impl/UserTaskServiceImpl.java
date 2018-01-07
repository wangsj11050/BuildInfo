package org.tinygroup.workplan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.common.dict.DictUtil;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.workplan.business.inter.UserTaskBusiness;
import org.tinygroup.workplan.dao.inter.pojo.TUserTask;
import org.tinygroup.workplan.dto.UserDemandChartDto;
import org.tinygroup.workplan.dto.UserTaskDto;
import org.tinygroup.workplan.service.inter.UserTaskService;

public class UserTaskServiceImpl implements UserTaskService {

	private UserTaskBusiness userTaskBusiness;
	
	private DictUtil dictUtil;
	
	public UserTaskBusiness getUserTaskBusiness() {
		return userTaskBusiness;
	}

	public void setUserTaskBusiness(UserTaskBusiness userTaskBusiness) {
		this.userTaskBusiness = userTaskBusiness;
	}

	public DictUtil getDictUtil() {
		return dictUtil;
	}

	public void setDictUtil(DictUtil dictUtil) {
		this.dictUtil = dictUtil;
	}

	@Override
	public UserTaskDto getUserTaskByKey(Integer id) {
		// TODO Auto-generated method stub
		return BeanUtil.copyProperties(UserTaskDto.class, userTaskBusiness.getUserTaskByKey(id));
	}

	@Override
	public UserTaskDto addUserTask(UserTaskDto userTaskDto) {
		TUserTask tuserTask = BeanUtil.copyProperties(TUserTask.class, userTaskDto);
		return BeanUtil.getCopiedPropertiesBean(UserTaskDto.class, userTaskBusiness.addUserTask(tuserTask));
	}

	@Override
	public int updateUserTask(UserTaskDto userTaskDto) {
		TUserTask tuserTask = BeanUtil.copyProperties(TUserTask.class, userTaskDto);
		return userTaskBusiness.updateUserTask(tuserTask);
	}

	@Override
	public List<UserDemandChartDto> getUserDemandChart(UserTaskDto userTaskDto, String order, String orderType) {
		TUserTask tuserTask = BeanUtil.copyProperties(TUserTask.class, userTaskDto);
		List<TUserTask> userTaskList = userTaskBusiness.getUserTaskList(tuserTask, order, orderType);
		return transFromUserTask(userTaskList);
	}

	/**
	 * 根据查询结果将其转换为UserDemandChartDto提供数据图展示数据
	 * @param userTaskList
	 * @return
	 */
	private List<UserDemandChartDto> transFromUserTask(List<TUserTask> userTaskList){
		List<UserDemandChartDto> userDemandChartList = new ArrayList<UserDemandChartDto>();
		if(userTaskList != null){
			for (TUserTask userTask : userTaskList) {
				UserDemandChartDto userDemandChart = new UserDemandChartDto();
				userDemandChart.setY(userTask.getTaskNum());
				userDemandChart.setId(userTask.getTaskType().toString());
				userDemandChart.setName(dictUtil.getDictItemText("WO_TASK_TYPE", userTask.getTaskType().toString()));
				userDemandChartList.add(userDemandChart);
			}
		}
		return userDemandChartList;
	}
}
