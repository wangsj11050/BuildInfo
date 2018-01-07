package org.tinygroup.workplan.business.impl;

import java.util.List;

import org.tinygroup.workplan.business.inter.TrainUserProblemBusiness;
import org.tinygroup.workplan.dao.inter.TTrainProblemsDao;
import org.tinygroup.workplan.dao.inter.TTrainUserProblemDao;
import org.tinygroup.workplan.dao.inter.pojo.TTrainUserProblem;

public class TrainUserProblemBusinessImpl implements TrainUserProblemBusiness {

	private TTrainUserProblemDao trainUserProblemDao;
	
	public TTrainUserProblemDao getTrainUserProblemDao() {
		return trainUserProblemDao;
	}

	public void setTrainUserProblemDao(TTrainUserProblemDao trainUserProblemDao) {
		this.trainUserProblemDao = trainUserProblemDao;
	}

	@Override
	public TTrainUserProblem getTrainUserProblemByKey(Integer id) {
		// TODO Auto-generated method stub
		return trainUserProblemDao.getByKey(id);
	}

	@Override
	public TTrainUserProblem addTrainUserProblem(TTrainUserProblem trainUserProblem) {
		// TODO Auto-generated method stub
		return trainUserProblemDao.add(trainUserProblem);
	}

	@Override
	public int updateTrainUserProblem(TTrainUserProblem trainUserProblem) {
		// TODO Auto-generated method stub
		return trainUserProblemDao.edit(trainUserProblem);
	}

	@Override
	public List<TTrainUserProblem> getTrainUserProblemList(TTrainUserProblem trainUserProblem) {
		// TODO Auto-generated method stub
		return trainUserProblemDao.getTrainUserProblemList(trainUserProblem);
	}

	@Override
	public List<TTrainUserProblem> getFinishTrainUserProblemList(TTrainUserProblem trainUserProblem) {
		// TODO Auto-generated method stub
		return trainUserProblemDao.getFinishTrainUserProblemList(trainUserProblem);
	}

}
