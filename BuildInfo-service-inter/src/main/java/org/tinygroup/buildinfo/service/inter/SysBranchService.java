package org.tinygroup.buildinfo.service.inter;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.SysBranchDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

import java.util.List;

/**
 * 机构服务接口
 * Created by Mr.wang on 2016/7/14.
 */
public interface SysBranchService {
    SysBranchDto getSysBranch(String branchCode);

    SysBranchDto addSysBranch(SysBranchDto sysBranchDto);

    int updateSysBranch(SysBranchDto sysBranchDto);

    int deleteSysBranch(String[] depCode);

    PageResponse getSysBranchPager(PageRequest pageRequest, SysBranchDto sysBranchDto);

    List getSysBranchList(SysBranchDto sysBranchDto);

    boolean checkSysBranchExists(SysBranchDto sysBranchDto);
    
    List getBranchTree(TreeDto treeDto);
    
//    boolean checkSubBranchExist(String[] branchCodes);
    
}
