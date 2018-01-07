package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.TransDto;

/**
 * 交易服务接口
 * Created by Mr.wang on 2016/8/3
 */
public interface TransService {
	
    TransDto getTrans(Integer id);

    TransDto addTrans(TransDto transDto);

    int updateTrans(TransDto transDto);

    int deleteTrans(Integer[] ids);

    PageResponse getTransPager(PageRequest pageRequest, TransDto transDto);

    List getTransList(TransDto transDto);

    boolean checkTransExists(TransDto transDto);
    
}
