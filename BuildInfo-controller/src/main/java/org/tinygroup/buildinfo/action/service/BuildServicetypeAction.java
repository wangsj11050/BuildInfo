package org.tinygroup.buildinfo.action.service;

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
import org.tinygroup.buildinfo.service.inter.BuildInfoServiceService;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicetypeDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

@Controller
@RequestMapping("/workbuildservice")
public class BuildServicetypeAction extends BaseController {

	private BuildInfoServiceService buildInfoServiceService;

	public BuildInfoServiceService getBuildInfoServiceService() {
		return buildInfoServiceService;
	}

	public void setBuildInfoServiceService(BuildInfoServiceService buildInfoServiceService) {
		this.buildInfoServiceService = buildInfoServiceService;
	}
	
	@RequestMapping("getPageData")
	@ResponseBody
	public PageResponse getPageData(PageRequest pageRequest, BuildServicetypeDto buildServicetypeDto, Model model){
        return buildInfoServiceService.getServicetypePager(pageRequest, buildServicetypeDto);
    }
	
	@RequestMapping("getTreeData")
	@ResponseBody
	public List<TreeDto> getTreeData(TreeDto treeDto){
		return buildInfoServiceService.getServicetypeTreeData(treeDto);
	}
	
	@RequestMapping("edit")
    public String get(String serviceCode, Model model){
        if(serviceCode !=null){
            BuildServicetypeDto buildServicetypeDto = buildInfoServiceService.getServicetypeByCode(serviceCode);
            model.addAttribute("buildServicetypeDto",buildServicetypeDto);
        }
        return "/biz/buildinfo/buildservice-edit";
    }
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(BuildServicetypeDto buildServicetypeDto, Model model){
		int count = buildInfoServiceService.updateServicetype(buildServicetypeDto);
		if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> save(BuildServicetypeDto buildServicetypeDto, Model model){
		boolean isExist = buildInfoServiceService.checkServicetypeExists(buildServicetypeDto);
		if(!isExist){
			return (buildInfoServiceService.addServicetype(buildServicetypeDto) != null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
		}
		
		return resultMap(false,"已经存在!");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="serviceCodes[]") String[] serviceCodes,Model model){
		if(serviceCodes != null){
			buildInfoServiceService.deleteServicetype(serviceCodes);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"depCodes 为空!");
	}
}
