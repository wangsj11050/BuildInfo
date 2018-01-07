package org.tinygroup.buildinfo.app.action;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tinygroup.buildinfo.service.inter.BuildPubDemandService;
import org.tinygroup.buildinfo.service.inter.dto.BuildPubdemandDto;

@Controller
@RequestMapping("/pubdemand")
public class PubDemandAction extends BaseController {

	private BuildPubDemandService buildPubDemandService;

	public BuildPubDemandService getBuildPubDemandService() {
		return buildPubDemandService;
	}

	public void setBuildPubDemandService(BuildPubDemandService buildPubDemandService) {
		this.buildPubDemandService = buildPubDemandService;
	}
	
	@RequestMapping("pubdemand")
	@ResponseBody
	public Map<?,?> pubDemand(BuildPubdemandDto buildPubdemandDto){
		if(buildPubdemandDto.getDemandState() == null || "".equals(buildPubdemandDto.getDemandState())){
			buildPubdemandDto.setDemandState("0");
		}
		if(buildPubdemandDto.getName() == null || "".equals(buildPubdemandDto.getName())){
			buildPubdemandDto.setName("无_客户未预留姓名");
		}
		buildPubdemandDto.setPubTime(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
		return (buildPubDemandService.addPubdemand(buildPubdemandDto) != null)?resultMap(true,"提交成功,稍后我们的顾问将与您联系，请保持电话畅通!"):resultMap(false,"提交失败,可查看星级顾问，直接和顾问取得联系!");
	}
}
