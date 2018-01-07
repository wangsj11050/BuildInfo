package org.tinygroup.buildinfo.common.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页dto
 */
public class PageRequest implements Serializable {

    private int pageNo = 1; // 当前页码
    private int pageSize; // 页面大小

    private Integer start;//开始记录数

    private List<String> orderByList; // 排序字段

    private List<Boolean> orderAscList;//是否为升序

    public PageRequest() {
        this.pageSize = -1;
    }

    /**
     * 构造方法
     *
     * @param pageNo   当前页码
     * @param pageSize 分页大小
     */
    public PageRequest(int pageNo, int pageSize) {
        this.setPageNo(pageNo);
        this.pageSize = pageSize;
    }

    /**
     * 获取当前页码
     *
     * @return
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页码
     *
     * @param pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 获取页面大小
     *
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置页面大小
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize <= 0 ? 10 : pageSize;
    }

    public List<String> getOrderByList() {
        return orderByList;
    }

    public void setOrderByList(List<String> orderByList) {
        this.orderByList = orderByList;
    }

    public List<Boolean> getOrderAscList() {
        return orderAscList;
    }

    public void setOrderAscList(List<Boolean> orderAscList) {
        this.orderAscList = orderAscList;
    }

    public int getStart() {
        if (start == null) {
            start = (pageNo - 1) * pageSize;
        }
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void addOrder(String orderType, boolean asc) {
        if (orderAscList == null) {
            orderAscList = new ArrayList<Boolean>();
        }
        orderAscList.add(asc);

        if (orderByList == null) {
            orderByList = new ArrayList<String>();
        }
        orderByList.add(orderType);
    }
}
