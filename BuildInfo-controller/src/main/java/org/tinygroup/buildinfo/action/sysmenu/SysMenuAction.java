package org.tinygroup.buildinfo.action.sysmenu;

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
import org.tinygroup.buildinfo.service.inter.SysMenuService;
import org.tinygroup.buildinfo.service.inter.dto.SysMenuDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

@Controller
@RequestMapping("/sysmenu")
public class SysMenuAction extends BaseController {

	private SysMenuService sysMenuService;
	
	private SysKindService sysKindService;
	

	public SysKindService getSysKindService() {
		return sysKindService;
	}

	public void setSysKindService(SysKindService sysKindService) {
		this.sysKindService = sysKindService;
	}

	public SysMenuService getSysMenuService() {
		return sysMenuService;
	}

	public void setSysMenuService(SysMenuService sysMenuService) {
		this.sysMenuService = sysMenuService;
	}
	
	@RequestMapping("manage")
    public String execute(Model model) {
//		model.addAttribute("transLists", getTransList());
		model.addAttribute("kindList",sysKindService.getKindsList(null));
		model.addAttribute("menuList", sysMenuService.getMenuInfos(null));
        return "biz/sys-menu/menu";
    }

    @RequestMapping(value="getPageData")
    @ResponseBody
    public PageResponse getPager(PageRequest pageRequest, SysMenuDto sysMenuDto,Integer searchParentId, Model model){
    	 if(searchParentId != null && !"".equals(searchParentId)){
    		 sysMenuDto.setParentId(searchParentId);
         }
    	return sysMenuService.getSysMenuPager(pageRequest, sysMenuDto);
    }
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> add(SysMenuDto sysMenuDto,Model model){
		boolean isExist = sysMenuService.checkSysMenuExists(sysMenuDto);
		if(!isExist){
			return sysMenuService.addSysMenu(sysMenuDto) != null ? resultMap(true,"添加成功!") : resultMap(false,"添加失败!");
		}
		return resultMap(false,"已经存在！");
	}
	
	@RequestMapping("edit")
	public String get(Integer menuId,Model model){
		if(menuId != null){
			SysMenuDto sysMenuDto = sysMenuService.getSysMenu(menuId);
			model.addAttribute("sysMenuDto",sysMenuDto);
		}
		//获取所有的交易码
//		model.addAttribute("transLists", getTransList());
		return "biz/sys-menu/menu-edit";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(SysMenuDto sysMenuDto,Model model){
		sysMenuService.updateSysMenu(sysMenuDto);
		return resultMap(true,"修改成功!");
	}

	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="menuIds[]")Integer[] menuIds,Model model){
		if(menuIds != null){
			sysMenuService.deleteSysMenu(menuIds);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"menuIds 为空!");
	}
	
	@RequestMapping("check")
	@ResponseBody
	public Map<?,?> check(SysMenuDto sysMenuDto){
		return sysMenuService.checkSysMenuExists(sysMenuDto) ? resultMap(false,"已经存在!") :resultMap(true,"");
	}
	
	@RequestMapping("getTreeData")
	@ResponseBody
	public List getMenuTree(TreeDto treeDto){
		return sysMenuService.getMenuTree(treeDto);
	}


	@RequestMapping("/auth")
	public String getHomePage(){
		return "auth/index";
	}
}
