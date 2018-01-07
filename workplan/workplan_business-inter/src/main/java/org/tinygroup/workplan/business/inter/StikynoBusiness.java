package org.tinygroup.workplan.business.inter;

import java.util.List;

import org.tinygroup.workplan.dao.inter.pojo.TStikyno;

public interface StikynoBusiness {
    
	TStikyno getStikyno(Integer id);
	
	TStikyno addStikyno(TStikyno stikyno);
	
	int updateStikyno(TStikyno stikyno);
	
	List<TStikyno> getStikynoList(TStikyno stikyno);
	
	List<TStikyno> getIndexStikynoList(TStikyno stikyno, String order, String orderType);
}
