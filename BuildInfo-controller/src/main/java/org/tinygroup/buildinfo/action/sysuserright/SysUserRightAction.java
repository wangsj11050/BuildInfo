package org.tinygroup.buildinfo.action.sysuserright;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.SysUserRightService;
import org.tinygroup.buildinfo.service.inter.dto.SysUserRightDto;

@Controller
@RequestMapping("/sysuserright")
public class SysUserRightAction extends BaseController {

	private SysUserRightService sysUserRightService;

	public SysUserRightService getSysUserRightService() {
		return sysUserRightService;
	}

	public void setSysUserRightService(SysUserRightService sysUserRightService) {
		this.sysUserRightService = sysUserRightService;
	}

	@ResponseBody
    @RequestMapping(value="getPageData")
    public PageResponse getPager(PageRequest pageRequest, SysUserRightDto sysUserRightDto, Model model){
        return sysUserRightService.getSysUserRightPager(pageRequest, sysUserRightDto);
    }
	
	@RequestMapping("add")
	@ResponseBody
	public Map<?,?> add(SysUserRightDto sysUserRightDto,Model model){
		return sysUserRightService.addSysUserRight(sysUserRightDto) != null ? resultMap(true,"添加成功!") : resultMap(false,"添加失败!");
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public String get(Integer id,Model model){
		if(id != null){
			SysUserRightDto sysUserRightDto = sysUserRightService.getSysUserRight(id);
			model.addAttribute("sysUserRightDto",sysUserRightDto);
		}
		return "biz/jobs/jobs-add";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(SysUserRightDto sysUserRightDto,Model model){
		int count = sysUserRightService.updateSysUserRight(sysUserRightDto);
		if(count > 0){
			return resultMap(true,"修改成功!");
		}
		return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam("value=ids") Integer[] ids,Model model){
		if(ids != null){
			sysUserRightService.deleteSysUserRight(ids);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"ids 为空!");
	}

	@RequestMapping("check")
	@ResponseBody
	public Map<?,?> check(SysUserRightDto sysUserRightDto){
		return sysUserRightService.checkSysUserRightExists(sysUserRightDto) ? resultMap(false,"已经存在!") :resultMap(true,"");
	}

}
