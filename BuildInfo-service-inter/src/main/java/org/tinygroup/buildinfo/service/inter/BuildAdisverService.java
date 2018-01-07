package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.BuildAdisverDto;

public interface BuildAdisverService {

	BuildAdisverDto getAdisverById(Integer id);
	
	List<BuildAdisverDto> getAdisverByName(String name);
	
	BuildAdisverDto addAdisver(BuildAdisverDto buildAdisverDto);
	
	PageResponse getAdisverPager(PageRequest pageRequest,BuildAdisverDto buildAdisverDto);
	
	int updateAdisver(BuildAdisverDto buildAdisverDto);
	
	int deleteAdisver(Integer[] ids);
	
	List<BuildAdisverDto> getAdisverList(BuildAdisverDto buildAdisverDto);
}
