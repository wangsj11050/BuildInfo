package org.tinygroup.buildinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.BuildServiceBusiness;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicetype;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicetypeDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;
import org.tinygroup.tinysqldsl.Pager;

public class BuildInfoServiceServiceImpl implements BuildInfoServiceService {

	private BuildServiceBusiness buildServiceBusiness;
	
	
	public BuildServiceBusiness getBuildServiceBusiness() {
		return buildServiceBusiness;
	}

	public void setBuildServiceBusiness(BuildServiceBusiness buildServiceBusiness) {
		this.buildServiceBusiness = buildServiceBusiness;
	}

	@Override
	public BuildServicetypeDto getServicetypeByCode(String serviceCode) {
		BuildServicetype buildServicetype = null;
		if(buildServiceBusiness.getServicetypeByCode(serviceCode).isEmpty()){
			buildServicetype = new BuildServicetype();
		}else{
			buildServicetype = buildServiceBusiness.getServicetypeByCode(serviceCode).get(0);
		}
		
		return BeanUtil.copyProperties(BuildServicetypeDto.class,buildServicetype);
	}

	@Override
	public BuildServicetypeDto addServicetype(BuildServicetypeDto buildServicetypeDto) {
		BuildServicetype buildServicetype = BeanUtil.copyProperties(BuildServicetype.class,buildServicetypeDto);
		return BeanUtil.copyProperties(BuildServicetypeDto.class,buildServiceBusiness.addServicetype(buildServicetype));
	}

	@Override
	public int updateServicetype(BuildServicetypeDto buildServicetypeDto) {
		BuildServicetype buildServicetype = BeanUtil.copyProperties(BuildServicetype.class,buildServicetypeDto);
		return buildServiceBusiness.updateServicetype(buildServicetype);
	}

	@Override
	public int[] deleteServicetype(String[] serviceCode) {
		List<BuildServicetype> servicetypeList = new ArrayList<BuildServicetype>();
		for(String code : serviceCode){
			BuildServicetype buildServicetype = new BuildServicetype();
			buildServicetype.setServiceCode(code);
			servicetypeList.add(buildServicetype);
		}
		return buildServiceBusiness.batchDelete(servicetypeList);
	}

	@Override
	public PageResponse getServicetypePager(PageRequest pageRequest, BuildServicetypeDto buildServicetypeDto) {
		BuildServicetype buildServicetype = BeanUtil.copyProperties(BuildServicetype.class,buildServicetypeDto);
        Pager<BuildServicetype> buildServicetypePager = buildServiceBusiness
                .getPager(pageRequest.getStart(),pageRequest.getPageSize(),buildServicetype);
        return PageResponseAdapter.transform(buildServicetypePager);
	}

	@Override
	public boolean checkServicetypeExists(BuildServicetypeDto buildServicetypeDto) {
		BuildServicetype buildServicetype = BeanUtil.copyProperties(BuildServicetype.class,buildServicetypeDto);
		buildServiceBusiness.checkServicetypeExists(buildServicetype);
		if(buildServiceBusiness.checkServicetypeExists(buildServicetype)!=null && !buildServiceBusiness.checkServicetypeExists(buildServicetype).isEmpty()){
			if(buildServiceBusiness.checkServicetypeExists(buildServicetype).get(0).getServiceCode().equals(buildServicetypeDto.getServiceCode())){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<TreeDto> getServicetypeTreeData(TreeDto treeDto) {
		TreeData treeData = BeanUtil.copyProperties(TreeData.class,treeDto);
		return transFromTreeData(buildServiceBusiness.getServicetypeTreeData(treeData));
	}

	@Override
	public List<BuildServicetypeDto> getServicetypeList(BuildServicetypeDto buildServicetypeDto) {
		BuildServicetype buildServicetype = BeanUtil.copyProperties(BuildServicetype.class,buildServicetypeDto);
		return transFromServicetypeDto(buildServiceBusiness.getServicetypeList(buildServicetype));
	}

	private List<BuildServicetypeDto> transFromServicetypeDto(List<BuildServicetype> buildServicetypeList){
		List<BuildServicetypeDto> buildServicetypeDtoList = new ArrayList<BuildServicetypeDto>();
		if(buildServicetypeList != null){
			for (BuildServicetype buildServicetype : buildServicetypeList) {
				BuildServicetypeDto buildServicetypeDto = BeanUtil.copyProperties(BuildServicetypeDto.class,buildServicetype);
				buildServicetypeDtoList.add(buildServicetypeDto);
			}
		}
		return buildServicetypeDtoList;
	}
	
	private List<TreeDto> transFromTreeData(List<TreeData> treeDataList){
		List<TreeDto> treeDtoList = new ArrayList<TreeDto>();
		if(treeDataList !=null){
			for (TreeData treeData : treeDataList) {
				TreeDto treeDto =  BeanUtil.copyProperties(TreeDto.class,treeData);
				treeDtoList.add(treeDto);
			}
		}
		return treeDtoList;
	}

	@Override
	public List<BuildServicetypeDto> getServiceTypeLikeName(String serviceName) {
		// TODO Auto-generated method stub
		return transFromServicetypeDto(buildServiceBusiness.getServiceTypeLikeName(serviceName));
	}
}
