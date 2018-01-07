package org.tinygroup.workplan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.common.dict.DictUtil;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.workplan.business.inter.UserDemandPlannBusiness;
import org.tinygroup.workplan.dao.inter.pojo.TUserDemandPlann;
import org.tinygroup.workplan.dto.UserDemandChartDto;
import org.tinygroup.workplan.dto.UserDemandPlannDto;
import org.tinygroup.workplan.service.inter.UserDemandPlannService;

public class UserDemandPlannServiceImpl implements UserDemandPlannService {

	private UserDemandPlannBusiness userDemandPlannBusiness;
	private DictUtil dictUtil;
	public UserDemandPlannBusiness getUserDemandPlannBusiness() {
		return userDemandPlannBusiness;
	}

	public void setUserDemandPlannBusiness(UserDemandPlannBusiness userDemandPlannBusiness) {
		this.userDemandPlannBusiness = userDemandPlannBusiness;
	}
	
	public DictUtil getDictUtil() {
		return dictUtil;
	}

	public void setDictUtil(DictUtil dictUtil) {
		this.dictUtil = dictUtil;
	}
	@Override
	public UserDemandPlannDto getUserDemandPlannByKey(Integer id) {
		return BeanUtil.copyProperties(UserDemandPlannDto.class,userDemandPlannBusiness.getUserDemandPlannByKey(id));
	}

	@Override
	public UserDemandPlannDto addUserDemandPlann(UserDemandPlannDto userDemandPlannDto) {
		TUserDemandPlann userDemandPlann = BeanUtil.copyProperties(TUserDemandPlann.class, userDemandPlannDto);
		return BeanUtil.getCopiedPropertiesBean(UserDemandPlannDto.class, userDemandPlannBusiness.addUserDemandPlann(userDemandPlann));
	}

	@Override
	public int updateUserDemandPlann(UserDemandPlannDto userDemandPlannDto) {
		TUserDemandPlann userDemandPlann = BeanUtil.copyProperties(TUserDemandPlann.class, userDemandPlannDto);
		return userDemandPlannBusiness.updateUserDemandPlann(userDemandPlann);
	}

	@Override
	public List<UserDemandChartDto> getUserDemandChartList(UserDemandPlannDto userDemandPlannDto, String order,
			String orderType) {
		TUserDemandPlann userDemandPlann = BeanUtil.copyProperties(TUserDemandPlann.class, userDemandPlannDto);
		List<TUserDemandPlann> userDemandPlannList = userDemandPlannBusiness.getUserDemandChart(userDemandPlann, order, orderType);
		return transFromUserDemandPlann(userDemandPlannList);
	}
	
	/**
	 * 根据查询结果将其转换为UserDemandChartDto提供数据图展示数据
	 * @param userTaskList
	 * @return
	 */
	private List<UserDemandChartDto> transFromUserDemandPlann(List<TUserDemandPlann> userDemandPlannList){
		List<UserDemandChartDto> userDemandChartList = new ArrayList<UserDemandChartDto>();
		for (TUserDemandPlann userDemandPlann : userDemandPlannList) {
			UserDemandChartDto userDemandChart = new UserDemandChartDto();
			userDemandChart.setY(userDemandPlann.getPlannNum());
			userDemandChart.setId(userDemandPlann.getPlannState().toString());
			userDemandChart.setName(dictUtil.getDictItemText("WO_PLANN_STATE", userDemandPlann.getPlannState().toString()));
			userDemandChart.setDrilldown(false);
			userDemandChartList.add(userDemandChart);
		}
		return userDemandChartList;
	}

	@Override
	public int getUserDemanndPlannCount(UserDemandPlannDto userDemandPlannDto) {
		TUserDemandPlann userDemandPlann = BeanUtil.copyProperties(TUserDemandPlann.class, userDemandPlannDto);
		List<TUserDemandPlann> userDemandPlannList = userDemandPlannBusiness.getUserDemanndPlannList(userDemandPlann);
		return userDemandPlannList.size();
	}

	@Override
	public int getFinishUserDemandPlannCount(UserDemandPlannDto userDemandPlannDto) {
		TUserDemandPlann userDemandPlann = BeanUtil.copyProperties(TUserDemandPlann.class, userDemandPlannDto);
		List<TUserDemandPlann> userDemandPlannList = userDemandPlannBusiness.getFinishUserDemandPlannList(userDemandPlann);
		return userDemandPlannList.size();
	}

}
