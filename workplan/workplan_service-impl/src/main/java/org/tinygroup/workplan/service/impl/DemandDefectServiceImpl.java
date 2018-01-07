package org.tinygroup.workplan.service.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.workplan.business.inter.DemandDefectBusiness;
import org.tinygroup.workplan.dao.inter.pojo.TDemandDefect;
import org.tinygroup.workplan.dto.DemandDefectDto;
import org.tinygroup.workplan.service.inter.DemandDefectService;

public class DemandDefectServiceImpl implements DemandDefectService {

	private DemandDefectBusiness demandDefectBusiness;
	
	public DemandDefectBusiness getDemandDefectBusiness() {
		return demandDefectBusiness;
	}

	public void setDemandDefectBusiness(DemandDefectBusiness demandDefectBusiness) {
		this.demandDefectBusiness = demandDefectBusiness;
	}

	@Override
	public DemandDefectDto getDemandDefectByKey(Integer id) {
		// TODO Auto-generated method stub
		return BeanUtil.copyProperties(DemandDefectDto.class, demandDefectBusiness.getDemandDefectByKey(id));
	}

	@Override
	public DemandDefectDto addDemandDefect(DemandDefectDto demandDefectDto) {
		TDemandDefect demandDefect = BeanUtil.copyProperties(TDemandDefect.class, demandDefectDto);
		return BeanUtil.getCopiedPropertiesBean(DemandDefectDto.class, demandDefectBusiness.addDemandDefect(demandDefect));
	}

	@Override
	public int updateDemandDefect(DemandDefectDto demandDefectDto) {
		TDemandDefect demandDefect = BeanUtil.copyProperties(TDemandDefect.class, demandDefectDto);
		return demandDefectBusiness.updateDemandDefect(demandDefect);
	}

	@Override
	public int getUserDemandDefectCount(DemandDefectDto demandDefectDto) {
		TDemandDefect demandDefect = BeanUtil.copyProperties(TDemandDefect.class, demandDefectDto);
		List<TDemandDefect> demandDefectList = demandDefectBusiness.getUserDemandDefectList(demandDefect);
		return demandDefectList == null ? 0 : demandDefectList.size();
	}

	@Override
	public int getFinishUserDemandDefectCount(DemandDefectDto demandDefectDto) {
		TDemandDefect demandDefect = BeanUtil.copyProperties(TDemandDefect.class, demandDefectDto);
		List<TDemandDefect> demandDefectList = demandDefectBusiness.getFinishUserDemandDefectList(demandDefect);
		return demandDefectList == null ? 0 : demandDefectList.size();
	}

}
