package org.tinygroup.buildinfo.action.org;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.OrgService;
import org.tinygroup.buildinfo.service.inter.SysBranchService;
import org.tinygroup.buildinfo.service.inter.dto.OrgDto;

/**
 * Created by Mr.wang on 2016/7/9.
 */

@Controller
@RequestMapping("/org")
public class OrgAction extends BaseController{
    private OrgService orgService;
    private SysBranchService sysBranchService;

    public SysBranchService getSysBranchService() {
		return sysBranchService;
	}

	public void setSysBranchService(SysBranchService sysBranchService) {
		this.sysBranchService = sysBranchService;
	}

	public OrgService getOrgService() {
        return orgService;
    }

    public void setOrgService(OrgService orgService) {
        this.orgService = orgService;
    }

    @RequestMapping("manage")
    public String execute(Model model){
    	model.addAttribute("branchList", sysBranchService.getSysBranchList(null));
        return "/biz/org/org";
    }

    @RequestMapping("getPageData")
    @ResponseBody
    public PageResponse getPager(PageRequest pageRequest, OrgDto orgDto,Model model){
       return orgService.getOrgPager(pageRequest, orgDto);
    }

    @RequestMapping("edit")
    public String get(Integer orgId,Model model){
        if(orgId!=null){
            OrgDto orgDto = orgService.getOrg(orgId);
            model.addAttribute("orgDto",orgDto);
        }
        return "/biz/org/org-edit";
    }
    @RequestMapping("details")
    public String details(Integer orgId,Model model){
        if(orgId!=null){
            OrgDto orgDto = orgService.getOrg(orgId);
            model.addAttribute("orgDto",orgDto);
        }
        return "/biz/org/details";
    }
    @RequestMapping("update")
    @ResponseBody
    public Map<?,?> update(OrgDto orgDto, Model model){
        orgService.updateOrg(orgDto);
        return resultMap(true,"修改成功!");
    }

    @RequestMapping("add")
    @ResponseBody
     public Map<?,?> add(OrgDto orgDto,Model model){
        return (orgService.addOrg(orgDto)!=null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
     }
}
