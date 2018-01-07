package org.tinygroup.buildinfo.action.pubdemand;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.BuildPubDemandService;
import org.tinygroup.buildinfo.service.inter.dto.BuildPubdemandDto;

@Controller
@RequestMapping("workbuildpub_demand")
public class BuildPubDemandAction extends BaseController {

	private BuildPubDemandService buildPubDemandService;

	public BuildPubDemandService getBuildPubDemandService() {
		return buildPubDemandService;
	}

	public void setBuildPubDemandService(BuildPubDemandService buildPubDemandService) {
		this.buildPubDemandService = buildPubDemandService;
	}
	
	@RequestMapping("getPageData")
	@ResponseBody
	public PageResponse getPageData(PageRequest pageRequest, BuildPubdemandDto buildPubdemandDto){
		String order = "pubTime";
		boolean asc = false;
		return buildPubDemandService.getPubdemandPager(pageRequest, buildPubdemandDto,order,asc);
	}
	
	@RequestMapping("edit")
	public String edit(Integer id,Model model){
		if(id != null){
			BuildPubdemandDto buildPubdemandDto = buildPubDemandService.getPubdemandById(id);
			model.addAttribute("buildPubdemandDto", buildPubdemandDto);
		}
		return "/biz/buildinfo/pub-demand/buildpub_demand-edit";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(Integer id,BuildPubdemandDto buildPubdemandDto, Model model){
		if(buildPubdemandDto != null && buildPubdemandDto.getId()==null){
			buildPubdemandDto.setId(id);
		}
		buildPubdemandDto.setUpdateTime(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
		int count = buildPubDemandService.updatePubdemand(buildPubdemandDto);
		if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> save(BuildPubdemandDto buildPubdemandDto, Model model){
		if(buildPubdemandDto.getDemandState() == null || "".equals(buildPubdemandDto.getDemandState())){
			buildPubdemandDto.setDemandState("0");
		}
		buildPubdemandDto.setPubTime(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
		return (buildPubDemandService.addPubdemand(buildPubdemandDto) != null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
	}
	
	@RequestMapping("pubddemand")
	@ResponseBody
	public Map<?,?> pubDemand(BuildPubdemandDto buildPubdemandDto){
		if(buildPubdemandDto.getDemandState() == null || "".equals(buildPubdemandDto.getDemandState())){
			buildPubdemandDto.setDemandState("0");
		}
		buildPubdemandDto.setPubTime(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
		return (buildPubDemandService.addPubdemand(buildPubdemandDto) != null)?resultMap(true,"提交成功,稍后我们的顾问将与您联系，请保持电话畅通!"):resultMap(false,"提交失败,可查看星级顾问，直接和顾问取得联系!");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="ids[]") Integer[] ids,Model model){
		if(ids != null){
			buildPubDemandService.deletePubdemand(ids);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"ids 为空!");
	}
	
}
