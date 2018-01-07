package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.BuildPubdemandDto;

public interface BuildPubDemandService {

	BuildPubdemandDto getPubdemandById(Integer id);
	
	BuildPubdemandDto addPubdemand(BuildPubdemandDto buildPubdemandDto);
	
	PageResponse getPubdemandPager(PageRequest pageRequest,BuildPubdemandDto buildPubdemandDto,String sortName, boolean asc);
	
	int updatePubdemand(BuildPubdemandDto buildPubdemandDto);
	
	int deletePubdemand(Integer[] ids);
	
	List<BuildPubdemandDto> getPubdemandList(BuildPubdemandDto buildPubdemandDto);
}
