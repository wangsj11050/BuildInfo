package org.tinygroup.buildinfo.action.sysdep;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.SysBranchService;
import org.tinygroup.buildinfo.service.inter.SysDepService;
import org.tinygroup.buildinfo.service.inter.dto.SysDepDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

import java.util.List;
import java.util.Map;

/**
 * Created by Mr.wang on 2016/7/15.
 */

@Controller
@RequestMapping("/sysdep")
public class SysDepAction extends BaseController{
    private SysDepService sysDepService;
    private SysBranchService sysBranchService;

    public SysBranchService getSysBranchService() {
		return sysBranchService;
	}

	public void setSysBranchService(SysBranchService sysBranchService) {
		this.sysBranchService = sysBranchService;
	}

	public SysDepService getSysDepService() {
        return sysDepService;
    }

    public void setSysDepService(SysDepService sysDepService) {
        this.sysDepService = sysDepService;
    }

    @RequestMapping("manage")
    public String execute(String depCode,Model model){
    	model.addAttribute("branchList", sysBranchService.getSysBranchList(null));
		model.addAttribute("depList", sysDepService.getSysDepList(null));
        if(depCode!=null) {
            model.addAttribute("SysDepDto", sysDepService.getSysDep(depCode));
        }
        return "/biz/department/department";
    }
    
    @RequestMapping("getPageData")
    @ResponseBody
    public PageResponse getPager(PageRequest pageRequest, SysDepDto sysDepDto,String searDepCode, Model model){
       if(searDepCode!=null){
           sysDepDto.setDepCode(searDepCode);
       }
        return sysDepService.getSysDepPager(pageRequest, sysDepDto);
    }

    @RequestMapping("edit")
    public String get(String depCode, Model model){
        if(depCode !=null){
            SysDepDto sysDepDto = sysDepService.getSysDep(depCode);
            model.addAttribute("sysDepDto",sysDepDto);
        }
        return "/biz/department/department-edit";
    }
    @RequestMapping("details")
    public String details(String depCode, Model model){
        if(depCode !=null){
            SysDepDto sysDepDto = sysDepService.getSysDep(depCode);
            model.addAttribute("sysDepDto",sysDepDto);
        }
        return "/biz/department/details";
    }
    @RequestMapping("update")
    @ResponseBody
    public Map<?,?> update(SysDepDto sysDepDto, Model model){
        int count = sysDepService.updateSysDep(sysDepDto);
        if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
    }

    @RequestMapping("save")
    @ResponseBody
    public Map<?,?> add(SysDepDto sysDepDto,Model model){
    	boolean isExist = sysDepService.checkSysDepExists(sysDepDto);
    	if(!isExist){
    		return (sysDepService.addSysDep(sysDepDto)!=null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在!");
    }

    @RequestMapping("getTreeData")
    @ResponseBody
    public List getDepTreeData(TreeDto treeDto){
    	return sysDepService.getDepTreeData(treeDto);
    }
    /**
     * 通过机构编号，获取部门树
     * @param treeDto
     * @return
     */
    @RequestMapping("getTreeByBranch")
    @ResponseBody
    public List getDepTreeByBranch(TreeDto treeDto){
    	return sysDepService.getDepTreeByBranch(treeDto);
    }
    @RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="depCodes[]") String[] depCodes,Model model){
		if(depCodes != null){
			sysDepService.deleteSysDep(depCodes);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"depCodes 为空!");
	}
    @RequestMapping("getParentDepTreeByBranch")
    @ResponseBody
    public List getParentDepTreeByBranch(TreeDto treeDto){
		return sysDepService.getParentDepTreeByBranch(treeDto);
    }
}
