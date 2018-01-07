package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.TsysOfficeUserDao;
import org.tinygroup.buildinfo.dao.inter.TsysUserDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysOfficeUser;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysUser;
import org.tinygroup.buildinfo.business.inter.SysUserBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/14.
 */
public class SysUserBusinessImpl implements SysUserBusiness{
    private TsysUserDao tsysUserDao;

    private TsysOfficeUserDao tsysOfficeUserDao;

    public TsysUserDao getTsysUserDao() {
        return tsysUserDao;
    }

    public void setTsysUserDao(TsysUserDao tsysUserDao) {
        this.tsysUserDao = tsysUserDao;
    }

    public TsysOfficeUserDao getTsysOfficeUserDao() {
        return tsysOfficeUserDao;
    }

    public void setTsysOfficeUserDao(TsysOfficeUserDao tsysOfficeUserDao) {
        this.tsysOfficeUserDao = tsysOfficeUserDao;
    }

    public TsysUser getById(String id) {
        return tsysUserDao.getByKey(id);
    }

    public int deleteByKeys(String... pks) {
        return tsysUserDao.deleteByKeys(pks);
    }

    public Pager<TsysUser> getPager(int start, int limit, TsysUser tsysUser, OrderBy... orderBies) {
        return tsysUserDao.searchPager(start, limit, tsysUser, orderBies);
    }

    public TsysUser add(TsysUser tsysUser) {
        return tsysUserDao.add(tsysUser);
    }

    public int update(TsysUser tsysUser) {
        return tsysUserDao.edit(tsysUser);
    }

    public boolean checkExists(TsysUser tsysUser) {
        return tsysUserDao.checkExist(tsysUser).size()>0?true:false;
    }

    public List<TsysOfficeUser> getTsysOfficeUserList(TsysOfficeUser tsysOfficeUser) {
        return tsysOfficeUserDao.query(tsysOfficeUser);
    }

    public Pager getAllInfoPager(int start, int pageSize, TsysUser sysUser) {
        return tsysUserDao.queryAllInfoPager(start,pageSize,sysUser);
    }

	public int updateLockStatusByKeys(String[] pks, String lockStatus) {
		return tsysUserDao.updateLockStatusByKeys(pks, lockStatus);
	}

    public int resetPwd(String defaultPwd, String... userIds) {
        if(defaultPwd==null || userIds==null || userIds.length==0){
            return 0;
        }
        return tsysUserDao.updatePwd(defaultPwd,userIds);
    }

    public boolean validate(String userName, String password) {
        return tsysUserDao.validate(userName,password);
    }

	@Override
	public List<TsysUser> getUserByIds(String[] ids) {
		// TODO Auto-generated method stub
		return tsysUserDao.getUserByIds(ids);
	}

	@Override
	public List<String> findPermissions(String userId) {
		// TODO Auto-generated method stub
		return tsysUserDao.findPermissions(userId);
	}


}
