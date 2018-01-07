package org.tinygroup.buildinfo.service.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDep;
import org.tinygroup.buildinfo.service.inter.SysDepService;
import org.tinygroup.buildinfo.service.inter.dto.SysDepDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysDepBusiness;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/14.
 */
public class SysDepServiceImpl implements SysDepService{
    private SysDepBusiness sysDepBusiness;

    public SysDepBusiness getSysDepBusiness() {
        return sysDepBusiness;
    }

    public void setSysDepBusiness(SysDepBusiness sysDepBusiness) {
        this.sysDepBusiness = sysDepBusiness;
    }

    public SysDepDto getSysDep(String depCode) {
        return BeanUtil.copyProperties(SysDepDto.class,sysDepBusiness.getById(depCode));
    }

    public SysDepDto addSysDep(SysDepDto sysDepDto) {
        TsysDep tsysdep = BeanUtil.copyProperties(TsysDep.class,sysDepDto);
        return BeanUtil.copyProperties(SysDepDto.class,sysDepBusiness.add(tsysdep));
    }

    public int updateSysDep(SysDepDto sysDepDto) {
        TsysDep tsysdep = BeanUtil.copyProperties(TsysDep.class,sysDepDto);
        return sysDepBusiness.update(tsysdep);
    }

    public int deleteSysDep(String[] depCode) {
        return sysDepBusiness.deleteByKeys(depCode);
    }

    public PageResponse getSysDepPager(PageRequest pageRequest, SysDepDto sysDepDto) {
        TsysDep tsysdep = BeanUtil.copyProperties(TsysDep.class,sysDepDto);
        Pager<TsysDep> tsysDepPager = sysDepBusiness
                .getPager(pageRequest.getStart(),pageRequest.getPageSize(),tsysdep);
        return PageResponseAdapter.transform(tsysDepPager);
    }

    public List getSysDepList(SysDepDto sysDepDto) {
    	if(sysDepDto == null){
    		sysDepDto = new SysDepDto();
    	}
        TsysDep tsysdep = BeanUtil.copyProperties(TsysDep.class,sysDepDto);
        return sysDepBusiness.getList(tsysdep);
    }

    public boolean checkSysDepExists(SysDepDto sysDepDto) {
        TsysDep tsysdep = BeanUtil.copyProperties(TsysDep.class,sysDepDto);
        return sysDepBusiness.checkExists(tsysdep);
    }

	public List getDepTreeData(TreeDto treeDto) {
		TreeData tree = BeanUtil.copyProperties(TreeData.class, treeDto);
		return sysDepBusiness.getTreeData(tree);
	}

	public List getDepTreeByBranch(TreeDto treeDto) {
		TreeData tree = BeanUtil.copyProperties(TreeData.class, treeDto);
		return sysDepBusiness.getDepTreeByBranch(tree);
	}
	public List getParentDepTreeByBranch(TreeDto treeDto) {
		String id = treeDto.getId();
		treeDto.setId(null);
		TreeData tree = BeanUtil.copyProperties(TreeData.class, treeDto);
		List<TreeData> depTreeList = sysDepBusiness.getDepTreeByBranch(tree);
		//为当前节点设置disableClick、disableSub
    	for (TreeData depTree : depTreeList){
			if(depTree.getId().equals(id)){
				depTree.setDisableClick("true");
				depTree.setDisableSub("true");
				break;
			}
    	}
		return depTreeList;
	}
}
