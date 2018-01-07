package org.tinygroup.buildinfo.action.sysroleright;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.SysRoleRightService;
import org.tinygroup.buildinfo.service.inter.dto.SysRoleRightDto;

@Controller
@RequestMapping("/sysroleright")
public class SysRoleRightAction extends BaseController {

	private SysRoleRightService sysRoleRightService;

	public SysRoleRightService getSysRoleRightService() {
		return sysRoleRightService;
	}

	public void setSysRoleRightService(SysRoleRightService sysRoleRightService) {
		this.sysRoleRightService = sysRoleRightService;
	}

	@ResponseBody
    @RequestMapping(value="getPageData")
    public PageResponse getPager(PageRequest pageRequest, SysRoleRightDto sysRoleRightDto, Model model){
        return sysRoleRightService.getSysRoleRightPager(pageRequest, sysRoleRightDto);
    }
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> add(SysRoleRightDto sysRoleRightDto,Model model){
		return sysRoleRightService.addSysRoleRight(sysRoleRightDto) != null ? resultMap(true,"添加成功!") : resultMap(false,"添加失败!");
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public String get(Integer id,Model model){
		if(id != null){
			SysRoleRightDto sysRoleRightDto = sysRoleRightService.getSysRoleRight(id);
			model.addAttribute("sysRoleRightDto",sysRoleRightDto);
		}
		return "biz/jobs/jobs-add";
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> update(SysRoleRightDto sysRoleRightDto,Model model){
		int count = sysRoleRightService.updateSysRoleRight(sysRoleRightDto);
		if(count > 0){
			return resultMap(true,"修改成功!");
		}
		return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam("value=ids") Integer[] ids,Model model){
		if(ids != null){
			sysRoleRightService.deleteSysRoleRight(ids);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"ids 为空!");
	}
	
	@RequestMapping("check")
	@ResponseBody
	public Map<?,?> check(SysRoleRightDto sysRoleRightDto){
		return sysRoleRightService.checkSysRoleRightExists(sysRoleRightDto) ? resultMap(false,"已经存在!") :resultMap(true,"");
	}
}
