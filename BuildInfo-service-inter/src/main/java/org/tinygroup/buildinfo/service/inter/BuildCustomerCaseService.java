package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.BuildCustomercaseDto;

public interface BuildCustomerCaseService {

	BuildCustomercaseDto getCustomerCaseById(Integer id);
	
	BuildCustomercaseDto addCustomerCase(BuildCustomercaseDto buildCustomercaseDto);
	
	PageResponse getCustomerCasePager(PageRequest pageRequest,BuildCustomercaseDto buildCustomercaseDto);
	
	int updateCustomerCase(BuildCustomercaseDto buildCustomercaseDto);
	
	int deleteCustomerCase(Integer[] ids);
	
	List<BuildCustomercaseDto> getCustomerCaseList(BuildCustomercaseDto buildCustomercaseDto);
}
