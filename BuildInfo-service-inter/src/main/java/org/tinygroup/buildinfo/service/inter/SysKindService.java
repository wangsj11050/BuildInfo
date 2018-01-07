package org.tinygroup.buildinfo.service.inter;


import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.SysKindDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

/**
 * 系统分类信息 service-dao
 * @author Mr.wang10692
 * @date 2016/07/14
 */
public interface SysKindService {
	/**
	 * 根据 分类编号 获取系统分类信息
	 * @param kindCode 分类编号
	 * @return
	 */
	SysKindDto getSysKind(String kindCode);

	/**
	 * 新增系统分类信息
	 * @param SysKindDto
	 * @return
     */
	SysKindDto addSysKind(SysKindDto sysKidDto);

	/**
	 * 更新系统分类信息
	 * @param SysKindDto
	 * @return
     */
	int updateSysKind(SysKindDto sysKindDto);

	/**
	 * 删除系统分类信息
	 * @param ids
     */
	void deleteSysKinds(String[] ids);

	/**
	 * 获取系统分类 分页信息
	 * @param pageRequest
	 * @param SysKindDto
     * @return
     */
	PageResponse getSysKindPager(PageRequest pageRequest, SysKindDto sysKindDto);

	/**
	 * 检查[系统分类信息]是否存在
	 * @param SysKindDto
	 * @return
     */
	boolean checkSysKindExists(SysKindDto sysKindDto);
	/**
	 * 获取系统分类的树
	 * @param treeDto
	 * @return
     */
	List getKindTree(TreeDto treeDto);

	List getKindsList(SysKindDto sysKindDto);
	
}
