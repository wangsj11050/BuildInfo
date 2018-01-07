package org.tinygroup.workplan.service.inter;

import java.util.List;

import org.tinygroup.workplan.dto.EventObjectDto;
import org.tinygroup.workplan.dto.StikynoDto;

public interface StikynoService {

	StikynoDto getStikyno(Integer id);
	
	StikynoDto addStikyno(StikynoDto stikyno);
	
	int updateStikyno(StikynoDto stikyno);
	
	List<EventObjectDto> getStikynoList(StikynoDto stikyno);
	
	List<StikynoDto> getStikynoDtoList(StikynoDto stikyno, String order, String orderType);
}
