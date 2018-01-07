package org.tinygroup.buildinfo.service.inter;


import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.SysRoleDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.TRightRefDto;

import java.util.List;

public interface SysRoleService {
	SysRoleDto getRole(Integer roleId);

	/**
	 * 新增角色
	 * @param SysRoleDto
	 * @return
     */
	SysRoleDto addRole(SysRoleDto SysRoleDto);

	/**
	 * 更新角色
	 * @param sysRoleDto
	 * @return
     */
	int updateRole(SysRoleDto sysRoleDto);

	/**
	 * 删除角色
	 * @param ids
     */
	void deleteRoles(Integer[] ids);

	/**
	 * 获取分页信息
	 * @param pageRequest
	 * @param sysRoleDto
     * @return
     */
	PageResponse getRolePager(PageRequest pageRequest, SysRoleDto sysRoleDto);


	List getRoleList(SysRoleDto sysRoleDto);
	/**
	 * 检查角色是否存在
	 * @param sysRoleDto
	 * @return
     */
	boolean checkRoleExists(SysRoleDto sysRoleDto);

	PageResponse queryRightsInRole(PageRequest pageRequest, Integer roleId, TRightRefDto tRightRefDto, Boolean isAssigned);

	boolean grantRoleRights(Integer roleId,Integer[] menuIds, String createBy);

	boolean revokeRoleRights(Integer roleId,Integer[] roleRightIds);
}
