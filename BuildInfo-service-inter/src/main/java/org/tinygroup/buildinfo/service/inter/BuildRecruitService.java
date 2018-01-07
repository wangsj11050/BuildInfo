package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.BuildRecruitDto;

public interface BuildRecruitService {

	BuildRecruitDto getRecruitById(Integer id);
	
	BuildRecruitDto addRecruit(BuildRecruitDto buildRecruitDto);
	
	PageResponse getRecruitPager(PageRequest pageRequest,BuildRecruitDto buildRecruitDto);
	
	int updateRecruit(BuildRecruitDto buildRecruitDto);
	
	int deleteRecruit(Integer[] ids);
	
	List<BuildRecruitDto> getRecruitList(BuildRecruitDto buildRecruitDto);
}
