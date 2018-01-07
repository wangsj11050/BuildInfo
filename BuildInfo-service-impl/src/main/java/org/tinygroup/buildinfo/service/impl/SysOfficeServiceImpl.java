package org.tinygroup.buildinfo.service.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDep;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysOffice;
import org.tinygroup.buildinfo.service.inter.SysOfficeService;
import org.tinygroup.buildinfo.service.inter.dto.SysOfficeDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysOfficeBusiness;
import org.tinygroup.tinysqldsl.Pager;

/**
 * 岗位信息 service-impl
 * @author Mr.wang10692
 * @date 2016/07/12
 */
public class SysOfficeServiceImpl implements SysOfficeService{
	
	private SysOfficeBusiness sysOfficeBusiness;
	
    public SysOfficeBusiness getSysOfficeBusiness() {
		return sysOfficeBusiness;
	}

	public void setSysOfficeBusiness(SysOfficeBusiness sysOfficeBusiness) {
		this.sysOfficeBusiness = sysOfficeBusiness;
	}

	public SysOfficeDto getSysOffice(String officeCode) {
		TsysOffice sysOffice = sysOfficeBusiness.getById(officeCode);
		SysOfficeDto sysOfficeDto = new SysOfficeDto();
		BeanUtil.copyProperties(sysOfficeDto, sysOffice);
		return sysOfficeDto;
	}

	public SysOfficeDto addSysOffice(SysOfficeDto sysOfficeDto) {
		TsysOffice sysOffice = BeanUtil.copyProperties(TsysOffice.class, sysOfficeDto);
		return BeanUtil.copyProperties(SysOfficeDto.class, sysOfficeBusiness.add(sysOffice));
	}

	public int updateSysOffice(SysOfficeDto sysOfficeDto) {
		TsysOffice sysOffice = BeanUtil.copyProperties(TsysOffice.class,sysOfficeDto);
        return sysOfficeBusiness.update(sysOffice);
	}

	public void deleteSysOffices(String[] ids) {
		sysOfficeBusiness.deleteByKeys(ids);
	}

	public PageResponse getSysOfficePager(PageRequest pageRequest,
			SysOfficeDto sysOfficeDto) {
		TsysOffice sysOffice = BeanUtil.copyProperties(TsysOffice.class, sysOfficeDto);
		Pager<TsysOffice> rolePager = sysOfficeBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),sysOffice);
        return PageResponseAdapter.transform(rolePager);
	}

	public boolean checkSysOfficeExists(SysOfficeDto sysOfficeDto) {
		TsysOffice sysOffice = BeanUtil.copyProperties(TsysOffice.class, sysOfficeDto);
		return sysOfficeBusiness.checkExists(sysOffice);
	}

	public List getOfficeTree(TreeDto treeDto) {
		TreeData tree = BeanUtil.copyProperties(TreeData.class, treeDto);
		return sysOfficeBusiness.getOfficeTree(tree);
	}

	public List getOfficeTreeByDep(TreeDto treeDto) {
		String currentOfficeCode = treeDto.getId();
		treeDto.setId(null);
		TreeData tree = BeanUtil.copyProperties(TreeData.class, treeDto);
		List<TreeData> treeList = sysOfficeBusiness.getOfficeTreeByDep(tree);
		for(TreeData treeData : treeList){
			String officeCode = treeData.getId();
			//为当前节点设置disableClick、disableSub
			if(officeCode.equals(currentOfficeCode)){
				treeData.setDisableClick("true");
				treeData.setDisableSub("true");
				break;
			}
		}
		return treeList;
	}

	/**
	 * TODO
	 *
	 * @param sysOfficeDto
	 * @return
	 */
	public List getOfficeList(SysOfficeDto sysOfficeDto) {
		if(sysOfficeDto == null){
			sysOfficeDto = new SysOfficeDto();
		}
		 TsysOffice office = BeanUtil.copyProperties(TsysOffice.class,sysOfficeDto);
		return sysOfficeBusiness.getOfficeList(office);
	}

	/*public List getOfficesTree(SysOfficeDto sysOfficeDto) {
		TsysOffice tsysOffice = BeanUtil.copyProperties(TsysOffice.class,sysOfficeDto);
		return sysOfficeBusiness.getOfficeTree(tsysOffice);
	}*/


}
