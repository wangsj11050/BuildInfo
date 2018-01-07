package org.tinygroup.buildinfo.service.impl;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysUser;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysUserLogin;
import org.tinygroup.buildinfo.service.inter.SysUserLoginService;
import org.tinygroup.buildinfo.service.inter.dto.SysUserDto;
import org.tinygroup.buildinfo.service.inter.dto.SysUserLoginDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysUserLoginBusiness;
import org.tinygroup.tinysqldsl.Pager;

/**
 * 用户登录服务
 * Created by Mr.wang on 2016/7/14.
 */
public class SysUserLoginServiceImpl implements SysUserLoginService{
    private SysUserLoginBusiness sysUserLoginBusiness;

    public SysUserLoginBusiness getSysUserLoginBusiness() {
        return sysUserLoginBusiness;
    }

    public void setSysUserLoginBusiness(SysUserLoginBusiness sysUserLoginBusiness) {
        this.sysUserLoginBusiness = sysUserLoginBusiness;
    }

    public SysUserLoginDto addSysUserLogin(SysUserLoginDto sysUserLoginDto) {
        TsysUserLogin tsysUserLogin = BeanUtil.copyProperties(TsysUserLogin.class,sysUserLoginDto);
        return BeanUtil.copyProperties(SysUserLoginDto.class,sysUserLoginBusiness.add(tsysUserLogin));
    }

    public int updateSysLogin(SysUserLoginDto sysUserLoginDto) {
        TsysUserLogin tsysUserLogin = BeanUtil.copyProperties(TsysUserLogin.class,sysUserLoginDto);
        return sysUserLoginBusiness.update(tsysUserLogin);
    }

    public int deleteSysUserLogin(String depCode) {
        return sysUserLoginBusiness.deleteByKeys(depCode);
    }

    public PageResponse getSysUserLoginPager(PageRequest pageRequest, SysUserLoginDto sysUserLoginDto) {
        TsysUserLogin tsysUserLogin = BeanUtil.copyProperties(TsysUserLogin.class,sysUserLoginDto);
        Pager<TsysUserLogin> pager = sysUserLoginBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),tsysUserLogin);
        return PageResponseAdapter.transform(pager);
    }

    /**
     *
     * @param sysUserDto
     * @return
     */
    public SysUserLoginDto getSysUserLoginByUser(SysUserDto sysUserDto) {
        TsysUser tsysUser = BeanUtil.copyProperties(TsysUser.class,sysUserDto);
        TsysUserLogin tsysUserLogin = sysUserLoginBusiness.getByUser(tsysUser);
        if(tsysUserLogin!=null) {
            return BeanUtil.copyProperties(SysUserLoginDto.class,tsysUserLogin);
        }
        return null;
    }

}
