package org.tinygroup.buildinfo.action.customercase;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.BuildCustomerCaseService;
import org.tinygroup.buildinfo.service.inter.dto.BuildCustomercaseDto;

@Controller
@RequestMapping("workbuildcustomer_case")
public class BuildCustomercaseAction extends BaseController {

	private BuildCustomerCaseService buildCustomerCaseService;

	public BuildCustomerCaseService getBuildCustomerCaseService() {
		return buildCustomerCaseService;
	}

	public void setBuildCustomerCaseService(BuildCustomerCaseService buildCustomerCaseService) {
		this.buildCustomerCaseService = buildCustomerCaseService;
	}
	
	@RequestMapping("getPageData")
	@ResponseBody
	public PageResponse getPageData(PageRequest pageRequest, BuildCustomercaseDto buildCustomercaseDto){
		return buildCustomerCaseService.getCustomerCasePager(pageRequest, buildCustomercaseDto);
	}
	
	@RequestMapping("edit")
	public String edit(Integer id,Model model){
		if(id != null){
			BuildCustomercaseDto buildCustomercaseDto = buildCustomerCaseService.getCustomerCaseById(id);
			model.addAttribute("buildCustomercaseDto", buildCustomercaseDto);
		}
		return "/biz/buildinfo/customer-case/buildcustomer_case-edit";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(Integer id,BuildCustomercaseDto buildCustomercaseDto, Model model){
		if(buildCustomercaseDto != null && buildCustomercaseDto.getId() == null){
			buildCustomercaseDto.setId(id);
		}
		int count = buildCustomerCaseService.updateCustomerCase(buildCustomercaseDto);
		if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> save(BuildCustomercaseDto buildCustomercaseDto, Model model){
		return (buildCustomerCaseService.addCustomerCase(buildCustomercaseDto) != null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="ids[]") Integer[] ids,Model model){
		if(ids != null){
			buildCustomerCaseService.deleteCustomerCase(ids);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"ids 为空!");
	}
}
