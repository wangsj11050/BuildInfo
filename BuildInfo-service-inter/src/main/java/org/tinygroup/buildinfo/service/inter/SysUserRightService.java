package org.tinygroup.buildinfo.service.inter;


import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.SysUserRightDto;

/**
 * 用户权限授权信息 service-dao
 * @author Mr.wang10692
 * @date 2016/07/14
 */
public interface SysUserRightService {
	/**
	 * 根据 id 获取用户权限授权信息
	 * @param id 
	 * @return
	 */
	SysUserRightDto getSysUserRight(Integer id);

	/**
	 * 新增用户权限授权信息
	 * @param sysUserRightDto
	 * @return
     */
	SysUserRightDto addSysUserRight(SysUserRightDto sysUserRightDto);

	/**
	 * 更新用户权限授权信息
	 * @param sysUserRightDto
	 * @return
     */
	int updateSysUserRight(SysUserRightDto sysUserRightDto);

	/**
	 * 删除用户权限授权信息
	 * @param ids
     */
	void deleteSysUserRight(Integer[] ids);

	/**
	 * 获取 用户权限授权 分页信息
	 * @param pageRequest
	 * @param sysUserRightDto
     * @return
     */
	PageResponse getSysUserRightPager(PageRequest pageRequest, SysUserRightDto sysUserRightDto);

	/**
	 * 检查[用户权限授权信息]是否存在
	 * @param sysUserRightDto
	 * @return
     */
	boolean checkSysUserRightExists(SysUserRightDto sysUserRightDto);
	
}
