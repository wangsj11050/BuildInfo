package org.tinygroup.buildinfo.service.inter;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.SysDepDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

import java.util.List;

/**
 * 部门服务接口
 * Created by Mr.wang on 2016/7/14.
 */
public interface SysDepService {
    SysDepDto getSysDep(String depCode);

    SysDepDto addSysDep(SysDepDto sysDepDto);

    int updateSysDep(SysDepDto sysDepDto);

    int deleteSysDep(String[] depCode);

    PageResponse getSysDepPager(PageRequest pageRequest, SysDepDto sysDepDto);

    List getSysDepList(SysDepDto sysDepDto);

    boolean checkSysDepExists(SysDepDto sysDepDto);
    
    List getDepTreeData(TreeDto treeDto);

	List getDepTreeByBranch(TreeDto treeDto);

	List getParentDepTreeByBranch(TreeDto treeDto);

}
