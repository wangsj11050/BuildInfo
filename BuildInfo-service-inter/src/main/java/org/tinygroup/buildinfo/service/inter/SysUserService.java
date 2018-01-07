package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.RoleDto;
import org.tinygroup.buildinfo.service.inter.dto.SysOfficeDto;
import org.tinygroup.buildinfo.service.inter.dto.SysOfficeUserDto;
import org.tinygroup.buildinfo.service.inter.dto.SysSubtransDto;
import org.tinygroup.buildinfo.service.inter.dto.SysUserDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.RoleUserRefDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.TRightRefDto;

/**
 * 用户服务
 * Created by Mr.wang on 2016/7/14.
 */
public interface SysUserService {
    SysUserDto getSysUser(String userId);

    SysUserDto addSysUser(SysUserDto sysUserDto);
    
    List<SysUserDto> getUserByIds(String[] ids);

    int updateSysUser(SysUserDto sysUserDto);

    int deleteSysUser(String[] depCode);

    PageResponse getSysUserPager(PageRequest pageRequest, SysUserDto sysUserDto);

    boolean checkSysUserExists(SysUserDto sysUserDto);

    boolean validateSysUserExists(String userName,String password);

    List getTsysOfficeUserList(SysOfficeUserDto sysOfficeUserDto);

    /**
     * 更新用户岗位
     * @param userCode
     * @param officeId
     * @param removeOfficeId
     * @return
     */
    boolean updateUserOffices(String userCode, String[] officeId, String[] removeOfficeId);

    PageResponse queryOfficeInUser(PageRequest pageRequest,String userCode, SysOfficeDto sysOfficeDto, Boolean isAssign);

    PageResponse queryRoleInUser(PageRequest pageRequest, String userCode, RoleUserRefDto roleUserRefDto, Boolean isAssign,
                                 Integer assignFlag);

    PageResponse querySubTransInUser(PageRequest pageRequest,String userCode, SysSubtransDto sysSubtransDto, Boolean isAssign);

    boolean grantUserOffices(String userCode,String[] preAddOfficeId);

    boolean revokeUserOffices(String userCode,String[] preRemoveOfficeId);

    /**
     * 获取用户角色
     * @param userCode
     * @param isSign 是否分配 true:已分配,false:为分配,null:所有
     * @return
     */
    List getUserRoleList(String userCode, RoleDto roleDto, Boolean isSign);

    /**
     * 给用户分配角色
     * @param userCode
     * @param preAddRoleId
     * @return
     */
    boolean grantUserRoles(String userCode,Integer[] preAddRoleId);

    /**
     * 收回用户角色
     * @param userCode
     * @param preAddRoleId
     * @return
     */
    boolean revokeUserRoles(String userCode, Integer[] preAddRoleId);

    /**
     * 分配用户
     * @param userCode
     * @param preAddOfficeId
     * @return
     */
    boolean grantUserSubTrans(String userCode,String[] preAddOfficeId);

    /**
     * 收回用户
     * @param userCode
     * @param preAddOfficeId
     * @return
     */
    boolean revokeUserSubTrans(String userCode,String[] preAddOfficeId);

    boolean grantRights(String userId,Integer[] menuIds, String createBy);

    boolean revokeRights(String userCode,Integer[] userRightIds);

    PageResponse queryRightsInUser(PageRequest pageRequest, String userCode, TRightRefDto tRightRefDto, boolean isAssigned);

    /**
     * 获取用户所有信息
     * @param pageRequest
     * @param sysUserDto
     * @return
     */
    PageResponse getAllInfoData(PageRequest pageRequest, SysUserDto sysUserDto);
    /**
     * 修改用户锁定状态
     * @param pks
     * @param lockStatus
     * @return
     */
    int updateLockStatusByKeys(String[] pks,String lockStatus);

    /**
     * 批量修改
     * @param defalutPwd
     * @param userIds
     * @return
     */
    int resetPwd(String defalutPwd, String[] userIds);

    /**
     * 用户重置密码
     * @param s
     * @param userId
     * @return
     */
    int resetOnePwd(String s, String userId);
    
    List<String> findPermissions(String userId);
}
