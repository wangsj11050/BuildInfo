package org.tinygroup.buildinfo.basedao.util;

import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/8.
 * page适配方法，将本地page对象转换成传输对象
 */
public class PageResponseAdapter {

    //转换
    public static PageResponse transform(Pager pager){
        PageResponse response = new PageResponse();
        response.setRows(pager.getRecords());
        response.setTotalPages(pager.getTotalPages());
        response.setTotal(pager.getTotalCount());
        response.setPageNo(pager.getCurrentPage());
        response.setStart(pager.getStart());
        response.setPageSize(pager.getLimit());
        return response;
    }
}
