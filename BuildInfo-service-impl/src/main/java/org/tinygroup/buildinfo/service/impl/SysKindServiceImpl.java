package org.tinygroup.buildinfo.service.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysKind;
import org.tinygroup.buildinfo.service.inter.SysKindService;
import org.tinygroup.buildinfo.service.inter.dto.SysKindDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysKindBusiness;
import org.tinygroup.tinysqldsl.Pager;

/**
 * 岗位信息 service-impl
 * @author Mr.wang10692
 * @date 2016/07/14
 */
public class SysKindServiceImpl implements SysKindService{
	
	private SysKindBusiness sysKindBusiness;
	
	public SysKindBusiness getSysKindBusiness() {
		return sysKindBusiness;
	}

	public void setSysKindBusiness(SysKindBusiness sysKindBusiness) {
		this.sysKindBusiness = sysKindBusiness;
	}

	public SysKindDto getSysKind(String kindCode) {
		TsysKind SysKind = sysKindBusiness.getById(kindCode);
		SysKindDto SysKindDto = new SysKindDto();
		BeanUtil.copyProperties(SysKindDto, SysKind);
		return SysKindDto;
	}

	public SysKindDto addSysKind(SysKindDto sysKindDto) {
		TsysKind sysKind = BeanUtil.copyProperties(TsysKind.class, sysKindDto);
		return BeanUtil.copyProperties(SysKindDto.class, sysKindBusiness.add(sysKind));
	}

	public int updateSysKind(SysKindDto sysKindDto) {
		TsysKind sysKind = BeanUtil.copyProperties(TsysKind.class,sysKindDto);
        return sysKindBusiness.update(sysKind);
	}

	public void deleteSysKinds(String[] ids) {
		sysKindBusiness.deleteByKeys(ids);
	}

	public PageResponse getSysKindPager(PageRequest pageRequest,
			SysKindDto sysKindDto) {
		TsysKind SysKind = BeanUtil.copyProperties(TsysKind.class, sysKindDto);
		Pager<TsysKind> rolePager = sysKindBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),SysKind);
        return PageResponseAdapter.transform(rolePager);
	}

	public boolean checkSysKindExists(SysKindDto sysKindDto) {
		TsysKind sysKind = BeanUtil.copyProperties(TsysKind.class, sysKindDto);
		return sysKindBusiness.checkExists(sysKind);
	}

	public List getKindTree(TreeDto treeDto) {
		String id = treeDto.getId();
		treeDto.setId(null);
		TreeData tree = BeanUtil.copyProperties(TreeData.class, treeDto);
		@SuppressWarnings("unchecked")
		List<TreeData> kindTreeList = sysKindBusiness.getKindTree(tree);
		//为当前节点设置disableClick、disableSub
    	for (TreeData treeData : kindTreeList){
			if(treeData.getId().equals(id)){
				treeData.setDisableClick("true");
				treeData.setDisableSub("true");
				break;
			}
    	}
		return kindTreeList;
		
	}

	public List getKindsList(SysKindDto sysKindDto) {
		if(sysKindDto == null){
			sysKindDto = new SysKindDto();
		}
		TsysKind sysKind = BeanUtil.copyProperties(TsysKind.class, sysKindDto);
		return sysKindBusiness.getKindsList(sysKind);
	}

}
