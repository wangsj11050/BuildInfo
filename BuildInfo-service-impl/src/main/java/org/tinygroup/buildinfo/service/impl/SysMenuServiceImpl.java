package org.tinygroup.buildinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysMenu;
import org.tinygroup.buildinfo.service.inter.SysMenuService;
import org.tinygroup.buildinfo.service.inter.dto.SysMenuDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysMenuBusiness;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

public class SysMenuServiceImpl implements SysMenuService {
	
	private SysMenuBusiness sysMenuBusiness;
	
	public SysMenuBusiness getSysMenuBusiness() {
		return sysMenuBusiness;
	}

	public void setSysMenuBusiness(SysMenuBusiness sysMenuBusiness) {
		this.sysMenuBusiness = sysMenuBusiness;
	}

	public SysMenuDto getSysMenu(Integer id) {
		TsysMenu sysMenu = sysMenuBusiness.getById(id);
		SysMenuDto sysMenuDto = new SysMenuDto();
		BeanUtil.copyProperties(sysMenuDto, sysMenu);
		return sysMenuDto;
	}

	public SysMenuDto addSysMenu(SysMenuDto sysMenuDto) {
		TsysMenu sysMenu = BeanUtil.copyProperties(TsysMenu.class, sysMenuDto);
		return BeanUtil.copyProperties(SysMenuDto.class, sysMenuBusiness.add(sysMenu));
	}

	public int updateSysMenu(SysMenuDto sysMenuDto) {
		TsysMenu sysMenu = BeanUtil.copyProperties(TsysMenu.class, sysMenuDto);
        return sysMenuBusiness.update(sysMenu);
	}

	public void deleteSysMenu(Integer[] ids) {
		sysMenuBusiness.deleteByKeys(ids);
	}

	public PageResponse getSysMenuPager(PageRequest pageRequest,
			SysMenuDto sysMenuDto) {
		TsysMenu sysMenu = BeanUtil.copyProperties(TsysMenu.class, sysMenuDto);
		Pager<TsysMenu> pager = sysMenuBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),sysMenu);
		return PageResponseAdapter.transform(pager);
	}

	public boolean checkSysMenuExists(SysMenuDto sysMenuDto) {
		TsysMenu sysMenu = BeanUtil.copyProperties(TsysMenu.class, sysMenuDto);
		return sysMenuBusiness.checkExists(sysMenu );
	}

	public List getMenuInfos(SysMenuDto sysMenuDto) {
		if(sysMenuDto == null){
			sysMenuDto = new SysMenuDto();
		}
		TsysMenu sysMenu = BeanUtil.copyProperties(TsysMenu.class, sysMenuDto);
		return sysMenuBusiness.getMenuInfos(sysMenu);
	}

	public List getMenuTree(TreeDto treeDto) {
		TreeData tree = BeanUtil.copyProperties(TreeData.class, treeDto);
		return sysMenuBusiness.getMenuTree(tree);
	}

	public List getUserSubTrans(String userId) {
		return sysMenuBusiness.getSubTransIds(userId);
	}


	public List<SysMenuDto> getSysMenuList(SysMenuDto sysMenuDto) {
		TsysMenu sysMenu = BeanUtil.copyProperties(TsysMenu.class, sysMenuDto);
		List<TsysMenu> tsysMenuList = sysMenuBusiness.getSysMenuList(sysMenu);
		List<SysMenuDto> sysMenuDtoList = new ArrayList<SysMenuDto>();
		for(TsysMenu tsysMenu:tsysMenuList){
			SysMenuDto sysMenuDto2 = BeanUtil.copyProperties(SysMenuDto.class,tsysMenu);
			sysMenuDtoList.add(sysMenuDto2);
		}
		return sysMenuDtoList;
	}

	public List<Integer> findMenuIdsByUser(String userCode) {
		OrderBy orderBy = new OrderBy("menuId",true);
		return sysMenuBusiness.findMenuIdsByUser(userCode);
	}

	@Override
	public List<Integer> findAppMenuIds(SysMenuDto sysMenuDto) {
		TsysMenu sysMenu = BeanUtil.copyProperties(TsysMenu.class, sysMenuDto);
		return sysMenuBusiness.findAppMenuIds(sysMenu);
	}


}
