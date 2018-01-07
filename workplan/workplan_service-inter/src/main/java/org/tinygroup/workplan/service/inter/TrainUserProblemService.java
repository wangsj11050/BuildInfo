package org.tinygroup.workplan.service.inter;

import org.tinygroup.workplan.dto.TrainUserProblemDto;

public interface TrainUserProblemService {

	TrainUserProblemDto getTrainUserProblemByKey(Integer id);
	
	TrainUserProblemDto addTrainUserProblem(TrainUserProblemDto trainUserProblemDto);
	
	int updateTrainUserProblem(TrainUserProblemDto trainUserProblemDto);
	
	int getUserTrainUserProblemCount(TrainUserProblemDto trainUserProblemDto);
	
	int getFinishUserTrainUserProblemCount(TrainUserProblemDto trainUserProblemDto);
}
