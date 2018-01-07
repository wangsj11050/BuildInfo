package org.tinygroup.buildinfo.service.inter;

import org.tinygroup.buildinfo.service.inter.dto.BuildAboutasDto;

public interface BuildAboutAsService {

	BuildAboutasDto getAboutAs();
	
	BuildAboutasDto addAboutAs(BuildAboutasDto buildAboutasDto);
	
	int updateAboutAs(BuildAboutasDto buildAboutasDto);
}
