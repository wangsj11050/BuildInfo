package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.business.inter.ServiceContentBusiness;
import org.tinygroup.buildinfo.dao.inter.BuildServicecontentDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildServicecontent;

public class ServiceContentBusinessImpl implements ServiceContentBusiness {

	private BuildServicecontentDao buildServicecontentDao;
	
	
	public BuildServicecontentDao getBuildServicecontentDao() {
		return buildServicecontentDao;
	}

	public void setBuildServicecontentDao(BuildServicecontentDao buildServicecontentDao) {
		this.buildServicecontentDao = buildServicecontentDao;
	}

	@Override
	public List<BuildServicecontent> getServiceContentByCode(String serviceCode) {
		// TODO Auto-generated method stub
		return buildServicecontentDao.getServiceContentByCode(serviceCode);
	}

	@Override
	public BuildServicecontent addServiceContent(BuildServicecontent buildServiceContent) {
		// TODO Auto-generated method stub
		return buildServicecontentDao.add(buildServiceContent);
	}

	@Override
	public int updateServiceContent(BuildServicecontent buildServiceContent) {
		// TODO Auto-generated method stub
		return buildServicecontentDao.editByCode(buildServiceContent);
	}

	@Override
	public int[] deleteServiceContent(String[] serviceCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getServicecontentList(BuildServicecontent buildServiceContent) {
		// TODO Auto-generated method stub
		return buildServicecontentDao.query(buildServiceContent, null);
	}

	@Override
	public List<BuildServicecontent> getServiceContentLikeName(String serviceName) {
		// TODO Auto-generated method stub
		return buildServicecontentDao.getServiceContentLikeName(serviceName);
	}

}
