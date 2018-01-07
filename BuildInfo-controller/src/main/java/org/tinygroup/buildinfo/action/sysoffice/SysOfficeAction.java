package org.tinygroup.buildinfo.action.sysoffice;

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
import org.tinygroup.buildinfo.service.inter.SysBranchService;
import org.tinygroup.buildinfo.service.inter.SysDepService;
import org.tinygroup.buildinfo.service.inter.SysOfficeService;
import org.tinygroup.buildinfo.service.inter.dto.SysOfficeDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

@Controller
@RequestMapping("/sysoffice")
public class SysOfficeAction extends BaseController{
	private SysOfficeService sysOfficeService;
	
	private SysBranchService sysBranchService;//机构
	
	private SysDepService sysDepService;//部门
	
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

	public SysOfficeService getSysOfficeService() {
		return sysOfficeService;
	}

	public void setSysOfficeService(SysOfficeService sysOfficeService) {
		this.sysOfficeService = sysOfficeService;
	}
	
	@RequestMapping("manage")
    public String execute(Model model) {
		model.addAttribute("branchList", sysBranchService.getSysBranchList(null));
		model.addAttribute("depList", sysDepService.getSysDepList(null));
		model.addAttribute("officeList", sysOfficeService.getOfficeList(null));
        return "biz/jobs/jobs";
    }

    @ResponseBody
    @RequestMapping(value="getPageData")
    public PageResponse getPager(PageRequest pageRequest, SysOfficeDto sysOfficeDto, Model model){
        return sysOfficeService.getSysOfficePager(pageRequest, sysOfficeDto);
    }

    @RequestMapping(value = "edit")
    public String get(String officeCode, Model model){
        if(officeCode!=null){
            SysOfficeDto sysOfficeDto = sysOfficeService.getSysOffice(officeCode);
            model.addAttribute("sysOfficeDto",sysOfficeDto);
        }
        return "biz/jobs/jobs-edit";
    }

    @RequestMapping(value="update")
    @ResponseBody
    public Map<?,?> update(SysOfficeDto sysOfficeDto,Model model){
        int count = sysOfficeService.updateSysOffice(sysOfficeDto);
        if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
    }

    @RequestMapping(value="save")
    @ResponseBody
    public Map<?,?> add(SysOfficeDto sysOfficeDto,Model model){
        if(sysOfficeDto.getParentCode().trim().length()==0){
            sysOfficeDto.setParentCode(null);
        }
    	boolean isExist = sysOfficeService.checkSysOfficeExists(sysOfficeDto);
    	if(!isExist){
			return sysOfficeService.addSysOffice(sysOfficeDto)!=null?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在！");
    }

    @RequestMapping(value="delete")
    @ResponseBody
    public Map<?,?> delete(@RequestParam(value="officeCodes[]")String[] officeCodes, Model model){
        if(officeCodes!=null){
            sysOfficeService.deleteSysOffices(officeCodes);
            return resultMap(true,"删除成功!");
        }
        return resultMap(false,"id为空!");
    }

    @RequestMapping(value="check")
    @ResponseBody
    public Map<?,?> check(SysOfficeDto sysOfficeDto){
        return sysOfficeService.checkSysOfficeExists(sysOfficeDto)?resultMap(false,"已经存在"):resultMap(true,"");
    }
    /**
     * 获取岗位树
     * @param tree
     * @return
     */
    @RequestMapping(value="getTreeData")
    @ResponseBody
    public List getOfficeTree(TreeDto tree){
        return sysOfficeService.getOfficeTree(tree);
    }
    /**
     * 获取岗位树
     * @param tree
     * @return
     */
    @RequestMapping(value="getOfficeTreeByDep")
    @ResponseBody
    public List getOfficeTreeByDep(TreeDto tree){
    	return sysOfficeService.getOfficeTreeByDep(tree);
    }

    /**
     *
     * @param sysOfficeDto
     * @return
     */
    /*@RequestMapping(value="getOfficesTree")
    @ResponseBody
    public List getOfficesTree(SysOfficeDto sysOfficeDto){
        return sysOfficeService.getOfficesTree(sysOfficeDto);
    }*/

}
