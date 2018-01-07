package org.tinygroup.buildinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.BuildServiceCenterBusiness;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecenter;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicetype;
import org.tinygroup.buildinfo.service.inter.BuildServiceCenterService;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicecenterDto;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicetypeDto;
import org.tinygroup.tinysqldsl.Pager;

public class BuildServiceCenterServiceImpl implements BuildServiceCenterService {

	private BuildServiceCenterBusiness buildServiceCenterBusiness;
	
	
	public BuildServiceCenterBusiness getBuildServiceCenterBusiness() {
		return buildServiceCenterBusiness;
	}

	public void setBuildServiceCenterBusiness(BuildServiceCenterBusiness buildServiceCenterBusiness) {
		this.buildServiceCenterBusiness = buildServiceCenterBusiness;
	}

	@Override
	public BuildServicecenterDto getServicecenterByCode(String servicecenterCode) {
		BuildServicecenter  buildServicecenter = null;
		if(buildServiceCenterBusiness.getServicecenterByCode(servicecenterCode).isEmpty()){
			buildServicecenter = new BuildServicecenter();
		}else{
			buildServicecenter = buildServiceCenterBusiness.getServicecenterByCode(servicecenterCode).get(0);
		}
		
		return BeanUtil.copyProperties(BuildServicecenterDto.class,buildServicecenter);
	}

	@Override
	public BuildServicecenterDto addServicecenter(BuildServicecenterDto buildServicecenterDto) {
		BuildServicecenter  buildServicecenter = BeanUtil.copyProperties(BuildServicecenter.class,buildServicecenterDto);
		return BeanUtil.copyProperties(BuildServicecenterDto.class,buildServiceCenterBusiness.addServicecenter(buildServicecenter));
	}

	@Override
	public int updateServicecenter(BuildServicecenterDto buildServicecenterDto) {
		BuildServicecenter  buildServicecenter = BeanUtil.copyProperties(BuildServicecenter.class,buildServicecenterDto);
		return buildServiceCenterBusiness.updateServicecenter(buildServicecenter);
	}

	@Override
	public int[] deleteServicecenter(String[] serviceCode) {
		List<BuildServicecenter> servicecenterList = new ArrayList<BuildServicecenter>();
		for(String code : serviceCode){
			BuildServicecenter buildServicecenter = new BuildServicecenter();
			buildServicecenter.setServicecenterCode(code);
			servicecenterList.add(buildServicecenter);
		}
		return buildServiceCenterBusiness.batchDelete(servicecenterList);
	}

	@Override
	public PageResponse getServicecenterPager(PageRequest pageRequest, BuildServicecenterDto buildServicecenterDto) {
		BuildServicecenter  buildServicecenter = BeanUtil.copyProperties(BuildServicecenter.class,buildServicecenterDto);
        Pager<BuildServicecenter> buildServicecenterPager = buildServiceCenterBusiness
                .getPager(pageRequest.getStart(),pageRequest.getPageSize(),buildServicecenter);
        return PageResponseAdapter.transform(buildServicecenterPager);
	}

	@Override
	public boolean checkServicecneterExists(BuildServicecenterDto buildServicecenterDto) {
		BuildServicecenter  buildServicecenter = BeanUtil.copyProperties(BuildServicecenter.class,buildServicecenterDto);
		buildServiceCenterBusiness.checkServicecenterExists(buildServicecenter);
		if(buildServiceCenterBusiness.checkServicecenterExists(buildServicecenter)!=null && !buildServiceCenterBusiness.checkServicecenterExists(buildServicecenter).isEmpty()){
			if(buildServiceCenterBusiness.checkServicecenterExists(buildServicecenter).get(0).getServicecenterCode().equals(buildServicecenterDto.getServicecenterCode())){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<BuildServicecenterDto> getServicecenterList(BuildServicecenterDto buildServicecenterDto) {
		BuildServicecenter  buildServicecenter = BeanUtil.copyProperties(BuildServicecenter.class,buildServicecenterDto);
		return transFromServicecenterDto(buildServiceCenterBusiness.getServicecenterList(buildServicecenter));
	}

	private List<BuildServicecenterDto> transFromServicecenterDto(List<BuildServicecenter> buildServicecenterList){
		List<BuildServicecenterDto> buildServicecenterDtoList = new ArrayList<BuildServicecenterDto>();
		if(buildServicecenterList != null){
			for (BuildServicecenter buildServicecenter : buildServicecenterList) {
				BuildServicecenterDto buildServicecenterDto = BeanUtil.copyProperties(BuildServicecenterDto.class,buildServicecenter);
				buildServicecenterDtoList.add(buildServicecenterDto);
			}
		}
		return buildServicecenterDtoList;
	}

	@Override
	public List<BuildServicecenterDto> getServicecenters(String[] codes) {
		return transFromServicecenterDto(buildServiceCenterBusiness.getServicecenters(codes));
	}
}
