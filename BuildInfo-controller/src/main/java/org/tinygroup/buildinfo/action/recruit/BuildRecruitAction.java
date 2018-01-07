package org.tinygroup.buildinfo.action.recruit;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.BuildRecruitService;
import org.tinygroup.buildinfo.service.inter.dto.BuildRecruitDto;
import org.tinygroup.buildinfo.service.inter.dto.complex.UserInfo;

@Controller
@RequestMapping("workbuildrecruit")
public class BuildRecruitAction extends BaseController {

	private BuildRecruitService buildRecruitService;
	
	public BuildRecruitService getBuildRecruitService() {
		return buildRecruitService;
	}

	public void setBuildRecruitService(BuildRecruitService buildRecruitService) {
		this.buildRecruitService = buildRecruitService;
	}

	@RequestMapping("getPageData")
	@ResponseBody
	public PageResponse getPageData(PageRequest pageRequest, BuildRecruitDto buildRecruitDto){
		return buildRecruitService.getRecruitPager(pageRequest, buildRecruitDto);
	}
	
	@RequestMapping("edit")
	public String edit(Integer id,Model model){
		if(id != null){
			BuildRecruitDto buildRecruitDto = buildRecruitService.getRecruitById(id);
			model.addAttribute("buildRecruitDto", buildRecruitDto);
		}
		
		return "/biz/buildinfo/recruit/buildrecruit-edit";
	}
	
	@RequestMapping("update")
	@ResponseBody
	public Map<?,?> update(Integer id,BuildRecruitDto buildRecruitDto, Model model,HttpSession session){
		if(buildRecruitDto != null && buildRecruitDto.getId() == null){
			buildRecruitDto.setId(id);
		}
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		String userName = userInfo.getUserName();
		buildRecruitDto.setUpdateUser(userName);
		buildRecruitDto.setUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
		int count = buildRecruitService.updateRecruit(buildRecruitDto);
		if(count > 0){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Map<?,?> save(BuildRecruitDto buildRecruitDto, Model model,HttpSession session){
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		String userName = userInfo.getUserName();
		buildRecruitDto.setPubUser(userName);
		buildRecruitDto.setPubTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
		return (buildRecruitService.addRecruit(buildRecruitDto) != null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public Map<?,?> delete(@RequestParam(value="ids[]") Integer[] ids,Model model){
		if(ids != null){
			buildRecruitService.deleteRecruit(ids);
			return resultMap(true,"删除成功!");
		}
		return resultMap(false,"ids 为空!");
	}
}
