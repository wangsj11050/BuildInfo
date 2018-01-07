package org.tinygroup.buildinfo.service.inter;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.SysUserDto;
import org.tinygroup.buildinfo.service.inter.dto.SysUserLoginDto;

/**
 * 用户登录状态
 * Created by Mr.wang on 2016/7/14.
 */
public interface SysUserLoginService {
    SysUserLoginDto addSysUserLogin(SysUserLoginDto sysUserLoginDto);

    int updateSysLogin(SysUserLoginDto sysUserLoginDto);

    int deleteSysUserLogin(String depCode);

    PageResponse getSysUserLoginPager(PageRequest pageRequest, SysUserLoginDto sysUserLoginDto);

    SysUserLoginDto getSysUserLoginByUser(SysUserDto sysUserDto);
}
