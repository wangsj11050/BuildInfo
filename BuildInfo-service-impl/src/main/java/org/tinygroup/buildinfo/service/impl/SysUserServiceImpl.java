package org.tinygroup.buildinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysOffice;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysOfficeUser;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysUser;
import org.tinygroup.buildinfo.dao.inter.pojo.complex.RoleUserRef;
import org.tinygroup.buildinfo.dao.inter.pojo.complex.TRightRef;
import org.tinygroup.buildinfo.service.inter.SysUserService;
import org.tinygroup.buildinfo.service.inter.dto.RoleDto;
import org.tinygroup.buildinfo.service.inter.dto.SysOfficeDto;
import org.tinygroup.buildinfo.service.inter.dto.SysOfficeUserDto;
import org.tinygroup.buildinfo.service.inter.dto.SysSubtransDto;
import org.tinygroup.buildinfo.service.inter.dto.SysUserDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.RoleUserRefDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.TRightRefDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysOfficeUserBusiness;
import org.tinygroup.buildinfo.business.inter.SysRoleUserBusiness;
import org.tinygroup.buildinfo.business.inter.SysUserBusiness;
import org.tinygroup.buildinfo.business.inter.SysUserRightBusiness;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/14.
 */
public class SysUserServiceImpl implements SysUserService{
	
	private SysUserBusiness sysUserBusiness;

    private SysOfficeUserBusiness sysOfficeUserBusiness;

    private SysRoleUserBusiness sysRoleUserBusiness;

    private SysUserRightBusiness sysUserRightBusiness;

    public SysUserRightBusiness getSysUserRightBusiness() {
        return sysUserRightBusiness;
    }

    public void setSysUserRightBusiness(SysUserRightBusiness sysUserRightBusiness) {
        this.sysUserRightBusiness = sysUserRightBusiness;
    }

    public SysRoleUserBusiness getSysRoleUserBusiness() {
        return sysRoleUserBusiness;
    }

    public void setSysRoleUserBusiness(SysRoleUserBusiness sysRoleUserBusiness) {
        this.sysRoleUserBusiness = sysRoleUserBusiness;
    }

    public SysOfficeUserBusiness getSysOfficeUserBusiness() {
        return sysOfficeUserBusiness;
    }

    public void setSysOfficeUserBusiness(SysOfficeUserBusiness sysOfficeUserBusiness) {
        this.sysOfficeUserBusiness = sysOfficeUserBusiness;
    }

    public SysUserBusiness getSysUserBusiness() {
		return sysUserBusiness;
	}

	public void setSysUserBusiness(SysUserBusiness sysUserBusiness) {
		this.sysUserBusiness = sysUserBusiness;
	}

	public SysUserDto getSysUser(String userId) {
		TsysUser sysUser = sysUserBusiness.getById(userId);
		SysUserDto sysUserDto = new SysUserDto();
		BeanUtil.copyProperties(sysUserDto, sysUser);
		return sysUserDto;
    }

    public SysUserDto addSysUser(SysUserDto sysUserDto) {
    	TsysUser tsysUser = BeanUtil.copyProperties(TsysUser.class, sysUserDto);
        return BeanUtil.copyProperties(SysUserDto.class, sysUserBusiness.add(tsysUser));
    }

    public int updateSysUser(SysUserDto sysUserDto) {
    	TsysUser tsysUser = BeanUtil.copyProperties(TsysUser.class, sysUserDto);
        return sysUserBusiness.update(tsysUser );
    }

    public int deleteSysUser(String[] depCodes) {
        return sysUserBusiness.deleteByKeys(depCodes);
    }

    public PageResponse getSysUserPager(PageRequest pageRequest, SysUserDto sysUserDto) {
    	TsysUser tsysUser = BeanUtil.copyProperties(TsysUser.class, sysUserDto);
		Pager<TsysUser> sysUserPager = sysUserBusiness.getPager(pageRequest.getStart(), pageRequest.getPageSize(), tsysUser);
        return PageResponseAdapter.transform(sysUserPager);
    }

    public boolean checkSysUserExists(SysUserDto sysUserDto) {
    	TsysUser tsysUser = BeanUtil.copyProperties(TsysUser.class, sysUserDto);
        return sysUserBusiness.checkExists(tsysUser);
    }

    public boolean validateSysUserExists(String userName, String password) {
        if(userName==null || password==null){
            return false;
        }
        return sysUserBusiness.validate(userName,password);
    }

    public List getTsysOfficeUserList(SysOfficeUserDto sysOfficeUserDto) {
        TsysOfficeUser tsysOfficeUser = BeanUtil.copyProperties(TsysOfficeUser.class,sysOfficeUserDto);
        return sysOfficeUserBusiness.getSysOfficeList(tsysOfficeUser);
    }



    public boolean updateUserOffices(String userCode, String[] officeId, String[] removeOfficeId) {
        return false;
    }

    public PageResponse queryOfficeInUser(PageRequest pageRequest,String userCode, SysOfficeDto sysOfficeDto, Boolean isAssign) {
        TsysOffice tsysOffice = BeanUtil.copyProperties(TsysOffice.class,sysOfficeDto);
        Pager pager =  sysOfficeUserBusiness.queryOfficeInUser(pageRequest.getStart(),pageRequest.getPageSize(),
                userCode,tsysOffice,isAssign);
        return PageResponseAdapter.transform(pager);
    }

    public PageResponse queryRoleInUser(PageRequest pageRequest, String userCode, RoleUserRefDto roleUserRefDto,
                                        Boolean isAssign,Integer assignFlag) {
    	RoleUserRef roleUserRef = BeanUtil.copyProperties(RoleUserRef.class,roleUserRefDto);
        Pager pager =  sysRoleUserBusiness.queryRoleInUser(pageRequest.getStart(),pageRequest.getPageSize(),
                userCode,roleUserRef,isAssign,assignFlag);
        return PageResponseAdapter.transform(pager);
    }

    public PageResponse querySubTransInUser(PageRequest pageRequest, String userCode, SysSubtransDto sysSubtransDto, Boolean isAssign) {
        TsysOffice tsysOffice = BeanUtil.copyProperties(TsysOffice.class,sysSubtransDto);
        Pager pager =  null;
        return PageResponseAdapter.transform(pager);
    }

    public boolean grantUserOffices(String userCode, String[] preAddOfficeId) {
        return sysOfficeUserBusiness.grantUserOffices(userCode,preAddOfficeId);
    }

    public boolean revokeUserOffices(String userCode, String[] preRemoveOfficeId) {
        return sysOfficeUserBusiness.revokeUserOffices(userCode,preRemoveOfficeId);
    }

    public List getUserRoleList(String userCode, RoleDto roleDto, Boolean isSign) {
        return null;
    }

    public boolean grantUserRoles(String userCode,Integer[] preAddRoleId) {
        return sysRoleUserBusiness.grantRoles(userCode,preAddRoleId);
    }

    public boolean revokeUserRoles(String userCode, Integer[] preAddRoleId) {
        return sysRoleUserBusiness.revokeRoles(userCode,preAddRoleId);
    }

    public boolean grantUserSubTrans(String userCode, String[] preAddOfficeId) {
        return false;
    }

    public boolean revokeUserSubTrans(String userCode, String[] preAddOfficeId) {
        return false;
    }

    public boolean grantRights(String userId,Integer[] menuIds, String createBy) {
        sysUserRightBusiness.grantRights(userId,menuIds, createBy);
        return true;
    }

    public boolean revokeRights(String userCode,Integer[] userRightIds) {
        int count = sysUserRightBusiness.revokeRights(userCode,userRightIds);
        if(count > 0){
        	return true;
        }else{
        	return false;
        }
    }

    public PageResponse queryRightsInUser(PageRequest pageRequest, String userCode, TRightRefDto tRightRefDto, boolean isAssigned) {
        TRightRef tRightRef = BeanUtil.copyProperties(TRightRef.class,tRightRefDto);
        Pager pager =  sysUserRightBusiness.queryRightsInUser(pageRequest.getStart(),pageRequest.getPageSize(),
                userCode,tRightRef,isAssigned);
        return PageResponseAdapter.transform(pager);
    }

    public PageResponse getAllInfoData(PageRequest pageRequest, SysUserDto sysUserDto) {
        TsysUser sysUser = BeanUtil.copyProperties(TsysUser.class,sysUserDto);
        Pager pager = sysUserBusiness.getAllInfoPager(pageRequest.getStart(),pageRequest.getPageSize(),
                sysUser);
        return PageResponseAdapter.transform(pager);
    }

	public int updateLockStatusByKeys(String[] pks, String lockStatus) {
		return sysUserBusiness.updateLockStatusByKeys(pks, lockStatus);
	}

    public int resetPwd(String defaultPwd, String[] userIds) {
        return sysUserBusiness.resetPwd(defaultPwd,userIds);
    }

    public int resetOnePwd(String s, String userId) {
        return sysUserBusiness.resetPwd(s,userId);
    }

	@Override
	public List<SysUserDto> getUserByIds(String[] ids) {
		return transFromUser(sysUserBusiness.getUserByIds(ids));
	}
	
	private List<SysUserDto> transFromUser(List<TsysUser> sysUserList){
		List<SysUserDto> sysUserDtoList = new ArrayList<SysUserDto>();
		if(sysUserList != null && sysUserList.size() >0){
			for (TsysUser sysUser : sysUserList) {
				sysUserDtoList.add(BeanUtil.copyProperties(SysUserDto.class, sysUser)) ;
			}
		}
		return sysUserDtoList;
	}

	@Override
	public List<String> findPermissions(String userId) {
		return sysUserBusiness.findPermissions(userId);
	}
}
