package org.tinygroup.buildinfo.action.syskind;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.SysKindService;
import org.tinygroup.buildinfo.service.inter.dto.SysKindDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

@Controller
@RequestMapping("/syskind")
public class SysKindAction extends BaseController{

	private SysKindService sysKindService;

	public SysKindService getSysKindService() {
		return sysKindService;
	}

	public void setSysKindService(SysKindService sysKindService) {
		this.sysKindService = sysKindService;
	}
	
	@RequestMapping("manage")
	public String get(Model model){
		model.addAttribute("allKinds",sysKindService.getKindsList(null));
		return "/biz/sys-kind/kind";
	}
	
	@ResponseBody
    @RequestMapping(value="getPageData")
    public PageResponse getPager(PageRequest pageRequest, SysKindDto sysKindDto,String searchParentCode, Model model){
        if(searchParentCode != null && !"".equals(searchParentCode)){
        	sysKindDto.setParentCode(searchParentCode);
        }
		return sysKindService.getSysKindPager(pageRequest, sysKindDto);
    }
	
	@RequestMapping(value = "edit")
    public String get(String kindCode, Model model){
        if(kindCode!=null){
            SysKindDto sysKindDto = sysKindService.getSysKind(kindCode);
            model.addAttribute("sysKindDto",sysKindDto);
        }
        return "biz/sys-kind/kind-edit";
    }
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(SysKindDto sysKindDto,Model model){
		int count = sysKindService.updateSysKind(sysKindDto);
		if(count > 0){
			return resultMap(true,"修改成功!");
		}
		return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> add(SysKindDto sysKindDto,Model model){
		boolean isExist = sysKindService.checkSysKindExists(sysKindDto);
		if(!isExist){
			return sysKindService.addSysKind(sysKindDto)!=null?resultMap(true,"添加成功!") : resultMap(false,"添加失败!");
		}
		return resultMap(false,"已经存在!");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="kindCodes[]") String[] kindCodes,Model model){
		if(kindCodes != null){
			sysKindService.deleteSysKinds(kindCodes);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"kindCodes 为空!");
	}
	
	@RequestMapping("check")
	@ResponseBody
	public Map<?,?> check(SysKindDto sysKindDto){
		return sysKindService.checkSysKindExists(sysKindDto) ? resultMap(false,"已经存在") : resultMap(true,"");
	}
	
	@RequestMapping("getTreeData")
    @ResponseBody
    public List getTreeData(TreeDto treeDto){
        return sysKindService.getKindTree(treeDto);
    }
}
