package org.tinygroup.buildinfo.service.inter;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.SysDictEntryDto;

/**
 * 用户登录状态
 * Created by Mr.wang on 2016/7/14.
 */
public interface SysDictEntryService {
	SysDictEntryDto getDictEntry(Integer dictEntryId);

	/**
	 * 新增数据字典条目
	 * @param SysDictEntryDto
	 * @return
     */
	SysDictEntryDto addDictEntry(SysDictEntryDto sysDictEntryDto);

	/**
	 * 更新数据字典条目
	 * @param sysDictEntryDto
	 * @return
     */
	int updateDictEntry(SysDictEntryDto sysDictEntryDto);

	/**
	 * 删除数据字典条目
	 * @param ids
     */
	void deleteDictEntrys(Integer[] ids);

	/**
	 * 获取分页信息
	 * @param pageRequest
	 * @param sysDictEntryDto
     * @return
     */
	PageResponse getDictEntryPager(PageRequest pageRequest, SysDictEntryDto sysDictEntryDto);

	/**
	 * 检查数据字典条目是否存在
	 * @param sysDictEntryDto
	 * @return
     */
	boolean checkDictEntryExists(SysDictEntryDto sysDictEntryDto);
	
}
