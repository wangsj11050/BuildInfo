package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.TreeData;
import org.tinygroup.buildinfo.dao.inter.pojo.TsysOffice;
import org.tinygroup.jdbctemplatedslsession.daosupport.OrderBy;
import org.tinygroup.tinysqldsl.Pager;

/**
 * Created by Mr.wang10692 on 2016/7/12.
 */
public interface SysOfficeBusiness {
	TsysOffice getById(String officeCode);

    Pager<TsysOffice> getPager(int start, int limit, TsysOffice sysOffice, final OrderBy... orderBies);

    TsysOffice add(TsysOffice sysOffice);

    int update(TsysOffice sysOffice);

    int deleteByKeys(String... pks);

    boolean checkExists(TsysOffice sysOffice);
    
    List getOfficeTree(TreeData tree);
    
    List getOfficeTreeByDep(TreeData tree);

	List getOfficeList(TsysOffice office);

//    List<TreeData> getOfficeTree(TsysOffice tsysOffice);
}
