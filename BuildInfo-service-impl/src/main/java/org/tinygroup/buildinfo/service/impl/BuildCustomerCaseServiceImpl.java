package org.tinygroup.buildinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.BuildCustomerCaseBusiness;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildCustomercase;
import org.tinygroup.buildinfo.service.inter.BuildCustomerCaseService;
import org.tinygroup.buildinfo.service.inter.dto.BuildCustomercaseDto;
import org.tinygroup.tinysqldsl.Pager;

public class BuildCustomerCaseServiceImpl implements BuildCustomerCaseService {

	private BuildCustomerCaseBusiness buildCustomerCaseBusiness;
	
	public BuildCustomerCaseBusiness getBuildCustomerCaseBusiness() {
		return buildCustomerCaseBusiness;
	}

	public void setBuildCustomerCaseBusiness(BuildCustomerCaseBusiness buildCustomerCaseBusiness) {
		this.buildCustomerCaseBusiness = buildCustomerCaseBusiness;
	}

	@Override
	public BuildCustomercaseDto getCustomerCaseById(Integer id) {
		return BeanUtil.copyProperties(BuildCustomercaseDto.class,buildCustomerCaseBusiness.getCustomerCaseById(id));
	}

	@Override
	public BuildCustomercaseDto addCustomerCase(BuildCustomercaseDto buildCustomercaseDto) {
		BuildCustomercase buildCustomercase = BeanUtil.copyProperties(BuildCustomercase.class,buildCustomercaseDto);
		return BeanUtil.copyProperties(BuildCustomercaseDto.class,buildCustomerCaseBusiness.addCustomerCase(buildCustomercase));
	}

	@Override
	public int updateCustomerCase(BuildCustomercaseDto buildCustomercaseDto) {
		BuildCustomercase buildCustomercase = BeanUtil.copyProperties(BuildCustomercase.class,buildCustomercaseDto);
		return buildCustomerCaseBusiness.updateCustomerCase(buildCustomercase);
	}

	@Override
	public int deleteCustomerCase(Integer[] ids) {
		// TODO Auto-generated method stub
		return buildCustomerCaseBusiness.deleteCustomerCase(ids);
	}

	@Override
	public List<BuildCustomercaseDto> getCustomerCaseList(BuildCustomercaseDto buildCustomercaseDto) {
		BuildCustomercase buildCustomercase = BeanUtil.copyProperties(BuildCustomercase.class,buildCustomercaseDto);
		return transFromCustomercaseDto(buildCustomerCaseBusiness.getCustomerCaseList(buildCustomercase));
	}
	
	
	private List<BuildCustomercaseDto> transFromCustomercaseDto(List<BuildCustomercase> buildCustomercaseList){
		List<BuildCustomercaseDto> buildCustomercaseDtoList = new ArrayList<BuildCustomercaseDto>();
		if(buildCustomercaseList != null){
			for (BuildCustomercase buildCustomercase : buildCustomercaseList) {
				BuildCustomercaseDto buildCustomercaseDto = BeanUtil.copyProperties(BuildCustomercaseDto.class,buildCustomercase);
				buildCustomercaseDtoList.add(buildCustomercaseDto);
			}
		}
		return buildCustomercaseDtoList;
	}

	@Override
	public PageResponse getCustomerCasePager(PageRequest pageRequest, BuildCustomercaseDto buildCustomercaseDto) {
		BuildCustomercase buildCustomercase = BeanUtil.copyProperties(BuildCustomercase.class,buildCustomercaseDto);
        Pager<BuildCustomercase> buildCustomercasePager = buildCustomerCaseBusiness
                .getPager(pageRequest.getStart(),pageRequest.getPageSize(),buildCustomercase);
        return PageResponseAdapter.transform(buildCustomercasePager);
	}

}
