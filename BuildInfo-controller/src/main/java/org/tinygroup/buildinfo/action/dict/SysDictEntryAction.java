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
import org.tinygroup.buildinfo.service.inter.SysKindService;
import org.tinygroup.buildinfo.service.inter.dto.SysDictEntryDto;

@Controller
@RequestMapping("/sysdictentry")
public class SysDictEntryAction extends BaseController {
    private SysDictEntryService sysDictEntryService;
    private SysKindService sysKindService;

	public SysKindService getSysKindService() {
		return sysKindService;
	}

	public void setSysKindService(SysKindService sysKindService) {
		this.sysKindService = sysKindService;
	}

	public SysDictEntryService getSysDictEntryService() {
		return sysDictEntryService;
	}

	public void setSysDictEntryService(SysDictEntryService sysDictEntryService) {
		this.sysDictEntryService = sysDictEntryService;
	}

	@RequestMapping("manage")
    public String execute(Model model) {
		model.addAttribute("kindList",sysKindService.getKindsList(null));
        return "biz/dict/dict";
    }

    @ResponseBody
    @RequestMapping(value="getPageData")
    public PageResponse getPager(PageRequest pageRequest, SysDictEntryDto dictEntryDto,String searchKindCode, Model model){
    	if(searchKindCode != null && !"".equals(searchKindCode)){
    		dictEntryDto.setKindCode(searchKindCode);
    	}
    	return sysDictEntryService.getDictEntryPager(pageRequest,dictEntryDto);
    }

    @RequestMapping(value = "edit")
    public String get(Integer dict_id, Model model){
        if(dict_id!=null){
            SysDictEntryDto dictEntryDto = sysDictEntryService.getDictEntry(dict_id);
            model.addAttribute("sysDictEntryDto",dictEntryDto);
        }
        return "biz/dict/dict-edit";
    }
    @RequestMapping(value = "detail")
    public String getDetail(Integer dictEntryId, Model model){
        if(dictEntryId!=null){
            SysDictEntryDto dictEntryDto = sysDictEntryService.getDictEntry(dictEntryId);
            model.addAttribute("sysDictEntryDto",dictEntryDto);
        }
        return "biz/dict/dict-detail";
    }
    @RequestMapping(value="update")
    @ResponseBody
    public Map<?,?> update(SysDictEntryDto dictEntryDto,Model model){
    	int count = sysDictEntryService.updateDictEntry(dictEntryDto);
    	if(count >0)
    		return resultMap(true,"修改成功!");
        return resultMap(false,"修改失败!");
    }

    @RequestMapping(value="save")
    @ResponseBody
    public Map<?,?> add(SysDictEntryDto dictEntryDto,Model model){
    	boolean isExist = sysDictEntryService.checkDictEntryExists(dictEntryDto);
    	if(!isExist){
    		return sysDictEntryService.addDictEntry(dictEntryDto)!=null?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在!");
    }

    @RequestMapping(value="delete")
    @ResponseBody
    public Map<?,?> delete(@RequestParam(value="dictEntryIds[]")Integer[] dictEntryIds, Model model){
        if(dictEntryIds!=null){
        	sysDictEntryService.deleteDictEntrys(dictEntryIds);
            return resultMap(true,"删除成功!");
        }
        return resultMap(false,"id为空!");
    }

    @RequestMapping(value="check")
    @ResponseBody
    public Map<?,?> check(SysDictEntryDto sysDictEntryDto){
        return sysDictEntryService.checkDictEntryExists(sysDictEntryDto)?resultMap(false,"已经存在"):resultMap(true,"");
    }

}
