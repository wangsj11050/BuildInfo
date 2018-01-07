package org.tinygroup.buildinfo.service.impl;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.Tbtrans;
import org.tinygroup.buildinfo.service.inter.TransService;
import org.tinygroup.buildinfo.service.inter.dto.TransDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.TransBusiness;
import org.tinygroup.tinysqldsl.Pager;

import java.util.List;

/**
 * Created by Mr.wang on 2016/8/3
 */
public class TransServiceImpl implements TransService {
    
	private TransBusiness transBusiness;

    public TransBusiness getTransBusiness() {
		return transBusiness;
	}

	public void setTransBusiness(TransBusiness transBusiness) {
		this.transBusiness = transBusiness;
	}

	public TransDto getTrans(Integer id) {
        return BeanUtil.copyProperties(TransDto.class,transBusiness.getById(id));
    }

    public TransDto addTrans(TransDto transDto) {
        Tbtrans trans = BeanUtil.copyProperties(Tbtrans.class,transDto);
        return BeanUtil.copyProperties(TransDto.class,transBusiness.add(trans));
    }

    public int updateTrans(TransDto transDto) {
    	Tbtrans tTrans = BeanUtil.copyProperties(Tbtrans.class,transDto);
        return transBusiness.update(tTrans);
    }

    public int deleteTrans(Integer[] transIds) {
        return transBusiness.deleteByKeys(transIds);
    }

    public PageResponse getTransPager(PageRequest pageRequest, TransDto transDto) {
    	Tbtrans trans = BeanUtil.copyProperties(Tbtrans.class,transDto);
        Pager<Tbtrans> transPager = transBusiness
                .searchPager(pageRequest.getStart(),pageRequest.getPageSize(),trans);
        return PageResponseAdapter.transform(transPager);
    }

    public List getTransList(TransDto transDto) {
    	if(transDto == null){
    		transDto = new TransDto();
    	}
    	Tbtrans trans = BeanUtil.copyProperties(Tbtrans.class,transDto);
        return transBusiness.getList(trans);
    }

    public boolean checkTransExists(TransDto transDto) {
    	Tbtrans trans = BeanUtil.copyProperties(Tbtrans.class,transDto);
        return transBusiness.checkExists(trans);
    }

}
