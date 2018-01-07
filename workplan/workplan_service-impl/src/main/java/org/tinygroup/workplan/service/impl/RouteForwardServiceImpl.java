package org.tinygroup.workplan.service.impl;

import org.tinygroup.buildinfo.common.dict.DictUtil;
import org.tinygroup.workplan.service.inter.RouteForwardService;

public class RouteForwardServiceImpl implements RouteForwardService {

	private DictUtil dictUtil;
	
	public DictUtil getDictUtil() {
		return dictUtil;
	}
	public void setDictUtil(DictUtil dictUtil) {
		this.dictUtil = dictUtil;
	}
	@Override
	public String userTaskRouteForward(String taskType) {
		return dictUtil.getDictItemText("ROUTE_TASK_TYPE", taskType);
	}

}
