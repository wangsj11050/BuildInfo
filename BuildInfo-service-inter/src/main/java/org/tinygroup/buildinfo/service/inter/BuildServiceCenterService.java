package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicecenterDto;

public interface BuildServiceCenterService {

	BuildServicecenterDto getServicecenterByCode(String servicecenterCode);
	
	BuildServicecenterDto addServicecenter(BuildServicecenterDto buildServicecenterDto);
	
	int updateServicecenter(BuildServicecenterDto buildServicecenterDto);
	
	int[] deleteServicecenter(String[] serviceCode);
	
	PageResponse getServicecenterPager(PageRequest pageRequest,BuildServicecenterDto buildServicecenterDto);
	
	boolean checkServicecneterExists(BuildServicecenterDto buildServicecenterDto);
	
	List<BuildServicecenterDto> getServicecenterList(BuildServicecenterDto buildServicecenterDto);
	
	List<BuildServicecenterDto> getServicecenters(String[] codes);
}
