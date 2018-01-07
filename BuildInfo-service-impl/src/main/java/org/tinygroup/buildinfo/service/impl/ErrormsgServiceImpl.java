package org.tinygroup.buildinfo.service.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.Tberrormsg;
import org.tinygroup.buildinfo.service.inter.ErrormsgService;
import org.tinygroup.buildinfo.service.inter.dto.ErrormsgDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.ErrormsgBusiness;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/8/3
 */
public class ErrormsgServiceImpl implements ErrormsgService{
    
	private ErrormsgBusiness errormsgBusiness;

    public ErrormsgBusiness getErrormsgBusiness() {
		return errormsgBusiness;
	}

	public void setErrormsgBusiness(ErrormsgBusiness errormsgBusiness) {
		this.errormsgBusiness = errormsgBusiness;
	}

	public ErrormsgDto getErrormsg(Integer id) {
        return BeanUtil.copyProperties(ErrormsgDto.class,errormsgBusiness.getById(id));
    }

    public ErrormsgDto addErrormsg(ErrormsgDto errormsgDto) {
        Tberrormsg errormsg = BeanUtil.copyProperties(Tberrormsg.class,errormsgDto);
        return BeanUtil.copyProperties(ErrormsgDto.class,errormsgBusiness.add(errormsg));
    }

    public int updateErrormsg(ErrormsgDto errormsgDto) {
    	Tberrormsg tErrormsg = BeanUtil.copyProperties(Tberrormsg.class,errormsgDto);
        return errormsgBusiness.update(tErrormsg);
    }

    public int deleteErrormsg(Integer[] errormsgIds) {
        return errormsgBusiness.deleteByKeys(errormsgIds);
    }

    public PageResponse getErrormsgPager(PageRequest pageRequest, ErrormsgDto errormsgDto) {
    	Tberrormsg errormsg = BeanUtil.copyProperties(Tberrormsg.class,errormsgDto);
        Pager<Tberrormsg> errormsgPager = errormsgBusiness
                .searchPager(pageRequest.getStart(),pageRequest.getPageSize(),errormsg);
        return PageResponseAdapter.transform(errormsgPager);
    }

    public List getErrormsgList(ErrormsgDto errormsgDto) {
    	if(errormsgDto == null){
    		errormsgDto = new ErrormsgDto();
    	}
    	Tberrormsg errormsg = BeanUtil.copyProperties(Tberrormsg.class,errormsgDto);
        return errormsgBusiness.getList(errormsg);
    }

    public boolean checkErrormsgExists(ErrormsgDto errormsgDto) {
    	Tberrormsg errormsg = BeanUtil.copyProperties(Tberrormsg.class,errormsgDto);
        return errormsgBusiness.checkExists(errormsg);
    }

}
