package org.tinygroup.buildinfo.service.inter;


import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.service.inter.dto.SysOfficeDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

/**
 * 岗位信息 service-dao
 * @author Mr.wang10692
 * @date 2016/07/12
 */
public interface SysOfficeService {
	/**
	 * 根据 岗位编号 获取岗位信息
	 * @param officeCode 岗位编号
	 * @return
	 */
	SysOfficeDto getSysOffice(String officeCode);

	/**
	 * 新增岗位信息
	 * @param SysOfficeDto
	 * @return
     */
	SysOfficeDto addSysOffice(SysOfficeDto sysOfficeDto);

	/**
	 * 更新岗位信息
	 * @param SysOfficeDto
	 * @return
     */
	int updateSysOffice(SysOfficeDto sysOfficeDto);

	/**
	 * 删除岗位信息
	 * @param ids
     */
	void deleteSysOffices(String[] ids);

	/**
	 * 获取岗位 分页信息
	 * @param pageRequest
	 * @param SysOfficeDto
     * @return
     */
	PageResponse getSysOfficePager(PageRequest pageRequest, SysOfficeDto sysOfficeDto);

	/**
	 * 检查[岗位信息]是否存在
	 * @param sysOfficeDto
	 * @return
     */
	boolean checkSysOfficeExists(SysOfficeDto sysOfficeDto);
	
	List getOfficeTree(TreeDto tree);
	
	List getOfficeTreeByDep(TreeDto tree);

	/**
	 * TODO
	 *
	 * @param object
	 * @return
	 */
	List getOfficeList(SysOfficeDto sysOfficeDto);

//	List getOfficesTree(SysOfficeDto sysOfficeDto);
}
