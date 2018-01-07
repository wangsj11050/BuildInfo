package org.tinygroup.buildinfo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.BuildNewsBusiness;
import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildNews;
import org.tinygroup.buildinfo.service.inter.BuildNewsService;
import org.tinygroup.buildinfo.service.inter.dto.BuildNewsDto;
import org.tinygroup.tinysqldsl.Pager;

public class BuildNewsServiceImpl implements BuildNewsService {

	private BuildNewsBusiness buildNewsBusiness;
	
	
	public BuildNewsBusiness getBuildNewsBusiness() {
		return buildNewsBusiness;
	}

	public void setBuildNewsBusiness(BuildNewsBusiness buildNewsBusiness) {
		this.buildNewsBusiness = buildNewsBusiness;
	}

	@Override
	public BuildNewsDto getNewsById(Integer id) {
		// TODO Auto-generated method stub
		return  BeanUtil.copyProperties(BuildNewsDto.class,buildNewsBusiness.getNewsById(id));
	}

	@Override
	public BuildNewsDto addNews(BuildNewsDto buildNewsDto) {
		BuildNews buildNews = BeanUtil.copyProperties(BuildNews.class,buildNewsDto);
		return BeanUtil.copyProperties(BuildNewsDto.class,buildNewsBusiness.addNews(buildNews));
	}

	@Override
	public PageResponse getNewsPager(PageRequest pageRequest, BuildNewsDto buildNewsDto) {
		BuildNews buildNews = BeanUtil.copyProperties(BuildNews.class,buildNewsDto);
        Pager<BuildNews> buildNewsPager = buildNewsBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),buildNews);
        return PageResponseAdapter.transform(buildNewsPager);
	}

	@Override
	public int updateNews(BuildNewsDto buildNewsDto) {
		BuildNews buildNews = BeanUtil.copyProperties(BuildNews.class,buildNewsDto);
		return buildNewsBusiness.updateNews(buildNews);
	}

	@Override
	public int deleteNews(Integer[] ids) {
		// TODO Auto-generated method stub
		return buildNewsBusiness.deleteNews(ids);
	}

	@Override
	public List<BuildNewsDto> getNewsList(BuildNewsDto buildNewsDto) {
		BuildNews buildNews = BeanUtil.copyProperties(BuildNews.class,buildNewsDto);
		return transFromNewsDto(buildNewsBusiness.getNewsList(buildNews));
	}
	
	private List<BuildNewsDto> transFromNewsDto(List<BuildNews> buildNewsList){
		List<BuildNewsDto> buildNewsDtoList = new ArrayList<BuildNewsDto>();
		if(buildNewsList != null){
			for (BuildNews buildNews : buildNewsList) {
				BuildNewsDto buildNewsDto = BeanUtil.copyProperties(BuildNewsDto.class,buildNews);
				buildNewsDtoList.add(buildNewsDto);
			}
		}
		return buildNewsDtoList;
	}

}
