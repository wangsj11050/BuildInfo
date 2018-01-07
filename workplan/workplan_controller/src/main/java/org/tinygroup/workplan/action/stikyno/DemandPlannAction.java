package org.tinygroup.workplan.action.stikyno;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.action.BaseController;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.complex.UserInfo;
import org.tinygroup.workplan.dto.DemandPlannDto;
import org.tinygroup.workplan.service.inter.DemandPlannService;

@Controller
@RequestMapping("workdemandplann")
public class DemandPlannAction extends BaseController {

	private DemandPlannService demandPlannService;
	
	public DemandPlannService getDemandPlannService() {
		return demandPlannService;
	}

	public void setDemandPlannService(DemandPlannService demandPlannService) {
		this.demandPlannService = demandPlannService;
	}

	@RequestMapping(value="getAllInfoPageData")
    @ResponseBody
    public PageResponse getAllInfoPageData(PageRequest pageRequest, DemandPlannDto demandPlannDto, Model model){
		if(demandPlannDto != null){
			demandPlannDto = new DemandPlannDto();
		}
		return demandPlannService.getDemandPlannPager(pageRequest, demandPlannDto);
	}
	
	@RequestMapping("demandedit")
    public String get(String id, Model model){
        if(id !=null && !"".equals(id)){
        	DemandPlannDto demandPlannDto = demandPlannService.getDemandPlannById(Integer.valueOf(id));
            model.addAttribute("demandPlannDto",demandPlannDto);
        }
        return "/demand/demandedit";
    }
	
	@RequestMapping("update")
    @ResponseBody
    public Map<?,?> update(DemandPlannDto demandPlannDto, Model model,HttpSession httpSession){
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
		demandPlannDto.setLastUpdateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		demandPlannDto.setLastUpdateUser(userInfo.getUserId());
        int count = demandPlannService.updateDemandPlann(demandPlannDto);
        if(count > 0 ){
        	return resultMap(true,"修改成功!");
        }
        return resultMap(false,"修改失败!");
    }

    @RequestMapping("save")
    @ResponseBody
    public Map<?,?> add(DemandPlannDto demandPlannDto,Model model,HttpSession httpSession){
    	boolean isExist = demandPlannService.CheckDemandPlannExists(demandPlannDto);
    	if(!isExist){
    		UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
    		demandPlannDto.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));//创建时间
    		demandPlannDto.setCreateUser(userInfo.getUserId());
    		return (demandPlannService.addDemandPlann(demandPlannDto)!=null)?resultMap(true,"添加成功!"):resultMap(false,"添加失败!");
    	}
    	return resultMap(false,"已经存在！");
    }
}
