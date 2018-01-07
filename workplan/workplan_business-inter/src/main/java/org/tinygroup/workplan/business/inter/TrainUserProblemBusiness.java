package org.tinygroup.workplan.business.inter;

import java.util.List;

import org.tinygroup.workplan.dao.inter.pojo.TTrainUserProblem;

public interface TrainUserProblemBusiness {

	TTrainUserProblem getTrainUserProblemByKey(Integer id);
	
	TTrainUserProblem addTrainUserProblem(TTrainUserProblem trainUserProblem);
	
	int updateTrainUserProblem(TTrainUserProblem trainUserProblem);
	
	List<TTrainUserProblem> getTrainUserProblemList(TTrainUserProblem trainUserProblem);
	
	List<TTrainUserProblem> getFinishTrainUserProblemList(TTrainUserProblem trainUserProblem);
}
