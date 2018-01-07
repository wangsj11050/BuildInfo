package org.tinygroup.buildinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.BuildAdisverBusiness;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildAdisver;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildCustomercase;
import org.tinygroup.buildinfo.service.inter.BuildAdisverService;
import org.tinygroup.buildinfo.service.inter.dto.BuildAdisverDto;
import org.tinygroup.buildinfo.service.inter.dto.BuildCustomercaseDto;
import org.tinygroup.tinysqldsl.Pager;

public class BuildAdisverServiceImpl implements BuildAdisverService {

	private BuildAdisverBusiness buildAdisverBusiness;
	
	public BuildAdisverBusiness getBuildAdisverBusiness() {
		return buildAdisverBusiness;
	}

	public void setBuildAdisverBusiness(BuildAdisverBusiness buildAdisverBusiness) {
		this.buildAdisverBusiness = buildAdisverBusiness;
	}

	@Override
	public BuildAdisverDto getAdisverById(Integer id) {
		
		return BeanUtil.copyProperties(BuildAdisverDto.class,buildAdisverBusiness.getAdisverById(id));
	}

	@Override
	public BuildAdisverDto addAdisver(BuildAdisverDto buildAdisverDto) {
		BuildAdisver buildAdisver = BeanUtil.copyProperties(BuildAdisver.class,buildAdisverDto);
		return BeanUtil.copyProperties(BuildAdisverDto.class,buildAdisverBusiness.addAdisver(buildAdisver));
	}

	@Override
	public PageResponse getAdisverPager(PageRequest pageRequest, BuildAdisverDto buildAdisverDto) {
		BuildAdisver buildAdisver = BeanUtil.copyProperties(BuildAdisver.class,buildAdisverDto);
        Pager<BuildAdisver> buildAdisverPager = buildAdisverBusiness.getAdisverPager(pageRequest.getStart(),pageRequest.getPageSize(),buildAdisver);
        return PageResponseAdapter.transform(buildAdisverPager);
	}

	@Override
	public int updateAdisver(BuildAdisverDto buildAdisverDto) {
		BuildAdisver buildAdisver = BeanUtil.copyProperties(BuildAdisver.class,buildAdisverDto);
		return buildAdisverBusiness.updateAdisver(buildAdisver);
	}

	@Override
	public int deleteAdisver(Integer[] ids) {
		// TODO Auto-generated method stub
		return buildAdisverBusiness.deleteAdisver(ids);
	}

	@Override
	public List<BuildAdisverDto> getAdisverList(BuildAdisverDto buildAdisverDto) {
		BuildAdisver buildAdisver = BeanUtil.copyProperties(BuildAdisver.class,buildAdisverDto);
		return transFromBuildAdisverDto(buildAdisverBusiness.getAdisverList(buildAdisver));
	}

	private List<BuildAdisverDto> transFromBuildAdisverDto(List<BuildAdisver> buildAdisverList){
		List<BuildAdisverDto> buildAdisverDtoList = new ArrayList<BuildAdisverDto>();
		if(buildAdisverList != null){
			for (BuildAdisver buildAdisver : buildAdisverList) {
				BuildAdisverDto buildAdisverDto = BeanUtil.copyProperties(BuildAdisverDto.class,buildAdisver);
				buildAdisverDtoList.add(buildAdisverDto);
			}
		}
		return buildAdisverDtoList;
	}

	@Override
	public List<BuildAdisverDto> getAdisverByName(String name) {
		return transFromBuildAdisverDto(buildAdisverBusiness.getAdisverByName(name));
	}
}
