package org.tinygroup.buildinfo.action.service;

import java.util.ArrayList;
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
import org.tinygroup.buildinfo.service.inter.BuildServiceCenterService;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicecenterDto;

@Controller
@RequestMapping("/workbuildservicecenter")
public class BuildServiceCenterAction extends BaseController {

	private BuildServiceCenterService buildServiceCenterService;

	public BuildServiceCenterService getBuildServiceCenterService() {
		return buildServiceCenterService;
	}

	public void setBuildServiceCenterService(BuildServiceCenterService buildServiceCenterService) {
		this.buildServiceCenterService = buildServiceCenterService;
	}
	
	@RequestMapping("getPageData")
	@ResponseBody
	public PageResponse getPageData(PageRequest pageRequest, BuildServicecenterDto buildServicecenterDto, Model model){
        return buildServiceCenterService.getServicecenterPager(pageRequest, buildServicecenterDto);
    }
	
	@RequestMapping("edit")
    public String get(String servicecenterCode, Model model){
        if(servicecenterCode !=null){
        	BuildServicecenterDto buildServicecenterDto = buildServiceCenterService.getServicecenterByCode(servicecenterCode);
            model.addAttribute("buildServicecenterDto",buildServicecenterDto);
        }
        return "/biz/buildinfo/service-center/buildservice_center-edit";
    }
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(BuildServicecenterDto buildServicecenterDto, Model model){
		int count = buildServiceCenterService.updateServicecenter(buildServicecenterDto);
		if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> save(BuildServicecenterDto buildServicecenterDto, Model model){
		boolean isExist = buildServiceCenterService.checkServicecneterExists(buildServicecenterDto);
		if(!isExist){
			return (buildServiceCenterService.addServicecenter(buildServicecenterDto) != null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
		}
		
		return resultMap(false,"已经存在!");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="serviceCodes[]") String[] serviceCodes,Model model){
		if(serviceCodes != null){
			buildServiceCenterService.deleteServicecenter(serviceCodes);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"serviceCodes 为空!");
	}
	
	@RequestMapping("ajax/serviceInCondition")
	@ResponseBody
	public List<BuildServicecenterDto> serviceInCondition(String initKey,boolean select2Init){
		if(select2Init){
			if(initKey != null){
				if (initKey.indexOf(",") > 0) {
	                String[] codes = initKey.split(",");
	                return buildServiceCenterService.getServicecenters(codes);
				}else{
					List<BuildServicecenterDto> result = new ArrayList<BuildServicecenterDto>();
					result.add(buildServiceCenterService.getServicecenterByCode(initKey));
				}
			}else{
				List<BuildServicecenterDto> result = new ArrayList<BuildServicecenterDto>();
				return result;
			}
		}
		return buildServiceCenterService.getServicecenterList(null);
	}
}
