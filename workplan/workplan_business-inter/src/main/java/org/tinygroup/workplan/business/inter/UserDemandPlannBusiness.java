package org.tinygroup.workplan.business.inter;

import java.util.List;

import org.tinygroup.workplan.dao.inter.pojo.TUserDemandPlann;

public interface UserDemandPlannBusiness {

	TUserDemandPlann getUserDemandPlannByKey(Integer id);
	
	TUserDemandPlann addUserDemandPlann(TUserDemandPlann userDemandPlann);
	
	int updateUserDemandPlann(TUserDemandPlann userDemandPlann);
	
	List<TUserDemandPlann> getUserDemandChart(TUserDemandPlann userDemandPlann, String order, String orderType);
	
	public List<TUserDemandPlann> getUserDemanndPlannList(TUserDemandPlann userDemandPlann);
	
	public List<TUserDemandPlann> getFinishUserDemandPlannList(TUserDemandPlann userDemandPlann);
}
