package org.tinygroup.buildinfo.service.inter;

import org.tinygroup.buildinfo.common.dto.PageRequest;
import org.tinygroup.buildinfo.common.dto.PageResponse;
import org.tinygroup.buildinfo.service.inter.dto.OrgDto;

import java.util.List;

/**
 * Created by Mr.wang on 2016/7/11.
 */
public interface OrgService {
    OrgDto getOrg(Integer orgId);

    OrgDto addOrg(OrgDto orgDto);

    int updateOrg(OrgDto orgDto);

    int deleteOrg(Integer[] ids);

    PageResponse getOrgPager(PageRequest pageRequest, OrgDto orgDto);

    List<?> getOrgs(OrgDto orgDto);
}
