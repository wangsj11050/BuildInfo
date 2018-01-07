package org.tinygroup.buildinfo.service.impl;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDictEntry;
import org.tinygroup.buildinfo.service.inter.SysDictEntryService;
import org.tinygroup.buildinfo.service.inter.dto.SysDictEntryDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.SysDictEntryBusiness;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/21.
 */
public class SysDictEntryServiceImpl implements SysDictEntryService{
	private SysDictEntryBusiness sysDictEntryBusiness;

    public SysDictEntryBusiness getSysDictEntryBusiness() {
		return sysDictEntryBusiness;
	}

	public void setSysDictEntryBusiness(SysDictEntryBusiness sysDictEntryBusiness) {
		this.sysDictEntryBusiness = sysDictEntryBusiness;
	}

	public SysDictEntryDto getDictEntry(Integer dictEntryId) {
		TsysDictEntry DictEntry = sysDictEntryBusiness.getById(dictEntryId);
		SysDictEntryDto DictEntryDto = new SysDictEntryDto();
        BeanUtil.copyProperties(DictEntryDto,DictEntry);
        return DictEntryDto;
    }

    public SysDictEntryDto addDictEntry(SysDictEntryDto dictEntryDto) {
        TsysDictEntry dictEntry = BeanUtil.copyProperties(TsysDictEntry.class,dictEntryDto);
        return BeanUtil.copyProperties(SysDictEntryDto.class,sysDictEntryBusiness.add(dictEntry));
    }

    public int updateDictEntry(SysDictEntryDto dictEntryDto) {
        TsysDictEntry dictEntry = BeanUtil.copyProperties(TsysDictEntry.class,dictEntryDto);
        return sysDictEntryBusiness.update(dictEntry);
    }

    public void deleteDictEntrys(Integer[] ids) {
        sysDictEntryBusiness.deleteByKeys(ids);
    }

    public PageResponse getDictEntryPager(PageRequest pageRequest, SysDictEntryDto dictEntryDto) {
        TsysDictEntry dictEntry = BeanUtil.copyProperties(TsysDictEntry.class,dictEntryDto);
        Pager<TsysDictEntry> dictEntryPager = sysDictEntryBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),dictEntry);
        return PageResponseAdapter.transform(dictEntryPager);
    }

    public boolean checkDictEntryExists(SysDictEntryDto dictEntryDto) {
        TsysDictEntry dictEntry = BeanUtil.copyProperties(TsysDictEntry.class,dictEntryDto);
        return sysDictEntryBusiness.checkExists(dictEntry);
    }

}
