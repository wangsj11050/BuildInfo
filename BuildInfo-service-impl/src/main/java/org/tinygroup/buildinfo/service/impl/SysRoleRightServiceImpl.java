package org.tinygroup.buildinfo.service.impl;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.ext.dao.inter.pojo.TsysRoleRight;
import org.tinygroup.buildinfo.service.inter.SysRoleRightService;
import org.tinygroup.buildinfo.service.inter.dto.SysRoleRightDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysRoleRightBusiness;
import org.tinygroup.tinysqldsl.Pager;

public class SysRoleRightServiceImpl implements SysRoleRightService {
	
	private SysRoleRightBusiness sysRoleRightBusiness;
	
	public SysRoleRightBusiness getSysRoleRightBusiness() {
		return sysRoleRightBusiness;
	}

	public void setSysRoleRightBusiness(SysRoleRightBusiness sysRoleRightBusiness) {
		this.sysRoleRightBusiness = sysRoleRightBusiness;
	}

	public SysRoleRightDto getSysRoleRight(Integer id) {
		TsysRoleRight sysRoleRight = sysRoleRightBusiness.getById(id);
		SysRoleRightDto sysRoleRightDto = new SysRoleRightDto();
		BeanUtil.copyProperties(sysRoleRightDto, sysRoleRight);
		return sysRoleRightDto;
	}

	public SysRoleRightDto addSysRoleRight(SysRoleRightDto sysRoleRightDto) {
		TsysRoleRight sysRoleRight = BeanUtil.copyProperties(TsysRoleRight.class, sysRoleRightDto);
		return BeanUtil.copyProperties(SysRoleRightDto.class, sysRoleRightBusiness.add(sysRoleRight));
	}

	public int updateSysRoleRight(SysRoleRightDto sysRoleRightDto) {
		TsysRoleRight sysRoleRight = BeanUtil.copyProperties(TsysRoleRight.class, sysRoleRightDto);
        return sysRoleRightBusiness.update(sysRoleRight);
	}

	public void deleteSysRoleRight(Integer[] ids) {
		sysRoleRightBusiness.deleteByKeys(ids);
	}

	public PageResponse getSysRoleRightPager(PageRequest pageRequest,
			SysRoleRightDto sysRoleRightDto) {
		TsysRoleRight sysRoleRight = BeanUtil.copyProperties(TsysRoleRight.class, sysRoleRightDto);
		Pager<TsysRoleRight> pager = sysRoleRightBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),sysRoleRight);
		return PageResponseAdapter.transform(pager);
	}

	public boolean checkSysRoleRightExists(SysRoleRightDto sysRoleRightDto) {
		TsysRoleRight sysRoleRight = BeanUtil.copyProperties(TsysRoleRight.class, sysRoleRightDto);
		return sysRoleRightBusiness.checkExists(sysRoleRight );
	}


}
