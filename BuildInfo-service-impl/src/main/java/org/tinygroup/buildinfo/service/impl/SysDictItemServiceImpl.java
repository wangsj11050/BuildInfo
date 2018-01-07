package org.tinygroup.buildinfo.service.impl;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDictItem;
import org.tinygroup.buildinfo.service.inter.SysDictItemService;
import org.tinygroup.buildinfo.service.inter.dto.SysDictItemDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysDictItemBusiness;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/21.
 */
public class SysDictItemServiceImpl implements SysDictItemService{
	private SysDictItemBusiness sysDictItemBusiness;

    public SysDictItemBusiness getSysDictItemBusiness() {
		return sysDictItemBusiness;
	}

	public void setSysDictItemBusiness(SysDictItemBusiness sysDictItemBusiness) {
		this.sysDictItemBusiness = sysDictItemBusiness;
	}

	public SysDictItemDto getDictItem(Integer DictItemId) {
		TsysDictItem DictItem = sysDictItemBusiness.getById(DictItemId);
		SysDictItemDto DictItemDto = new SysDictItemDto();
        BeanUtil.copyProperties(DictItemDto,DictItem);
        return DictItemDto;
    }

    public SysDictItemDto addDictItem(SysDictItemDto DictItemDto) {
        TsysDictItem DictItem = BeanUtil.copyProperties(TsysDictItem.class,DictItemDto);
        return BeanUtil.copyProperties(SysDictItemDto.class,sysDictItemBusiness.add(DictItem));
    }

    public int updateDictItem(SysDictItemDto DictItemDto) {
        TsysDictItem DictItem = BeanUtil.copyProperties(TsysDictItem.class,DictItemDto);
        return sysDictItemBusiness.update(DictItem);
    }

    public void deleteDictItems(Integer[] ids) {
        sysDictItemBusiness.deleteByKeys(ids);
    }

    public PageResponse getDictItemPager(PageRequest pageRequest, SysDictItemDto dictItemDto) {
        TsysDictItem dictItem = BeanUtil.copyProperties(TsysDictItem.class,dictItemDto);
        Pager<TsysDictItem> dictItemPager = sysDictItemBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),dictItem);
        return PageResponseAdapter.transform(dictItemPager);
    }

    public boolean checkDictItemExists(SysDictItemDto dictItemDto) {
        TsysDictItem dictItem = BeanUtil.copyProperties(TsysDictItem.class,dictItemDto);
        return sysDictItemBusiness.checkExists(dictItem);
    }

}
