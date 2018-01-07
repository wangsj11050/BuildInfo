package org.tinygroup.buildinfo.business.impl;

import java.util.List;

import org.tinygroup.buildinfo.business.inter.BuildAboutAsBusiness;
import org.tinygroup.buildinfo.dao.inter.BuildAboutasDao;
import org.tinygroup.buildinfo.dao.inter.pojo.BuildAboutas;

public class BuildAboutAsBusinessImpl implements BuildAboutAsBusiness {

	private BuildAboutasDao buildAboutasDao;
	
	public BuildAboutasDao getBuildAboutasDao() {
		return buildAboutasDao;
	}

	public void setBuildAboutasDao(BuildAboutasDao buildAboutasDao) {
		this.buildAboutasDao = buildAboutasDao;
	}

	@Override
	public List<BuildAboutas> getAboutAs() {
		// TODO Auto-generated method stub
		return buildAboutasDao.query(null, null);
	}

	@Override
	public BuildAboutas addAboutAs(BuildAboutas buildAboutas) {
		// TODO Auto-generated method stub
		return buildAboutasDao.add(buildAboutas);
	}

	@Override
	public int updateAboutAs(BuildAboutas buildAboutas) {
		// TODO Auto-generated method stub
		return buildAboutasDao.edit(buildAboutas);
	}

}
