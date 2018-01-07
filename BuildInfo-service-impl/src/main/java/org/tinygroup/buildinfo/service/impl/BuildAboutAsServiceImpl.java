package org.tinygroup.buildinfo.service.impl;

import java.util.List;

import org.tinygroup.buildinfo.business.inter.BuildAboutAsBusiness;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildAboutas;
import org.tinygroup.buildinfo.service.inter.BuildAboutAsService;
import org.tinygroup.buildinfo.service.inter.dto.BuildAboutasDto;

public class BuildAboutAsServiceImpl implements BuildAboutAsService {

	private BuildAboutAsBusiness buildAboutAsBusiness;
	
	public BuildAboutAsBusiness getBuildAboutAsBusiness() {
		return buildAboutAsBusiness;
	}

	public void setBuildAboutAsBusiness(BuildAboutAsBusiness buildAboutAsBusiness) {
		this.buildAboutAsBusiness = buildAboutAsBusiness;
	}

	@Override
	public BuildAboutasDto getAboutAs() {
		
		List<BuildAboutas> aboutAsList = buildAboutAsBusiness.getAboutAs();
		if(aboutAsList !=  null && !aboutAsList.isEmpty()){
			return BeanUtil.copyProperties(BuildAboutasDto.class,aboutAsList.get(0));
		}
		return null;
	}

	@Override
	public BuildAboutasDto addAboutAs(BuildAboutasDto buildAboutasDto) {
		BuildAboutas buildAboutAs = BeanUtil.copyProperties(BuildAboutas.class,buildAboutasDto);
		return BeanUtil.copyProperties(BuildAboutasDto.class,buildAboutAsBusiness.addAboutAs(buildAboutAs));
	}

	@Override
	public int updateAboutAs(BuildAboutasDto buildAboutasDto) {
		BuildAboutas buildAboutAs = BeanUtil.copyProperties(BuildAboutas.class,buildAboutasDto);
		return buildAboutAsBusiness.updateAboutAs(buildAboutAs);
	}

}
