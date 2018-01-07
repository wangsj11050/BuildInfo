package org.tinygroup.buildinfo.service.inter;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.ErrormsgDto;

/**
 * 错误码服务接口
 * Created by Mr.wang on 2016/8/3
 */
public interface ErrormsgService {
	
    ErrormsgDto getErrormsg(Integer id);

    ErrormsgDto addErrormsg(ErrormsgDto errormsgDto);

    int updateErrormsg(ErrormsgDto errormsgDto);

    int deleteErrormsg(Integer[] ids);

    PageResponse getErrormsgPager(PageRequest pageRequest, ErrormsgDto errormsgDto);

    List getErrormsgList(ErrormsgDto errormsgDto);

    boolean checkErrormsgExists(ErrormsgDto errormsgDto);
    
}
