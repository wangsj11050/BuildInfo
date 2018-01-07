package org.tinygroup.buildinfo.action.role;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.SysKindService;
import org.tinygroup.buildinfo.service.inter.SysRoleService;
import org.tinygroup.buildinfo.service.inter.dto.SysRoleDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.TRightRefDto;

@Controller
@RequestMapping("/sysrole")
public class SysRoleAction extends BaseController {
    private SysRoleService sysRoleService;
    
    private SysKindService sysKindService;
    
	public SysKindService getSysKindService() {
		return sysKindService;
	}

	public void setSysKindService(SysKindService sysKindService) {
		this.sysKindService = sysKindService;
	}

	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	@RequestMapping("manage")
    public String execute(Model model) {
        return "biz/role/role";
    }
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/manage/roleright")
    public String getRoleRightPage(Model model, Integer roleId) {
		model.addAttribute("roleId", roleId);
        return "biz/role/role-right";
    }
	@RequestMapping("/manage/assign")
    public String assignRightManage(Integer roleId,Boolean isAssigned,Model model){
		model.addAttribute("kindList", sysKindService.getKindsList(null));   
		model.addAttribute("roleId", roleId);
		if(isAssigned.booleanValue()){
            return "/biz/role/jur2";
        }else{
            return "/biz/role/jur1";
        }
    }
    @ResponseBody
    @RequestMapping(value="getPageData")
    public PageResponse getPager(PageRequest pageRequest, SysRoleDto roleDto, Model model){
        return sysRoleService.getRolePager(pageRequest,roleDto);
    }

    @RequestMapping(value = "edit")
    public String get(Integer roleId, Model model){
        if(roleId!=null){
            SysRoleDto roleDto = sysRoleService.getRole(roleId);
            model.addAttribute("sysRoleDto",roleDto);
        }
        return "biz/role/role-edit";
    }

    @RequestMapping(value="update")
    @ResponseBody
    public Map<?,?> update(SysRoleDto roleDto,Model model){
    	int count = sysRoleService.updateRole(roleDto);
    	if(count >0 )
    		return resultMap(true,"修改成功!");
    	return resultMap(false,"修改失败!");
    }

    @RequestMapping(value="save")
    @ResponseBody
    public Map<?,?> add(SysRoleDto roleDto,Model model){
    	boolean isExist = sysRoleService.checkRoleExists(roleDto);
    	if(!isExist){
    		return sysRoleService.addRole(roleDto)!=null?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在!");
    }

    @RequestMapping(value="delete")
    @ResponseBody
    public Map<?,?> delete(@RequestParam(value="roleIds[]")Integer[] roleIds, Model model){
        if(roleIds!=null){
        	sysRoleService.deleteRoles(roleIds);
            return resultMap(true,"删除成功!");
        }
        return resultMap(false,"id为空!");
    }

    @RequestMapping(value="check")
    @ResponseBody
    public Map<?,?> check(SysRoleDto roleDto){
        return sysRoleService.checkRoleExists(roleDto)?resultMap(false,"已经存在"):resultMap(true,"");
    }

    @RequestMapping("/rights/manage/assignData")
    @ResponseBody
    public PageResponse getRightsData(PageRequest pageRequest, Integer roleId, TRightRefDto tRightRefDto, Boolean isAssigned){
        return sysRoleService.queryRightsInRole(pageRequest,roleId,tRightRefDto,isAssigned);
    }


    /**
     * @param roleId
     * @param menuIds
     * @return
     */
    @RequestMapping("rights/grant")
    @ResponseBody
    public Map<?,?> grantRights(Integer roleId,String menuIds,HttpSession httpSession){
        String[] menuIdArray = menuIds.split(",",-1);
        Integer[] menuIdIntArray = new Integer[menuIdArray.length];
        for(int i=0;i<menuIdArray.length;i++){
            String menuIdStr = menuIdArray[i];
            menuIdIntArray[i]=Integer.parseInt(menuIdStr);
        }
        boolean result = sysRoleService.grantRoleRights(roleId,menuIdIntArray,(String)httpSession.getAttribute("userCode"));
        if(result){
            return resultMap(true,"操作成功!");
        }else{
            return resultMap(false,"操作失败!");
        }
    }

    /**
     *
     * @param menuIds
     * @param roleId
     * @return
     */
    @RequestMapping("/rights/revoke")
    @ResponseBody
    public Map<?,?> revokeRights(String menuIds,Integer roleId){
        String[] menuIdArray = menuIds.split(",",-1);
        Integer[] menuIdIntArray = new Integer[menuIdArray.length];
        for(int i=0;i<menuIdArray.length;i++){
            String menuIdStr = menuIdArray[i];
            menuIdIntArray[i]=Integer.parseInt(menuIdStr);
        }
        boolean result = sysRoleService.revokeRoleRights(roleId,menuIdIntArray);
        if(result){
            return resultMap(true,"操作成功!");
        }else{
            return resultMap(false,"操作失败!");
        }
    }

}
