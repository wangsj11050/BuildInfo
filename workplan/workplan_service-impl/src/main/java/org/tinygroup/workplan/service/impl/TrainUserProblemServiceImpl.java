package org.tinygroup.workplan.service.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.workplan.business.inter.TrainUserProblemBusiness;
import org.tinygroup.workplan.dao.inter.pojo.TTrainUserProblem;
import org.tinygroup.workplan.dto.TrainUserProblemDto;
import org.tinygroup.workplan.service.inter.TrainUserProblemService;

public class TrainUserProblemServiceImpl implements TrainUserProblemService {

	private TrainUserProblemBusiness trainUserProblemBusiness;
	
	
	public TrainUserProblemBusiness getTrainUserProblemBusiness() {
		return trainUserProblemBusiness;
	}

	public void setTrainUserProblemBusiness(TrainUserProblemBusiness trainUserProblemBusiness) {
		this.trainUserProblemBusiness = trainUserProblemBusiness;
	}

	@Override
	public TrainUserProblemDto getTrainUserProblemByKey(Integer id) {
		// TODO Auto-generated method stub
		return BeanUtil.copyProperties(TrainUserProblemDto.class, trainUserProblemBusiness.getTrainUserProblemByKey(id));
	}

	@Override
	public TrainUserProblemDto addTrainUserProblem(TrainUserProblemDto trainUserProblemDto) {
		// TODO Auto-generated method stub
		TTrainUserProblem trainUserProblem = BeanUtil.copyProperties(TTrainUserProblem.class, trainUserProblemDto);
		return BeanUtil.getCopiedPropertiesBean(TrainUserProblemDto.class, trainUserProblemBusiness.addTrainUserProblem(trainUserProblem));
	}

	@Override
	public int updateTrainUserProblem(TrainUserProblemDto trainUserProblemDto) {
		TTrainUserProblem trainUserProblem = BeanUtil.copyProperties(TTrainUserProblem.class, trainUserProblemDto);
		return trainUserProblemBusiness.updateTrainUserProblem(trainUserProblem);
	}

	@Override
	public int getUserTrainUserProblemCount(TrainUserProblemDto trainUserProblemDto) {
		TTrainUserProblem trainUserProblem = BeanUtil.copyProperties(TTrainUserProblem.class, trainUserProblemDto);
		List<TTrainUserProblem> trainUserProblemList = trainUserProblemBusiness.getTrainUserProblemList(trainUserProblem);
		return trainUserProblemList == null ? 0 : trainUserProblemList.size();
	}

	@Override
	public int getFinishUserTrainUserProblemCount(TrainUserProblemDto trainUserProblemDto) {
		TTrainUserProblem trainUserProblem = BeanUtil.copyProperties(TTrainUserProblem.class, trainUserProblemDto);
		List<TTrainUserProblem> finishTrainUserProblemList = trainUserProblemBusiness.getFinishTrainUserProblemList(trainUserProblem);
		return finishTrainUserProblemList == null ? 0 : finishTrainUserProblemList.size();
	}

}
