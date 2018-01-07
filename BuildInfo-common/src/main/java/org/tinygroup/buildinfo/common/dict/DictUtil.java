package org.tinygroup.buildinfo.common.dict;

import java.util.List;

import org.tinygroup.context.impl.ContextImpl;
import org.tinygroup.dict.Dict;
import org.tinygroup.dict.DictGroup;
import org.tinygroup.dict.DictItem;
import org.tinygroup.dict.DictManager;

public class DictUtil {

	private DictManager dictManager;

	public DictManager getDictManager() {
		return dictManager;
	}

	public void setDictManager(DictManager dictManager) {
		this.dictManager = dictManager;
	}

	/**
	 * 根据字典分类获取字典实例
	 * @param dictTypeName
	 * @return
	 */
	public Dict getDict(String dictTypeName){
		return dictManager.getDict(dictTypeName, new ContextImpl());
	}
	
	/**
	 * 根据字典分类获取字典子项列表
	 * @param dictTypeName
	 * @return
	 */
	public List<DictItem> getDictItemList(String dictTypeName){
		List<DictGroup> dictList = getDict(dictTypeName).getDictGroupList();
		List<DictItem> dictItemlist = null;
		if(dictList.size()==1){
			dictItemlist = dictList.get(0).getItemList();
		}
		return dictItemlist;
	}
	
	/**
	 * 根据字典分类以及字典值获取字典文本
	 * @param dictTypeName
	 * @param dictItemValue
	 * @return
	 */
	public String getDictItemText(String dictTypeName,String dictItemValue){
		String dictItemText = null;
		List<DictItem> dictItemlist = getDictItemList(dictTypeName);
		if(dictItemlist !=null){
			for(DictItem dictItem:dictItemlist){
				if(dictItemValue.equals(dictItem.getValue())){
					dictItemText = dictItem.getText();
				}
			}
		}
		return dictItemText;
	}
}
