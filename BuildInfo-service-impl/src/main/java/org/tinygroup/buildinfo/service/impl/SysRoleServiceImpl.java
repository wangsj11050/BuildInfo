package org.tinygroup.buildinfo.service.impl;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysRole;
import org.tinygroup.buildinfo.dao.inter.pojo.complex.TRightRef;
import org.tinygroup.buildinfo.service.inter.SysRoleService;
import org.tinygroup.buildinfo.service.inter.dto.SysRoleDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.TRightRefDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysRoleBusiness;
import org.tinygroup.buildinfo.business.inter.SysRoleRightBusiness;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/7/7.
 */
public class SysRoleServiceImpl implements SysRoleService{
    private SysRoleBusiness sysRoleBusiness;

    private SysRoleRightBusiness sysRoleRightBusiness;

    public SysRoleRightBusiness getSysRoleRightBusiness() {
        return sysRoleRightBusiness;
    }

    public void setSysRoleRightBusiness(SysRoleRightBusiness sysRoleRightBusiness) {
        this.sysRoleRightBusiness = sysRoleRightBusiness;
    }

    public SysRoleBusiness getSysRoleBusiness() {
		return sysRoleBusiness;
	}

	public void setSysRoleBusiness(SysRoleBusiness sysRoleBusiness) {
		this.sysRoleBusiness = sysRoleBusiness;
	}

	public SysRoleDto getRole(Integer roleId) {
		TsysRole role = sysRoleBusiness.getById(roleId);
		SysRoleDto roleDto = new SysRoleDto();
        BeanUtil.copyProperties(roleDto,role);
        return roleDto;
    }

    public SysRoleDto addRole(SysRoleDto roleDto) {
        TsysRole role = BeanUtil.copyProperties(TsysRole.class,roleDto);
        return BeanUtil.copyProperties(SysRoleDto.class,sysRoleBusiness.add(role));
    }

    public int updateRole(SysRoleDto roleDto) {
        TsysRole role = BeanUtil.copyProperties(TsysRole.class,roleDto);
        return sysRoleBusiness.update(role);
    }

    public void deleteRoles(Integer[] ids) {
        sysRoleBusiness.deleteByKeys(ids);
    }

    public PageResponse getRolePager(PageRequest pageRequest, SysRoleDto roleDto) {
        TsysRole role = BeanUtil.copyProperties(TsysRole.class,roleDto);
        Pager<TsysRole> rolePager = sysRoleBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),role);
        return PageResponseAdapter.transform(rolePager);
    }

    public List getRoleList(SysRoleDto sysRoleDto) {
        TsysRole tsysRole = BeanUtil.copyProperties(TsysRole.class,sysRoleDto);
        return sysRoleBusiness.getList(tsysRole);
    }

    public boolean checkRoleExists(SysRoleDto roleDto) {
        TsysRole role = BeanUtil.copyProperties(TsysRole.class,roleDto);
        return sysRoleBusiness.checkExists(role);
    }

    public PageResponse queryRightsInRole(PageRequest pageRequest, Integer roleId, TRightRefDto tRightRefDto, Boolean isAssigned) {
        TRightRef tRightRef = BeanUtil.copyProperties(TRightRef.class,tRightRefDto);
        Pager pager =  sysRoleRightBusiness.queryRightsInRole(pageRequest.getStart(),pageRequest.getPageSize(),
                roleId,tRightRef,isAssigned);
        return PageResponseAdapter.transform(pager);
    }

    public boolean grantRoleRights(Integer roleId,Integer[] menuIds, String createBy) {
        sysRoleRightBusiness.grantRights(roleId,menuIds,createBy);
        return true;
    }

    public boolean revokeRoleRights(Integer roleId,Integer[] roleRightIds) {
        return sysRoleRightBusiness.revokeRights(roleId,roleRightIds);
    }


}
