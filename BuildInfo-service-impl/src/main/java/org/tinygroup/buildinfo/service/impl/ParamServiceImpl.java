package org.tinygroup.buildinfo.service.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.Tbparam;
import org.tinygroup.buildinfo.service.inter.ParamService;
import org.tinygroup.buildinfo.service.inter.dto.ParamDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.ParamBusiness;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/8/3
 */
public class ParamServiceImpl implements ParamService{
    
	private ParamBusiness paramBusiness;

    public ParamBusiness getParamBusiness() {
		return paramBusiness;
	}

	public void setParamBusiness(ParamBusiness paramBusiness) {
		this.paramBusiness = paramBusiness;
	}

	public ParamDto getParam(Integer id) {
        return BeanUtil.copyProperties(ParamDto.class,paramBusiness.getById(id));
    }

    public ParamDto addParam(ParamDto paramDto) {
        Tbparam param = BeanUtil.copyProperties(Tbparam.class,paramDto);
        return BeanUtil.copyProperties(ParamDto.class,paramBusiness.add(param));
    }

    public int updateParam(ParamDto paramDto) {
    	Tbparam tParam = BeanUtil.copyProperties(Tbparam.class,paramDto);
        return paramBusiness.update(tParam);
    }

    public int deleteParam(Integer[] paramIds) {
        return paramBusiness.deleteByKeys(paramIds);
    }

    public PageResponse getParamPager(PageRequest pageRequest, ParamDto paramDto) {
    	Tbparam param = BeanUtil.copyProperties(Tbparam.class,paramDto);
        Pager<Tbparam> paramPager = paramBusiness
                .searchPager(pageRequest.getStart(),pageRequest.getPageSize(),param);
        return PageResponseAdapter.transform(paramPager);
    }

    public List getParamList(ParamDto paramDto) {
    	if(paramDto == null){
    		paramDto = new ParamDto();
    	}
    	Tbparam param = BeanUtil.copyProperties(Tbparam.class,paramDto);
        return paramBusiness.getList(param);
    }

    public boolean checkParamExists(ParamDto paramDto) {
    	Tbparam param = BeanUtil.copyProperties(Tbparam.class,paramDto);
        return paramBusiness.checkExists(param);
    }

}
