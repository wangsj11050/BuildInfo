package org.tinygroup.buildinfo.action.adisver;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.BuildAdisverService;
import org.tinygroup.buildinfo.service.inter.dto.BuildAdisverDto;

@Controller
@RequestMapping("workbuildadisver")
public class BuildAdisverAction extends BaseController {

	private BuildAdisverService buildAdisverService;

	public BuildAdisverService getBuildAdisverService() {
		return buildAdisverService;
	}

	public void setBuildAdisverService(BuildAdisverService buildAdisverService) {
		this.buildAdisverService = buildAdisverService;
	}
	
	@RequestMapping("getPageData")
	@ResponseBody
	public PageResponse getPageData(PageRequest pageRequest, BuildAdisverDto buildAdisverDto){
		return buildAdisverService.getAdisverPager(pageRequest, buildAdisverDto);
	}
	
	@RequestMapping("edit")
	public String edit(Integer id,Model model){
		if(id != null){
			BuildAdisverDto buildAdisverDto = buildAdisverService.getAdisverById(id);
			model.addAttribute("buildAdisverDto", buildAdisverDto);
		}
		return "/biz/buildinfo/adisver/buildadisver-edit";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(Integer id,BuildAdisverDto buildAdisverDto, Model model){
		if(buildAdisverDto != null && buildAdisverDto.getId() == null){
			buildAdisverDto.setId(id);
		}
		int count = buildAdisverService.updateAdisver(buildAdisverDto);
		if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> save(BuildAdisverDto buildAdisverDto, Model model){
		return (buildAdisverService.addAdisver(buildAdisverDto) != null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="ids[]") Integer[] ids,Model model){
		if(ids != null){
			buildAdisverService.deleteAdisver(ids);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"ids 为空!");
	}
}
