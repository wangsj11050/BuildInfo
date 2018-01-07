package org.tinygroup.buildinfo.service.impl;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.ext.dao.inter.pojo.TsysUserRight;
import org.tinygroup.buildinfo.service.inter.SysUserRightService;
import org.tinygroup.buildinfo.service.inter.dto.SysUserRightDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysUserRightBusiness;
import org.tinygroup.tinysqldsl.Pager;

public class SysUserRightServiceImpl implements SysUserRightService {
	
	private SysUserRightBusiness sysUserRightBusiness;
	
	public SysUserRightBusiness getSysUserRightBusiness() {
		return sysUserRightBusiness;
	}

	public void setSysUserRightBusiness(SysUserRightBusiness sysUserRightBusiness) {
		this.sysUserRightBusiness = sysUserRightBusiness;
	}

	public SysUserRightDto getSysUserRight(Integer id) {
		TsysUserRight sysUserRight = sysUserRightBusiness.getById(id);
		SysUserRightDto sysUserRightDto = new SysUserRightDto();
		BeanUtil.copyProperties(sysUserRightDto, sysUserRight);
		return sysUserRightDto;
	}

	public SysUserRightDto addSysUserRight(SysUserRightDto sysUserRightDto) {
		TsysUserRight sysUserRight = BeanUtil.copyProperties(TsysUserRight.class, sysUserRightDto);
		return BeanUtil.copyProperties(SysUserRightDto.class, sysUserRightBusiness.add(sysUserRight));
	}

	public int updateSysUserRight(SysUserRightDto sysUserRightDto) {
		TsysUserRight sysUserRight = BeanUtil.copyProperties(TsysUserRight.class, sysUserRightDto);
        return sysUserRightBusiness.update(sysUserRight);
	}

	public void deleteSysUserRight(Integer[] ids) {
		sysUserRightBusiness.deleteByKeys(ids);
	}

	public PageResponse getSysUserRightPager(PageRequest pageRequest,
			SysUserRightDto sysUserRightDto) {
		TsysUserRight sysUserRight = BeanUtil.copyProperties(TsysUserRight.class, sysUserRightDto);
		Pager<TsysUserRight> pager = sysUserRightBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),sysUserRight);
		return PageResponseAdapter.transform(pager);
	}

	public boolean checkSysUserRightExists(SysUserRightDto sysUserRightDto) {
		TsysUserRight sysUserRight = BeanUtil.copyProperties(TsysUserRight.class, sysUserRightDto);
		return sysUserRightBusiness.checkExists(sysUserRight );
	}


}
