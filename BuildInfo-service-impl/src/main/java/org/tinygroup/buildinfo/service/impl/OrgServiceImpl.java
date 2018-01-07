package org.tinygroup.buildinfo.service.impl;

import java.util.List;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.common.util.BeanUtil;
import org.tinygroup.buildinfo.dao.inter.pojo.Org;
import org.tinygroup.buildinfo.service.inter.OrgService;
import org.tinygroup.buildinfo.service.inter.dto.OrgDto;
import org.tinygroup.buildinfo.basedao.util.PageResponseAdapter;
import org.tinygroup.buildinfo.business.inter.OrgBusiness;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang on 2016/7/11.
 */
public class OrgServiceImpl implements OrgService{
    private OrgBusiness orgBusiness;

    public OrgBusiness getOrgBusiness() {
        return orgBusiness;
    }

    public void setOrgBusiness(OrgBusiness orgBusiness) {
        this.orgBusiness = orgBusiness;
    }

    public OrgDto getOrg(Integer orgId) {
        return BeanUtil.copyProperties(OrgDto.class,orgBusiness.getById(orgId));
    }

    public OrgDto addOrg(OrgDto orgDto) {
        Org org = BeanUtil.copyProperties(Org.class,orgDto);
        return BeanUtil.copyProperties(OrgDto.class,orgBusiness.add(org));
    }

    public int updateOrg(OrgDto orgDto) {
        return orgBusiness.update(BeanUtil.copyProperties(Org.class,orgDto));
    }

    public int deleteOrg(Integer[] ids) {
        return orgBusiness.deleteByKeys(ids);
    }

    public PageResponse getOrgPager(PageRequest pageRequest, OrgDto orgDto) {
        Org org = BeanUtil.copyProperties(Org.class,orgDto);
        Pager<Org> orgPager = orgBusiness.getPager(pageRequest.getStart(),pageRequest.getPageSize(),org);
        return PageResponseAdapter.transform(orgPager);
    }

    public List<?> getOrgs(OrgDto orgDto) {
        return orgBusiness.getList(BeanUtil.copyProperties(Org.class,orgDto));
    }
}
