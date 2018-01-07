package org.tinygroup.workplan.action.stikyno;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.service.inter.dto.complex.UserInfo;
import org.tinygroup.workplan.dto.StikynoDto;
import org.tinygroup.workplan.service.inter.StikynoService;

@Controller
@RequestMapping("/workstikyno")
public class StikynoAction extends BaseController {

	private StikynoService stikynoService;

	public StikynoService getStikynoService() {
		return stikynoService;
	}

	public void setStikynoService(StikynoService stikynoService) {
		this.stikynoService = stikynoService;
	}
	
	@RequestMapping("getStikynoInfo")
	@ResponseBody
	public List getStikynoInfo(HttpSession httpSession,StikynoDto stikynoDto,Model model){
		if(stikynoDto == null){
			stikynoDto = new StikynoDto();
		}
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		stikynoDto.setCreateUser(userInfo.getUserId());
		stikynoDto.setExtField_1("1");
		return stikynoService.getStikynoList(stikynoDto);
	}
	
	/**
	 * 首页点击日期弹出日志填写请求
	 * @param date
	 * @param action
	 * @param model
	 * @return
	 */
	@RequestMapping("stikynomodal")
	public String getDel(String date,String action,Model model){
		StikynoDto stikynoDto = null;
		if("add".equals(action)){
			stikynoDto = new StikynoDto();
			stikynoDto.setHandleTime(date);
			model.addAttribute("stikynoDto", stikynoDto);
			model.addAttribute("action", action);
		}else if("edit".equals(action)){
			Integer id = 0;
			if(date != null){
				id = Integer.valueOf(date);
			}
			
			stikynoDto = stikynoService.getStikyno(id);
			model.addAttribute("stikynoDto",stikynoDto);
		}
		return "stikyno/stikynomodal";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public Map<?,?> add(HttpSession httpSession,StikynoDto stikynoDto,Model model){
		if(stikynoDto != null){
			UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
			stikynoDto.setCreateUser(userInfo.getUserId());
			stikynoDto.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			return(stikynoService.addStikyno(stikynoDto) != null ? resultMap(true, "便签新增成功!"):resultMap(false, "便签新增失败!"));
		}else{
			return resultMap(false, "便签数据为空,新增失败!");
		}
	}
	
	@RequestMapping("edit")
	@ResponseBody
	public Map<?,?> edit(StikynoDto stikynoDto,Model model){
		if(stikynoDto != null){
			stikynoDto.setExtField_2(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
			stikynoService.updateStikyno(stikynoDto);
			return resultMap(true, "便签更新成功!");
		}else{
			return resultMap(false, "便签数据为空,更新失败!");
		}
	}
}
