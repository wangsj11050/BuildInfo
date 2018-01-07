package org.tinygroup.buildinfo.action.sysbranch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.SysBranchService;
import org.tinygroup.buildinfo.service.inter.dto.SysBranchDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

import java.util.List;
import java.util.Map;

/**
 * Created by Mr.wang on 2016/7/15.
 */

@Controller
@RequestMapping("/sysbranch")
public class SysBranchAction extends BaseController{
    private SysBranchService sysBranchService;

    public SysBranchService getSysBranchService() {
        return sysBranchService;
    }

    public void setSysBranchService(SysBranchService sysBranchService) {
        this.sysBranchService = sysBranchService;
    }

    @RequestMapping("manage")
    public String execute(Model model){
    	model.addAttribute("branchList", sysBranchService.getSysBranchList(null));
        return "/biz/org/org";
    }

    @RequestMapping("getPageData")
    @ResponseBody
    public PageResponse getPager(PageRequest pageRequest, SysBranchDto sysBranchDto,String branchSearchCode, Model model){
        if(branchSearchCode!=null){
            sysBranchDto.setBranchCode(branchSearchCode);
        }
        return sysBranchService.getSysBranchPager(pageRequest, sysBranchDto);
    }

    @RequestMapping("edit")
    public String get(String branchCode,Model model){
        if(branchCode!=null){
            SysBranchDto sysBranchDto = sysBranchService.getSysBranch(branchCode);
            model.addAttribute("sysBranchDto",sysBranchDto);
        }
        return "/biz/org/org-edit";
    }
    @RequestMapping("details")
    public String details(String branchCode,Model model){
        if(branchCode!=null){
            SysBranchDto sysBranchDto = sysBranchService.getSysBranch(branchCode);
            model.addAttribute("sysBranchDto",sysBranchDto);
        }
        return "/biz/org/details";
    }
    @RequestMapping("update")
    @ResponseBody
    public Map<?,?> update(SysBranchDto sysBranchDto, Model model){
        int count = sysBranchService.updateSysBranch(sysBranchDto);
        if(count > 0)
        	return resultMap(true,"修改成功!");
        return resultMap(false,"修改失败!");
    }

    @RequestMapping("save")
    @ResponseBody
    public Map<?,?> add(SysBranchDto sysBranchDto,Model model){
    	boolean isExist = sysBranchService.checkSysBranchExists(sysBranchDto);
    	if(!isExist){
    		return (sysBranchService.addSysBranch(sysBranchDto)!=null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在!");
    }

    @RequestMapping("getTreeData")
    @ResponseBody
    public List getTreeData(TreeDto treeDto){
        return sysBranchService.getBranchTree(treeDto);
    }
    
    /**
     * 删除
     * @param branchCodes
     * @param model
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public Map<?,?> delete(@RequestParam(value="branchCodes[]")String[] branchCodes ,Model model){
    	if(branchCodes != null){
    		sysBranchService.deleteSysBranch(branchCodes);
    		return resultMap(true,"删除成功!");
    	}
    	return resultMap(false,"depCodes 为空!");
    }
}
