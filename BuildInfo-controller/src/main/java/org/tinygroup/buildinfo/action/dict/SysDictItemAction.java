package org.tinygroup.buildinfo.action.dict;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.SysDictEntryService;
import org.tinygroup.buildinfo.service.inter.SysDictItemService;
import org.tinygroup.buildinfo.service.inter.SysKindService;
import org.tinygroup.buildinfo.service.inter.dto.SysDictEntryDto;
import org.tinygroup.buildinfo.service.inter.dto.SysDictItemDto;

@Controller
@RequestMapping("/sysdictitem")
public class SysDictItemAction extends BaseController {
    private SysDictItemService sysDictItemService;

    private SysDictEntryService sysDictEntryService;

	public SysDictItemService getSysDictItemService() {
		return sysDictItemService;
	}

	public void setSysDictItemService(SysDictItemService sysDictItemService) {
		this.sysDictItemService = sysDictItemService;
	}

    public SysDictEntryService getSysDictEntryService() {
        return sysDictEntryService;
    }

    public void setSysDictEntryService(SysDictEntryService sysDictEntryService) {
        this.sysDictEntryService = sysDictEntryService;
    }

    @RequestMapping("manage")
    public String execute(Model model) {
        return "biz/dict/dict";
    }

    @ResponseBody
    @RequestMapping(value="getPageData")
    public PageResponse getPager(PageRequest pageRequest, SysDictItemDto dictItemDto, Model model){
        return sysDictItemService.getDictItemPager(pageRequest,dictItemDto);
    }

    @RequestMapping(value = "edit")
    public String get(Integer dictItemId,Integer dictEntryId, Model model){
        if(dictItemId!=null){
            SysDictItemDto dictItemDto = sysDictItemService.getDictItem(dictItemId);
            model.addAttribute("sysDictItemDto",dictItemDto);
        }
        SysDictEntryDto sysDictEntryDto = sysDictEntryService.getDictEntry(dictEntryId);
        model.addAttribute("sysDictEntryDto", sysDictEntryDto);
        return "biz/dict/dict-edits";
    }

    @RequestMapping(value="update")
    @ResponseBody
    public Map<?,?> update(SysDictItemDto dictItemDto,Model model){
    	int count = sysDictItemService.updateDictItem(dictItemDto);
    	if(count > 0){
    		model.addAttribute("dictEntryId", dictItemDto.getDictEntryId());
    		return resultMap(true,"修改成功!");
    	}
    	return resultMap(false,"修改失败!");
    }

    @RequestMapping(value="save")
    @ResponseBody
    public Map<?,?> add(SysDictItemDto dictItemDto,Model model){
    	boolean isExist = sysDictItemService.checkDictItemExists(dictItemDto);
    	if(!isExist){
    		return sysDictItemService.addDictItem(dictItemDto)!=null?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在!");
    }

    @RequestMapping(value="delete")
    @ResponseBody
    public Map<?,?> delete(@RequestParam(value="dictItemIds[]")Integer[] dictItemIds, Model model){
        if(dictItemIds!=null){
        	sysDictItemService.deleteDictItems(dictItemIds);
            return resultMap(true,"删除成功!");
        }
        return resultMap(false,"id为空!");
    }

    @RequestMapping(value="check")
    @ResponseBody
    public Map<?,?> check(SysDictItemDto dictItemDto){
        return sysDictItemService.checkDictItemExists(dictItemDto)?resultMap(false,"已经存在"):resultMap(true,"");
    }

}
