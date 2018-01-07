package org.tinygroup.buildinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.business.inter.ServiceContentBusiness;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecontent;
import org.tinygroup.buildinfo.service.inter.ServiceContentService;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicecontentDto;

public class ServiceContentServiceImpl implements ServiceContentService {

	private ServiceContentBusiness serviceContentBusiness;
	
	
	public ServiceContentBusiness getServiceContentBusiness() {
		return serviceContentBusiness;
	}

	public void setServiceContentBusiness(ServiceContentBusiness serviceContentBusiness) {
		this.serviceContentBusiness = serviceContentBusiness;
	}

	@Override
	public BuildServicecontentDto getServiceContentByCode(String serviceCode) {
		BuildServicecontent buildServicecontent = null;
		if(serviceContentBusiness.getServiceContentByCode(serviceCode).isEmpty()){
			buildServicecontent = new BuildServicecontent();
		}else{
			buildServicecontent = serviceContentBusiness.getServiceContentByCode(serviceCode).get(0);
		}
		
		return BeanUtil.copyProperties(BuildServicecontentDto.class,buildServicecontent);
	}

	@Override
	public BuildServicecontentDto addServiceContent(BuildServicecontentDto buildServiceContentDto) {
		BuildServicecontent buildServicecontent = BeanUtil.copyProperties(BuildServicecontent.class,buildServiceContentDto);
		return BeanUtil.copyProperties(BuildServicecontentDto.class,serviceContentBusiness.addServiceContent(buildServicecontent));
	}

	@Override
	public int updateServiceContent(BuildServicecontentDto buildServiceContentDto) {
		BuildServicecontent buildServicecontent = BeanUtil.copyProperties(BuildServicecontent.class,buildServiceContentDto);
		return serviceContentBusiness.updateServiceContent(buildServicecontent);
	}

	@Override
	public int[] deleteServiceContent(String[] serviceCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BuildServicecontentDto> getServicecontentList(BuildServicecontentDto buildServicecontentDto) {
		BuildServicecontent buildServicecontent = BeanUtil.copyProperties(BuildServicecontent.class,buildServicecontentDto);
		return transFromServicecontentDto(serviceContentBusiness.getServicecontentList(buildServicecontent));
	}

	private List<BuildServicecontentDto> transFromServicecontentDto(List<BuildServicecontent> buildServicecontentList){
		List<BuildServicecontentDto> buildServicecontentDtoList = new ArrayList<BuildServicecontentDto>();
		if(buildServicecontentList != null){
			for (BuildServicecontent buildServicecontent : buildServicecontentList) {
				BuildServicecontentDto buildServicecontentDto = BeanUtil.copyProperties(BuildServicecontentDto.class,buildServicecontent);
				buildServicecontentDtoList.add(buildServicecontentDto);
			}
		}
		return buildServicecontentDtoList;
	}

	@Override
	public List<BuildServicecontentDto> getServiceContentLikeName(String serviceName) {
		return transFromServicecontentDto(serviceContentBusiness.getServiceContentLikeName(serviceName));
	}
}
