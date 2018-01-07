package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.BuildServicetypeDto;
import org.tinygroup.buildinfo.service.inter.dto.TreeDto;

public interface BuildInfoServiceService {

	BuildServicetypeDto getServicetypeByCode(String serviceCode);
	
	List<BuildServicetypeDto> getServiceTypeLikeName (String serviceName);
	
	BuildServicetypeDto addServicetype(BuildServicetypeDto buildServicetypeDto);
	
	int updateServicetype(BuildServicetypeDto buildServicetypeDto);
	
	int[] deleteServicetype(String[] serviceCode);
	
	PageResponse getServicetypePager(PageRequest pageRequest,BuildServicetypeDto buildServicetypeDto);
	
	boolean checkServicetypeExists(BuildServicetypeDto buildServicetypeDto);
	
	List<TreeDto> getServicetypeTreeData(TreeDto treeDto);
	
	List<BuildServicetypeDto> getServicetypeList(BuildServicetypeDto buildServicetypeDto);
}
