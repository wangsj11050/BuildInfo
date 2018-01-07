package org.tinygroup.buildinfo.service.inter;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.SysDictItemDto;

/**
 * 
 * Created by Mr.wang on 2016/7/21.
 */
public interface SysDictItemService {
	SysDictItemDto getDictItem(Integer dictItemId);

	/**
	 * 新增数据字典项
	 * @param SysDictItemDto
	 * @return
     */
	SysDictItemDto addDictItem(SysDictItemDto sysDictItemDto);

	/**
	 * 更新数据字典项
	 * @param sysDictItemDto
	 * @return
     */
	int updateDictItem(SysDictItemDto sysDictItemDto);

	/**
	 * 删除数据字典项
	 * @param ids
     */
	void deleteDictItems(Integer[] ids);

	/**
	 * 获取分页信息
	 * @param pageRequest
	 * @param sysDictItemDto
     * @return
     */
	PageResponse getDictItemPager(PageRequest pageRequest, SysDictItemDto sysDictItemDto);

	/**
	 * 检查数据字典项是否存在
	 * @param sysDictItemDto
	 * @return
     */
	boolean checkDictItemExists(SysDictItemDto sysDictItemDto);
	
}
