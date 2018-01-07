package org.tinygroup.buildinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.BuildPubDemandBusiness;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.common.util.NameUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildPubdemand;
import org.tinygroup.buildinfo.service.inter.BuildPubDemandService;
import org.tinygroup.buildinfo.service.inter.dto.BuildPubdemandDto;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class BuildPubDemandServiceImpl implements BuildPubDemandService {

	private BuildPubDemandBusiness buildPubDemandBusiness;
	
	public BuildPubDemandBusiness getBuildPubDemandBusiness() {
		return buildPubDemandBusiness;
	}

	public void setBuildPubDemandBusiness(BuildPubDemandBusiness buildPubDemandBusiness) {
		this.buildPubDemandBusiness = buildPubDemandBusiness;
	}

	@Override
	public BuildPubdemandDto getPubdemandById(Integer id) {
		// TODO Auto-generated method stub
		return BeanUtil.copyProperties(BuildPubdemandDto.class,buildPubDemandBusiness.getPubdemandById(id));
	}

	@Override
	public BuildPubdemandDto addPubdemand(BuildPubdemandDto buildPubdemandDto) {
		BuildPubdemand buildPubdemand = BeanUtil.copyProperties(BuildPubdemand.class,buildPubdemandDto);
		return BeanUtil.copyProperties(BuildPubdemandDto.class,buildPubDemandBusiness.addPubdemand(buildPubdemand));
	}

	@Override
	public PageResponse getPubdemandPager(PageRequest pageRequest, BuildPubdemandDto buildPubdemandDto,String sortName, boolean asc) {
		BuildPubdemand buildPubdemand = BeanUtil.copyProperties(BuildPubdemand.class,buildPubdemandDto);
		
        Pager<BuildPubdemand> buildPubdemandPager = buildPubDemandBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),buildPubdemand,new OrderBy(NameUtil.resolveNameDesc(sortName), asc));
        return PageResponseAdapter.transform(buildPubdemandPager);
	}

	@Override
	public int updatePubdemand(BuildPubdemandDto buildPubdemandDto) {
		BuildPubdemand buildPubdemand = BeanUtil.copyProperties(BuildPubdemand.class,buildPubdemandDto);
		return buildPubDemandBusiness.updatePubdemand(buildPubdemand);
	}

	@Override
	public int deletePubdemand(Integer[] ids) {
		// TODO Auto-generated method stub
		return buildPubDemandBusiness.deletePubdemand(ids);
	}

	@Override
	public List<BuildPubdemandDto> getPubdemandList(BuildPubdemandDto buildPubdemandDto) {
		BuildPubdemand buildPubdemand = BeanUtil.copyProperties(BuildPubdemand.class,buildPubdemandDto);
		return transFromPubdemandDto(buildPubDemandBusiness.getPubdemandList(buildPubdemand));
	}

	private List<BuildPubdemandDto> transFromPubdemandDto(List<BuildPubdemand> buildPubdemandList){
		List<BuildPubdemandDto> buildPubdemandDtoList = new ArrayList<BuildPubdemandDto>();
		if(buildPubdemandList != null){
			for (BuildPubdemand buildPubdemand : buildPubdemandList) {
				BuildPubdemandDto buildPubdemandDto = BeanUtil.copyProperties(BuildPubdemandDto.class,buildPubdemand);
				buildPubdemandDtoList.add(buildPubdemandDto);
			}
		}
		return buildPubdemandDtoList;
	}
}
