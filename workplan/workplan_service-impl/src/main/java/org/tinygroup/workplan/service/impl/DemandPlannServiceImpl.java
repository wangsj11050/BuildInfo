package org.tinygroup.workplan.service.impl;

import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.tinysqldsl.Pager;
import org.tinygroup.workplan.business.inter.DemandPlannBusiness;
import org.tinygroup.workplan.dao.inter.pojo.TDemandPlann;
import org.tinygroup.workplan.dto.DemandPlannDto;
import org.tinygroup.workplan.service.inter.DemandPlannService;

public class DemandPlannServiceImpl implements DemandPlannService {

	private DemandPlannBusiness demandPlannBusiness;
	
	public DemandPlannBusiness getDemandPlannBusiness() {
		return demandPlannBusiness;
	}

	public void setDemandPlannBusiness(DemandPlannBusiness demandPlannBusiness) {
		this.demandPlannBusiness = demandPlannBusiness;
	}

	@Override
	public DemandPlannDto getDemandPlannById(Integer id) {
		return BeanUtil.copyProperties(DemandPlannDto.class,demandPlannBusiness.getDemandPlannById(id));
	}

	@Override
	public DemandPlannDto addDemandPlann(DemandPlannDto demandPlannDto) {
		TDemandPlann tdemandPlann = BeanUtil.copyProperties(TDemandPlann.class,demandPlannDto);
		return BeanUtil.getCopiedPropertiesBean(DemandPlannDto.class,demandPlannBusiness.addDemandPlann(tdemandPlann));
	}

	@Override
	public int updateDemandPlann(DemandPlannDto demandPlannDto) {
		TDemandPlann tdemandPlann = BeanUtil.copyProperties(TDemandPlann.class,demandPlannDto);
		return demandPlannBusiness.updateDemandPlann(tdemandPlann);
	}

	@Override
	public int deleteDemandPlann(Integer[] ids) {
		return demandPlannBusiness.deleteDemandPlann(ids);
	}

	@Override
	public PageResponse getDemandPlannPager(PageRequest pageRequest, DemandPlannDto demandPlannDto) {
		TDemandPlann tdemandPlann = BeanUtil.copyProperties(TDemandPlann.class,demandPlannDto);
		Pager pager = demandPlannBusiness.getDemandPlannPager(pageRequest.getStart(), pageRequest.getPageSize(), tdemandPlann);
		return PageResponseAdapter.transform(pager);
	}

	@Override
	public boolean CheckDemandPlannExists(DemandPlannDto demandPlannDto) {
		TDemandPlann tdemandPlann = BeanUtil.copyProperties(TDemandPlann.class,demandPlannDto);
		return demandPlannBusiness.CheckDemandPlannExists(tdemandPlann);
	}

}
