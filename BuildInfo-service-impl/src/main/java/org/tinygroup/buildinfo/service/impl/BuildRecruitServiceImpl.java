package org.tinygroup.buildinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.BuildRecruitBusiness;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildRecruit;
import org.tinygroup.buildinfo.service.inter.BuildRecruitService;
import org.tinygroup.buildinfo.service.inter.dto.BuildRecruitDto;
import org.tinygroup.tinysqldsl.Pager;

public class BuildRecruitServiceImpl implements BuildRecruitService{

	private BuildRecruitBusiness buildRecruitBusiness;
	
	public BuildRecruitBusiness getBuildRecruitBusiness() {
		return buildRecruitBusiness;
	}

	public void setBuildRecruitBusiness(BuildRecruitBusiness buildRecruitBusiness) {
		this.buildRecruitBusiness = buildRecruitBusiness;
	}

	@Override
	public BuildRecruitDto getRecruitById(Integer id) {
		
		return BeanUtil.copyProperties(BuildRecruitDto.class,buildRecruitBusiness.getRecruitById(id));
	}

	@Override
	public BuildRecruitDto addRecruit(BuildRecruitDto buildRecruitDto) {
		BuildRecruit buildRecruit = BeanUtil.copyProperties(BuildRecruit.class, buildRecruitDto);
		return BeanUtil.copyProperties(BuildRecruitDto.class,buildRecruitBusiness.addRecruit(buildRecruit));
	}

	@Override
	public PageResponse getRecruitPager(PageRequest pageRequest, BuildRecruitDto buildRecruitDto) {
		BuildRecruit buildRecruit = BeanUtil.copyProperties(BuildRecruit.class,buildRecruitDto);
        Pager<BuildRecruit> buildRecruitPager = buildRecruitBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),buildRecruit);
        return PageResponseAdapter.transform(buildRecruitPager);
	}

	@Override
	public int updateRecruit(BuildRecruitDto buildRecruitDto) {
		BuildRecruit buildRecruit = BeanUtil.copyProperties(BuildRecruit.class,buildRecruitDto);
		return buildRecruitBusiness.updateRecruit(buildRecruit);
	}

	@Override
	public int deleteRecruit(Integer[] ids) {
		return buildRecruitBusiness.deleteRecruit(ids);
	}

	@Override
	public List<BuildRecruitDto> getRecruitList(BuildRecruitDto buildRecruitDto) {
		BuildRecruit buildRecruit = BeanUtil.copyProperties(BuildRecruit.class,buildRecruitDto);
		return transFormRecruits(buildRecruitBusiness.getRecruitList(buildRecruit));
	}
	
	private List<BuildRecruitDto> transFormRecruits(List<BuildRecruit> buildRecruitDtoList){
		List<BuildRecruitDto> buildRecruitList = new ArrayList<BuildRecruitDto>();
		if(buildRecruitDtoList != null){
			for (BuildRecruit buildRecruit : buildRecruitDtoList) {
				BuildRecruitDto buildRecruitDto = BeanUtil.copyProperties(BuildRecruitDto.class,buildRecruit);
				buildRecruitList.add(buildRecruitDto);
			}
		}
		return buildRecruitList;
	}

}
