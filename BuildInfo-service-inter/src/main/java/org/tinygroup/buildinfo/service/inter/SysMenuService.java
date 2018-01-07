package org.tinygroup.buildinfo.service.inter;


import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.SysMenuDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

/**
 * 菜单信息 service-dao
 * @author Mr.wang10692
 * @date 2016/07/14
 */
public interface SysMenuService {
	/**
	 * 根据 id 获取菜单信息
	 * @param id 
	 * @return
	 */
	SysMenuDto getSysMenu(Integer id);

	/**
	 * 新增菜单信息
	 * @param sysMenuDto
	 * @return
     */
	SysMenuDto addSysMenu(SysMenuDto sysMenuDto);

	/**
	 * 更新菜单信息
	 * @param sysMenuDto
	 * @return
     */
	int updateSysMenu(SysMenuDto sysMenuDto);

	/**
	 * 删除菜单信息
	 * @param ids
     */
	void deleteSysMenu(Integer[] ids);

	/**
	 * 获取 菜单 分页信息
	 * @param pageRequest
	 * @param sysMenuDto
     * @return
     */
	PageResponse getSysMenuPager(PageRequest pageRequest, SysMenuDto sysMenuDto);

	/**
	 * 检查[菜单信息]是否存在
	 * @param sysMenuDto
	 * @return
     */
	boolean checkSysMenuExists(SysMenuDto sysMenuDto);
	
	List getMenuInfos(SysMenuDto sysMenuDto);

	List getMenuTree(TreeDto treeDto);

	List getUserSubTrans(String userId);

	List getSysMenuList(SysMenuDto sysMenuDto);

	List<Integer> findMenuIdsByUser(String userCode);
	
	List<Integer> findAppMenuIds(SysMenuDto sysMenuDto);
}
