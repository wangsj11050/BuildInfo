package org.tinygroup.buildinfo.business.impl.dictload;


import org.tinygroup.buildinfo.dao.inter.TsysDictEntryDao;
import org.tinygroup.buildinfo.dao.inter.TsysDictItemDao;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDictEntry;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysDictItem;
import org.tinygroup.dict.DictGroup;
import org.tinygroup.dict.DictManager;
import org.tinygroup.dict.impl.AbstractDictLoader;

import java.util.List;

/**
 * 数据字典管理器
 */
public class DictDataLoaderImpl extends AbstractDictLoader {
	private TsysDictEntryDao tsysDictEntryDao;

	private TsysDictItemDao tsysDictItemDao;


	public TsysDictItemDao getTsysDictItemDao() {
		return tsysDictItemDao;
	}

	public void setTsysDictItemDao(TsysDictItemDao tsysDictItemDao) {
		this.tsysDictItemDao = tsysDictItemDao;
	}

	public TsysDictEntryDao getTsysDictEntryDao() {

		return tsysDictEntryDao;
	}

	public void setTsysDictEntryDao(TsysDictEntryDao tsysDictEntryDao) {
		this.tsysDictEntryDao = tsysDictEntryDao;
	}

	public void load(DictManager dictManager) {
		List<TsysDictEntry> tsysDictEntryList = tsysDictEntryDao.query(null);
		if (tsysDictEntryList != null) {
			for (TsysDictEntry tDict : tsysDictEntryList) {
				Integer dictId = tDict.getId();
				TsysDictItem tsysDictItem = new TsysDictItem();
				tsysDictItem.setDictEntryId(dictId);
				//select * from t_dict_item where dict_id=?
				List<TsysDictItem> items = tsysDictItemDao.query(tsysDictItem);
				org.tinygroup.dict.Dict dict = new org.tinygroup.dict.Dict();
//					dict.setName((String) bean.get(DICT_VALUE));
				dict.setName(tDict.getDictEntryCode());
				DictGroup group = new DictGroup();
				if(items!=null){
					for (TsysDictItem item : items) {
						org.tinygroup.dict.DictItem dictItem = new org.tinygroup.dict.DictItem();
//							dictItem.setText((String) item.get(DICT_ITEM_NAME));
//							dictItem.setValue((String) item.get(DICT_ITEM_VALUE));
						dictItem.setText(item.getDictItemName());
						dictItem.setValue(item.getDictItemCode());
						group.addDictItem(dictItem);
					}
				}
				dict.addDictGroup(group);
				putDict(dict.getName(), dict, dictManager);
			}
		}

	}

}
