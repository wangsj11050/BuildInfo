package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.service.inter.dto.BuildServicecontentDto;

public interface ServiceContentService {

	BuildServicecontentDto getServiceContentByCode(String serviceCode);
	
	List<BuildServicecontentDto> getServiceContentLikeName(String serviceName);
	
	BuildServicecontentDto addServiceContent(BuildServicecontentDto buildServiceContentDto);
	
	int updateServiceContent(BuildServicecontentDto buildServiceContentDto);
	
	int[] deleteServiceContent(String[] serviceCode);
	
	List<BuildServicecontentDto> getServicecontentList(BuildServicecontentDto buildServicecontentDto);
}
