package org.tinygroup.buildinfo.action.news;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.BuildNewsService;
import org.tinygroup.buildinfo.service.inter.dto.BuildNewsDto;

@Controller
@RequestMapping("workbuildnews")
public class BuildNewsAction extends BaseController {

	private BuildNewsService buildNewsService;
	
	public BuildNewsService getBuildNewsService() {
		return buildNewsService;
	}

	public void setBuildNewsService(BuildNewsService buildNewsService) {
		this.buildNewsService = buildNewsService;
	}

	@RequestMapping("getPageData")
	@ResponseBody
	public PageResponse getPageData(PageRequest pageRequest, BuildNewsDto buildNewsDto){
		return buildNewsService.getNewsPager(pageRequest, buildNewsDto);
	}
	
	@RequestMapping("edit")
	public String edit(Integer id,Model model){
		if(id != null){
			BuildNewsDto buildNewsDto = buildNewsService.getNewsById(id);
			model.addAttribute("buildNewsDto", buildNewsDto);
		}
		return "/biz/buildinfo/news/buildnews-edit";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(Integer id,BuildNewsDto buildNewsDto, Model model){
		if(buildNewsDto != null && buildNewsDto.getId() == null){
			buildNewsDto.setId(id);
		}
		int count = buildNewsService.updateNews(buildNewsDto);
		if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> save(BuildNewsDto buildNewsDto, Model model){
		return (buildNewsService.addNews(buildNewsDto) != null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="ids[]") Integer[] ids,Model model){
		if(ids != null){
			buildNewsService.deleteNews(ids);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"ids 为空!");
	}
	
}
