package org.tinygroup.buildinfo.action.aboutas;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.service.inter.BuildAboutAsService;
import org.tinygroup.buildinfo.service.inter.dto.BuildAboutasDto;

@Controller
@RequestMapping("aboutas")
public class BuildAboutAsAction extends BaseController {

	private BuildAboutAsService buildAboutAsService;
	
	public BuildAboutAsService getBuildAboutAsService() {
		return buildAboutAsService;
	}

	public void setBuildAboutAsService(BuildAboutAsService buildAboutAsService) {
		this.buildAboutAsService = buildAboutAsService;
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> save(BuildAboutasDto buildAboutasDto){
		return (buildAboutAsService.addAboutAs(buildAboutasDto) != null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(Integer id,BuildAboutasDto buildAboutasDto){
		if(buildAboutasDto != null && buildAboutasDto.getId() == null){
			buildAboutasDto.setId(id);
		}
		int count = buildAboutAsService.updateAboutAs(buildAboutasDto);
		if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
	}
	
	
}
