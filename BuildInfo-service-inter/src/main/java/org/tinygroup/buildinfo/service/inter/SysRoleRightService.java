package org.tinygroup.buildinfo.service.inter;


import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.SysRoleRightDto;

/**
 * 角色权限授权信息 service-dao
 * @author Mr.wang10692
 * @date 2016/07/14
 */
public interface SysRoleRightService {
	/**
	 * 根据 id 获取用户权限授权信息
	 * @param id 
	 * @return
	 */
	SysRoleRightDto getSysRoleRight(Integer id);

	/**
	 * 新增角色权限授权信息
	 * @param sysRoleRightDto
	 * @return
     */
	SysRoleRightDto addSysRoleRight(SysRoleRightDto sysRoleRightDto);

	/**
	 * 更新角色权限授权信息
	 * @param sysRoleRightDto
	 * @return
     */
	int updateSysRoleRight(SysRoleRightDto sysRoleRightDto);

	/**
	 * 删除角色权限授权信息
	 * @param ids
     */
	void deleteSysRoleRight(Integer[] ids);

	/**
	 * 获取 角色权限授权 分页信息
	 * @param pageRequest
	 * @param sysRoleRightDto
     * @return
     */
	PageResponse getSysRoleRightPager(PageRequest pageRequest, SysRoleRightDto sysRoleRightDto);

	/**
	 * 检查[角色权限授权信息]是否存在
	 * @param sysRoleRightDto
	 * @return
     */
	boolean checkSysRoleRightExists(SysRoleRightDto sysRoleRightDto);
	
}
