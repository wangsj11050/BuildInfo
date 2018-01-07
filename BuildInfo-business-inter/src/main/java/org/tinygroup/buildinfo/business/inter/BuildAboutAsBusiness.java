package org.tinygroup.buildinfo.business.inter;

import java.util.List;

import org.tinygroup.buildinfo.dao.inter.pojo.BuildAboutas;

public interface BuildAboutAsBusiness {

	List<BuildAboutas> getAboutAs();
	
	BuildAboutas addAboutAs(BuildAboutas buildAboutas);
	
	int updateAboutAs(BuildAboutas buildAboutas);
}
