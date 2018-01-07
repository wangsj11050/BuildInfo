package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.BuildNewsDto;

public interface BuildNewsService {

	BuildNewsDto getNewsById(Integer id);
	
	BuildNewsDto addNews(BuildNewsDto buildNewsDto);
	
	PageResponse getNewsPager(PageRequest pageRequest,BuildNewsDto buildNewsDto);
	
	int updateNews(BuildNewsDto buildNewsDto);
	
	int deleteNews(Integer[] ids);
	
	List<BuildNewsDto> getNewsList(BuildNewsDto buildNewsDto);
}
