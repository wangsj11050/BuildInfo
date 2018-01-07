package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.ParamDto;

/**
 * 参数服务接口
 * Created by Mr.wang on 2016/8/3
 */
public interface ParamService {
	
    ParamDto getParam(Integer id);

    ParamDto addParam(ParamDto paramDto);

    int updateParam(ParamDto paramDto);

    int deleteParam(Integer[] ids);

    PageResponse getParamPager(PageRequest pageRequest, ParamDto paramDto);

    List getParamList(ParamDto paramDto);

    boolean checkParamExists(ParamDto paramDto);
    
}
