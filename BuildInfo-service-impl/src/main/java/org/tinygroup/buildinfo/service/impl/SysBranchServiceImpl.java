package org.tinygroup.buildinfo.service.impl;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysBranch;
import org.tinygroup.buildinfo.service.inter.SysBranchService;
import org.tinygroup.buildinfo.service.inter.dto.SysBranchDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysBranchBusiness;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/7/14.
 */
public class SysBranchServiceImpl implements SysBranchService{
    private SysBranchBusiness sysBranchBusiness;

    public SysBranchBusiness getSysBranchBusiness() {
        return sysBranchBusiness;
    }

    public void setSysBranchBusiness(SysBranchBusiness sysBranchBusiness) {
        this.sysBranchBusiness = sysBranchBusiness;
    }

    public SysBranchDto getSysBranch(String branchCode) {
        return BeanUtil.copyProperties(SysBranchDto.class,sysBranchBusiness.getById(branchCode));
    }

    public SysBranchDto addSysBranch(SysBranchDto sysBranchDto) {
        TsysBranch tsysBranch = BeanUtil.copyProperties(TsysBranch.class,sysBranchDto);
        return BeanUtil.copyProperties(SysBranchDto.class,sysBranchBusiness.add(tsysBranch));
    }

    public int updateSysBranch(SysBranchDto sysBranchDto) {
        TsysBranch tsysBranch = BeanUtil.copyProperties(TsysBranch.class,sysBranchDto);
        return sysBranchBusiness.update(tsysBranch);
    }

    public int deleteSysBranch(String[] depCode) {
        return sysBranchBusiness.deleteByKeys(depCode);
    }

    public PageResponse getSysBranchPager(PageRequest pageRequest, SysBranchDto sysBranchDto) {
        TsysBranch tsysBranch = BeanUtil.copyProperties(TsysBranch.class,sysBranchDto);
        Pager<TsysBranch> tsysBranchPager =
                sysBranchBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),tsysBranch);
        return PageResponseAdapter.transform(tsysBranchPager);
    }

    public List getSysBranchList(SysBranchDto sysBranchDto) {
    	if(sysBranchDto == null){
    		sysBranchDto = new SysBranchDto();
    	}
        TsysBranch tsysBranch = BeanUtil.copyProperties(TsysBranch.class,sysBranchDto);
        return sysBranchBusiness.getList(tsysBranch);
    }

    public boolean checkSysBranchExists(SysBranchDto sysBranchDto) {
        TsysBranch tsysBranch = BeanUtil.copyProperties(TsysBranch.class,sysBranchDto);
        return sysBranchBusiness.checkExists(tsysBranch);
    }

	public List getBranchTree(TreeDto treeDto) {
		String id = treeDto.getId();
		treeDto.setId(null);
		TreeData tree = BeanUtil.copyProperties(TreeData.class, treeDto);
		@SuppressWarnings("unchecked")
		List<TreeData> treeDataList = sysBranchBusiness.getTreeData(tree);
		//为当前节点设置disableClick、disableSub
    	for (TreeData branchTree : treeDataList){
			if(branchTree.getId().equals(id)){
				branchTree.setDisableClick("true");
				branchTree.setDisableSub("true");
				break;
			}
    	}
		return treeDataList;
	}

	/*public boolean checkSubBranchExist(String[] sysBranchDto) {
		TsysBranch sysBranch = BeanUtil.copyProperties(TsysBranch.class, sysBranchDto);
		return sysBranchBusiness.checkSubBranchExist(sysBranch);
	}*/
}
